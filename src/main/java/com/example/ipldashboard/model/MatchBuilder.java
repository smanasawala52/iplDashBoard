package com.example.ipldashboard.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MatchBuilder {
	private Match match = new Match();

	public MatchBuilder() {
		match = new Match();
	}

	public Match build() {
		return match;
	}

	/**
	 * @param id the id to set
	 */
	public MatchBuilder setId(long id) {
		this.match.setId(id);
		return this;
	}

	/**
	 * @param city the city to set
	 */
	public MatchBuilder setCity(String city) {
		this.match.setCity(city);
		return this;
	}

	/**
	 * @param date the date to set
	 */
	public MatchBuilder setDate(LocalDate date) {
		this.match.setDate(date);
		return this;
	}

	/**
	 * @param playerOfMatch the playerOfMatch to set
	 */
	public MatchBuilder setPlayerOfMatch(String playerOfMatch) {
		this.match.setPlayerOfMatch(playerOfMatch);
		return this;
	}

	/**
	 * @param venue the venue to set
	 */
	public MatchBuilder setVenue(String venue) {
		if (venue != null) {
			if (venue.equalsIgnoreCase("M.Chinnaswamy Stadium")) {
				venue = "M. Chinnaswamy Stadium";
				this.match.setCity("Bengaluru");
			}
			if (venue.equalsIgnoreCase("M Chinnaswamy Stadium")) {
				venue = "M. Chinnaswamy Stadium";
				this.match.setCity("Bengaluru");
			}
			if (venue.equalsIgnoreCase("MA Chidambaram Stadium")) {
				venue = "MA Chidambaram Stadium";
				this.match.setCity("Chennai");
			}
			if (venue.equalsIgnoreCase("MA Chidambaram Stadium, Chepauk")) {
				venue = "MA Chidambaram Stadium";
				this.match.setCity("Chennai");
			}
			if (venue.equalsIgnoreCase("MA Chidambaram Stadium, Chepauk, Chennai")) {
				venue = "MA Chidambaram Stadium";
				this.match.setCity("Chennai");
			}
			if (venue.equalsIgnoreCase("Dubai International Cricket Stadium")) {
				venue = "Dubai International Cricket Stadium";
				this.match.setCity("Dubai");
			}
			if (venue.equalsIgnoreCase("Sharjah Cricket Stadium")) {
				venue = "Sharjah Cricket Stadium";
				this.match.setCity("Sharjah");
			}
			if (venue.equalsIgnoreCase("Punjab Cricket Association IS Bindra Stadium")) {
				venue = "Punjab Cricket Association IS Bindra Stadium";
				this.match.setCity("Mohali");
			}
			if (venue.equalsIgnoreCase("Punjab Cricket Association IS Bindra Stadium, Mohali")) {
				venue = "Punjab Cricket Association IS Bindra Stadium";
				this.match.setCity("Mohali");
			}
			if (venue.equalsIgnoreCase("Punjab Cricket Association Stadium, Mohali")) {
				venue = "Punjab Cricket Association IS Bindra Stadium";
				this.match.setCity("Mohali");
			}

			if (venue.equalsIgnoreCase("subrata roy sahara stadium")) {
				venue = "Maharashtra Cricket Association Stadium";
				this.match.setCity("Pune");
			}
			if (venue.equalsIgnoreCase("Narendra Modi Stadium, Ahmedabad")) {
				venue = "Narendra Modi Stadium";
				this.match.setCity("Ahmedabad");
			}
			if (venue.equalsIgnoreCase("Narendra Modi Stadium, Ahmedabad")) {
				venue = "Narendra Modi Stadium";
				this.match.setCity("Ahmedabad");
			}
			if (venue.equalsIgnoreCase("Sardar Patel Stadium, Motera")) {
				venue = "Narendra Modi Stadium";
				this.match.setCity("Ahmedabad");
			}
			if (venue.equalsIgnoreCase("Feroz Shah Kotla Stadium")) {
				venue = "Arun Jaitley Stadium";
				this.match.setCity("Delhi");
			}
			if (venue.equalsIgnoreCase("Feroz Shah Kotla")) {
				venue = "Arun Jaitley Stadium";
				this.match.setCity("Delhi");
			}
			if (venue.equalsIgnoreCase("Arun Jaitley Stadium, Delhi")) {
				venue = "Arun Jaitley Stadium";
				this.match.setCity("Delhi");
			}
			if (venue.equalsIgnoreCase("Arun Jaitley Stadium")) {
				venue = "Arun Jaitley Stadium";
				this.match.setCity("Delhi");
			}
			if (venue.equalsIgnoreCase("Zayed Cricket Stadium, Abu Dhabi")) {
				venue = "Sheikh Zayed Stadium";
				this.match.setCity("Abu Dhabi");
			}
			if (venue.equalsIgnoreCase("Sheikh Zayed Stadium")) {
				venue = "Sheikh Zayed Stadium";
				this.match.setCity("Abu Dhabi");
			}
			if (venue.equalsIgnoreCase("Wankhede Stadium, Mumbai")) {
				venue = "Wankhede Stadium";
				this.match.setCity("Mumbai");
			}
			if (venue.equalsIgnoreCase("Wankhede Stadium")) {
				venue = "Wankhede Stadium";
				this.match.setCity("Mumbai");
			}
			if (venue.equalsIgnoreCase("Brabourne Stadium, Mumbai")) {
				venue = "Brabourne Stadium";
				this.match.setCity("Mumbai");
			}
			if (venue.equalsIgnoreCase("Brabourne Stadium, Mumbai")) {
				venue = "Brabourne Stadium";
				this.match.setCity("Mumbai");
			}
			if (venue.equalsIgnoreCase("Vidarbha Cricket Association Stadium, Jamtha")) {
				venue = "Vidarbha Cricket Association Stadium";
				this.match.setCity("Nagpur");
			}
			if (venue.equalsIgnoreCase("Dr DY Patil Sports Academy, Mumbai")) {
				venue = "Dr DY Patil Sports Academy";
				this.match.setCity("Mumbai");
			}
			if (venue.equalsIgnoreCase("Maharashtra Cricket Association Stadium, Pune")) {
				venue = "Maharashtra Cricket Association Stadium";
				this.match.setCity("Pune");
			}
			if (venue.equalsIgnoreCase("Rajiv Gandhi International Stadium, Uppal")) {
				venue = "Rajiv Gandhi International Stadium";
				this.match.setCity("Hyderabad");
			}
			if (venue.equalsIgnoreCase("Eden Gardens, Kolkata")) {
				venue = "Eden Gardens";
				this.match.setCity("Kolkata");
			}

		}
		this.match.setVenue(venue);
		if (this.match.getCity() == null || (this.match.getCity() != null && this.match.getCity().isEmpty())) {
			if (this.match.getVenue().equalsIgnoreCase("Dubai International Cricket Stadium")) {
				this.match.setCity("Dubai");
			}
			if (this.match.getVenue().equalsIgnoreCase("Sharjah Cricket Stadium")) {
				this.match.setCity("Sharjah");
			} else {
				this.match.setCity(this.match.getVenue());
			}
		}
		return this;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public MatchBuilder setTeam1(String team1) {
		this.match.setTeam1(team1);
		return this;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public MatchBuilder setTeam2(String team2) {
		this.match.setTeam2(team2);
		return this;
	}

	/**
	 * @param winner the winner to set
	 */
	public MatchBuilder setWinner(String winner) {
		this.match.setWinner(winner);
		return this;
	}

	/**
	 * @param result the result to set
	 */
	public MatchBuilder setResult(String result) {
		this.match.setResult(result);
		return this;
	}

	/**
	 * @param resultMargin the resultMargin to set
	 */
	public MatchBuilder setResultMargin(String resultMargin) {
		this.match.setResultMargin(Integer.parseInt(resultMargin));
		return this;
	}

	/**
	 * @param umpire1 the umpire1 to set
	 */
	public MatchBuilder setUmpire1(String umpire1) {
		this.match.setUmpire1(umpire1);
		return this;
	}

	/**
	 * @param umpire2 the umpire2 to set
	 */
	public MatchBuilder setUmpire2(String umpire2) {
		this.match.setUmpire2(umpire2);
		return this;
	}

	/**
	 * @param tossWinner the tossWinner to set
	 */
	public MatchBuilder setTossWinner(String tossWinner) {
		this.match.setTossWinner(tossWinner);
		return this;
	}

	/**
	 * @param tossDecision the tossDecision to set
	 */
	public MatchBuilder setTossDecision(String tossDecision) {
		this.match.setTossDecision(tossDecision);
		return this;
	}

	public MatchBuilder setResult(MatchInputJsonOutcomeBy by) {
		if (by != null) {
			if (by.getWickets() > 0) {
				this.match.setResult("wickets");
				this.match.setResultMargin(by.getWickets());
			} else if (by.getRuns() > 0) {
				this.match.setResult("runs");
				this.match.setResultMargin(by.getRuns());
			} else if (by.getInnings() > 0) {
				this.match.setResult("innings");
				this.match.setResultMargin(by.getInnings());
			}
		}
		return this;
	}

	public MatchBuilder setOutcome(MatchInputJsonOutcome outcome) {
		if (outcome.getWinner() != null) {
			this.match.setWinner(outcome.getWinner());
		}
		if (outcome.getBy() != null) {
			if (outcome.getBy().getWickets() > 0) {
				this.match.setResult("wickets");
				this.match.setResultMargin(outcome.getBy().getWickets());
			} else if (outcome.getBy().getRuns() > 0) {
				this.match.setResult("runs");
				this.match.setResultMargin(outcome.getBy().getRuns());
			} else if (outcome.getBy().getInnings() > 0) {
				this.match.setResult("innings");
				this.match.setResultMargin(outcome.getBy().getInnings());
			}
		}
		return this;
	}

	public MatchBuilder setOfficials(MatchInputJsonInfoOfficials officials) {
//		System.out.println("officials: " + officials);
		if (officials != null) {
			StringBuilder sb = new StringBuilder();
			String pre = "";
			if (officials.getUmpires() != null) {
				sb.append(pre).append("Umpires: " + officials.getUmpires().stream().collect(Collectors.joining(", ")));
				pre = " and ";
			}
			if (officials.getMatchReferees() != null) {
				sb.append(pre).append(
						" Match Referees: " + officials.getMatchReferees().stream().collect(Collectors.joining(", ")));
				pre = " and ";
			}
			if (officials.getReserveUmpires() != null) {
				sb.append(pre).append(" Reserve Umpires: "
						+ officials.getReserveUmpires().stream().collect(Collectors.joining(", ")));
				pre = " and ";
			}
			if (officials.getTvUmpires() != null) {
				sb.append(pre)
						.append(" TV Umpires: " + officials.getTvUmpires().stream().collect(Collectors.joining(", ")));
				pre = " and ";
			}
			this.match.setUmpire1(sb.toString());
		}
		return this;
	}

	public MatchBuilder setPlayerOfMatch(List<String> playerOfMatch) {
		if (playerOfMatch != null) {
			this.match.setPlayerOfMatch(playerOfMatch.stream().collect(Collectors.joining(", ")));
		}
		return this;
	}

	public MatchBuilder setPlayers(String players) {
		if (players != null) {
			this.match.setPlayers(players);
		}
		return this;
	}

	public MatchBuilder setEvent(MatchInputJsonInfoEvent event) {
		if (event != null) {
			if (event.getStage() != null) {
				this.match.setEventStage(event.getStage());
			}
			if (event.getGroup() != null) {
				this.match.setEventGroup(event.getGroup());
			}
			if (event.getMatchNumber() != null) {
				this.match.setEventMatchNumber(event.getMatchNumber());
			}
		}
		return this;
	}

	public MatchBuilder setSeson(String season) {
		if (season != null) {
			this.match.setSeason(season);
		}
		return this;
	}
}
