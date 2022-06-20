package com.example.ipldashboard.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonInning {
	private String team;
	private List<MatchInputJsonOver> overs;
	private List<String> absentHurt;
	private Map<String, Integer> penaltyRuns;
	private boolean declared;
	private boolean forfeited;

	private List<MatchInputJsonPowerPlay> powerplays;
	private Map<String, MatchInputJsonInningMiscountedOvers> miscountedOvers;
	private MatchInputJsonTarget target;
	private boolean superOver;

	private Map<String, MatchInputJsonInningBatters> batters = new HashMap<>();
	private Map<String, MatchInputJsonInningBowlers> bowlers = new HashMap<>();

	private int totalFours;
	private int totalSixes;

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public List<MatchInputJsonOver> getOvers() {
		return overs;
	}

	public void setOvers(List<MatchInputJsonOver> overs) {
		this.overs = overs;
	}

	public List<String> getAbsentHurt() {
		return absentHurt;
	}

	public void setAbsentHurt(List<String> absentHurt) {
		this.absentHurt = absentHurt;
	}

	public Map<String, Integer> getPenaltyRuns() {
		return penaltyRuns;
	}

	public void setPenaltyRuns(Map<String, Integer> penaltyRuns) {
		this.penaltyRuns = penaltyRuns;
	}

	public boolean isDeclared() {
		return declared;
	}

	public void setDeclared(boolean declared) {
		this.declared = declared;
	}

	public boolean isForfeited() {
		return forfeited;
	}

	public void setForfeited(boolean forfeited) {
		this.forfeited = forfeited;
	}

	public List<MatchInputJsonPowerPlay> getPowerplays() {
		return powerplays;
	}

	public void setPowerplays(List<MatchInputJsonPowerPlay> powerplays) {
		this.powerplays = powerplays;
	}

	public Map<String, MatchInputJsonInningMiscountedOvers> getMiscountedOvers() {
		return miscountedOvers;
	}

	public void setMiscountedOvers(Map<String, MatchInputJsonInningMiscountedOvers> miscountedOvers) {
		this.miscountedOvers = miscountedOvers;
	}

	public MatchInputJsonTarget getTarget() {
		return target;
	}

	public void setTarget(MatchInputJsonTarget target) {
		this.target = target;
	}

	public boolean isSuperOver() {
		return superOver;
	}

	public void setSuperOver(boolean superOver) {
		this.superOver = superOver;
	}

	public Map<String, MatchInputJsonInningBatters> getBatters() {
		return batters;
	}

	public void setBatters(Map<String, MatchInputJsonInningBatters> batters) {
		this.batters = batters;
	}

	public Map<String, MatchInputJsonInningBowlers> getBowlers() {
		return bowlers;
	}

	public void setBowlers(Map<String, MatchInputJsonInningBowlers> bowlers) {
		this.bowlers = bowlers;
	}

	public int getTotalFours() {
		return totalFours;
	}

	public void setTotalFours(int totalFours) {
		this.totalFours = totalFours;
	}

	public int getTotalSixes() {
		return totalSixes;
	}

	public void setTotalSixes(int totalSixes) {
		this.totalSixes = totalSixes;
	}

	@Override
	public String toString() {
		return "MatchInputJsonInning [team=" + team + ", overs=" + overs + ", absentHurt=" + absentHurt
				+ ", penaltyRuns=" + penaltyRuns + ", declared=" + declared + ", forfeited=" + forfeited
				+ ", powerplays=" + powerplays + ", miscountedOvers=" + miscountedOvers + ", target=" + target
				+ ", superOver=" + superOver + "]";
	}

}
