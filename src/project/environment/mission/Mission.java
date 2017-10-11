package project.environment.mission;

import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Vector3d;

public class Mission {

	private List<Vector3d> points;

	public Mission() {
		this.points = new ArrayList<>();
	}

	public Mission(List<Vector3d> points) {
		this.points = points;
	}

	public void addPoint(Vector3d point) {
		this.points.add(point);
	}

	public boolean isAchieved() {
		return points.isEmpty();
	}

	public List<Vector3d> getPoints() {
		return this.points;
	}

}
