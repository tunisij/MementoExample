package com.tunisij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Caretaker implementation
public class SaveManager {
	
	private Map<String, List<GameSave>> gameSaves;
	
	public SaveManager() {
		gameSaves = new HashMap<>();
	}
	
	public void addSaveState(String character, GameSave gameSave) {
		if (gameSaves.get(character) == null) {
			gameSaves.put(character, new ArrayList<>(Arrays.asList(gameSave)));
		} else {
			gameSaves.get(character).add(gameSave);
		}
	}
	
	public GameSave getSavePoint(String character, int index) {
		return gameSaves.get(character).get(index);
	}
}
