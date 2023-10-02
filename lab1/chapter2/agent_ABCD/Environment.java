package chapter2.agent_ABCD;

/**
 * A B C D
 */
public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";

	public static int score = 0;

	public enum LocationState {
		CLEAN, DIRTY
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment(LocationState locAState, LocationState locBState, LocationState locCState,
			LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		this.envState.setAgentLocation(location);
		this.agent = agent;
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		String location = envState.getAgentLocation();
		if (action == SUCK_DIRT) {
			score += 500;
			this.envState.setLocationState(this.envState.getAgentLocation(), LocationState.CLEAN);
		} else if (action == MOVE_UP) {
			if (location == LOCATION_A || location == LOCATION_B) {
				score -= 100;
			} else {
				score -= 10;
				this.envState.setAgentLocation(location == LOCATION_C ? LOCATION_A : LOCATION_B);
			}
		} else if (action == MOVE_LEFT) {
			if (location == LOCATION_A || location == LOCATION_C) {
				score -= 100;
			} else {
				score -= 10;
				this.envState.setAgentLocation(location == LOCATION_B ? LOCATION_A : LOCATION_C);
			}
		} else if (action == MOVE_DOWN) {
			if (location == LOCATION_C || location == LOCATION_D) {
				score -= 100;
			} else {
				score -= 10;
				this.envState.setAgentLocation(location == LOCATION_A ? LOCATION_C : LOCATION_D);
			}
		} else {
			if (location == LOCATION_B || location == LOCATION_D) {
				score -= 100;
			} else {
				score -= 10;
				this.envState.setAgentLocation(location == LOCATION_A ? LOCATION_B : LOCATION_D);
			}
		}
		return envState;
	}

	// get percept<AgentLocation, LocationState> at the current location where agent
	// is in.
	public Percept getPerceptSeenBy() {
		// TODO
		return new Percept(this.envState.getAgentLocation(),
				this.envState.getLocationState(this.envState.getAgentLocation()));
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
		System.out.println("Score: " + score);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}
}
