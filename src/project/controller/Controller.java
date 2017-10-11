package project.controller;

import java.util.Set;

import project.AbstractRobot;
import project.BuildingInterface;
import project.SimulatorController;
import project.environment.Building;
import project.environment.Room;
import project.robot.Robot;
import simbad.sim.EnvironmentDescription;

public class Controller extends SimulatorController {

	private Set<Robot> robots;

	private Building b;

	public Controller(Building b, Set<Robot> robots, EnvironmentDescription e) {
		super(b, robots, e);
		this.robots = robots;
		this.b = b;
	}

	@Override
	public void update() {
		for (Robot r : robots) {
			if (b.contains(r)) {
				b.addRobot(r);
			}
		}
		for (Room room : b.getRooms()) {
			room.clearRobots();
			for (AbstractRobot r : robots) {

				if (room.contains(r)) {
					room.addRobot(r);
				}
			}
			System.out.println("Room " +room.getName()+" contains robots "+ room.getRobots());

		}

		for (Robot r : robots) {
			System.out.println("Robot "+r.getName()+"\t Mission: "+r.getMission().getPoints());
			r.updateDestinationGoal();
		}
		System.out.println("The building is containing the robots" + b.getRobots());

	}

}
