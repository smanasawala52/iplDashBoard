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

	public void populateCummulativeData() {
		for (MatchInputJsonInning inning : innings) {
			int cummulativeWickets = 0;
			int cummulativeRuns = 0;
			if (inning.getOvers() != null && !inning.getOvers().isEmpty()) {
				for (MatchInputJsonOver over : inning.getOvers()) {
					for (MatchInputJsonOverDelivery delivery : over.getDeliveries()) {
						MatchInputJsonInningBatters batter = inning.getBatters().get(delivery.getBatter());
						if (batter == null) {
							batter = new MatchInputJsonInningBatters();
						}
						MatchInputJsonInningBowlers bowler = inning.getBowlers().get(delivery.getBowler());
						if (bowler == null) {
							bowler = new MatchInputJsonInningBowlers();
						}
						delivery.getRunsStr();
						if (!delivery.isIllegalDelivery()) {
							batter.setBallsPlayed(batter.getBallsPlayed() + 1);
							bowler.setBalls(bowler.getBalls() + 1);
						}
						if (delivery.getRuns() != null) {
							cummulativeRuns += delivery.getRuns().getTotal();
							batter.setName(delivery.getBatter());
							batter.setRuns(batter.getRuns() + delivery.getRuns().getBatter());
							bowler.setTotalRunsGiven(bowler.getTotalRunsGiven() + delivery.getRuns().getTotal());
							if (delivery.getRuns().getBatter() == 0) {
								batter.setZeros(batter.getZeros() + 1);
							} else if (delivery.getRuns().getBatter() == 1) {
								batter.setOnes(batter.getOnes() + 1);
							} else if (delivery.getRuns().getBatter() == 2) {
								batter.setTwos(batter.getTwos() + 1);
							} else if (delivery.getRuns().getBatter() == 3) {
								batter.setThrees(batter.getThrees() + 1);
							} else if (delivery.getRuns().getBatter() == 4) {
								batter.setFours(batter.getFours() + 1);
								inning.setTotalFours(inning.getTotalFours() + 1);
							} else if (delivery.getRuns().getBatter() == 5) {
								batter.setFives(batter.getFives() + 1);
							} else if (delivery.getRuns().getBatter() == 6) {
								batter.setSixes(batter.getSixes() + 1);
								inning.setTotalSixes(inning.getTotalSixes() + 1);
							}
						}
						double r = (double) batter.getRuns() / batter.getBallsPlayed();
						r *= 100.0;
						double salary = Math.round(r * 100.0) / 100.0;
						batter.setStrikeRate(salary);

						inning.getBatters().put(delivery.getBatter(), batter);
						r = (double) bowler.getTotalRunsGiven() / bowler.getOvers();
						// r *= 100.0;
						salary = Math.round(r * 100.0) / 100.0;
						bowler.setEconomyRate(salary);

						inning.getBowlers().put(delivery.getBowler(), bowler);
						if (delivery.getWickets() != null) {
							for (MatchInputJsonOverDeliveryWicket wicket : delivery.getWickets()) {
								if (wicket.getKind().equalsIgnoreCase("bowled")
										|| wicket.getKind().equalsIgnoreCase("caught")
										|| wicket.getKind().equalsIgnoreCase("caught and bowled")
										|| wicket.getKind().equalsIgnoreCase("lbw")
										|| wicket.getKind().equalsIgnoreCase("stumped")
										|| wicket.getKind().equalsIgnoreCase("hit the ball twice")
										|| wicket.getKind().equalsIgnoreCase("handled the ball")) {
									inning.getBowlers().get(delivery.getBowler())
											.setWickets(inning.getBowlers().get(delivery.getBowler()).getWickets() + 1);
								}
								if (inning.getBatters().get(wicket.getPlayerOut()) != null) {
									inning.getBatters().get(wicket.getPlayerOut()).setOut(true);
									inning.getBatters().get(wicket.getPlayerOut()).setKind(wicket.getKind());
									inning.getBatters().get(wicket.getPlayerOut())
											.setWicketInfo(wicket.toString() + " bolwer: " + delivery.getBowler()
													+ " in the " + (over.getOver() + 1) + " over");
								} else {
									MatchInputJsonInningBatters value = new MatchInputJsonInningBatters();
									value.setName(wicket.getPlayerOut());
									value.setWicketInfo(wicket.toString() + " bolwer: " + delivery.getBowler()
											+ " in the " + (over.getOver() + 1) + " over");
									inning.getBatters().put(wicket.getPlayerOut(), value);
								}
								cummulativeWickets += 1;
							}
						}
						over.setCummulativeRuns(cummulativeRuns);
						over.setCummulativeWickets(cummulativeWickets);
						r = (double) cummulativeRuns / (over.getOver() + 1);
						salary = Math.round(r * 100.0) / 100.0;
						over.setRunRate(salary);

					}
				}
			}
		}
	}

}
