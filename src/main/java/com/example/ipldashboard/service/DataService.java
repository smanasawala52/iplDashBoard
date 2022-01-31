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
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.model.ITeamCount;
import com.example.ipldashboard.model.IVenueCount;
import com.example.ipldashboard.model.Match;
import com.example.ipldashboard.model.MatchBuilder;
import com.example.ipldashboard.model.MatchInputJson;
import com.example.ipldashboard.model.Team;
import com.example.ipldashboard.model.Venue;
import com.example.ipldashboard.model.VenueBuilder;
import com.example.ipldashboard.repository.MatchRepository;
import com.example.ipldashboard.repository.TeamRepository;
import com.example.ipldashboard.repository.VenueRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataService {
	private String dirLocation = "ipl_json";

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

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

		List<Match> matches = new ArrayList<>();
		try {
			List<File> files = Files.list(Paths.get(dirLocation))
					.map(Path::toFile).collect(Collectors.toList());
			for (File file : files) {
				try {
					MatchInputJson value = objectMapper.readValue(
							new File(file.getPath()), MatchInputJson.class);
					// System.out.println(value);
					Match match = new MatchBuilder()
							.setId(Long.valueOf(
									file.getName().replace(".json", "")))
							.setCity(value.getInfo().getCity())
							.setDate(Instant
									.ofEpochMilli(value.getInfo().getDates()
											.get(0).getTime())
									.atZone(ZoneId.systemDefault())
									.toLocalDate())
							.setPlayerOfMatch(
									value.getInfo().getPlayerOfMatch())
							.setEvent(value.getInfo().getEvent())
							.setOutcome(value.getInfo().getOutcome())
							.setTeam1(value.getInfo().getTeams().get(0))
							.setTeam2(value.getInfo().getTeams().get(1))
							.setVenue(value.getInfo().getVenue())
							.setTossDecision(
									value.getInfo().getToss().getDecision())
							.setTossWinner(
									value.getInfo().getToss().getWinner())
							.setOfficials(value.getInfo().getOfficials())
							.setSeson(value.getInfo().getSeason()).build();

					matches.add(match);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// files.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.sort(matches);
		matchRepository.saveAllAndFlush(matches);

		System.out.println("JOB FINISHED");
		jdbcTemplate
				.query("SELECT * FROM matches", (rs, rn) -> new MatchBuilder()
						.setId(rs.getLong("id")).setCity(rs.getString("city"))
						.setUmpire1(rs.getString("umpire1"))
						.setUmpire2(rs.getString("umpire2"))
						.setDate(Instant
								.ofEpochMilli(rs.getDate("date").getTime())
								.atZone(ZoneId.systemDefault()).toLocalDate())
						// LocalDate.ofInstant(input.toInstant(),
						// ZoneId.systemDefault())
						.setTeam1(rs.getString("team1"))
						.setTeam2(rs.getString("team2"))
						.setWinner(rs.getString("winner"))
						.setResult(rs.getString("result"))
						.setResultMargin(rs.getString("result_margin"))
						.setPlayerOfMatch(rs.getString("player_of_match"))
						.setVenue(rs.getString("venue")).build())
				.forEach(match -> System.out.println("" + match));

		List<ITeamCount> objs = matchRepository.countTotalMatchesByTeam1();
		List<ITeamCount> objs2 = matchRepository.countTotalMatchesByTeam2();
		List<Team> teams = teamService.getTeams(objs, objs2);
		System.out.println(teams);

		teamRepository.saveAll(teams);

		System.out.println("------------------------");

		List<IVenueCount> objsVenues = matchRepository
				.countTotalMatchesByVenue();
		List<Venue> venues = objsVenues.stream().map(x -> new VenueBuilder()
				.setName(x.getVenueName()).setCity(x.getCity())
				.setTotalMatches(x.getTotalMatches())
				.setTotalWins(x.getTotalWins()).setTotalTies(x.getTotalTies())
				.setTotalNoResult(x.getTotalNoResult())
				.setTotalTossWinBatFirst(x.getTotalTossWinBatFirst())
				.setTotalTossWinFieldFirst(x.getTotalTossWinFieldFirst())
				.setTotalWins(x.getTotalWins())
				.setTotalWinsBatFirst(x.getTotalWinsBatFirst())
				.setTotalWinsFieldFirst(x.getTotalWinsFieldFirst())
				.setTotalWinsByRuns(x.getTotalWinsByRuns())
				.setTotalWinsByWikets(x.getTotalWinsByWikets())
				.setTeams(x.getTeams()).build()).collect(Collectors.toList());
		System.out.println(venues);

		venueRepository.saveAll(venues);

	}

	public MatchInputJson getMatch(Long key) {
		try {
			MatchInputJson value = objectMapper.readValue(
					new File(dirLocation + "/" + key + ".json"),
					MatchInputJson.class);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
