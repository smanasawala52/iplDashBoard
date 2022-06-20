package com.example.ipldashboard.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOverDelivery {
	private String batter;
	private String bowler;
	private Map<String, Integer> extras;
	private boolean illegalDelivery = false;
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

	public void setReplacements(MatchInputJsonOverDeliveryReplacement replacements) {
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

	public String getRunsStr() {
		StringBuilder sb = new StringBuilder();
		if (runs != null) {
			sb.append(runs.getTotal());
			if (extras != null && !extras.isEmpty()) {
				StringBuilder extraSb = new StringBuilder();
				String preExtra = "";
				for (Entry<String, Integer> extra : extras.entrySet()) {
					if (extra.getKey().equalsIgnoreCase("wides")) {
						extraSb.append(preExtra).append("w:").append(extra.getValue());
						preExtra = ", ";
						illegalDelivery = true;
					} else if (extra.getKey().equalsIgnoreCase("byes")) {
						extraSb.append(preExtra).append("b:").append(extra.getValue());
						preExtra = ", ";
						illegalDelivery = false;
					} else if (extra.getKey().equalsIgnoreCase("legbyes")) {
						extraSb.append(preExtra).append("lb:").append(extra.getValue());
						preExtra = ", ";
						illegalDelivery = false;
					} else if (extra.getKey().equalsIgnoreCase("noballs")) {
						extraSb.append(preExtra).append("nb:").append(extra.getValue());
						preExtra = ", ";
						illegalDelivery = true;
					} else if (extra.getKey().equalsIgnoreCase("penalty")) {
						extraSb.append(preExtra).append("penalty:").append(extra.getValue());
						preExtra = ", ";
						illegalDelivery = false;
					}
				}
				sb.append(" (Extra:").append(runs.getExtras()).append(" - ").append(extraSb.toString()).append(")");
			}
		}
		return sb.toString();
	}

	public void setWickets(List<MatchInputJsonOverDeliveryWicket> wickets) {
		this.wickets = wickets;
	}

	public boolean isIllegalDelivery() {
		return illegalDelivery;
	}

	public void setIllegalDelivery(boolean illegalDelivery) {
		this.illegalDelivery = illegalDelivery;
	}

	@Override
	public String toString() {
		return "MatchInputJsonOverDelivery [batter=" + batter + ", bowler=" + bowler + ", extras=" + extras
				+ ", nonStriker=" + nonStriker + ", replacements=" + replacements + ", review=" + review + ", runs="
				+ runs + ", wickets=" + wickets + "]";
	}
}
