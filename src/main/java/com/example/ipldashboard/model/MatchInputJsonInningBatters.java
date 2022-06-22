package com.example.ipldashboard.model;

public class MatchInputJsonInningBatters {
	private String name;
	private int runs;
	private double strikeRate;
	private int ballsPlayed;
	private String wicketInfo;
	private int zeros;
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private boolean out = false;
	private String kind;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public int getZeros() {
		return zeros;
	}

	public void setZeros(int zeros) {
		this.zeros = zeros;
	}

	public int getOnes() {
		return ones;
	}

	public void setOnes(int ones) {
		this.ones = ones;
	}

	public int getTwos() {
		return twos;
	}

	public void setTwos(int twos) {
		this.twos = twos;
	}

	public int getThrees() {
		return threes;
	}

	public void setThrees(int threes) {
		this.threes = threes;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public boolean isOut() {
		return out;
	}

	public void setOut(boolean out) {
		this.out = out;
	}

	public int getBallsPlayed() {
		return ballsPlayed;
	}

	public void setBallsPlayed(int ballsPlayed) {
		this.ballsPlayed = ballsPlayed;
	}

	public String getWicketInfo() {
		return wicketInfo;
	}

	public void setWicketInfo(String wicketInfo) {
		this.wicketInfo = wicketInfo;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	@Override
	public String toString() {
		return "MatchInputJsonInningBatters [name=" + name + ", runs=" + runs + ", strikeRate=" + strikeRate
				+ ", ballsPlayed=" + ballsPlayed + ", wicketInfo=" + wicketInfo + ", zeros=" + zeros + ", ones=" + ones
				+ ", twos=" + twos + ", threes=" + threes + ", fours=" + fours + ", fives=" + fives + ", sixes=" + sixes
				+ ", out=" + out + ", kind=" + kind + "]";
	}

}
