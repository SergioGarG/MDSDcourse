package project.robot;

import javax.vecmath.Vector3d;

import project.AbstractRobot;
import project.environment.mission.Mission;
import project.environment.mission.Strategy;

public class Robot extends AbstractRobot {

	private Mission mission;
	private Strategy strategy;

	public Robot(Mission mission, Strategy strategy, Vector3d position, String name) {
		super(position, name);
		this.setMission(mission);
		this.setStrategy(strategy);
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	@Override
	public String toString() {
		return "Robot " + this.getName();
	}

	public void updateDestinationGoal() {

		if (!mission.isAchieved()) {
			Vector3d nextPoint = strategy.getNextPoint(this, mission);
			if (nextPoint != null) {
				this.setDestination(nextPoint);
			}
		}
	}
}
