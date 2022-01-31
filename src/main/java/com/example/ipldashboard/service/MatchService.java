package com.example.ipldashboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.MatchInputJson;
import com.example.ipldashboard.repository.MatchRepository;

@Service
public class MatchService {
	@Autowired
	private MatchRepository matchRepository;
	@Autowired
	private DataService dataService;

	public Page<Match> getMatches(int i, int pAGE_SIZE) {
		return matchRepository
				.getByOrderByDateDesc(PageRequest.of(i, pAGE_SIZE));

	}

	public MatchInputJson getMatchDetails(String id) {
		// Optional<Match> matchDetails = matchRepository
		// .findById(Long.valueOf(id));
		// if (matchDetails.isPresent()) {
		// return matchDetails.get();
		// }

		return dataService.getMatch(Long.valueOf(id));
	}
}
