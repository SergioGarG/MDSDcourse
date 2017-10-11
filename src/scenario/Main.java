package scenario;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;

import project.AbstractRobot;
import project.SimulatorController;
import project.controller.Controller;
import project.environment.Building;
import project.environment.DiningRoom;
import project.environment.mission.Mission;
import project.environment.mission.OrderedStrategy;
import project.environment.mission.Strategy;
import project.robot.Robot;
import simbad.sim.HorizontalBoundary;
import simbad.sim.HorizontalWall;
import simbad.sim.VerticalBoundary;
import simbad.sim.VerticalWall;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Wall;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		EnvironmentDescription e = new EnvironmentDescription();
		Building b = new Building();

		DiningRoom d = new DiningRoom();

		d.addBox(new Wall(new Vector3d(-5, 0, 0), 10, 2, e));

		Boundary w1 = new HorizontalBoundary(-5.0f, -5.0f, 5.0f, e);
		b.addBorderBoundary(w1);

		Boundary w2 = new HorizontalBoundary(5.0f, -5.0f, 5.0f, e);
		b.addBorderBoundary(w2);

		Boundary w3 = new VerticalBoundary(5.0f, -5.0f, 5.0f, e);
		b.addBorderBoundary(w3);

		Boundary w4 = new VerticalBoundary(-5.0f, -5.0f, 5.0f, e);
		b.addBorderBoundary(w4);

		// w3.setColor(new Color3f(Color.RED));
		// b.addBorderBoundary(w3);

		// BorderBoundary w4 = new BorderBoundary(new Vector3d(0, 0, -5), 10, 2,
		// e);
		// w4.setColor(new Color3f(Color.YELLOW));
		// b.addBorderBoundary(w4);

		AbstractWall roomWall1 = new HorizontalWall(-1f, 4.5f, 3.5f, e);
		d.addWall(roomWall1);

		AbstractWall roomWall2 = new HorizontalWall(-4.5f, 4.5f, 1f, e);
		d.addWall(roomWall2);

		AbstractWall roomWall3 = new VerticalWall(4.5f, -4.5f, -1f, e);
		d.addWall(roomWall3);

		AbstractWall roomWall4 = new VerticalWall(1f, -4.5f, -1f, e);
		d.addWall(roomWall4);

		b.addRoom(d);

		Set<Robot> robots = new HashSet<>();

		List<Vector3d> destinationsr1 = new ArrayList<>();
		destinationsr1.add(new Vector3d(2, 0, 3));
		destinationsr1.add(new Vector3d(-1, 0, -1));
		destinationsr1.add(new Vector3d(3, 0, -3));

		Mission m1 = new Mission(destinationsr1);

		List<Vector3d> destinationsr2 = new ArrayList<>();
		destinationsr2.add(new Vector3d(-2, 0, 3));

		Mission m2 = new Mission(destinationsr2);

		Robot robot1 = new Robot(m1, new OrderedStrategy(), new Vector3d(0, 0, 0), "Robot 1");
		Robot robot2 = new Robot(m2, new OrderedStrategy(), new Vector3d(1, 0, 3), "Robot 2");

		robots.add(robot1);
		robots.add(robot2);
		SimulatorController controller = new Controller(b, robots, e);

		// crete two instances of the same example robot

		// t.run();

		// e.add(robot1);
		// add the two robots to the environment
		// environment.add(robot1);
		// environment.add(robot2);

	}

}
