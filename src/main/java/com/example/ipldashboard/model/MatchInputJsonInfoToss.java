package com.example.ipldashboard.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonInfoToss {
	private boolean uncontested;
	private String decision;
	private String winner;

	@Override
	public String toString() {
		return "MatchInputJsonInfoToss [uncontested=" + uncontested
				+ ", decision=" + decision + ", winner=" + winner + "]";
	}

	public boolean isUncontested() {
		return uncontested;
	}

	public void setUncontested(boolean uncontested) {
		this.uncontested = uncontested;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
}
