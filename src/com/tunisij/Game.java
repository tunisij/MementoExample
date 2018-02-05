package com.tunisij;

import java.util.ArrayList;
import java.util.List;

//Originator class
public class Game {
	
	private List<Character> characters = new ArrayList<>();
	private int selectedCharacter;
	
	public Game(String... characterNames) {
		for (String name : characterNames) {
			characters.add(new Character(0, 100, name));
		}
		this.selectedCharacter = 0;
	}

	//creates a memento for a given character
	public GameSave save(String characterName) {
		for (Character character : characters) {
			if (character.getName().equals(characterName)) {
				System.out.println(character.getName() + "'s progress has been saved");
				System.out.println("");
				return new GameSave(character);
			}
		}
		return null;
	}
	
	//sets a given character's state back
	public void restore(GameSave gameSave) {
		for (Character character : characters) {
			if (character.getName().equals(gameSave.getSavedState().getName())) {
				int health = character.getHealth();
				character = gameSave.getSavedState();
				character.setHealth(health);
				
				System.out.println("Restored " + character.getName() + " to save point");
				System.out.println(character.getName() + " has taken " + character.getPosition() + " steps total");
				System.out.println(character.getName() + " has " + character.getHealth() + " health");
				System.out.println("");
				
				return;
			}
		}
	}
	
	public void move(int steps) {
		characters.get(selectedCharacter).setPosition(characters.get(selectedCharacter).getPosition() + steps);
		System.out.println("Moved " + characters.get(selectedCharacter).getName() + " " + steps + " steps");
		
		if (characters.get(selectedCharacter).getPosition() != steps) {
			System.out.println(characters.get(selectedCharacter).getName() + " has moved a total of " + characters.get(selectedCharacter).getPosition() + " steps");
		}
		System.out.println("");
	}
	
	public void switchCharacter() {
		int previousCharacter = selectedCharacter;
		selectedCharacter = (selectedCharacter + 1) % characters.size();
		System.out.println("Switched from " + characters.get(previousCharacter).getName() + " to " + characters.get(selectedCharacter).getName());
		System.out.println(characters.get(selectedCharacter).getName() + " has taken " + characters.get(selectedCharacter).getPosition() + " steps total");
		System.out.println(characters.get(selectedCharacter).getName() + " has " + characters.get(selectedCharacter).getHealth() + " health");
		System.out.println("");
	}
	
	public void takeDamage(int damage) {
		characters.get(selectedCharacter).setHealth(characters.get(selectedCharacter).getHealth() - damage);
		System.out.println(characters.get(selectedCharacter).getName() + " has taken " + damage + " damage");
		System.out.println(characters.get(selectedCharacter).getName() + " has " + characters.get(selectedCharacter).getHealth() + " health");
		System.out.println("");
	}
	
}
