package com.tunisij;

//Memento implementation
public class GameSave {

	private final Character character;
	
	public GameSave(Character character) {
		this.character = new Character(character.getPosition(), character.getHealth(), character.getName());
	}
	
	public Character getSavedState() {
		return this.character;
	}
}
