package project;

import javax.vecmath.Vector3d;

public abstract class AbstractRobot {

	private RobotAgent agent;

	public AbstractRobot(Vector3d position, String name) {
		agent = new RobotAgent(position, name);
	}

	public void setDestination(Vector3d destination) {
		agent.setDestination(destination);
	}

	public Vector3d getPosition() {
		return agent.getPosition();
	}

	protected void setController(SimulatorController controller) {
		agent.setController(controller);
	}

	protected RobotAgent getAgent() {
		return this.agent;
	}

	public String getName() {
		return agent.getName();
	}

	public boolean isAtPosition(Vector3d dest) {
		return agent.isAtPosition(dest);
	}
}
