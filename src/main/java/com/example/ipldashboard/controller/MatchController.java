package com.example.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.MatchInputJson;
import com.example.ipldashboard.model.MatchInputJsonOutcome;
import com.example.ipldashboard.service.DataService;
import com.example.ipldashboard.service.MatchService;

@RestController
public class MatchController {

	@Autowired
	private MatchService matchService;

	private int PAGE_SIZE = 10;

	@Autowired
	private DataService dataService;

	@GetMapping("/matches")
	public ModelAndView getMatches(@RequestParam(defaultValue = "0", name = "cp", required = false) int cp) {
		ModelAndView modelAndView = new ModelAndView("matches");
		modelAndView.addObject("slug", dataService.getSlug());
		if (cp <= 0) {
			cp = 0;
		}
		modelAndView.addObject("pageSize", PAGE_SIZE);
		Page<Match> page = matchService.getMatches(cp, PAGE_SIZE);
		modelAndView.addObject("matches", page);
		modelAndView.addObject("hasNext", page.hasNext());
		modelAndView.addObject("hasPrevious", page.hasPrevious());
		return modelAndView;
	}

	@GetMapping("/matches/{id}")
	public ModelAndView getMatchDetails(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("matchDetailsJson");
		modelAndView.addObject("slug", dataService.getSlug());
		MatchInputJson matchDetails = matchService.getMatchDetails(id);
		modelAndView.addObject("match", matchDetails);
		modelAndView.addObject("result", getOutcome(matchDetails));
		return modelAndView;
	}

	public String getOutcome(MatchInputJson matchInputJson) {
		StringBuilder sb = new StringBuilder();
		if (matchInputJson != null && matchInputJson.getInfo() != null
				&& matchInputJson.getInfo().getOutcome() != null) {
			MatchInputJsonOutcome outcome = matchInputJson.getInfo().getOutcome();
			if (outcome.getWinner() != null) {
				sb.append(outcome.getWinner()).append(" won by ");
				if (outcome.getBy() != null) {
					if (outcome.getBy().getWickets() > 0) {
						sb.append(outcome.getBy().getWickets()).append(" wickets.");
					} else if (outcome.getBy().getRuns() > 0) {
						sb.append(outcome.getBy().getRuns()).append(" runs.");
					} else if (outcome.getBy().getInnings() > 0) {
						sb.append(outcome.getBy().getInnings()).append(" innings.");
					}
				}
			} else {
				sb.append("Match returned no Result.");
			}
		} else {
			sb.append("Match returned no Result.");
		}
		return sb.toString();
	}
}
