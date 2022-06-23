package com.example.ipldashboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.Page;
import com.example.ipldashboard.model.PageBuilder;
import com.example.ipldashboard.model.Player;
import com.example.ipldashboard.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> getPlayers(Map<String, String> queryParams) {
		List<Player> matches = playerRepository.findAll();
		if (matches != null && !matches.isEmpty()) {
			matches = new ArrayList<Player>(matches);
			Stream<Player> stream = matches.stream();
			String player = queryParams.get("player");
			String team = queryParams.get("team");
			String venue = queryParams.get("venue");
			String city = queryParams.get("city");
			String season = queryParams.get("season");
			String eventStage = queryParams.get("stage");
			String eventGroup = queryParams.get("group");
			String playerOfMatch = queryParams.get("playerOfMatch");
			String winner = queryParams.get("winner");
			String result = queryParams.get("result");
			String tossWinner = queryParams.get("tossWinner");
			String tossDecision = queryParams.get("tossDecision");
			System.out.println(team);
			int tempCp = 0;
			try {
				tempCp = Integer.parseInt(queryParams.get("cp"));
			} catch (Exception e) {
				tempCp = 0;
			}
			int tempPageSize = 10;
			try {
				tempPageSize = Integer.parseInt(queryParams.get("pageSize"));
			} catch (Exception e) {
				tempPageSize = 10;
			}
			final int pageSize = tempPageSize;
			final int cp = tempCp;

			if (team != null && !team.isEmpty()) {
				stream = stream.filter(x -> (x.getTeam().equalsIgnoreCase(team)));
			}
			if (player != null && !player.isEmpty()) {
				stream = stream.filter(x -> x.getName().equalsIgnoreCase(player));
			}
			if (city != null && !city.isEmpty()) {
				stream = stream.filter(x -> x.getCity().equalsIgnoreCase(city));
			}
			if (venue != null && !venue.isEmpty()) {
				stream = stream.filter(x -> x.getVenue().equalsIgnoreCase(venue));
			}
			if (season != null && !season.isEmpty()) {
				stream = stream.filter(x -> x.getSeason().equalsIgnoreCase(season));
			}
			if (eventStage != null && !eventStage.isEmpty()) {
				stream = stream.filter(x -> x.getEventStage() != null && !x.getEventStage().isEmpty())
						.filter(x -> x.getEventStage().equalsIgnoreCase(eventStage));
			}
			if (eventGroup != null && !eventGroup.isEmpty()) {
				stream = stream.filter(x -> x.getEventGroup() != null && !x.getEventGroup().isEmpty())
						.filter(x -> x.getEventGroup().equalsIgnoreCase(eventGroup));
			}
			if (playerOfMatch != null && !playerOfMatch.isEmpty()) {
				stream = stream.filter(x -> x.getPlayerOfMatch().equalsIgnoreCase(player));
			}
			if (winner != null && !winner.isEmpty()) {
				stream = stream.filter(x -> x.getWinner().equalsIgnoreCase(winner));
			}
			if (result != null && !result.isEmpty()) {
				stream = stream.filter(x -> x.getResult().equalsIgnoreCase(result));
			}
			if (tossWinner != null && !tossWinner.isEmpty()) {
				stream = stream.filter(x -> x.getTossWinner().equalsIgnoreCase(tossWinner));
			}
			if (tossDecision != null && !tossDecision.isEmpty()) {
				stream = stream.filter(x -> x.getTossDecision().equalsIgnoreCase(tossDecision));
			}
			if (player != null && !player.isEmpty()) {
				stream = stream.filter(x -> x.getName().contains(player));
			}
			final Map<String, Player> players = new TreeMap<>();

			if (stream != null) {
				stream.forEach(playerInput -> {
					Player playerTemp = players.get(playerInput.getName());
					if (playerTemp == null) {
						playerTemp = new Player();
						BeanUtils.copyProperties(playerInput, playerTemp);
						players.put(playerTemp.getName(), playerTemp);
					}
					Match match = new Match();
					BeanUtils.copyProperties(playerInput, match);
					match.setId(playerInput.getMatch());
					match.setTeam1(playerInput.getMatchTeam1());
					match.setTeam2(playerInput.getMatchTeam2());
					playerTemp.getTeamNames().add(playerInput.getTeam());
					// Batting avg
					playerTemp.setBallsPlayed(playerTemp.getBallsPlayed() + playerInput.getBallsPlayed());
					playerTemp.setZeros(playerTemp.getZeros() + playerInput.getZeros());
					playerTemp.setOnes(playerTemp.getOnes() + playerInput.getOnes());
					playerTemp.setTwos(playerTemp.getTwos() + playerInput.getTwos());
					playerTemp.setThrees(playerTemp.getThrees() + playerInput.getThrees());
					playerTemp.setFours(playerTemp.getFours() + playerInput.getFours());
					playerTemp.setFives(playerTemp.getFives() + playerInput.getFives());
					playerTemp.setSixes(playerTemp.getSixes() + playerInput.getSixes());
					playerTemp.setRuns(playerTemp.getRuns() + playerInput.getRuns());

					if (playerInput.getPlayerOfMatch().equals(playerInput.getName())) {
						playerTemp.getPlayerOfMatches().add(playerInput.getMatch());
					}

					playerTemp.setKind(playerInput.getKind());
					double r = (double) playerTemp.getRuns() / playerTemp.getBallsPlayed();
					r *= 100.0;
					double salary = Math.round(r * 100.0) / 100.0;
					playerTemp.setStrikeRate(salary);

					//

					playerTemp.getMatchesAll().add(match);
					if (!playerTemp.getMatchesAll().isEmpty()) {
						Collections.sort(playerTemp.getMatchesAll());
						int totalMatches = playerTemp.getMatchesAll().size();
						int totalPages = (playerTemp.getMatchesAll().size() / pageSize) + 1;
						int offset = cp * pageSize;
						if (cp > totalPages - 1) {
							offset = (totalPages - 1) * pageSize;
						}
						List<Match> tempMatches1 = playerTemp.getMatchesAll().stream().skip(offset).limit(pageSize)
								.collect(Collectors.toList());
						// System.out.println("tempMatches1: " + tempMatches1);
						if (tempMatches1 != null && !tempMatches1.isEmpty()) {
							Page<Match> page = new PageBuilder<Match>().setContent(tempMatches1)
									.setNumber(offset / pageSize).setNumberOfElements(tempMatches1.size())
									.setTotalElements(totalMatches).setTotalPages(totalPages)
									.setTotalElements(totalMatches).build();
							playerTemp.setMatches(page);
						}
					}
					playerTemp.getVenues().add(playerInput.getVenue());
					playerTemp.getSeasons().add(playerInput.getSeason());
					if (playerInput.getEventStage() != null) {
						playerTemp.getEventStages().add(playerInput.getEventStage());
					}
					if (playerInput.getCity() != null) {
						playerTemp.getCities().add(playerInput.getCity());
					} else {
						// System.out.println("No City set as venue: " + x);
						playerTemp.getCities().add(playerInput.getVenue());
					}
					// System.out.println(x.getMatches().getContent());
					players.put(playerTemp.getName(), playerTemp);
				});
			}
			List<Player> playersLst = new ArrayList<>();
			for (Entry<String, Player> tempPlayer : players.entrySet()) {
				playersLst.add(tempPlayer.getValue());
			}
			return playersLst;
		}

		return null;
	}

}
