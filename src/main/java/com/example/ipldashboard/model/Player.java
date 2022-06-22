package com.example.ipldashboard.model;

import java.time.LocalDate;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int runs;
	private int matchesPlayed;

	private double strikeRate;
	private int ballsPlayed;
	private String wicketInfo;
	private int zeros;
	private long match;
	private String team;
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private boolean out = false;

	private int overs;
	private String kind;
	private int balls;
	private int totalRunsGiven;
	@Transient
	private Map<String, Integer> runsGiven;
	@Transient
	private Map<String, Integer> extras;
	private int wickets;
	private double economyRate;

	private String city;
	private LocalDate date;
	private String playerOfMatch = "";
	private String venue;
	private String winner = "";
	private String result = "";
	private int resultMargin;
	private String tossWinner = "";
	private String tossDecision = "";

	private String eventStage;
	private String eventMatchNumber;
	private String eventGroup;
	private String season;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getBallsPlayed() {
		return ballsPlayed;
	}

	public void setBallsPlayed(int ballsPlayed) {
		this.ballsPlayed = ballsPlayed;
	}

	public String getWicketInfo() {
		return wicketInfo;
	}

	public void setWicketInfo(String wicketInfo) {
		this.wicketInfo = wicketInfo;
	}

	public int getZeros() {
		return zeros;
	}

	public void setZeros(int zeros) {
		this.zeros = zeros;
	}

	public long getMatch() {
		return match;
	}

	public void setMatch(long match) {
		this.match = match;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getOnes() {
		return ones;
	}

	public void setOnes(int ones) {
		this.ones = ones;
	}

	public int getTwos() {
		return twos;
	}

	public void setTwos(int twos) {
		this.twos = twos;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public int getOvers() {
		return overs;
	}

	public void setOvers(int overs) {
		this.overs = overs;
	}

	public int getBalls() {
		return balls;
	}

	public void setBalls(int balls) {
		this.balls = balls;
	}

	public int getTotalRunsGiven() {
		return totalRunsGiven;
	}

	public void setTotalRunsGiven(int totalRunsGiven) {
		this.totalRunsGiven = totalRunsGiven;
	}

	public Map<String, Integer> getRunsGiven() {
		return runsGiven;
	}

	public void setRunsGiven(Map<String, Integer> runsGiven) {
		this.runsGiven = runsGiven;
	}

	public Map<String, Integer> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Integer> extras) {
		this.extras = extras;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public double getEconomyRate() {
		return economyRate;
	}

	public void setEconomyRate(double economyRate) {
		this.economyRate = economyRate;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getPlayerOfMatch() {
		return playerOfMatch;
	}

	public void setPlayerOfMatch(String playerOfMatch) {
		this.playerOfMatch = playerOfMatch;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getResultMargin() {
		return resultMargin;
	}

	public void setResultMargin(int resultMargin) {
		this.resultMargin = resultMargin;
	}

	public String getTossWinner() {
		return tossWinner;
	}

	public void setTossWinner(String tossWinner) {
		this.tossWinner = tossWinner;
	}

	public String getTossDecision() {
		return tossDecision;
	}

	public void setTossDecision(String tossDecision) {
		this.tossDecision = tossDecision;
	}

	public String getEventStage() {
		return eventStage;
	}

	public void setEventStage(String eventStage) {
		this.eventStage = eventStage;
	}

	public String getEventMatchNumber() {
		return eventMatchNumber;
	}

	public void setEventMatchNumber(String eventMatchNumber) {
		this.eventMatchNumber = eventMatchNumber;
	}

	public String getEventGroup() {
		return eventGroup;
	}

	public void setEventGroup(String eventGroup) {
		this.eventGroup = eventGroup;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", runs=" + runs + ", matchesPlayed=" + matchesPlayed
				+ ", strikeRate=" + strikeRate + ", ballsPlayed=" + ballsPlayed + ", wicketInfo=" + wicketInfo
				+ ", zeros=" + zeros + ", match=" + match + ", team=" + team + ", ones=" + ones + ", twos=" + twos
				+ ", threes=" + threes + ", fours=" + fours + ", fives=" + fives + ", sixes=" + sixes + ", out=" + out
				+ ", overs=" + overs + ", kind=" + kind + ", balls=" + balls + ", totalRunsGiven=" + totalRunsGiven
				+ ", runsGiven=" + runsGiven + ", extras=" + extras + ", wickets=" + wickets + ", economyRate="
				+ economyRate + ", city=" + city + ", date=" + date + ", playerOfMatch=" + playerOfMatch + ", venue="
				+ venue + ", winner=" + winner + ", result=" + result + ", resultMargin=" + resultMargin
				+ ", tossWinner=" + tossWinner + ", tossDecision=" + tossDecision + ", eventStage=" + eventStage
				+ ", eventMatchNumber=" + eventMatchNumber + ", eventGroup=" + eventGroup + ", season=" + season + "]";
	}

}
