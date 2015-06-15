package org.tommy.stationery.ink.core.util.analystics.model;

/**
 * Vmstat Data holder
 */
public interface VmstatData {
	String[] getValuesFor(String columnTitle);

	int getLineCount();

	boolean hasColumn(String title);
}
