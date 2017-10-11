package project;

import java.util.Set;

import simbad.gui.Simbad;
import simbad.sim.EnvironmentDescription;
import simbad.sim.Simulator;

public abstract class SimulatorController {

	public SimulatorController(BuildingInterface b, Set<? extends AbstractRobot> robots, EnvironmentDescription e) {
		System.out.println("*********************");
		// request antialising so that diagonal lines are not "stairy"
		System.setProperty("j3d.implicitAntialiasing", "true");

		// creation of the environment containing all obstacles and robots
		// EnvironmentDescription environment = new
		// ExampleEnvironment(b.gerObjects());

		b.gerObjects().stream().forEach(o -> e.add(o));
		robots.forEach((r) -> {
			e.add(r.getAgent());
			r.setController(this);
		});

		// environment.add

		// here we create an instance of the whole Simbad simulator and we
		// assign the newly created environment
		Simbad frame = new Simbad(e, false);
		frame.update(frame.getGraphics());

		Simulator sim = frame.getSimulator();
		sim.startSimulation();
	}

	public abstract void update();
}
