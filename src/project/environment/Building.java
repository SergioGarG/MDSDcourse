package project.environment;

import java.util.HashSet;
import java.util.Set;

import project.AbstractRobot;
import project.BuildingInterface;
import simbad.sim.Boundary;
import simbad.sim.HorizontalBoundary;
import simbad.sim.StaticObject;

public class Building implements BuildingInterface {

	private Set<Room> rooms;
	private Set<Boundary> boundaries;
	private Set<AbstractRobot> robots;

	public Building() {
		this.rooms = new HashSet<>();
		this.boundaries = new HashSet<>();
		robots = new HashSet<>();
	}

	public Set<Room> getRooms() {
		return this.rooms;
	}

	public void addRoom(Room room) {
		this.rooms.add(room);
	}

	public Set<Boundary> getBorderBoundary() {
		return this.boundaries;
	}

	public void addBorderBoundary(Boundary room) {
		this.boundaries.add(room);
	}

	public Set<StaticObject> gerObjects() {
		Set<StaticObject> objects = new HashSet<>();
		rooms.forEach(r -> objects.addAll(r.getWalls()));
		objects.addAll(boundaries);
		return objects;
	}

	public void clearRobots() {
		this.robots = new HashSet<>();
	}

	public void addRobot(AbstractRobot r) {
		this.robots.add(r);
	}

	public boolean contains(AbstractRobot robot) {
		Float maxx = -9999.0f;
		Float maxz = -9999.0f;
		Float minx = +9999.0f;
		Float minz = +9999.0f;
		for (Boundary b : this.boundaries) {
			if (b.getP1x() < minx) {
				minx = b.getP1x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP2x() < minx) {
				minx = b.getP1x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP1x() > maxx) {
				maxx = b.getP1x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP2x() > maxx) {
				maxx = b.getP2x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP1z() < minz) {
				minz = b.getP1x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP2x() < minx) {
				minz = b.getP2x();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP1z() > maxz) {
				maxz = b.getP1z();
			}
		}

		for (Boundary b : this.boundaries) {
			if (b.getP2x() > maxz) {
				maxz = b.getP2z();
			}
		}

		System.out.println(minx+"\t"+maxx+"\t"+minz+"\t"+maxz+"\t");
		if (robot.getPosition().getX() < maxx && robot.getPosition().getX() > minx && robot.getPosition().getZ() < maxz
				&& robot.getPosition().getZ() > minz) {
			return true;
		}
		return false;

	}

	public Set<AbstractRobot> getRobots() {
		return this.robots;
	}
}
