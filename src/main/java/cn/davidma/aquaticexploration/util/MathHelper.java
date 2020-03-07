package cn.davidma.aquaticexploration.util;

public class MathHelper {
	
	public static double oscillate(double time, double min, double max) {
		return min + (Math.sin(Math.toRadians(time)) + 1) / 2 * (max - min);
	}
}