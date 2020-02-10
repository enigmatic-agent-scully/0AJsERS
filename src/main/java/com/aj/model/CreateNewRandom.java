package com.aj.model;

import java.util.ArrayList;
import java.util.List;

public class CreateNewRandom {
	public static String[][] lOtLadies = {{"Sara", "Lance", "sLance", "whiteCanary", "admin"}, {"Nyssa", "Al-Ghul", "nyssaA", "nandaParbat", "empl"}, {"Ava", "Sharpe", "dirSharpe", "bigBoss", "admin"}, {"Zari", "Tomaz", "fightTheFuture", "2042", "empl"}, {"Amaya", "Jiwe", "zambesiGirl", "pendantPower", "empl"}, {"Kendra", "Saunders", "hawkwings", "flying", "empl"}, {"Mona", "Wu", "animalLover", "monaWu", "empl"}, {"Norah", "Darhk", "evilToGood", "missmydad", "admin"}};
	
	
	public static List<User> createUsers() {
		List<User> users = new ArrayList<>();
		for (String[] arr : lOtLadies) {
			User newU = new User(arr[0], arr[1], arr[2], arr[3], arr[4]);
			users.add(newU);
		}
		
		return users;
	}
	
}
