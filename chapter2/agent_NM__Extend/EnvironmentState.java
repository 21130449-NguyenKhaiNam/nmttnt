package chapter2.agent_NM__Extend;

import java.util.HashMap;
import java.util.Map;

import chapter2.agent_NM__Extend.Environment.LocationState;


public class EnvironmentState {
	private Map<String, Environment.LocationState> state = new HashMap<String, Environment.LocationState>();
	private String agentLocation = null;//
	private int x = -1;
	private int y = -1;

	public EnvironmentState(LocationState[][] lss) {
		for (int i = 0; i < Environment.LOCATIONS.length; i++) {
			for (int j = 0; j < Environment.LOCATIONS[i].length; j++) {
				this.state.put(Environment.LOCATIONS[i][j], lss[i][j]);
			}
		}
	}

	public void setAgentLocation(String location, int x, int y) {
		this.agentLocation = location;
		this.x = x;
		this.y = y;
		this.state.put(location, LocationState.CLEAN);
	}

	public String getAgentLocation() {
		return this.agentLocation;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public LocationState getLocationState(String location) {
		return this.state.get(location);
	}

	public void setLocationState(String location, LocationState clean) {
		this.state.put(location, clean);
	}

	public void display() {
		System.out.println("Environment state: \n\t" + this.state);
	}
}