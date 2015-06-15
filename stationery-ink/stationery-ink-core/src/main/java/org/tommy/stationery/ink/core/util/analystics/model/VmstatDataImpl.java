package org.tommy.stationery.ink.core.util.analystics.model;

import java.util.HashMap;
import java.util.Map;


// TODO : improve data model, anemic seems stupid here. There has to be a better way.
public class VmstatDataImpl implements VmstatData {
	String[] titles;
	String[][] values;

	public void setTitles(String[] strings) {
		if(values!=null&&strings.length!=values.length)
		{
			throw new IllegalArgumentException("There should be as many column titles as values");
		}
		titles = strings;
	}

	public void setValues(String[][] values) {
		this.values = values;
	}

	@Override
	public String[] getValuesFor(String title) {
		int index = findColumnIndex(title);
		if (index == -1) {
			return null;
		}
		String[] result = new String[values.length];
		int i = 0;
		for (String[] v : values) {
			result[i++] = v[index];
		}
		return result;
	}

	/**
	 * Finds index for given column. Returns -1 if not found.
	 * 
	 * @param title
	 *            the column title.
	 * @return index for given column. -1 if not found.
	 */
	private int findColumnIndex(String title) {
		int index = 0;
		for (String t : titles) {
			if (title.equals(t)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	@Override
	public boolean hasColumn(String title) {
		return findColumnIndex(title) != -1;
	}

	@Override
	public int getLineCount() {
		return values.length;
	}

	@Override
	public String toString() {
		Map<Integer, Integer> maxLengthPerColumn = findMaxLengthPercolum(values);
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < titles.length; ++i) {
			buffer.append(rpad(titles[i], maxLengthPerColumn.get(i))).append("|");
		}
		buffer.append("\n");
		for (int i = 0; i < values.length; ++i) {
			String[] line = values[i];
			for (int j = 0; j < line.length; ++j) {
				int maxLength = maxLengthPerColumn.get(j);
				buffer.append(rpad(line[j], maxLength)).append("|");
			}
			buffer.append("\n");
		}
		return buffer.toString();
	}

	private String rpad(String v, int maxLength) {
		if (v.length() < maxLength) {
			StringBuilder b = new StringBuilder(v);
			b.setLength(maxLength);
			v = b.toString();
		}
		return v;
	}

	/**
	 * Returns max length for each column index (starting at 0).
	 * 
	 * @param vals
	 *            the table to be analyzed.
	 * @return max length for each column index (starting at 0).
	 */
	private Map<Integer, Integer> findMaxLengthPercolum(String[][] vals) {
		HashMap<Integer, Integer> maxLengthPerCol = new HashMap<Integer, Integer>();
		for (int lineNumber = 0; lineNumber < values.length; lineNumber++) {
			for (int columnNumber = 0; columnNumber < vals[lineNumber].length; ++columnNumber) {
				String columnValue = vals[lineNumber][columnNumber];
				if (maxLengthPerCol.get(columnNumber) == null
						|| columnValue.length() >= maxLengthPerCol.get(columnNumber)) {
					maxLengthPerCol.put(columnNumber, columnValue.length() + 1);
				}
			}
		}
		return maxLengthPerCol;
	}
}
