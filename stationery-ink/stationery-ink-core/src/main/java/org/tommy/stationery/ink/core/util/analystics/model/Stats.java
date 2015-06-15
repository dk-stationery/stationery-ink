package org.tommy.stationery.ink.core.util.analystics.model;

import java.util.Arrays;

public class Stats {
	private final float[] values;
	private float[] sortedValues;

	public Stats(String[] values) {
		this.values = new float[values.length];
		int i = 0;
		for (String s : values) {
			this.values[i++] = Float.parseFloat(s);
		}
		compute();
	}

	private void compute() {
		sortedValues = values.clone();
		assert sortedValues != values;
		Arrays.sort(sortedValues);
	}

	public float getMin() {
		return sortedValues[0];
	}

	public float getMax() {
		return sortedValues[sortedValues.length - 1];
	}

	public float getAvg() {
		float total = 0;
		for (float v : values) {
			total += v;
		}
		return total / values.length;
	}

	public float getMean() {
		return sortedValues[sortedValues.length / 2];
	}

	public float getPercentile(int percentile) {
		return sortedValues[(int) ((int)sortedValues.length*percentile/100f)];
	}
}
