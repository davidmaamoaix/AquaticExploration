package cn.davidma.aquaticexploration.util.helper;

import java.util.Random;

public class MathHelper {
	
	public static double oscillate(double time, double min, double max) {
		return min + (Math.sin(Math.toRadians(time)) + 1) / 2 * (max - min);
	}
	
	public static float randomFloat(Random rand, float min, float max) {
		return rand.nextFloat() * (max - min) + min;
	}
}
