package com.example.ipldashboard.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.model.Player;
import com.example.ipldashboard.service.DataService;
import com.example.ipldashboard.service.PlayerService;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService playerService;
	private List<String> ignoreList = Arrays.asList("cp", "pageSize");
	@Autowired
	private DataService dataService;

	@GetMapping("/player")
	public ModelAndView getPlayers(@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("players");
		modelAndView.addObject("slug", dataService.getSlug());
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("team", "");
		queryMap.put("player", "");
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
		queryMap.put("player", "");
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
		List<Player> temp = playerService.getPlayers(queryParams);
		modelAndView.addObject("pageBaseUrl", "/player?1=1" + sb.toString());
		modelAndView.addObject("players", temp);
		return modelAndView;
	}

}
