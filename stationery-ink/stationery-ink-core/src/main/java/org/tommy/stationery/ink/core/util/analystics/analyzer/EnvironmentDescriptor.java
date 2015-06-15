package org.tommy.stationery.ink.core.util.analystics.analyzer;

public class EnvironmentDescriptor {

	private final int cpuCount;
	private final boolean javaRunning;

	/**
	 * 
	 * @param cpuCount
	 *            the number of CPU of the system.
	 * @param javaRunning
	 *            if Java is the (main) app running, if we should try and make
	 *            advice about issues inside a JVM.
	 */
	public EnvironmentDescriptor(int cpuCount, boolean javaRunning) {
		this.cpuCount = cpuCount;
		this.javaRunning = javaRunning;
	}

	public int getCpuCount() {
		return cpuCount;
	}

	public boolean hasJavaRunning() {
		return javaRunning;
	}
}
