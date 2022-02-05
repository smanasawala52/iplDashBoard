package com.example.ipldashboard.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.service.DataService;
import com.example.ipldashboard.service.MatchService;
import com.example.ipldashboard.service.TeamService;
import com.example.ipldashboard.service.VenueService;

@RestController
public class HomePageController {

	@Autowired
	private TeamService teamService;

	@Autowired
	private DataService dataService;

	@Autowired
	private MatchService matchService;

	@Autowired
	private VenueService venueService;

	private int PAGE_SIZE = 5;

	@GetMapping("/")
	public ModelAndView getHome(@RequestParam final Map<String, String> queryParams) {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("slug", dataService.getSlug());
		modelAndView.addObject("teams", teamService.getTeams());
		modelAndView.addObject("venues", venueService.getVenues());
		modelAndView.addObject("matches", matchService.getMatches(0, PAGE_SIZE).getContent());
		modelAndView.addObject("cities", venueService.getCities());
		return modelAndView;
	}

	@GetMapping("/loadMatchData")
	public ModelAndView loadMatchData() {
		ModelAndView modelAndView = new ModelAndView("loadMatchData");
		return modelAndView;
	}

	@GetMapping("/loadMatchData/{id}")
	public List<Match> loadMatchData(@PathVariable("id") final String dirPath) {
		dataService.setDirLocation(dirPath);
		try {
			dataService.loadMatchData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matchService.getMatches(0, PAGE_SIZE).getContent();
	}
}
