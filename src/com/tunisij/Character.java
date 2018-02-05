package com.tunisij;

public class Character {

	private int position;
	private int health;
	private String name;

	public Character(Integer position, Integer health, String name) {
		this.position = position;
		this.health = health;
		this.name = name;
	}

	public int getPosition() {
		return this.position;
	}

	public int getHealth() {
		return this.health;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
