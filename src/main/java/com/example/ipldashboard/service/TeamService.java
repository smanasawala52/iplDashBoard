package com.example.ipldashboard.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.model.ITeamCount;
import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.Page;
import com.example.ipldashboard.model.PageBuilder;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.model.TeamBuilder;
import com.example.ipldashboard.model.Venue;
import com.example.ipldashboard.repository.MatchRepository;
import com.example.ipldashboard.repository.TeamRepository;

@Service
public class TeamService {

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private TeamRepository teamRepository;

	public List<Team> getTeams(List<ITeamCount> objs1, List<ITeamCount> objs2) {
		List<Team> t1 = objs1.stream()
				.map(x -> new TeamBuilder().setName(x.getTeamName()).setTotalMatches(x.getTotalMatches())
						.setTotalWins(x.getTotalWins()).setTotalBatFirst(x.getTotalBatFirst())
						.setTotalFieldFirst(x.getTotalFieldFirst()).setTotalNoResult(x.getTotalNoResult())
						.setTotalTies(x.getTotalTies()).setTotalTossWinBatFirst(x.getTotalTossWinBatFirst())
						.setTotalTossWinFieldFirst(x.getTotalTossWinFieldFirst()).setTotalTossWins(x.getTotalTossWins())
						.setTotalWins(x.getTotalWins()).setTotalWinsBatFirst(x.getTotalWinsBatFirst())
						.setTotalWinsFieldFirst(x.getTotalWinsFieldFirst()).setTotalWinsByRuns(x.getTotalWinsByRuns())
						.setTotalWinsByWikets(x.getTotalWinsByWikets()).build())
				.collect(Collectors.toList());
		List<Team> t2 = objs2.stream()
				.map(x -> new TeamBuilder().setName(x.getTeamName()).setTotalMatches(x.getTotalMatches())
						.setTotalWins(x.getTotalWins()).setTotalBatFirst(x.getTotalBatFirst())
						.setTotalFieldFirst(x.getTotalFieldFirst()).setTotalNoResult(x.getTotalNoResult())
						.setTotalTies(x.getTotalTies()).setTotalTossWinBatFirst(x.getTotalTossWinBatFirst())
						.setTotalTossWinFieldFirst(x.getTotalTossWinFieldFirst()).setTotalTossWins(x.getTotalTossWins())
						.setTotalWins(x.getTotalWins()).setTotalWinsBatFirst(x.getTotalWinsBatFirst())
						.setTotalWinsFieldFirst(x.getTotalWinsFieldFirst()).setTotalWinsByRuns(x.getTotalWinsByRuns())
						.setTotalWinsByWikets(x.getTotalWinsByWikets()).build())
				.collect(Collectors.toList());
		// System.out.println(t1 + "" + t2);
		List<Team> teams = new ArrayList<>(Stream.of(t1, t2).flatMap(List::stream)
				.collect(Collectors.toMap(Team::getName, d -> d, (Team x, Team y) -> {
					x.setTotalBatFirst(x.getTotalBatFirst() + y.getTotalBatFirst());
					x.setTotalFieldFirst(x.getTotalFieldFirst() + y.getTotalFieldFirst());
					x.setTotalMatches(x.getTotalMatches() + y.getTotalMatches());
					x.setTotalNoResult(x.getTotalNoResult() + y.getTotalNoResult());
					x.setTotalTies(x.getTotalTies() + y.getTotalTies());
					x.setTotalTossWinBatFirst(x.getTotalTossWinBatFirst() + y.getTotalTossWinBatFirst());
					x.setTotalTossWinFieldFirst(x.getTotalTossWinFieldFirst() + y.getTotalTossWinFieldFirst());
					x.setTotalTossWins(x.getTotalTossWins() + y.getTotalTossWins());
					x.setTotalWins(x.getTotalWins() + y.getTotalWins());
					x.setTotalWinsBatFirst(x.getTotalWinsBatFirst() + y.getTotalWinsBatFirst());
					x.setTotalWinsFieldFirst(x.getTotalWinsFieldFirst() + y.getTotalWinsFieldFirst());
					x.setTotalWinsByRuns(x.getTotalWinsByRuns() + y.getTotalWinsByRuns());
					x.setTotalWinsByWikets(x.getTotalWinsByWikets() + y.getTotalWinsByWikets());
					x.getTeams().addAll(y.getTeams());
					x.setTotalWinsPercent(populateWinsPercent(x.getTotalWins(), x.getTotalMatches()));
					return x;
				})).values());
		;
		return teams;
	}

	public List<Team> getTeams() {
		return teamRepository.findAllByOrderByNameAsc();
	}

	public List<Team> getTeamByName1AndName2(String teamName1, String teamName2, int cp, String venue, int pageSize) {
		System.out.println("Venue: " + venue + " teamName1: " + teamName1 + " teamName2: " + teamName2);
		if (!venue.isEmpty()) {
			List<ITeamCount> objs1 = matchRepository.countTotalMatchesByTeam1AndTeam2AndVenue(teamName1, teamName2,
					venue);
			List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2AndTeam1AndVenue(teamName2, teamName1,
					venue);
			List<Team> teams = getTeams(objs1, objs2);
			teams = teams.stream().map(team -> {
				// team.setMatches(matchRepository
				// .getByVenueAndTeam1AndTeam2OrVenueAndTeam2AndTeam1OrderByDateDesc(
				// venue, teamName1, teamName2, venue, teamName1,
				// teamName2, PageRequest.of(cp, pageSize)));
				return team;
			}).collect(Collectors.toList());

			// Get team 2 data as well
			List<ITeamCount> objs1Team2 = matchRepository.countTotalMatchesByTeam1AndTeam2AndVenue(teamName2, teamName1,
					venue);
			List<ITeamCount> objs2Team2 = matchRepository.countTotalMatchesByTeam2AndTeam1AndVenue(teamName1, teamName2,
					venue);
			List<Team> teams2 = getTeams(objs1Team2, objs2Team2);
			if (teams != null && teams2 != null) {
				teams.addAll(teams2);
			}
			System.out.println(teams2);
			return teams;
		} else {
			List<ITeamCount> objs1 = matchRepository.countTotalMatchesByTeam1AndTeam2(teamName1, teamName2);
			List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2AndTeam1(teamName2, teamName1);

			List<Team> teams = getTeams(objs1, objs2);
			teams = teams.stream().map(team -> {
				List<String> lstVenues = matchRepository.findCity(teamName1, teamName2, teamName2, teamName1);
				// Collections.sort(lstVenues);
				System.out.println("Shabbir: " + lstVenues);
				team.getVenues().addAll(lstVenues);
				// team.setMatches(matchRepository
				// .getByTeam1AndTeam2OrTeam2AndTeam1OrderByDateDesc(
				// teamName1, teamName2, teamName1, teamName2,
				// PageRequest.of(cp, pageSize)));
				return team;
			}).collect(Collectors.toList());

			// Get team 2 data as well
			List<ITeamCount> objs1Team2 = matchRepository.countTotalMatchesByTeam1AndTeam2(teamName2, teamName1);
			List<ITeamCount> objs2Team2 = matchRepository.countTotalMatchesByTeam2AndTeam1(teamName1, teamName2);
			List<Team> teams2 = getTeams(objs1Team2, objs2Team2);
			if (teams != null && teams2 != null) {
				teams.addAll(teams2);
			}

			System.out.println(teams);
			return teams;
		}
	}

	public List<Team> getTeamByName1(String teamName1, int cp, String venue, int pageSize) {
		System.out.println("Venue: " + venue);
		final List<Team> teamsAll = getTeams();
		if (!venue.isEmpty()) {
			List<ITeamCount> objs1 = matchRepository.countTotalMatchesByTeam1AndVenue(teamName1, venue);
			List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2AndVenue(teamName1, venue);
			List<Team> teams = getTeams(objs1, objs2);
			teams = teams.stream().map(team -> {
				// team.setMatches(matchRepository
				// .getByVenueAndTeam1OrVenueAndTeam2OrderByDateDesc(venue,
				// teamName1, venue, teamName1,
				// PageRequest.of(cp, pageSize)));
				teamsAll.stream().filter(x -> !x.getName().equalsIgnoreCase(teamName1)).forEach(x -> {
					List<Team> temp = getTeamByName1AndName2(teamName1, x.getName(), 0, venue, 3);
					if (temp != null && !temp.isEmpty()) {
						temp.get(0).setName(x.getName());
						team.getTeams().addAll(temp);
					}
				});
				return team;
			}).collect(Collectors.toList());

			System.out.println(teams);
			return teams;
		} else {
			List<ITeamCount> objs1 = matchRepository.countTotalMatchesByTeam1(teamName1);
			List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2(teamName1);
			List<Team> teams = getTeams(objs1, objs2);
			teams = teams.stream().map(team -> {
				// team.setMatches(matchRepository
				// .getByTeam1OrTeam2OrderByDateDesc(teamName1, teamName1,
				// PageRequest.of(cp, pageSize)));
				List<String> lstV = matchRepository.findCity(teamName1, teamName1);
				// Collections.sort(lstV);
				System.out.println("Shabbir: " + lstV);
				team.getVenues().addAll(lstV);
				teamsAll.stream().filter(x -> !x.getName().equalsIgnoreCase(teamName1)).forEach(x -> {
					List<Team> temp = getTeamByName1AndName2(teamName1, x.getName(), 0, venue, 3);
					if (temp != null && !temp.isEmpty()) {
						temp.get(0).setName(x.getName());
						team.getTeams().addAll(temp);
					}
				});
				return team;
			}).collect(Collectors.toList());
			return teams;
		}
	}

	private double populateWinsPercent(long totalWins, long totalMatches) {
		System.out.println("total Wins: " + totalWins + " totalMatches: " + totalMatches);
		double totalWinsPercent = 0;
		if (totalWins > 0 && totalMatches > 0) {
			totalWinsPercent = (totalWins * 100) / totalMatches;
		}
		totalWinsPercent = (((int) totalWinsPercent * 100) / 100);
		return totalWinsPercent;
	}

	public List<Team> getTeams(Map<String, String> queryParams) {
		List<Match> matches = matchRepository.findAll();
		if (matches != null && !matches.isEmpty()) {
			matches = new ArrayList<Match>(matches);
			Stream<Match> stream = matches.stream();
			String team1 = queryParams.get("team1");
			String team2 = queryParams.get("team2");
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
			String player = queryParams.get("player");
			int cp = 0;
			try {
				cp = Integer.parseInt(queryParams.get("cp"));
			} catch (Exception e) {
				cp = 0;
			}
			int pageSize = 10;
			try {
				pageSize = Integer.parseInt(queryParams.get("pageSize"));
			} catch (Exception e) {
				pageSize = 10;
			}

			if (team1 != null && !team1.isEmpty() && team2 != null && !team2.isEmpty()) {
				stream = stream
						.filter(x -> (x.getTeam1().equalsIgnoreCase(team1) && x.getTeam2().equalsIgnoreCase(team2))
								|| x.getTeam1().equalsIgnoreCase(team2) && x.getTeam2().equalsIgnoreCase(team1));
			} else if (team1 != null && !team1.isEmpty() && (team2 == null || (team2 != null && team2.isEmpty()))) {
				stream = stream
						.filter(x -> x.getTeam1().equalsIgnoreCase(team1) || x.getTeam2().equalsIgnoreCase(team1));
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
				stream = stream.filter(x -> x.getPlayerOfMatch().equalsIgnoreCase(playerOfMatch));
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
				stream = stream.filter(x -> x.getPlayers().contains(player));
			}
			final List<Match> tempMatches = new ArrayList<>();
			final Map<String, Venue> venues = new HashMap<>();
			final Map<String, Team> otherTeams = new TreeMap<>();
			final Map<String, List<Match>> teams2Matches = new TreeMap<>();
			final SortedSet<String> seasons = new TreeSet<>();
			final SortedSet<String> eventStages = new TreeSet<>();
			final SortedSet<String> cities = new TreeSet<>();
			final SortedSet<String> players = new TreeSet<>();
			final Team t1 = new Team();
			final Team t2 = new Team();

			if (stream != null) {
				stream.forEach(x -> {
					tempMatches.add(x);
					Map<String, List<String>> playersMap = new HashMap<>();
					if (x.getPlayers() != null) {
						String[] playerTeams = x.getPlayers().split("\\^");
//						System.out.println("------------playerTeams raw------------------------: " + x.getPlayers());
//						List<String> playerTeams = Arrays.asList(x.getPlayers().split("^"));
						for (int i = 0; i < playerTeams.length; i++) {
//							System.out.println(
//									"----i: " + i + "--------playerTeams------------------------: " + playerTeams[i]);
							String[] playerTeamsPlayer = playerTeams[i].split("\\|");
							List<String> tmpPlayers = new ArrayList<>();
							String[] playerslst = playerTeamsPlayer[1].split(",");
							for (int j = 0; j < playerslst.length; j++) {
								tmpPlayers.add(playerslst[j]);
							}
							playersMap.put(playerTeamsPlayer[0], tmpPlayers);
						}
//						for (String playerTeam : playerTeams) {
//							List<String> playerTeamsPlayer = Arrays.asList(playerTeam.split("|"));
//							System.out.println(
//									"------------playerTeamsPlayer------------------------: " + playerTeamsPlayer);
//							playersMap.put(playerTeamsPlayer.get(0),
//									Arrays.asList(playerTeamsPlayer.get(1).split(",")));
//						}
//						System.out.println("------------------------------------: " + playersMap);
					}
					Team otherTeam = new Team();
					if (otherTeams.get(x.getTeam2()) == null) {
						otherTeam.setName(x.getTeam2());
					} else {
						otherTeam = otherTeams.get(x.getTeam2());
					}
					if (team1 != null && !team1.isEmpty()) {
						t1.setName(team1);
						if (playersMap.get(team1) != null) {
//							System.out.println(team1 + "playersMap.get(team1)" + playersMap.get(team1));
							players.addAll(playersMap.get(team1));
						}
						if (x.getTeam1().equals(team1)) {
							// add team2 details to teams2Names and
							// teams2Matches for comparsion
							if (otherTeams.get(x.getTeam2()) == null) {
								otherTeam.setName(x.getTeam2());
								otherTeams.put(x.getTeam2(), otherTeam);
							} else {
								otherTeam = otherTeams.get(x.getTeam2());
							}
							if (teams2Matches.get(x.getTeam2()) == null) {
								List<Match> lstMatches = new ArrayList<>();
								lstMatches.add(x);
								teams2Matches.put(x.getTeam2(), lstMatches);
							} else {
								teams2Matches.get(x.getTeam2()).add(x);
							}
						}
						if (x.getTeam2().equals(team1)) {
							// add team2 details to teams2Names and
							// teams2Matches for comparsion
							if (otherTeams.get(x.getTeam1()) == null) {
								otherTeam.setName(x.getTeam1());
								otherTeams.put(x.getTeam1(), otherTeam);
							} else {
								otherTeam = otherTeams.get(x.getTeam1());
							}
							if (teams2Matches.get(x.getTeam1()) == null) {
								List<Match> lstMatches = new ArrayList<>();
								lstMatches.add(x);
								teams2Matches.put(x.getTeam1(), lstMatches);
							} else {
								teams2Matches.get(x.getTeam1()).add(x);
							}
						}
						t1.setTotalMatches(t1.getTotalMatches() + 1);
						if ((x.getResult() != null && x.getResult().isEmpty()) || x.getResult() == null
								|| (x.getResult() != null && x.getResult().equalsIgnoreCase("NA"))) {
							t1.setTotalNoResult(t1.getTotalNoResult() + 1);
						}
						if (x.getWinner() != null && x.getWinner().equals(team1)) {
							t1.setTotalWins(t1.getTotalWins() + 1);
						}
						if (x.getTossWinner().equals(team1)) {
							t1.setTotalTossWins(t1.getTotalTossWins() + 1);
							if (x.getTossDecision().equals("bat")) {
								t1.setTotalTossWinBatFirst(t1.getTotalTossWinBatFirst() + 1);
								t1.setTotalBatFirst(t1.getTotalBatFirst() + 1);
								if (x.getWinner() != null && x.getWinner().equals(team1)) {
									t1.setTotalWinsBatFirst(t1.getTotalWinsBatFirst() + 1);
								}
							}
							if (x.getTossDecision().equals("field")) {
								t1.setTotalTossWinFieldFirst(t1.getTotalTossWinFieldFirst() + 1);
								t1.setTotalFieldFirst(t1.getTotalFieldFirst() + 1);
								if (x.getWinner() != null && x.getWinner().equals(team1)) {
									t1.setTotalWinsFieldFirst(t1.getTotalWinsFieldFirst() + 1);
								}
							}
						} else {
							if (x.getTossDecision().equals("field")) {
								t1.setTotalBatFirst(t1.getTotalBatFirst() + 1);
								if (x.getWinner() != null && x.getWinner().equals(team1)) {
									t1.setTotalWinsBatFirst(t1.getTotalWinsBatFirst() + 1);
								}
							}
							if (x.getTossDecision().equals("bat")) {
								t1.setTotalFieldFirst(t1.getTotalFieldFirst() + 1);
								if (x.getWinner() != null && x.getWinner().equals(team1)) {
									t1.setTotalWinsFieldFirst(t1.getTotalWinsFieldFirst() + 1);
								}
							}
						}
						if (x.getWinner() != null && x.getWinner().equals(team1)) {
							if (x.getResult().equalsIgnoreCase("runs")) {
								t1.setTotalWinsByRuns(t1.getTotalWinsByRuns() + 1);
							}
							if (x.getResult().equalsIgnoreCase("wickets")) {
								t1.setTotalWinsByWikets(t1.getTotalWinsByWikets() + 1);
							}
						}

					}
					otherTeam.setTotalMatches(otherTeam.getTotalMatches() + 1);
					if ((x.getResult() != null && x.getResult().isEmpty()) || x.getResult() == null
							|| (x.getResult() != null && x.getResult().equalsIgnoreCase("NA"))) {
						otherTeam.setTotalNoResult(otherTeam.getTotalNoResult() + 1);
					}
					if (x.getWinner() != null && x.getWinner().equals(otherTeam.getName())) {
						otherTeam.setTotalWins(otherTeam.getTotalWins() + 1);
					}
					if (x.getTossWinner().equals(otherTeam.getName())) {
						otherTeam.setTotalTossWins(otherTeam.getTotalTossWins() + 1);
						if (x.getTossDecision().equals("bat")) {
							otherTeam.setTotalTossWinBatFirst(otherTeam.getTotalTossWinBatFirst() + 1);
							otherTeam.setTotalBatFirst(otherTeam.getTotalBatFirst() + 1);
							if (x.getWinner().equals(otherTeam.getName())) {
								otherTeam.setTotalWinsBatFirst(otherTeam.getTotalWinsBatFirst() + 1);
							}
						}
						if (x.getTossDecision().equals("field")) {
							otherTeam.setTotalTossWinFieldFirst(otherTeam.getTotalTossWinFieldFirst() + 1);
							otherTeam.setTotalFieldFirst(otherTeam.getTotalFieldFirst() + 1);
							if (x.getWinner().equals(otherTeam.getName())) {
								otherTeam.setTotalWinsFieldFirst(otherTeam.getTotalWinsFieldFirst() + 1);
							}
						}
					} else {
						if (x.getTossDecision().equals("field")) {
							otherTeam.setTotalBatFirst(otherTeam.getTotalBatFirst() + 1);
							if (x.getWinner().equals(otherTeam.getName())) {
								otherTeam.setTotalWinsBatFirst(otherTeam.getTotalWinsBatFirst() + 1);
							}
						}
						if (x.getTossDecision().equals("bat")) {
							otherTeam.setTotalFieldFirst(otherTeam.getTotalFieldFirst() + 1);
							if (x.getWinner().equals(otherTeam.getName())) {
								otherTeam.setTotalWinsFieldFirst(otherTeam.getTotalWinsFieldFirst() + 1);
							}
						}
					}
					if (x.getWinner().equals(otherTeam.getName())) {
						if (x.getResult().equalsIgnoreCase("runs")) {
							otherTeam.setTotalWinsByRuns(otherTeam.getTotalWinsByRuns() + 1);
						}
						if (x.getResult().equalsIgnoreCase("wickets")) {
							otherTeam.setTotalWinsByWikets(otherTeam.getTotalWinsByWikets() + 1);
						}
					}

					otherTeams.put(otherTeam.getName(), otherTeam);
					if (team2 != null && !team2.isEmpty()) {
						t2.setName(team2);

						t2.setTotalMatches(t2.getTotalMatches() + 1);
						if ((x.getResult() != null && x.getResult().isEmpty()) || x.getResult() == null
								|| (x.getResult() != null && x.getResult().equalsIgnoreCase("NA"))) {
							t2.setTotalNoResult(t2.getTotalNoResult() + 1);
						}
						if (x.getWinner() != null && x.getWinner().equals(team2)) {
							t2.setTotalWins(t2.getTotalWins() + 1);
						}
						if (x.getTossWinner().equals(team2)) {
							t2.setTotalTossWins(t2.getTotalTossWins() + 1);
							if (x.getTossDecision().equals("bat")) {
								t2.setTotalTossWinBatFirst(t2.getTotalTossWinBatFirst() + 1);
								t2.setTotalBatFirst(t2.getTotalBatFirst() + 1);
								if (x.getWinner().equals(team2)) {
									t2.setTotalWinsBatFirst(t2.getTotalWinsBatFirst() + 1);
								}
							}
							if (x.getTossDecision().equals("field")) {
								t2.setTotalTossWinFieldFirst(t2.getTotalTossWinFieldFirst() + 1);
								t2.setTotalFieldFirst(t2.getTotalFieldFirst() + 1);
								if (x.getWinner().equals(team2)) {
									t2.setTotalWinsFieldFirst(t2.getTotalWinsFieldFirst() + 1);
								}
							}
						} else {
							if (x.getTossDecision().equals("field")) {
								t2.setTotalBatFirst(t2.getTotalBatFirst() + 1);
								if (x.getWinner().equals(team2)) {
									t2.setTotalWinsBatFirst(t2.getTotalWinsBatFirst() + 1);
								}
							}
							if (x.getTossDecision().equals("bat")) {
								t2.setTotalFieldFirst(t2.getTotalFieldFirst() + 1);
								if (x.getWinner().equals(team2)) {
									t2.setTotalWinsFieldFirst(t2.getTotalWinsFieldFirst() + 1);
								}
							}
						}
						if (x.getWinner().equals(team2)) {
							if (x.getResult().equalsIgnoreCase("runs")) {
								t2.setTotalWinsByRuns(t2.getTotalWinsByRuns() + 1);
							}
							if (x.getResult().equalsIgnoreCase("wickets")) {
								t2.setTotalWinsByWikets(t2.getTotalWinsByWikets() + 1);
							}
						}
					}
					Venue venueObj = new Venue();
					if (venues.get(x.getVenue()) != null) {
						venueObj = venues.get(x.getVenue());
					}
					venueObj.setName(x.getVenue());
					venueObj.setCity(x.getCity());
					venueObj.setMatches(null);
					venueObj.setTotalMatches(venueObj.getTotalMatches() + 1);
					if ((x.getResult() != null && x.getResult().isEmpty()) || x.getResult() == null
							|| (x.getResult() != null && x.getResult().equalsIgnoreCase("NA"))) {
						venueObj.setTotalNoResult(venueObj.getTotalNoResult() + 1);
					}
					if (x.getTossDecision().equals("field")) {
						venueObj.setTotalTossWinFieldFirst(venueObj.getTotalTossWinFieldFirst() + 1);
					}
					if (x.getTossDecision().equals("bat")) {
						venueObj.setTotalTossWinBatFirst(venueObj.getTotalTossWinBatFirst() + 1);
					}
					if (x.getWinner() != null) {
						venueObj.setTotalWins(venueObj.getTotalWins() + 1);
						if (x.getWinner().equals(x.getTossWinner())) {
							if (x.getTossDecision().equals("bat")) {
								venueObj.setTotalWinsBatFirst(venueObj.getTotalWinsBatFirst() + 1);
							}
							if (x.getTossDecision().equals("field")) {
								venueObj.setTotalWinsFieldFirst(venueObj.getTotalWinsFieldFirst() + 1);
							}
						} else {
							if (x.getTossDecision().equals("bat")) {
								venueObj.setTotalWinsFieldFirst(venueObj.getTotalWinsFieldFirst() + 1);
							}
							if (x.getTossDecision().equals("field")) {
								venueObj.setTotalWinsBatFirst(venueObj.getTotalWinsBatFirst() + 1);
							}
						}
						if (x.getResult().equals("runs")) {
							venueObj.setTotalWinsByRuns(venueObj.getTotalWinsByRuns() + 1);
						}
						if (x.getResult().equals("wickets")) {
							venueObj.setTotalWinsByWikets(venueObj.getTotalWinsByWikets() + 1);
						}
					}
					venues.put(x.getVenue(), venueObj);
					seasons.add(x.getSeason());
					if (x.getEventStage() != null) {
						eventStages.add(x.getEventStage());
					}

					if (x.getCity() != null) {
						cities.add(x.getCity());
					} else {
						System.out.println("No City set as venue: " + x);
						cities.add(x.getVenue());
					}
				});
			}
			if (!tempMatches.isEmpty()) {
				Collections.sort(tempMatches);
				int totalMatches = tempMatches.size();
				int totalPages = (tempMatches.size() / pageSize) + 1;
				int offset = cp * pageSize;
				if (cp > totalPages - 1) {
					offset = (totalPages - 1) * pageSize;
				}
				List<Match> tempMatches1 = tempMatches.stream().skip(offset).limit(pageSize)
						.collect(Collectors.toList());
				if (tempMatches1 != null && !tempMatches1.isEmpty()) {
					Page<Match> page = new PageBuilder<Match>().setContent(tempMatches1).setNumber(offset / pageSize)
							.setNumberOfElements(tempMatches1.size()).setTotalElements(totalMatches)
							.setTotalPages(totalPages).setTotalElements(totalMatches).build();
					t1.setMatches(page);
				}
			}
			if (venue != null && !venue.isEmpty()) {
				venues.remove(venue);
			}
			t1.setVenues(new TreeSet<>(venues.keySet()));
			if (venues != null && !venues.isEmpty() && venues.size() == 1) {
				queryParams.put("venue", venues.keySet().iterator().next());
			}
			if (season != null && !season.isEmpty()) {
				seasons.remove(season);
			}
			if (seasons != null && !seasons.isEmpty() && seasons.size() == 1) {
				queryParams.put("season", seasons.first());
			}
			t1.setSeasons(seasons);
			t1.setEventStage(eventStages);
			if (eventStages != null && !eventStages.isEmpty() && eventStages.size() == 1) {
				queryParams.put("stage", eventStages.first());
			}
			if (team2 != null && !team2.isEmpty()) {
				otherTeams.remove(team2);
			}
			if (!otherTeams.isEmpty() && !teams2Matches.isEmpty()) {
				for (Entry<String, Team> otherTeam : otherTeams.entrySet()) {
					List<Match> otherTeamMatches = teams2Matches.get(otherTeam.getKey());
					if (otherTeamMatches != null && !otherTeamMatches.isEmpty()) {
						int totalMatchesOtherTeams = otherTeamMatches.size();
						Collections.sort(otherTeamMatches);
						if (otherTeamMatches.size() > 3) {
							otherTeamMatches = otherTeamMatches.subList(0, 3);
						}
						Page<Match> pageOtherTeamMatches = new PageBuilder<Match>().setContent(otherTeamMatches)
								.setNumber(0).setNumberOfElements(otherTeamMatches.size())
								.setTotalElements(totalMatchesOtherTeams).setTotalPages(1).build();
						otherTeam.getValue().setMatches(pageOtherTeamMatches);
					}
					t1.getTeams().add(otherTeam.getValue());
				}
			}
			// System.out.println(cities);
			t1.setCities(cities);
			if (cities != null && !cities.isEmpty() && cities.size() == 1) {
				queryParams.put("city", cities.first());
			}
			t1.setPlayers(players);
			if (players != null && !players.isEmpty() && players.size() == 1) {
				queryParams.put("player", players.first());
			}
			t1.setTeamNames(new TreeSet<>(otherTeams.keySet()));
			if (otherTeams != null && !otherTeams.isEmpty() && otherTeams.size() == 1) {
				queryParams.put("team2", otherTeams.keySet().iterator().next());
			}
			// System.out.println("-------------------------------");
			// System.out.println(t1.getTeams());
			// System.out.println("-------------------------------");
			List<Team> teams = new ArrayList<>();
			teams.add(t1);
			if (team2 != null && !team2.isEmpty()) {
				teams.add(t2);
			}
			// System.out.println("-----------TEAMS--------------------" + team2);
			// System.out.println(t2);
			// System.out.println("-------------------------------");
			return teams;
		}

		return null;
	}

}
