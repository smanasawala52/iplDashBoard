package com.example.ipldashboard.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOver {
	private int over;
	private List<MatchInputJsonOverDelivery> deliveries;
	private int cummulativeRuns;
	private int cummulativeWickets;
	private double runRate;

	@Override
	public String toString() {
		return "MatchInputJsonOver [over=" + over + ", deliveries=" + deliveries + ", cummulativeRuns="
				+ cummulativeRuns + ", cummulativeWickets=" + cummulativeWickets + ", runRate=" + runRate + "]";
	}

	public int getOver() {
		return over;
	}

	public void setOver(int over) {
		this.over = over;
	}

	public List<MatchInputJsonOverDelivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<MatchInputJsonOverDelivery> deliveries) {
		this.deliveries = deliveries;
	}

	public int getCummulativeRuns() {
		return cummulativeRuns;
	}

	public void setCummulativeRuns(int cummulativeRuns) {
		this.cummulativeRuns = cummulativeRuns;
	}

	public int getCummulativeWickets() {
		return cummulativeWickets;
	}

	public void setCummulativeWickets(int cummulativeWickets) {
		this.cummulativeWickets = cummulativeWickets;
	}

	public double getRunRate() {
		return runRate;
	}

	public void setRunRate(double runRate) {
		this.runRate = runRate;
	}

}
