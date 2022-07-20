package com.eric.catMouseApi.models;

public class ScenarioRequest {

	private String scenario = "";
	private int spacesCanJump = 0;
	
	public String getScenario() {
		return scenario;
	}
	public void setScenario(String scenario) {
		this.scenario = scenario;
	}
	public int getSpacesCanJump() {
		return spacesCanJump;
	}
	public void setSpacesCanJump(int spacesCanJump) {
		this.spacesCanJump = spacesCanJump;
	}
}
