package com.aj.model;

public class CreateNewRandom {
	public static String[][] lOtLadies = {{"Sara", "Lance", "sLance", "whiteCanary", "admin"}, {"Nyssa", "Al-Ghul", "nyssaA", "nandaParbat", "empl"}, {"Ava", "Sharpe", "dirSharpe", "bigBoss", "admin"}, {"Zari", "Tomaz", "fightTheFuture", "2042"}, {"Amaya", "Jiwe", "zambesiGirl", "pendantPower"}, {"Kendra", "Saunders", "hawkwings", "flying"}, {"Mona", "Wu", "animalLover", "monaWu"}, {"Norah", "Darhk", "evilToGood", "missmydad"}};
	
	
	public static User createRandomUser() {
		int whichIn = (int) Math.floor(Math.random() * lOtLadies.length - 1);
		User newU = new User(lOtLadies[whichIn][0], lOtLadies[whichIn][1], lOtLadies[whichIn][2],lOtLadies[whichIn][3], lOtLadies[whichIn][4]);
		return newU;
	}
	
}
