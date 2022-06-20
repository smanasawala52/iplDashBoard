package com.example.ipldashboard.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOverDeliveryWicket {
	// bowled, caught, caught and bowled, lbw, stumped, run out, retired hurt,
	// hit
	// wicket, obstructing the field, hit the ball twice, handled the ball, or
	// timed
	// out.
	private String kind;
	private String playerOut;
	private List<Map<String, String>> fielders;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getPlayerOut() {
		return playerOut;
	}

	public void setPlayerOut(String playerOut) {
		this.playerOut = playerOut;
	}

	public List<Map<String, String>> getFielders() {
		return fielders;
	}

	public void setFielders(List<Map<String, String>> fielders) {
		this.fielders = fielders;
	}

	@Override
	public String toString() {
				StringBuilder sb = new StringBuilder();
		sb.append(playerOut).append(" was ").append(kind);
		if (fielders != null && !fielders.isEmpty()) {
			String pre = " by ";
			for (Map<String, String> fielder : fielders) {
				sb.append(pre).append(fielder.get("name"));
				pre = " and ";
			}
		}
		// "MatchInputJsonOverDeliveryWicket [kind=" + kind + ", playerOut="
		// + playerOut + ", fielders=" + fielders + "]";
		return sb.toString();

	}

}
