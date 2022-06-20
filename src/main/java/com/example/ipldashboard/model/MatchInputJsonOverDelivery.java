package com.example.ipldashboard.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOverDelivery {
	private String batter;
	private String bowler;
	private Map<String, Integer> extras;
	private String nonStriker;
	private MatchInputJsonOverDeliveryReplacement replacements;
	private MatchInputJsonOverDeliveryReview review;
	private MatchInputJsonOverDeliveryRuns runs;
	private List<MatchInputJsonOverDeliveryWicket> wickets;

	public String getBatter() {
		return batter;
	}

	public void setBatter(String batter) {
		this.batter = batter;
	}

	public String getBowler() {
		return bowler;
	}

	public void setBowler(String bowler) {
		this.bowler = bowler;
	}

	public Map<String, Integer> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, Integer> extras) {
		this.extras = extras;
	}

	public String getNonStriker() {
		return nonStriker;
	}

	public void setNonStriker(String nonStriker) {
		this.nonStriker = nonStriker;
	}

	public MatchInputJsonOverDeliveryReplacement getReplacements() {
		return replacements;
	}

	public void setReplacements(
			MatchInputJsonOverDeliveryReplacement replacements) {
		this.replacements = replacements;
	}

	public MatchInputJsonOverDeliveryReview getReview() {
		return review;
	}

	public void setReview(MatchInputJsonOverDeliveryReview review) {
		this.review = review;
	}

	public MatchInputJsonOverDeliveryRuns getRuns() {
		return runs;
	}

	public void setRuns(MatchInputJsonOverDeliveryRuns runs) {
		this.runs = runs;
	}

	public List<MatchInputJsonOverDeliveryWicket> getWickets() {
		return wickets;
	}
	
	public String getWicketsStr() {
		StringBuilder sb = new StringBuilder();
		if (wickets != null && !wickets.isEmpty()) {
			String pre = "";
			for (MatchInputJsonOverDeliveryWicket wicket : wickets) {
				sb.append(pre).append(wicket.toString());
				pre = ", ";
			}
		}
		return sb.toString();
	}


	public void setWickets(List<MatchInputJsonOverDeliveryWicket> wickets) {
		this.wickets = wickets;
	}

	@Override
	public String toString() {
		return "MatchInputJsonOverDelivery [batter=" + batter + ", bowler="
				+ bowler + ", extras=" + extras + ", nonStriker=" + nonStriker
				+ ", replacements=" + replacements + ", review=" + review
				+ ", runs=" + runs + ", wickets=" + wickets + "]";
	}
}
