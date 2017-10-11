package project.environment.mission;

import javax.vecmath.Vector3d;

import project.robot.Robot;

public abstract class Strategy {

	public abstract Vector3d getCurrentPoint(Mission mission);

	public abstract void removeReachedPoint(Mission mission);

	public Vector3d getNextPoint(Robot r, Mission mission) {
		
		if (r.isAtPosition(getCurrentPoint(mission))) {
			removeReachedPoint(mission);
			System.out.println("removing point");
		}
		if(mission.getPoints().isEmpty()){
			return null;
		}
		return getCurrentPoint(mission);

	}
}
