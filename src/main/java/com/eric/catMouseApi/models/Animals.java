package com.eric.catMouseApi.models;

public class Animals {
	private String scenario = "";
	private boolean catExists = false;
	private boolean dogExists = false;
	private boolean mouseExists = false;
	private int catLocation = 0;
	private int dogLocation = 0;
	private int mouseLocation = 0;
	private int catMouseDistance = 0;
	private int catDogDistance = 0;
	private int spacesCatCanJump = 0;
	
	public Animals(String scenario, int spacesCanJump) {
		this.setScenario(scenario);
		this.setCatExists(scenario.indexOf("C") > -1 ? true : false);
		this.setDogExists(scenario.indexOf("C") > -1 ? true : false);
		this.setMouseExists(scenario.indexOf("C") > -1 ? true : false);
		this.setCatLocation(scenario.indexOf("C"));
		this.setDogLocation(scenario.indexOf("D"));
		this.setMouseLocation(scenario.indexOf("m"));
		this.setCatMouseDistance(Math.abs(this.catLocation - this.mouseLocation)-1);
		this.setCatDogDistance(Math.abs(this.catLocation - this.dogLocation)-1);
		this.setSpacesCatCanJump(spacesCanJump);
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public boolean isCatExists() {
		return catExists;
	}

	public void setCatExists(boolean catExists) {
		this.catExists = catExists;
	}

	public boolean isDogExists() {
		return dogExists;
	}

	public void setDogExists(boolean dogExists) {
		this.dogExists = dogExists;
	}

	public boolean isMouseExists() {
		return mouseExists;
	}

	public void setMouseExists(boolean mouseExists) {
		this.mouseExists = mouseExists;
	}

	public int getCatLocation() {
		return catLocation;
	}

	public void setCatLocation(int catLocation) {
		this.catLocation = catLocation;
	}

	public int getDogLocation() {
		return dogLocation;
	}

	public void setDogLocation(int dogLocation) {
		this.dogLocation = dogLocation;
	}

	public int getMouseLocation() {
		return mouseLocation;
	}

	public void setMouseLocation(int mouseLocation) {
		this.mouseLocation = mouseLocation;
	}

	public int getCatMouseDistance() {
		return catMouseDistance;
	}

	public void setCatMouseDistance(int catMouseDistance) {
		this.catMouseDistance = catMouseDistance;
	}

	public int getSpacesCatCanJump() {
		return spacesCatCanJump;
	}

	public void setSpacesCatCanJump(int spacesCatCanJump) {
		this.spacesCatCanJump = spacesCatCanJump;
	}
	

	public int getCatDogDistance() {
		return catDogDistance;
	}

	public void setCatDogDistance(int catDogDistance) {
		this.catDogDistance = catDogDistance;
	}
	
	public boolean hasAnimals() {
		String[] animalLetters = { "C", "D", "m"};
		for(String letter : animalLetters) { //loop through predetermined letters representing animals to ensure they are not all missing.			
			/*
			 * Once it is true we can break out of this loop because we are only checking if the string contains none of the animals.
			 *  It is assumed if all the animals are not missing it will contain at least C and m.
			 */
			if(this.scenario.contains(letter)) return true;
		}
		return false; //None of the animals were found
	}
	
	public boolean jumpedFarEnough() {
		/*
		 * check if spacesCatCanJump is greater than or equal to amount of spaces between the cat and mouse.
		 * subtracting 1 to get the amount of spaces between the cat and mouse, otherwise we will get the distance between their respective positions.
		 */
		if(this.spacesCatCanJump >= this.catMouseDistance) return true;
		else return false;
	}
	
	public boolean dogBetween() {
		/*
		 * Check to see if the mouse is protected by the dog by the dog being between the cat and mouse
		 */
		if((this.catLocation < this.dogLocation && this.dogLocation < this.mouseLocation) || (this.mouseLocation < this.dogLocation && this.dogLocation < this.catLocation )) return true;
		else return false;
	}
	public boolean collidesWithDog() {
		/*
		 * This is to check if the cat collides with the dog at all even if the cat can't jump all the way to the mouse.
		 * Need to check if dogLocation is greater than -1 to make sure that a dog exists. String.indexOf function will return -1 if not found
		 */
		if((this.dogLocation > -1 ) && (this.spacesCatCanJump >= this.catDogDistance)) return true;
		else return false;
	}
}
