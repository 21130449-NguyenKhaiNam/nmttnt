package chapter2.agent_NM__Extend;

import java.util.Random;

import chapter2.agent_NM.Environment.LocationState;

public class AgentProgram {
	Action[] locations = { Environment.MOVE_UP, Environment.MOVE_RIGHT, Environment.MOVE_DOWN, Environment.MOVE_LEFT };

	public Action execute(Percept p) {// location, status
		// TODO
		Action action = null;
		if (p.getLocationState().name().equals(LocationState.DIRTY.name())) {
			action = Environment.SUCK_DIRT;
		} else {
			action = locations[(new Random()).nextInt(locations.length)];
		}
		return action;
	}
}