package simbad.sim;

import java.awt.Color;

import javax.vecmath.Color3f;

import project.Point;

/**
 * A wall which can be put in the environnement.
 */
public class VerticalWall extends AbstractWall {
	
	private Float p1x;
	private Float p2x;
	private Float p1z;
	private static final float height = 2;

	public VerticalWall(Float p1z, Float p1x, Float p2x, EnvironmentDescription wd) {
		super(new Point(p1x+(p2x - p1x)/2, p1z), p2x - p1x, height, wd);
		setColor(new Color3f(Color.RED));
		this.p1x = p1x;
		this.p1z = p1z;
		this.p2x = p2x;
	}

	public Float getP1x() {
		return p1x;
	}

	public Float getP1z() {
		return p1z;
	}

	public Float getP2x() {
		return p2x;
	}

	public Float getP2z() {
		return p1z;
	}

}