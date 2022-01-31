package com.example.ipldashboard.model;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team implements Comparable<Team> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private long totalMatches;
	private long totalWins;
	@Transient
	private double totalWinsPercent;
	private long totalTies;
	private long totalNoResult;
	private long totalTossWins;
	@Transient
	private double totalTossWinsPercent;
	private long totalTossWinBatFirst;
	@Transient
	private double totalTossWinBatFirstPercent;
	private long totalTossWinFieldFirst;
	@Transient
	private double totalTossWinFieldFirstPercent;
	private long totalBatFirst;
	@Transient
	private double totalBatFirstPercent;
	private long totalFieldFirst;
	@Transient
	private double totalFieldFirstPercent;
	private long totalWinsBatFirst;
	@Transient
	private double totalWinsBatFirstPercent;
	private long totalWinsFieldFirst;
	@Transient
	private double totalWinsFieldFirstPercent;
	private long totalWinsByWikets;
	@Transient
	private double totalWinsByWiketsPercent;
	private long totalWinsByRuns;
	@Transient
	private double totalWinsByRunsPercent;
	@Transient
	private Page<Match> matches;

	@Transient
	private SortedSet<Team> teams = new TreeSet<>();

	@Transient
	private SortedSet<String> venues = new TreeSet<>();

	@Transient
	private SortedSet<String> seasons = new TreeSet<>();
	@Transient
	private SortedSet<String> eventGroups = new TreeSet<>();
	@Transient
	private SortedSet<String> eventStage = new TreeSet<>();

	@Transient
	private SortedSet<String> teamNames = new TreeSet<>();

	public Team() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the totalMatches
	 */
	public long getTotalMatches() {
		return totalMatches;
	}

	/**
	 * @param totalMatches
	 *            the totalMatches to set
	 */
	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
		this.totalWinsPercent = populateWinsPercent(this.totalMatches,
				this.totalWins);
		this.totalBatFirstPercent = populateWinsPercent(this.totalMatches,
				this.totalBatFirst);
		this.totalFieldFirstPercent = populateWinsPercent(this.totalMatches,
				this.totalFieldFirst);
		this.totalTossWinsPercent = populateWinsPercent(this.totalMatches,
				this.totalTossWins);
	}

	/**
	 * @return the totalWins
	 */
	public long getTotalWins() {
		return totalWins;
	}

	/**
	 * @param totalWins
	 *            the totalWins to set
	 */
	public void setTotalWins(long totalWins) {
		this.totalWins = totalWins;
		this.totalWinsPercent = populateWinsPercent(this.totalMatches,
				this.totalWins);
		this.totalWinsBatFirstPercent = populateWinsPercent(this.totalWins,
				this.totalWinsBatFirst);
		this.totalWinsByRunsPercent = populateWinsPercent(this.totalWins,
				this.totalWinsByRuns);
		this.totalWinsByWiketsPercent = populateWinsPercent(this.totalWins,
				this.totalWinsByWikets);
		this.totalWinsFieldFirstPercent = populateWinsPercent(this.totalWins,
				this.totalWinsFieldFirst);
	}

	/**
	 * @return the totalTies
	 */
	public long getTotalTies() {
		return totalTies;
	}

	/**
	 * @param totalTies
	 *            the totalTies to set
	 */
	public void setTotalTies(long totalTies) {
		this.totalTies = totalTies;
	}

	/**
	 * @return the totalNoResult
	 */
	public long getTotalNoResult() {
		return totalNoResult;
	}

	/**
	 * @param totalNoResult
	 *            the totalNoResult to set
	 */
	public void setTotalNoResult(long totalNoResult) {
		this.totalNoResult = totalNoResult;
	}

	/**
	 * @return the totalTossWins
	 */
	public long getTotalTossWins() {
		return totalTossWins;
	}

	/**
	 * @param totalTossWins
	 *            the totalTossWins to set
	 */
	public void setTotalTossWins(long totalTossWins) {
		this.totalTossWins = totalTossWins;
		this.totalTossWinsPercent = populateWinsPercent(this.totalMatches,
				this.totalTossWins);
		this.totalTossWinBatFirstPercent = populateWinsPercent(
				this.totalTossWins, this.totalTossWinBatFirst);
		this.totalTossWinFieldFirstPercent = populateWinsPercent(
				this.totalTossWins, this.totalTossWinFieldFirst);
	}

	/**
	 * @return the totalTossWinBatFirst
	 */
	public long getTotalTossWinBatFirst() {
		return totalTossWinBatFirst;
	}

	/**
	 * @param totalTossWinBatFirst
	 *            the totalTossWinBatFirst to set
	 */
	public void setTotalTossWinBatFirst(long totalTossWinBatFirst) {
		this.totalTossWinBatFirst = totalTossWinBatFirst;
		this.totalTossWinBatFirstPercent = populateWinsPercent(
				this.totalTossWins, this.totalTossWinBatFirst);
	}

	/**
	 * @return the totalTossWinFieldFirst
	 */
	public long getTotalTossWinFieldFirst() {
		return totalTossWinFieldFirst;
	}

	/**
	 * @param totalTossWinFieldFirst
	 *            the totalTossWinFieldFirst to set
	 */
	public void setTotalTossWinFieldFirst(long totalTossWinFieldFirst) {
		this.totalTossWinFieldFirst = totalTossWinFieldFirst;
		this.totalTossWinFieldFirstPercent = populateWinsPercent(
				this.totalTossWins, this.totalTossWinFieldFirst);
	}

	/**
	 * @return the totalBatFirst
	 */
	public long getTotalBatFirst() {
		return totalBatFirst;
	}

	/**
	 * @param totalBatFirst
	 *            the totalBatFirst to set
	 */
	public void setTotalBatFirst(long totalBatFirst) {
		this.totalBatFirst = totalBatFirst;
		this.totalBatFirstPercent = populateWinsPercent(this.totalMatches,
				this.totalBatFirst);
	}

	/**
	 * @return the totalFieldFirst
	 */
	public long getTotalFieldFirst() {
		return totalFieldFirst;
	}

	/**
	 * @param totalFieldFirst
	 *            the totalFieldFirst to set
	 */
	public void setTotalFieldFirst(long totalFieldFirst) {
		this.totalFieldFirst = totalFieldFirst;
		this.totalFieldFirstPercent = populateWinsPercent(this.totalMatches,
				this.totalFieldFirst);
	}

	/**
	 * @return the totalWinsBatFirst
	 */
	public long getTotalWinsBatFirst() {
		return totalWinsBatFirst;
	}

	/**
	 * @param totalWinsBatFirst
	 *            the totalWinsBatFirst to set
	 */
	public void setTotalWinsBatFirst(long totalWinsBatFirst) {
		this.totalWinsBatFirst = totalWinsBatFirst;
		this.totalWinsBatFirstPercent = populateWinsPercent(this.totalWins,
				this.totalWinsBatFirst);
	}

	/**
	 * @return the totalWinsFieldFirst
	 */
	public long getTotalWinsFieldFirst() {
		return totalWinsFieldFirst;
	}

	/**
	 * @param totalWinsFieldFirst
	 *            the totalWinsFieldFirst to set
	 */
	public void setTotalWinsFieldFirst(long totalWinsFieldFirst) {
		this.totalWinsFieldFirst = totalWinsFieldFirst;
		this.totalWinsFieldFirstPercent = populateWinsPercent(this.totalWins,
				this.totalWinsFieldFirst);
	}

	/**
	 * @return the totalWinsByWikets
	 */
	public long getTotalWinsByWikets() {
		return totalWinsByWikets;
	}

	/**
	 * @param totalWinsByWikets
	 *            the totalWinsByWikets to set
	 */
	public void setTotalWinsByWikets(long totalWinsByWikets) {
		this.totalWinsByWikets = totalWinsByWikets;
		this.totalWinsByWiketsPercent = populateWinsPercent(this.totalWins,
				this.totalWinsByWikets);
	}

	/**
	 * @return the totalWinsByRuns
	 */
	public long getTotalWinsByRuns() {
		return totalWinsByRuns;
	}

	/**
	 * @param totalWinsByRuns
	 *            the totalWinsByRuns to set
	 */
	public void setTotalWinsByRuns(long totalWinsByRuns) {
		this.totalWinsByRuns = totalWinsByRuns;
		this.totalWinsByRunsPercent = populateWinsPercent(this.totalWins,
				this.totalWinsByRuns);
	}

	/**
	 * @return the matches
	 */
	public Page<Match> getMatches() {
		return matches;
	}

	/**
	 * @param matches
	 *            the matches to set
	 */
	public void setMatches(Page<Match> matches) {
		this.matches = matches;
	}

	/**
	 * @return the teams
	 */
	public SortedSet<Team> getTeams() {
		return teams;
	}

	/**
	 * @param teams
	 *            the teams to set
	 */
	public void setTeams(SortedSet<Team> teams) {
		this.teams = teams;
	}

	/**
	 * @return the venues
	 */
	public SortedSet<String> getVenues() {
		return venues;
	}

	/**
	 * @param venues
	 *            the venues to set
	 */
	public void setVenues(SortedSet<String> venues) {
		this.venues = venues;
	}

	@Override
	public int compareTo(Team o) {
		if (this != null && o != null && this.name != null && o.name != null) {
			return this.name.compareTo(o.name);
		}
		return 0;
	}

	/**
	 * @return the totalWinsPercent
	 */
	public double getTotalWinsPercent() {
		return totalWinsPercent;
	}

	/**
	 * @param totalWinsPercent
	 *            the totalWinsPercent to set
	 */
	public void setTotalWinsPercent(double totalWinsPercent) {
		this.totalWinsPercent = totalWinsPercent;
	}

	/**
	 * @return the seasons
	 */
	public SortedSet<String> getSeasons() {
		return seasons;
	}

	/**
	 * @param seasons
	 *            the seasons to set
	 */
	public void setSeasons(SortedSet<String> seasons) {
		this.seasons = seasons;
	}

	/**
	 * @return the eventGroups
	 */
	public SortedSet<String> getEventGroups() {
		return eventGroups;
	}

	/**
	 * @param eventGroups
	 *            the eventGroups to set
	 */
	public void setEventGroups(SortedSet<String> eventGroups) {
		this.eventGroups = eventGroups;
	}

	/**
	 * @return the eventStage
	 */
	public SortedSet<String> getEventStage() {
		return eventStage;
	}

	/**
	 * @param eventStage
	 *            the eventStage to set
	 */
	public void setEventStage(SortedSet<String> eventStage) {
		this.eventStage = eventStage;
	}

	/**
	 * @return the totalTossWinsPercent
	 */
	public double getTotalTossWinsPercent() {
		return totalTossWinsPercent;
	}

	/**
	 * @param totalTossWinsPercent
	 *            the totalTossWinsPercent to set
	 */
	public void setTotalTossWinsPercent(double totalTossWinsPercent) {
		this.totalTossWinsPercent = totalTossWinsPercent;
	}

	/**
	 * @return the totalTossWinBatFirstPercent
	 */
	public double getTotalTossWinBatFirstPercent() {
		return totalTossWinBatFirstPercent;
	}

	/**
	 * @param totalTossWinBatFirstPercent
	 *            the totalTossWinBatFirstPercent to set
	 */
	public void setTotalTossWinBatFirstPercent(
			double totalTossWinBatFirstPercent) {
		this.totalTossWinBatFirstPercent = totalTossWinBatFirstPercent;
	}

	/**
	 * @return the totalTossWinFieldFirstPercent
	 */
	public double getTotalTossWinFieldFirstPercent() {
		return totalTossWinFieldFirstPercent;
	}

	/**
	 * @param totalTossWinFieldFirstPercent
	 *            the totalTossWinFieldFirstPercent to set
	 */
	public void setTotalTossWinFieldFirstPercent(
			double totalTossWinFieldFirstPercent) {
		this.totalTossWinFieldFirstPercent = totalTossWinFieldFirstPercent;
	}

	/**
	 * @return the totalBatFirstPercent
	 */
	public double getTotalBatFirstPercent() {
		return totalBatFirstPercent;
	}

	/**
	 * @param totalBatFirstPercent
	 *            the totalBatFirstPercent to set
	 */
	public void setTotalBatFirstPercent(double totalBatFirstPercent) {
		this.totalBatFirstPercent = totalBatFirstPercent;
	}

	/**
	 * @return the totalFieldFirstPercent
	 */
	public double getTotalFieldFirstPercent() {
		return totalFieldFirstPercent;
	}

	/**
	 * @param totalFieldFirstPercent
	 *            the totalFieldFirstPercent to set
	 */
	public void setTotalFieldFirstPercent(double totalFieldFirstPercent) {
		this.totalFieldFirstPercent = totalFieldFirstPercent;
	}

	/**
	 * @return the totalWinsBatFirstPercent
	 */
	public double getTotalWinsBatFirstPercent() {
		return totalWinsBatFirstPercent;
	}

	/**
	 * @param totalWinsBatFirstPercent
	 *            the totalWinsBatFirstPercent to set
	 */
	public void setTotalWinsBatFirstPercent(double totalWinsBatFirstPercent) {
		this.totalWinsBatFirstPercent = totalWinsBatFirstPercent;
	}

	/**
	 * @return the totalWinsFieldFirstPercent
	 */
	public double getTotalWinsFieldFirstPercent() {
		return totalWinsFieldFirstPercent;
	}

	/**
	 * @param totalWinsFieldFirstPercent
	 *            the totalWinsFieldFirstPercent to set
	 */
	public void setTotalWinsFieldFirstPercent(
			double totalWinsFieldFirstPercent) {
		this.totalWinsFieldFirstPercent = totalWinsFieldFirstPercent;
	}

	/**
	 * @return the totalWinsByWiketsPercent
	 */
	public double getTotalWinsByWiketsPercent() {
		return totalWinsByWiketsPercent;
	}

	/**
	 * @param totalWinsByWiketsPercent
	 *            the totalWinsByWiketsPercent to set
	 */
	public void setTotalWinsByWiketsPercent(double totalWinsByWiketsPercent) {
		this.totalWinsByWiketsPercent = totalWinsByWiketsPercent;
	}

	/**
	 * @return the totalWinsByRunsPercent
	 */
	public double getTotalWinsByRunsPercent() {
		return totalWinsByRunsPercent;
	}

	/**
	 * @param totalWinsByRunsPercent
	 *            the totalWinsByRunsPercent to set
	 */
	public void setTotalWinsByRunsPercent(double totalWinsByRunsPercent) {
		this.totalWinsByRunsPercent = totalWinsByRunsPercent;
	}

	/**
	 * @return the teamNames
	 */
	public SortedSet<String> getTeamNames() {
		return teamNames;
	}

	/**
	 * @param teamNames
	 *            the teamNames to set
	 */
	public void setTeamNames(SortedSet<String> teamNames) {
		this.teamNames = teamNames;
	}

	private double populateWinsPercent(long totalMatches, long totalWins) {
		double totalWinsPercent = 0;
		if (totalWins > 0 && totalMatches > 0) {
			totalWinsPercent = (totalWins * 10000) / totalMatches;
		}
		return (((double) ((int) totalWinsPercent)) / 100);
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", totalMatches="
				+ totalMatches + ", totalWins=" + totalWins
				+ ", totalWinsPercent=" + totalWinsPercent + ", totalTies="
				+ totalTies + ", totalNoResult=" + totalNoResult
				+ ", totalTossWins=" + totalTossWins + ", totalTossWinsPercent="
				+ totalTossWinsPercent + ", totalTossWinBatFirst="
				+ totalTossWinBatFirst + ", totalTossWinBatFirstPercent="
				+ totalTossWinBatFirstPercent + ", totalTossWinFieldFirst="
				+ totalTossWinFieldFirst + ", totalTossWinFieldFirstPercent="
				+ totalTossWinFieldFirstPercent + ", totalBatFirst="
				+ totalBatFirst + ", totalBatFirstPercent="
				+ totalBatFirstPercent + ", totalFieldFirst=" + totalFieldFirst
				+ ", totalFieldFirstPercent=" + totalFieldFirstPercent
				+ ", totalWinsBatFirst=" + totalWinsBatFirst
				+ ", totalWinsBatFirstPercent=" + totalWinsBatFirstPercent
				+ ", totalWinsFieldFirst=" + totalWinsFieldFirst
				+ ", totalWinsFieldFirstPercent=" + totalWinsFieldFirstPercent
				+ ", totalWinsByWikets=" + totalWinsByWikets
				+ ", totalWinsByWiketsPercent=" + totalWinsByWiketsPercent
				+ ", totalWinsByRuns=" + totalWinsByRuns
				+ ", totalWinsByRunsPercent=" + totalWinsByRunsPercent
				+ ", matches=" + matches + ", teams=" + teams + ", venues="
				+ venues + ", seasons=" + seasons + ", eventGroups="
				+ eventGroups + ", eventStage=" + eventStage + ", teamNames="
				+ teamNames + "]";
	}

}
