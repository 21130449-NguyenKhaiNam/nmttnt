package chapter2.agent_AB;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		// TODO
		return p.getLocationState().equals(Environment.LocationState.DIRTY) ? Environment.SUCK_DIRT
				: (p.getAgentLocation().equals(Environment.LOCATION_A) ? Environment.MOVE_RIGHT
						: Environment.MOVE_LEFT);
	}
}