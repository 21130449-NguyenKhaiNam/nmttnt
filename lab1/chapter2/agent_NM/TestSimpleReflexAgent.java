package chapter2.agent_NM; 

public class TestSimpleReflexAgent {
	public static void main(String[] args) {
		Environment env = new Environment();
		Agent agent = new Agent(new AgentProgram());
		env.addAgent(agent, Environment.LOCATIONS[0][0]);

		env.stepUntilDone();
	}
}
