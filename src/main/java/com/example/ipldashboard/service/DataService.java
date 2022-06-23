package com.example.ipldashboard.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.model.ITeamCount;
import com.example.ipldashboard.model.IVenueCount;
import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.MatchBuilder;
import com.example.ipldashboard.model.MatchInputJson;
import com.example.ipldashboard.model.MatchInputJsonInning;
import com.example.ipldashboard.model.MatchInputJsonInningBatters;
import com.example.ipldashboard.model.MatchInputJsonInningBowlers;
import com.example.ipldashboard.model.Player;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.model.Venue;
import com.example.ipldashboard.model.VenueBuilder;
import com.example.ipldashboard.repository.MatchRepository;
import com.example.ipldashboard.repository.PlayerRepository;
import com.example.ipldashboard.repository.TeamRepository;
import com.example.ipldashboard.repository.VenueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataService {
	private String dirLocation = "ipl_json";
	private String slug = "IPL";

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private MatchRepository matchRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private VenueRepository venueRepository;

	@Autowired
	private TeamService teamService;

	@PostConstruct
	public void loadMatchData() throws Exception {
		System.out.println("Dataloading started");
		matchRepository.deleteAll();
		matchRepository.flush();
		teamRepository.deleteAll();
		teamRepository.flush();
		venueRepository.deleteAll();
		venueRepository.flush();
		playerRepository.deleteAll();
		playerRepository.flush();

		List<Match> matches = new ArrayList<>();
		Map<String, Player> players1 = new HashMap<>();
		try {
			List<File> files = Files.list(Paths.get(dirLocation)).map(Path::toFile).collect(Collectors.toList());
			for (File file : files) {
				try {
					if (file.getPath().endsWith(".json")) {
						MatchInputJson value = objectMapper.readValue(new File(file.getPath()), MatchInputJson.class);
						// System.out.println(value);
						if (dirLocation.equalsIgnoreCase("t20s_male_json")) {
							if (value != null && value.getInfo() != null && value.getInfo().getEvent() != null
									&& value.getInfo().getEvent().getName() != null
									&& value.getInfo().getSeason() != null) {
								if (!value.getInfo().getEvent().getName().equalsIgnoreCase("ICC Men's T20 World Cup")
										|| !value.getInfo().getSeason().equalsIgnoreCase("2021/22")) {
									continue;
								}
							} else {
								continue;
							}
						}
						if (dirLocation.equalsIgnoreCase("odis_male_json") && value != null && value.getInfo() != null
								&& value.getInfo().getEvent() != null && value.getInfo().getEvent().getName() != null
								&& !value.getInfo().getEvent().getName().equalsIgnoreCase("World Cup")) {
							continue;
						}
						Match match = new MatchBuilder().setId(Long.valueOf(file.getName().replace(".json", "")))
								.setCity(value.getInfo().getCity())
								.setDate(Instant.ofEpochMilli(value.getInfo().getDates().get(0).getTime())
										.atZone(ZoneId.systemDefault()).toLocalDate())
								.setPlayerOfMatch(value.getInfo().getPlayerOfMatch())
								.setEvent(value.getInfo().getEvent()).setOutcome(value.getInfo().getOutcome())
								.setTeam1(value.getInfo().getTeams().get(0)).setTeam2(value.getInfo().getTeams().get(1))
								.setVenue(value.getInfo().getVenue())
								.setTossDecision(value.getInfo().getToss().getDecision())
								.setTossWinner(value.getInfo().getToss().getWinner())
								.setOfficials(value.getInfo().getOfficials()).setSeson(value.getInfo().getSeason())
								.build();
						value.populateCummulativeData();
						// populate player data
						if (value.getInfo().getPlayers() != null && !value.getInfo().getPlayers().isEmpty()) {
							for (Entry<String, List<String>> matchPlayer : value.getInfo().getPlayers().entrySet()) {
								if (matchPlayer.getValue() != null && !matchPlayer.getValue().isEmpty()) {
									for (String pla : matchPlayer.getValue()) {
										Player player = players1.get(pla + "_" + match.getId());
										if (player == null) {
											player = new Player();
											player.setName(pla);
										}
										player.setMatchesPlayed(player.getMatchesPlayed() + 1);
										player.setMatch(match.getId());
										player.setTeam(matchPlayer.getKey());
										player.setMatchTeam1(match.getTeam1());
										player.setMatchTeam2(match.getTeam2());
										BeanUtils.copyProperties(match, player);
										players1.put(pla + "_" + match.getId(), player);
									}
									if (match.getPlayers() != null && !match.getPlayers().isEmpty()) {
										match.setPlayers(match.getPlayers() + "^" + matchPlayer.getKey() + "|"
												+ matchPlayer.getValue().toString().replace(", ", ",").replace("[", "")
														.replace("]", ""));
									} else {
										match.setPlayers(matchPlayer.getKey() + "|" + matchPlayer.getValue().toString()
												.replace(", ", ",").replace("[", "").replace("]", ""));
									}
								}
							}
						}
						if (value.getInnings() != null && !value.getInnings().isEmpty()) {
							for (MatchInputJsonInning inning : value.getInnings()) {
								if (inning.getBatters() != null && !inning.getBatters().isEmpty()) {
									for (Entry<String, MatchInputJsonInningBowlers> blower : inning.getBowlers()
											.entrySet()) {
										Player player = players1.get(blower.getKey() + "_" + match.getId());
										if (player == null) {
											player = new Player();
										}
										BeanUtils.copyProperties(blower.getValue(), player);
									}
									for (Entry<String, MatchInputJsonInningBatters> batter : inning.getBatters()
											.entrySet()) {
										Player player = players1.get(batter.getKey() + "_" + match.getId());
										if (player == null) {
											player = new Player();
										}
										BeanUtils.copyProperties(batter.getValue(), player);
										player.setName(batter.getKey());
										player.setBallsPlayed(
												player.getBallsPlayed() + batter.getValue().getBallsPlayed());
										player.setZeros(player.getZeros() + batter.getValue().getZeros());
										player.setOnes(player.getOnes() + batter.getValue().getOnes());
										player.setTwos(player.getTwos() + batter.getValue().getTwos());
										player.setThrees(player.getThrees() + batter.getValue().getThrees());
										player.setFours(player.getFours() + batter.getValue().getFours());
										player.setFives(player.getFives() + batter.getValue().getFives());
										player.setSixes(player.getSixes() + batter.getValue().getSixes());
										player.setRuns(player.getRuns() + batter.getValue().getRuns());
										player.setKind(batter.getValue().getKind());
										double r = (double) player.getRuns() / player.getBallsPlayed();
										r *= 100.0;
										double salary = Math.round(r * 100.0) / 100.0;
										player.setStrikeRate(salary);
										players1.put(batter.getKey() + "_" + match.getId(), player);
									}
								}

							}
						}
						matches.add(match);
					}
				} catch (Exception e) {
					System.out.println(file.getPath());
					e.printStackTrace();
				}
			}
			// files.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(matches);
		matchRepository.saveAllAndFlush(matches);
		playerRepository.saveAllAndFlush(players1.values());
		players1.values().parallelStream()
				.filter(x -> x.getName().equalsIgnoreCase("HH Pandya") && x.getMatch() == 1312200L)
				.forEach(System.out::println);
//		System.out.println(players1);
		System.out.println("JOB FINISHED");
		jdbcTemplate
				.query("SELECT * FROM matches",
						(rs, rn) -> new MatchBuilder().setId(rs.getLong("id")).setCity(rs.getString("city"))
								.setUmpire1(rs.getString("umpire1")).setUmpire2(rs.getString("umpire2"))
								.setDate(Instant.ofEpochMilli(rs.getDate("date").getTime())
										.atZone(ZoneId.systemDefault()).toLocalDate())
								// LocalDate.ofInstant(input.toInstant(),
								// ZoneId.systemDefault())
								.setTeam1(rs.getString("team1")).setTeam2(rs.getString("team2"))
								.setWinner(rs.getString("winner")).setResult(rs.getString("result"))
								.setResultMargin(rs.getString("result_margin"))
								.setPlayerOfMatch(rs.getString("player_of_match")).setVenue(rs.getString("venue"))
								.setPlayers(rs.getString("players")).build())
				.forEach(match -> System.out.println("" + match));

		List<ITeamCount> objs = matchRepository.countTotalMatchesByTeam1();
		List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2();
		List<Team> teams = teamService.getTeams(objs, objs2);
		// System.out.println(teams);

		teamRepository.saveAll(teams);

		System.out.println("------------------------");

		List<IVenueCount> objsVenues = matchRepository.countTotalMatchesByVenue();
		List<Venue> venues = objsVenues.stream()
				.map(x -> new VenueBuilder().setName(x.getVenueName()).setCity(x.getCity())
						.setTotalMatches(x.getTotalMatches()).setTotalWins(x.getTotalWins())
						.setTotalTies(x.getTotalTies()).setTotalNoResult(x.getTotalNoResult())
						.setTotalTossWinBatFirst(x.getTotalTossWinBatFirst())
						.setTotalTossWinFieldFirst(x.getTotalTossWinFieldFirst()).setTotalWins(x.getTotalWins())
						.setTotalWinsBatFirst(x.getTotalWinsBatFirst())
						.setTotalWinsFieldFirst(x.getTotalWinsFieldFirst()).setTotalWinsByRuns(x.getTotalWinsByRuns())
						.setTotalWinsByWikets(x.getTotalWinsByWikets()).setTeams(x.getTeams()).build())
				.collect(Collectors.toList());
		// System.out.println(venues);

		venueRepository.saveAll(venues);

	}

	public void setDirLocation(String dirLocation) {
		if (dirLocation != null && !dirLocation.isEmpty()) {
			this.dirLocation = dirLocation;
			switch (dirLocation) {
			case "ipl_json":
				slug = "IPL Dashboard";
				break;
			case "t20s_male_json":
				slug = "ICC Men's T20 World Cup Dashboard";
				break;
			case "odis_male_json":
				slug = "ODIs Male";
				break;
			}
		}

	}

	public MatchInputJson getMatch(Long key) {
		try {
			MatchInputJson value = objectMapper.readValue(new File(dirLocation + "/" + key + ".json"),
					MatchInputJson.class);
			if (value != null) {
				value.populateCummulativeData();
			}
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getSlug() {
		return slug;
	}

}
