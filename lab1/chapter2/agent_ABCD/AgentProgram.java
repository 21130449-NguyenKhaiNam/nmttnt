package chapter2.agent_ABCD;

public class AgentProgram {
	Action[] actionMoves = { MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN };

	public Action execute(Percept p) {// location, status
		// TODO
		chapter2.agent_AB.Action action = null;
		if (p.getLocationState().equals(Environment.LocationState.DIRTY)) {
			action = SUCK_DIRT;
		} else if (p.getAgentLocation().equals(Environment.LOCATION_A)) {
			action = MOVE_RIGHT;
		} else {
			action = MOVE_LEFT;
		}
		return action;
	}
}