package com.tunisij;

/**
 * Think of this as a side scrolling game where steps taken is in positive x direction.
 * You can switch between multiple characters at any point you'd like to.
 * Each character has the ability to move back to any save point independent of the other character.
 * When a character moves to a previous save point, their health does not revert, it stays the same
 */
public class GameEngine {

	public static void main(String[] args) {
		String billy = "billy";
		String joe = "joe";
		
		Game game = new Game(billy, joe);
		SaveManager manager = new SaveManager();
		
		game.move(10);
		manager.addSaveState(billy, game.save(billy));
		game.takeDamage(10);
		game.switchCharacter();
		game.move(20);
		game.switchCharacter();
		game.move(30);
		game.restore(manager.getSavePoint(billy, 0));
		game.switchCharacter();
	}
}
