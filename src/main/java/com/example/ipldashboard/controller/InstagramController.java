package com.example.ipldashboard.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import javax.websocket.server.PathParam;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.service.DataService;

@RestController
public class InstagramController {
	@Autowired
	private DataService dataService;

	@GetMapping("/auth")
	public ModelAndView auth(
			@RequestParam final Map<String, String> queryParams) {
		String accessToken = "";
		if (queryParams.get("code") != null) {
			String code = queryParams.get("code");
			code = code.replace("_#", "");
			try {
				URL url = new URL(
						"https://api.instagram.com/oauth/access_token");
				HttpURLConnection http = (HttpURLConnection) url
						.openConnection();
				http.setRequestMethod("POST");
				http.setDoOutput(true);
				http.setRequestProperty("Content-Type",
						"application/x-www-form-urlencoded");
				System.out.println(code);
				String data = "client_id=3459013894384110&client_secret=a9e48424a8389816a5f8c3b3edfb5f1c&grant_type=authorization_code&code="
						+ code
						+ "&redirect_uri=https://ipl-dashboard-shabbir.herokuapp.com/auth";
				System.out.println("data: " + data);
				byte[] out = data.getBytes(StandardCharsets.UTF_8);

				OutputStream stream = http.getOutputStream();
				stream.write(out);
				stream.flush();
				String line;
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(http.getInputStream()));
				line = reader.readLine();
				System.out.println(line);

				stream.close();
				reader.close();
				System.out.println(http.getResponseCode() + " "
						+ http.getResponseMessage());
				System.out.println(http.getContent());
				http.disconnect();
				JSONObject json = new JSONObject(line);
				accessToken = (String) json.get("access_token");
				System.out.println("access_token: " + accessToken);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return new ModelAndView("redirect:" + "/instadetails/" + accessToken);
	}

	@GetMapping("/instadetails/{accessToken}")
	public ModelAndView populateInstaDataAccessToken(
			@PathVariable("accessToken") String accessToken) {
		ModelAndView modelAndView = new ModelAndView("instadetails");
		modelAndView.addObject("slug", dataService.getSlug());
		try {
			modelAndView.addObject("access_token", accessToken);
			String data = "fields=username,media,media_count&access_token="
					+ accessToken;
			URL obj = new URL("https://graph.instagram.com/v14.0/me?" + data);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + obj);
			System.out.println("Response Code : " + responseCode);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String line = response.toString();
			// print in String
			System.out.println(line);

			JSONObject json = new JSONObject(line);
			System.out.println(json.get("media_count"));
			modelAndView.addObject("media", json.get("media"));
			modelAndView.addObject("username", json.get("username"));
			modelAndView.addObject("media_count", json.get("media_count"));
			JSONObject media = (JSONObject) json.get("media");
			if (media.getJSONArray("data") != null) {
				List<String> mediaList = new ArrayList<>();
				System.out.println(media.getJSONArray("data"));
				JSONArray content = media.getJSONArray("data");
				for (int i = 0; i < content.length(); i++) {
					JSONObject object = (JSONObject) content.get(i);
					try {
						// call media url to get media data
						obj = new URL("https://graph.instagram.com/"
								+ object.getString("id")
								+ "?fields=id,media_type,media_url,username,timestamp&access_token="
								+ accessToken);
						con = (HttpURLConnection) obj.openConnection();
						// optional default is GET
						con.setRequestMethod("GET");
						// add request header
						con.setRequestProperty("User-Agent", "Mozilla/5.0");
						responseCode = con.getResponseCode();
						System.out.println(
								"\nSending 'GET' request to URL : " + obj);
						System.out.println("Response Code : " + responseCode);
						in = new BufferedReader(
								new InputStreamReader(con.getInputStream()));
						inputLine = "";
						response = new StringBuffer();
						while ((inputLine = in.readLine()) != null) {
							response.append(inputLine);
						}
						in.close();
						line = response.toString();
						JSONObject mediaTemp = new JSONObject(line);
						mediaList.add(mediaTemp.getString("media_url")
								.replace("\\", ""));
					} catch (Exception em) {
						em.printStackTrace();
					}
				}
				modelAndView.addObject("mediaList", mediaList);
			}
			populateInstaUserDetails(modelAndView,
					(String) json.get("username"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}

	private void populateInstaUserDetails(ModelAndView modelAndView,
			String username) {
		try {
			// basic info
			URL obj = new URL(
					"https://i.instagram.com/api/v1/users/web_profile_info/?username="
							+ username);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("Accept-Encoding", "gzip");
			con.setRequestProperty("cookie",
					"sessionid=8485620030:WM9DLpiiVsYD4E:11:AYf2u72g7nTjxWXW-v4X-Z46fvCADtb4yQd-ZxZJFQ;");
			con.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
			con.setRequestProperty("x-ig-app-id", "936619743392459");

			int responseCode = con.getResponseCode();
			// System.out.println(con.getHeaderFields());
			System.out.println("\nSending 'GET' request to URL : " + obj);
			System.out.println("Response Code : " + responseCode);
			// reader = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(con.getInputStream())));
			String inputLine = "";
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String line = response.toString();
			// print in String
			System.out.println(line);
			JSONObject jsonUserInfo = new JSONObject(line);
			String owner = jsonUserInfo.getJSONObject("data")
					.getJSONObject("user").getString("id");
			modelAndView.addObject(owner, owner);
			modelAndView.addAllObjects(
					populateInstaUserFollowerPage(owner, "").getModelMap());
			modelAndView.addObject("followers_count",
					jsonUserInfo.getJSONObject("data").getJSONObject("user")
							.getJSONObject("edge_followed_by")
							.getString("count"));

			modelAndView.addObject("biography",
					jsonUserInfo.getJSONObject("data").getJSONObject("user")
							.getString("biography"));
			modelAndView.addObject("profilePicUrl",
					jsonUserInfo.getJSONObject("data").getJSONObject("user")
							.getString("profile_pic_url"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@GetMapping("/instaFollowers/{owner}/{maxId}")
	public ModelAndView populateInstaUserFollowerPage(
			@PathParam("owner") String owner,
			@PathParam("maxId") String maxId) {
		ModelAndView modelAndView = new ModelAndView("instadetails");
		modelAndView.addObject("slug", dataService.getSlug());
		try {
			// basic info
			URL obj = new URL("https://i.instagram.com/api/v1/friendships/"
					+ owner
					+ "/followers/?count=12&search_surface=follow_list_page&max_id="
					+ maxId);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			// optional default is GET
			con.setDoOutput(true);
			con.setRequestProperty("Content-Type", "application/json");
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("Accept-Encoding", "gzip");
			con.setRequestProperty("cookie",
					"sessionid=8485620030:WM9DLpiiVsYD4E:11:AYf2u72g7nTjxWXW-v4X-Z46fvCADtb4yQd-ZxZJFQ;");
			con.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.0.0 Safari/537.36");
			con.setRequestProperty("x-ig-app-id", "936619743392459");

			int responseCode = con.getResponseCode();
			// System.out.println(con.getHeaderFields());
			System.out.println("\nSending 'GET' request to URL : " + obj);
			System.out.println("Response Code : " + responseCode);
			// reader = new InputStreamReader(con.getInputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(con.getInputStream())));
			String inputLine = "";
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			String line = response.toString();
			// print in String
			System.out.println(line);
			JSONObject jsonUserInfo = new JSONObject(line);
			Map<String, List<String>> followers = new LinkedHashMap<>();
			JSONArray followerJson = jsonUserInfo.getJSONArray("users");
			modelAndView.addObject("owner", owner);
			for (int i = 0; i < followerJson.length(); i++) {
				JSONObject object = (JSONObject) followerJson.get(i);
				try {
					String pkFollower = object.getString("pk");
					String usernameFollower = object.getString("username");
					String fullNameFollower = object.getString("full_name");
					String profilePicUrlFollower = object
							.getString("profile_pic_url");
					List<String> follower = followers.get(pkFollower);
					if (follower == null) {
						follower = new ArrayList<String>();
					}
					follower.add(pkFollower);
					follower.add(usernameFollower);
					follower.add(fullNameFollower);
					if (profilePicUrlFollower != null) {
						follower.add(profilePicUrlFollower);
					}
					followers.put(pkFollower, follower);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			modelAndView.addObject("followers", followers);
			modelAndView.addObject("maxId",
					jsonUserInfo.getString("next_max_id"));
			System.out.println(followers);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelAndView;
	}

	@GetMapping("/deauth")
	public ModelAndView deauth() {
		ModelAndView modelAndView = new ModelAndView("instadeauth");
		modelAndView.addObject("slug", dataService.getSlug());
		return modelAndView;
	}

	@GetMapping("/deleteAuth")
	public ModelAndView deleteAuth() {
		ModelAndView modelAndView = new ModelAndView("instadeleteauth");
		modelAndView.addObject("slug", dataService.getSlug());
		return modelAndView;
	}
}
