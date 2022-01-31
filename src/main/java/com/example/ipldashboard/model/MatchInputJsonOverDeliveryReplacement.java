package com.example.ipldashboard.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOverDeliveryReplacement {
	private List<MatchInputJsonOverDeliveryReplacementMatch> match;
	private List<MatchInputJsonOverDeliveryReplacementRole> role;

	public List<MatchInputJsonOverDeliveryReplacementMatch> getMatch() {
		return match;
	}

	public void setMatch(
			List<MatchInputJsonOverDeliveryReplacementMatch> match) {
		this.match = match;
	}

	public List<MatchInputJsonOverDeliveryReplacementRole> getRole() {
		return role;
	}

	public void setRole(List<MatchInputJsonOverDeliveryReplacementRole> role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "MatchInputJsonOverDeliveryReplacement [match=" + match
				+ ", role=" + role + "]";
	}

}
