package com.example.ipldashboard.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJsonOver {
	private int over;
	private List<MatchInputJsonOverDelivery> deliveries;

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

	@Override
	public String toString() {
		return "MatchInputJsonOver [over=" + over + ", deliveries=" + deliveries
				+ "]";
	}
}
