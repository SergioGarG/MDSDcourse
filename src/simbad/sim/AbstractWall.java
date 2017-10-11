package simbad.sim;

import javax.vecmath.Vector3d;

public abstract class AbstractWall extends Wall {

	public AbstractWall(Vector3d pos ,float length,float height ,EnvironmentDescription wd) {
		super(pos, length, height, wd);
	}

	public abstract Float getP1x();

	public abstract Float getP1z();

	public abstract Float getP2x();

	public abstract Float getP2z();
}