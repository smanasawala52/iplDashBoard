package com.example.ipldashboard.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.service.DataService;

@RestController
public class InstagramController {
	@Autowired
	private DataService dataService;

	@GetMapping("/auth")
	public ModelAndView auth(@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("instadetails");
		modelAndView.addObject("slug", dataService.getSlug());
		if (queryParams.get("code") != null) {
			String code = queryParams.get("code");
			code = code.replace("_#", "");
			try {
				URL url = new URL("https://api.instagram.com/oauth/access_token");
				HttpURLConnection http = (HttpURLConnection) url.openConnection();
				http.setRequestMethod("POST");
				http.setDoOutput(true);
				http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				System.out.println(code);
				String data = "client_id=3459013894384110&client_secret=a9e48424a8389816a5f8c3b3edfb5f1c&grant_type=authorization_code&code="
						+ code + "&redirect_uri=https://ipl-dashboard-shabbir.herokuapp.com/auth";
				System.out.println("data: " + data);
				byte[] out = data.getBytes(StandardCharsets.UTF_8);

				OutputStream stream = http.getOutputStream();
				stream.write(out);
				stream.flush();
				String line;
				BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
				line = reader.readLine();
				System.out.println(line);

				stream.close();
				reader.close();
				System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
				System.out.println(http.getContent());
				http.disconnect();
				JSONObject json = new JSONObject(line);
				String accessToken = (String) json.get("access_token");
				System.out.println("access_token: " + accessToken);
				modelAndView.addObject("access_token", accessToken);

				data = "fields=username,media,media_count&access_token=" + accessToken;
				URL obj = new URL("https://graph.instagram.com/v14.0/me?" + data);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				// optional default is GET
				con.setRequestMethod("GET");
				// add request header
				con.setRequestProperty("User-Agent", "Mozilla/5.0");
				int responseCode = con.getResponseCode();
				System.out.println("\nSending 'GET' request to URL : " + url);
				System.out.println("Response Code : " + responseCode);
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				line = response.toString();
				// print in String
				System.out.println(line);

				json = new JSONObject(line);
				System.out.println(json.get("media_count"));
				modelAndView.addObject("media", json.get("media"));
				modelAndView.addObject("username", json.get("username"));
				modelAndView.addObject("media_count", json.get("media_count"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
