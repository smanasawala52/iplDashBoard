package com.example.ipldashboard.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.service.DataService;
import com.example.ipldashboard.service.TeamService;

@RestController
public class TeamController {

	@Autowired
	private TeamService teamService;
	private List<String> ignoreList = Arrays.asList("cp", "pageSize");
	@Autowired
	private DataService dataService;

	@GetMapping("/teams")
	public ModelAndView getTeams(@RequestParam final Map<String, String> queryParams) {
		String team1 = queryParams.get("team1");
		if (team1 != null && !team1.isEmpty()) {
			new ModelAndView("teamDetails");
		}
		ModelAndView modelAndView = new ModelAndView("teamDetails");
		modelAndView.addObject("slug", dataService.getSlug());
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("team1", "");
		queryMap.put("team2", "");
		queryMap.put("venue", "");
		queryMap.put("city", "");
		queryMap.put("season", "");
		queryMap.put("stage", "");
		queryMap.put("group", "");
		queryMap.put("playerOfMatch", "");
		queryMap.put("winner", "");
		queryMap.put("result", "");
		queryMap.put("result", "");
		queryMap.put("tossWinner", "");
		queryMap.put("tossDecision", "");
		modelAndView.addObject("pageSize", 10);

		if (queryParams != null && !queryParams.isEmpty()) {
			for (Entry<String, String> queryParam : queryParams.entrySet()) {
				if (queryParam.getValue() != null && !queryParam.getValue().isEmpty()
						&& !queryParam.getValue().equalsIgnoreCase("null")
						&& !ignoreList.contains(queryParam.getKey())) {
					// modelAndView.addObject(queryParam.getKey(),
					// queryParam.getValue());
					queryMap.put(queryParam.getKey(), queryParam.getValue());
				}
			}

		}
		String pre = "&";
		StringBuilder sb = new StringBuilder();
		StringBuilder sbVenue = new StringBuilder();
		for (Entry<String, Object> queryParam : queryMap.entrySet()) {
			if (queryParam.getValue() != null && !ignoreList.contains((queryParam.getKey()))) {
				modelAndView.addObject(queryParam.getKey(), queryParam.getValue());
				sb.append(pre).append(queryParam.getKey()).append("=").append(String.valueOf(queryParam.getValue()));
				pre = "&";
			}
		}
		modelAndView.addObject("pageBaseUrl", "teams?1=1" + sb.toString());
		modelAndView.addObject("teams", teamService.getTeams(queryParams));
		return modelAndView;
	}

	@GetMapping("/teams/{teamName1}/{teamName2}")
	public ModelAndView getTeamByName1AndName2(@PathVariable("teamName1") String teamName1,
			@PathVariable("teamName2") String teamName2,
			@RequestParam(defaultValue = "0", name = "cp", required = false) int cp,
			@RequestParam(defaultValue = "", name = "venue", required = false) String venue) {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("venue", venue);
		queryParams.put("team1", teamName1);
		queryParams.put("team2", teamName2);
		queryParams.put("cp", String.valueOf(cp));
		return getTeams(queryParams);

		// ModelAndView modelAndView = new ModelAndView("teamDetails");
		// if (cp <= 0) {
		// cp = 0;
		// }
		// if (venue == null || venue.equals("null")) {
		// venue = "";
		// }
		// modelAndView.addObject("pageSize", 10);
		// modelAndView.addObject("teams", teamService
		// .getTeamByName1AndName2(teamName1, teamName2, cp, venue, 10));
		// if (!venue.isEmpty()) {
		// modelAndView.addObject("venue", venue);
		// }
		// if (!teamName1.isEmpty()) {
		// modelAndView.addObject("teamName1", teamName1);
		// }
		// if (!teamName1.isEmpty()) {
		// modelAndView.addObject("teamName2", teamName2);
		// }
		// modelAndView.addObject("pageBaseUrl",
		// "/teams/" + teamName1 + "/" + teamName2 + "?venue=" + venue);
		//
		// return modelAndView;
	}

	@GetMapping("/teams/{teamName1}")
	public ModelAndView getTeamByName1(@PathVariable("teamName1") String teamName1,
			@RequestParam(defaultValue = "0", name = "cp", required = false) int cp,
			@RequestParam(defaultValue = "", name = "venue", required = false) String venue) {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("venue", venue);
		queryParams.put("team1", teamName1);
		queryParams.put("cp", String.valueOf(cp));
		return getTeams(queryParams);
		// ModelAndView modelAndView = new ModelAndView("teamDetails");
		// List<Team> teams = teamService.getTeamByName1(teamName1, cp, venue,
		// 10);
		// modelAndView.addObject("teams", teams);
		// if (cp <= 0) {
		// cp = 0;
		// }
		// if (venue == null || venue.equals("null")) {
		// venue = "";
		// }
		//
		// modelAndView.addObject("pageSize", 10);
		// if (!teamName1.isEmpty()) {
		// modelAndView.addObject("teamName1", teamName1);
		// }
		// if (!venue.isEmpty()) {
		// modelAndView.addObject("venue", venue);
		// }
		// modelAndView.addObject("pageBaseUrl",
		// "/teams/" + teamName1 + "?venue=" + venue);
		//
		// return modelAndView;
	}

	@GetMapping("/")
	public ModelAndView getHome(@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("slug", dataService.getSlug());
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("team1", "");
		queryMap.put("team2", "");
		queryMap.put("venue", "");
		queryMap.put("city", "");
		queryMap.put("season", "");
		queryMap.put("stage", "");
		queryMap.put("group", "");
		queryMap.put("playerOfMatch", "");
		queryMap.put("winner", "");
		queryMap.put("result", "");
		queryMap.put("result", "");
		queryMap.put("tossWinner", "");
		queryMap.put("tossDecision", "");
		modelAndView.addObject("pageSize", 10);

		if (queryParams != null && !queryParams.isEmpty()) {
			for (Entry<String, String> queryParam : queryParams.entrySet()) {
				if (queryParam.getValue() != null && !queryParam.getValue().isEmpty()
						&& !queryParam.getValue().equalsIgnoreCase("null")
						&& !ignoreList.contains(queryParam.getKey())) {
					// modelAndView.addObject(queryParam.getKey(),
					// queryParam.getValue());
					queryMap.put(queryParam.getKey(), queryParam.getValue());
				}
			}

		}
		String pre = "&";
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Object> queryParam : queryMap.entrySet()) {
			if (queryParam.getValue() != null && !ignoreList.contains((queryParam.getKey()))) {
				modelAndView.addObject(queryParam.getKey(), queryParam.getValue());
				sb.append(pre).append(queryParam.getKey()).append("=").append(String.valueOf(queryParam.getValue()));
				pre = "&";
			}
		}
		List<Team> temp = teamService.getTeams(queryParams);
		modelAndView.addObject("pageBaseUrl", "?1=1" + sb.toString());
		modelAndView.addObject("teams", temp);
		return modelAndView;
	}

}
