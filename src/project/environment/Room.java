package project.environment;

import java.util.HashSet;
import java.util.Set;

import project.AbstractRobot;
import simbad.sim.AbstractWall;
import simbad.sim.Boundary;
import simbad.sim.Wall;

public abstract class Room {

	private Set<AbstractWall> walls;
	private Set<AbstractRobot> robots;
	
	private final String name;

	public Room(String name) {
		walls = new HashSet<>(5);
		robots = new HashSet<>();
		this.name=name;
		
	}

	public void addWall(AbstractWall wall) {
		this.walls.add(wall);
	}

	public Set<AbstractWall> getWalls(){
		return this.walls;
	}
	
	public boolean contains(AbstractRobot robot) {
		Float maxx = -9999.0f;
		Float maxz = -9999.0f;
		Float minx = +9999.0f;
		Float minz = +9999.0f;
		for (AbstractWall b : this.walls) {
			if (b.getP1x() < minx) {
				minx = b.getP1x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP2x() < minx) {
				minx = b.getP1x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP1x() > maxx) {
				maxx = b.getP1x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP2x() > maxx) {
				maxx = b.getP2x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP1z() < minz) {
				minz = b.getP1x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP2x() < minx) {
				minz = b.getP2x();
			}
		}

		for (AbstractWall b : this.walls) {
			if (b.getP1z() > maxz) {
				maxz = b.getP1z();
			}
		}

		for (AbstractWall b : this.walls) {
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
	public void clearRobots() {
		this.robots = new HashSet<>();
	}

	public void addRobot(AbstractRobot r) {
		this.robots.add(r);
	}
	
	public Set<AbstractRobot> getRobots() {
		return this.robots;
	}

	public String getName() {
		return name;
	}
}
