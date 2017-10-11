package project.environment.mission;

import javax.vecmath.Vector3d;

public class OrderedStrategy extends Strategy {

	@Override
	public Vector3d getCurrentPoint(Mission mission) {
		
		
		Vector3d targetPoint=mission.getPoints().get(0);
		System.out.println("Target point: "+targetPoint);
		return targetPoint;
	}

	@Override
	public void removeReachedPoint(Mission mission) {
		mission.getPoints().remove(0);

	}
}
