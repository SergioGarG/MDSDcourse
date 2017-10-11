package simbad.sim;

import java.awt.Color;

import javax.vecmath.Color3f;

import project.Point;


/**
 * A wall which can be put in the environnement.
 */
public class HorizontalWall extends AbstractWall {

	private Float p1x;
	private Float p1z;
	private Float p2z;
	private static final float height = 2;

	public HorizontalWall(Float p1x, Float p1z, Float p2z, EnvironmentDescription wd) {
		super(new Point(p1x, p1z+(p2z - p1z)/2), p2z - p1z, height,  wd);
		setColor(new Color3f(Color.RED));
		this.rotate90(1);
		this.p1x=p1x;
		this.p1z=p1z;
		this.p2z=p2z;
	}


	public Float getP1x() {
		return p1x;
	}

	public Float getP1z() {
		return p1z;
	}

	public Float getP2x() {
		return p1x;
	}

	public Float getP2z() {
		return p2z;
	}

}
