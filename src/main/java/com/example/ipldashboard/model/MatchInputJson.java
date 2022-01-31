package com.example.ipldashboard.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MatchInputJson {
	private MatchInputJsonInfo info;
	private List<MatchInputJsonInning> innings;

	public MatchInputJsonInfo getInfo() {
		return info;
	}

	public void setInfo(MatchInputJsonInfo info) {
		this.info = info;
	}

	public List<MatchInputJsonInning> getInnings() {
		return innings;
	}

	public void setInnings(List<MatchInputJsonInning> innings) {
		this.innings = innings;
	}

	@Override
	public String toString() {
		return "MatchInputJson [info=" + info + ", innings=" + innings + "]";
	}

}
