package com.example.ipldashboard.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOverDeliveryRuns {
	private int batter;
	private int extras;
	private boolean nonBoundary;
	private int total;

	public int getBatter() {
		return batter;
	}

	public void setBatter(int batter) {
		this.batter = batter;
	}

	public int getExtras() {
		return extras;
	}

	public void setExtras(int extras) {
		this.extras = extras;
	}

	public boolean isNonBoundary() {
		return nonBoundary;
	}

	public void setNonBoundary(boolean nonBoundary) {
		this.nonBoundary = nonBoundary;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(total);
		return sb.toString();
//		return "MatchInputJsonOverDeliveryRuns [batsman=" + batsman
//				+ ", extras=" + extras + ", nonBoundary=" + nonBoundary
//				+ ", total=" + total + "]";
	}

}
