package project.environment;

import java.util.HashSet;
import java.util.Set;

import simbad.sim.Box;

public class DiningRoom extends Room {

	public Set<Box> boxes;
	

	public DiningRoom() {
		super("Dining room");
		this.boxes = new HashSet<>();
	}
	
	public void addBox(Box box) {
		this.boxes.add(box);
	}

	public void removeBox(Box box) {
		this.boxes.add(box);
	}
	
}
