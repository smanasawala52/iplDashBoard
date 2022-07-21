package com.example.ipldashboard.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ipldashboard.config.EthAccountConfig;
import com.example.ipldashboard.model.NFTMetadata;
import com.example.ipldashboard.model.Team;

@Service
public class NFTService {
	@Autowired
	private TeamService teamService;

	@Autowired
	private EthAccountConfig ethAccountConfig;
	private List<String> ignoreList = Arrays.asList("cp", "pageSize");

	public NFTMetadata getTeamNftMetadata(Map<String, String> queryParams, Team team) {
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
		queryMap.put("tossWinner", "");
		queryMap.put("tossDecision", "");
		queryMap.put("player", "");

		if (queryParams != null && !queryParams.isEmpty()) {
			for (Entry<String, String> queryParam : queryParams.entrySet()) {
				if (queryParam.getValue() != null && !queryParam.getValue().isEmpty()
						&& !queryParam.getValue().equalsIgnoreCase("null")
						&& !ignoreList.contains(queryParam.getKey())) {
					queryMap.put(queryParam.getKey(), queryParam.getValue());
				}
			}
		}
		String preName = "";
		StringBuilder sbName = new StringBuilder();
		StringBuilder sbDescriptions = new StringBuilder();

		String pre = "";
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Object> queryParam : queryMap.entrySet()) {
			if (queryParam.getValue() != null && !ignoreList.contains((queryParam.getKey()))) {
				sb.append(pre).append(queryParam.getKey()).append("=").append(String.valueOf(queryParam.getValue()));
				pre = "&";
			}
		}

		String team1 = queryParams.get("team1");
		if (team1 != null && !team1.isEmpty()) {
			sbDescriptions.append(team1);
			sbName.append(team1);
			Map<String, Object> jsonObject = new HashMap<>();
			List<Map<String, Object>> jsonTraits = new ArrayList<>();
			try {
				jsonObject.put("name", "Shabbir");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (queryMap.get("team2") != null && !String.valueOf(queryMap.get("team2")).isEmpty()) {
				sbDescriptions.append(" played against ").append(queryMap.get("team2"));
				sbName.append(" vs ").append(queryMap.get("team2"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "Played Against");
					attr.put("value", String.valueOf(queryMap.get("team2")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("venue") != null && !String.valueOf(queryMap.get("venue")).isEmpty()) {
				sbDescriptions.append(" at ").append(queryMap.get("venue"));
				sbName.append(" at ").append(queryMap.get("venue"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "Venue");
					attr.put("value", String.valueOf(queryMap.get("venue")));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("city") != null && !String.valueOf(queryMap.get("city")).isEmpty()) {
				sbDescriptions.append(", ").append(queryMap.get("city"));
				sbName.append(", ").append(queryMap.get("city"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "City");
					attr.put("value", queryMap.get("city"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("season") != null && !String.valueOf(queryMap.get("season")).isEmpty()) {
				sbDescriptions.append(" in the season of ").append(queryMap.get("season"));
				sbName.append(" ").append(queryMap.get("season"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "Season");
					attr.put("value", queryMap.get("season"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("stage") != null && !String.valueOf(queryMap.get("stage")).isEmpty()) {
				sbDescriptions.append(" at the stage of ").append(queryMap.get("stage"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "Stage");
					attr.put("value", queryMap.get("stage"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("player") != null && !String.valueOf(queryMap.get("player")).isEmpty()) {
				sbDescriptions.append(" with ").append(queryMap.get("player"));
				Map<String, Object> attr = new HashMap<>();
				try {
					attr.put("trait_type", "Players");
					attr.put("value", queryMap.get("player"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonTraits.add(attr);
			}
			if (queryMap.get("playerOfMatch") != null && !String.valueOf(queryMap.get("playerOfMatch")).isEmpty()) {
				sbDescriptions.append(" where ").append(queryMap.get("playerOfMatch"))
						.append(" was awarded player of the match");
			}
			if (queryMap.get("winner") != null && !String.valueOf(queryMap.get("winner")).isEmpty()) {
				sbDescriptions.append(" and match won by ").append(queryMap.get("winner"));
			}
			if (queryMap.get("result") != null && !String.valueOf(queryMap.get("result")).isEmpty()) {
				sbDescriptions.append(" with ").append(queryMap.get("result"));
			}

			if (team == null) {
				List<Team> temp = teamService.getTeams(queryParams);
				if (temp != null && !temp.isEmpty()) {
					team = temp.get(0);
				}
			}
			if (team != null && team.getName() != null && !team.getName().isEmpty()) {
				NFTMetadata nftMetadata = new NFTMetadata();
				// generate nft data for returned team
				nftMetadata.setExternalLink("https://ipl-dashboard-shabbir.herokuapp.com/?" + sb.toString());
				if (team.getCities() != null && !team.getCities().isEmpty()) {
					nftMetadata.getAttributes().put("cities",
							team.getCities().toString().replace("[", "").replace("]", ""));
				}
				if (team.getVenues() != null && !team.getVenues().isEmpty()) {
					nftMetadata.getAttributes().put("venues",
							team.getVenues().toString().replace("[", "").replace("]", ""));
				}
				if (team.getEventGroups() != null && !team.getEventGroups().isEmpty()) {
					nftMetadata.getAttributes().put("event-groups",
							team.getEventGroups().toString().replace("[", "").replace("]", ""));
				}
				if (team.getEventStage() != null && !team.getEventStage().isEmpty()) {
					nftMetadata.getAttributes().put("stages", team.getEventStage());
				}
				if (queryMap.get("player") != null && !String.valueOf(queryMap.get("player")).isEmpty()) {
					nftMetadata.getAttributes().put("players", String.valueOf(queryMap.get("player")));
				} else if (team.getPlayers() != null && !team.getPlayers().isEmpty()) {
					nftMetadata.getAttributes().put("players",
							team.getPlayers().toString().replace("[", "").replace("]", ""));
				}
				if (team.getTeamNames() != null && !team.getTeamNames().isEmpty()) {
					nftMetadata.getAttributes().put("played-with-teams",
							team.getTeamNames().toString().replace("[", "").replace("]", ""));
				}
				if (team.getSeasons() != null && !team.getSeasons().isEmpty()) {
					if (queryParams.get("season") == null
							|| (queryParams.get("season") != null && queryParams.get("season").isEmpty())) {
						sbName.append(" seasons").append(team.getSeasons());
					}
					nftMetadata.getAttributes().put("seasons",
							team.getSeasons().toString().replace("[", "").replace("]", ""));
				}
				if (team.getName() != null && !team.getName().isEmpty()) {
					nftMetadata.getAttributes().put("teamName", team.getName());
				}

				nftMetadata.setName(sbName.toString());
				nftMetadata.setDescription(sbDescriptions.toString());
				// Match attributes
				if (team.getTotalMatches() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-played", team.getTotalMatches() + "");
				}
				if (team.getTotalWins() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-won", team.getTotalWins() + "");
				}
				if (team.getTotalWinsPercent() > 0) {
					nftMetadata.getAttributes().put("percent-of-matches-won", team.getTotalWinsPercent() + "");
				}
				if (team.getTotalNoResult() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-no-result", team.getTotalNoResult() + "");
				}

				if (team.getTotalBatFirst() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-batted-first", team.getTotalBatFirst() + "");
				}
				if (team.getTotalBatFirstPercent() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-batted-first-percent",
							team.getTotalBatFirstPercent() + "");
				}
				if (team.getTotalBatFirst() > 0) {
					nftMetadata.getAttributes().put("number-of-matches-batted-first", team.getTotalBatFirst() + "");
				}
				// convert attributes String to attributes map
				sb = new StringBuilder();
				pre = "";
				for (Entry<String, Object> attribute : nftMetadata.getAttributes().entrySet()) {
					sb.append(pre).append(attribute.getKey()).append("|").append(attribute.getValue());
					pre = "^";
				}
				nftMetadata.setAttributesStr(sb.toString());

				nftMetadata.setImage(ethAccountConfig.getNftImageBaseURLTeams() + ""
						+ team1.replaceAll("[^a-zA-Z0-9]", "").replace(" ", "").toLowerCase() + ".jpg");
				try {
					jsonObject.put("attributes", jsonTraits);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("nftMetadata: " + nftMetadata);
				return nftMetadata;
			}
		}
		return null;
	}
}
