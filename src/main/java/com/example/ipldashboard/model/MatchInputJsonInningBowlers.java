package com.example.ipldashboard.model;

import java.util.Map;

public class MatchInputJsonInningBowlers {
	private int name;
	private int overs;
	private int balls;
	private int totalRunsGiven;
	private Map<String, Integer> runsGiven;
	private Map<String, Integer> extras;
	private int wickets;
	private double economyRate;

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "MatchInputJsonInningBowlers [name=" + name + ", overs=" + overs + ", balls=" + balls
				+ ", totalRunsGiven=" + totalRunsGiven + ", runsGiven=" + runsGiven + ", extras=" + extras
				+ ", wickets=" + wickets + "]";
	}

	public double getEconomyRate() {
		return economyRate;
	}

	public void setEconomyRate(double economyRate) {
		this.economyRate = economyRate;
	}

}
