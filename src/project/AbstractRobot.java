package project;

public abstract class AbstractRobot {

	private RobotAgent agent;

	public AbstractRobot(Point position, String name) {
		agent = new RobotAgent(position, name);
	}

	public void setDestination(Point destination) {
		agent.setDestination(destination);
	}

	public Point getPosition() {
		return new Point(agent.getPosition().x, agent.getPosition().z);
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

	public boolean isAtPosition(Point dest) {
		return agent.isAtPosition(dest);
	}
}
