package chapter2.agent_NM;

import java.util.Random;

// Suppose the environment is square
public class Environment {
	public static final Action MOVE_LEFT = new DynamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DynamicAction("RIGHT");
	public static final Action MOVE_UP = new DynamicAction("UP");
	public static final Action MOVE_DOWN = new DynamicAction("DOWN");
	public static final Action SUCK_DIRT = new DynamicAction("SUCK");
	public static final String[][] LOCATIONS = { { "A", "C", "D" }, { "E", "F", "G", "H" },
			{ "I", "J", "K", "L" } };

	public static int score = 0;

	public enum LocationState {
		CLEAN, DIRTY, WALL, OBSTACLE
	}

	private EnvironmentState envState;
	private boolean isDone = false;// all squares are CLEAN
	private Agent agent = null;

	public Environment() {
		LocationState[][] lss = new LocationState[LOCATIONS.length][];
		Random rd = new Random();
		for (int i = 0; i < LOCATIONS.length; i++) {
			lss[i] = new LocationState[LOCATIONS[i].length];
			for (int j = 0; j < LOCATIONS[i].length; j++) {
				int num = rd.nextInt(10);
				LocationState state = null;
				if (num == 0) {
					state = LocationState.WALL;
				} else if (num == 1 || num == 2) {
					state = LocationState.DIRTY;
				} else {
					if (num < 6) {
						state = LocationState.CLEAN;
					} else {
						state = LocationState.OBSTACLE;
					}
				}

				lss[i][j] = state;
			}
		}
		envState = new EnvironmentState(lss);
	}

	// add an agent into the enviroment
	public void addAgent(Agent agent, String location) {
		// TODO
		int x = -1;
		int y = -1;
		for (int i = 0; i < Environment.LOCATIONS.length; i++) {
			for (int j = 0; j < Environment.LOCATIONS[i].length; j++) {
				if (location.equals(Environment.LOCATIONS[i][j])) {
					x = i;
					y = j;
				}
			}
		}
		this.envState.setAgentLocation(location, x, y);
		this.agent = agent;
	}

	public EnvironmentState getCurrentState() {
		return this.envState;
	}

	// Update enviroment state when agent do an action
	public EnvironmentState executeAction(Action action) {
		// TODO
		int x = this.envState.getX();
		int y = this.envState.getY();
		if (action == SUCK_DIRT) {
			score += 500;
			this.envState.setLocationState(this.envState.getAgentLocation(), LocationState.CLEAN);
		} else {
			if (action == MOVE_UP) {
				x += 1;
			} else if (action == MOVE_RIGHT) {
				y += 1;
			} else if (action == MOVE_DOWN) {
				x -= 1;
			} else {
				y -= 1;
			}
			move(action, x, y);
		}
		return envState;
	}

	public void move(Action ac, int x, int y) {
		if (canMove(this.envState.getAgentLocation(), ac)) {
			LocationState state = this.envState.getLocationState(LOCATIONS[x][y]);
			if (state == LocationState.WALL || state == LocationState.OBSTACLE) {
				score -= 100;
			} else {
				score -= 10;
				this.envState.setAgentLocation(LOCATIONS[x][y], x, y);
			}
		} else {
			score -= 100;
		}
	}

	public boolean canMove(String location, Action ac) {
		if (ac == MOVE_UP || ac == MOVE_DOWN) {
			int len = ac == MOVE_UP ? LOCATIONS.length - 1 : 0;
			for (int i = 0; i < LOCATIONS[len].length; i++) {
				if (location.equals(LOCATIONS[len][i]))
					return false;
			}
		} else if (ac == MOVE_RIGHT || ac == MOVE_LEFT) {
			for (int i = 0; i < LOCATIONS.length; i++) {
				if (location.equals(LOCATIONS[i][ac == MOVE_RIGHT ? LOCATIONS[0].length - 1 : 0]))
					return false;
			}
		}
		return true;
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

		for (int i = 0; i < Environment.LOCATIONS.length; i++) {
			for (int j = 0; j < Environment.LOCATIONS[i].length; j++) {
				LocationState state = es.getLocationState(Environment.LOCATIONS[i][j]);
				if (state == LocationState.DIRTY) {
					isDone = false;
					break;
				} else {
					isDone = true;
				}
			}
			if (!isDone)
				break;
		}

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
			if (i > 100000) {
				System.out.println("------------- Error ------------");
				System.out.println("------------- Help: I'm stuck on Everest -------------");
				break;
			}
			step();
		}
	}
}
