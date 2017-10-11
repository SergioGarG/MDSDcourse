package project;

import javax.vecmath.Vector3d;

import simbad.sim.Agent;
import simbad.sim.RobotFactory;

public class RobotAgent extends Agent {

	// private String currentMode;

	private double MIN_DIST = 0.1;
	private Point destination;

	private SimulatorController controller;

	public RobotAgent(Point position, String name) {
		super(new Vector3d(position.getX(), 0, position.getZ()), name);

		this.destination = position;
		// Add bumpers
		RobotFactory.addBumperBeltSensor(this, 12);
		// Add sonars
		RobotFactory.addSonarBeltSensor(this, 4);
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}

	public void setController(SimulatorController controller) {
		this.controller = controller;

	}

	/** This method is called by the simulator engine on reset. */
	public void initBehavior() {
		System.out.println("I exist and my name is " + this.name);
	}

	/**
	 * This method is call cyclically (20 times per second) by the simulator
	 * engine.
	 */
	public void performBehavior() {

		System.out.println("robot: " + this.getName() + "DESTINATION AAAA: " + destination + " current location"
				+ this.getPosition());
		Vector3d position = this.getPosition();

		if (!isAtPosition(this.destination)) {
			double angle = -Math.atan2((destination.getZ() - position.z), (destination.getX() - position.x)) * 180
					/ Math.PI;

			this.rotateY(angle);
			this.setTranslationalVelocity(1);
		} else {
			this.setTranslationalVelocity(0);
			this.setRotationalVelocity(0);
		}

		controller.update();
		// this.rotate
		// this.rotateY(2);
		// this.getRotation().set(cross);
		// if (y != desiredy) {
		// System.out.println("orientation not correct");
		// this.getRotation().get(m);
		// m.rotY(desiredy-y);
		// m.rotY(2);
		// this.getRotation().set(m);
		// }
		// if()
		// this.controller.update();
		// moveToPosition(new Vector3d(new Vector3d(1, 1, 1)));
		// perform the following actions every 5 virtual seconds
		/*
		 * if(this.getCounter() % 5 == 0) { if(this.collisionDetected()) {
		 * this.currentMode = "avoidObstacle"; } else { this.currentMode =
		 * "goAround"; }
		 * 
		 * if(this.currentMode == "goAround") { // the robot's speed is always
		 * 0.5 m/s this.setTranslationalVelocity(0.5);
		 * 
		 * // frequently change orientation if ((getCounter() % 100) == 0) {
		 * setRotationalVelocity(Math.PI / 2 * (0.5 - Math.random())); } } else
		 * { // don't move this.setTranslationalVelocity(0); // rotate only
		 * until obstacle is not there setRotationalVelocity(Math.PI / 2); } }
		 */

	}

	public boolean isAtPosition(Point dest) {
		Vector3d position = this.getPosition();

		if ((Math.abs(dest.getZ() - position.z)) > MIN_DIST || ((Math.abs(dest.getX() - position.x)) > MIN_DIST)) {
			return false;
		}
		return true;
	}
}