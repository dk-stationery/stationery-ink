package org.tommy.stationery.ink.core.util.analystics.loader;

import org.tommy.stationery.ink.core.util.analystics.model.VmstatDataImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Reasonably tolerant {@link VmstatDataLoader} implementation. Should accept
 * typical vmstat output (Linux/Aix tested).
 * 
 * <p>
 * <em>Note: don't hesitate to send vmstat output from your platform if it
 * doesn't work for you.</em>
 * </p>
 * 
 * <p>
 * Currently known issues:
 * </p>
 * <ul>
 * <li>Implementation consider there should be as many columns for titles as for
 * values. This rationale doesn't work when timestamp is displayed with
 * "hh mi ss" (with spaces in only one title). TODO
 * </ul>
 * 
 */
public class DefaultVmstatDataLoader implements VmstatDataLoader {

	List<String[]> vmstatLines;

	public DefaultVmstatDataLoader(String vmstatFilePath)
			throws VmstatDataFormatException {
		File vmstatFile = new File(vmstatFilePath);
		if (!vmstatFile.exists() || !vmstatFile.canRead()) {
			throw new IllegalArgumentException("File with path "
					+ vmstatFilePath + " doesn't exist or cannot be read.");
		}
		loadLines(vmstatFile);
	}

	private void loadLines(File vmstatFile) throws VmstatDataFormatException {
		try {
			List<String[]> lines = new ArrayList<String[]>();
			BufferedReader reader = new BufferedReader(new FileReader(
					vmstatFile));
			String line;
			while (null != (line = reader.readLine())) {
				addLine(lines, line);
			}
			if (lines.size() < 2) {
				throw new VmstatDataFormatException(
						"Not enough vmstat data to analyze, "
								+ "there should be at least one line for column titles, and one for values");
			}
			vmstatLines = lines;
		} catch (FileNotFoundException e) {
			throw new VmstatDataFormatException("File not found", e);
		} catch (IOException e) {
			throw new VmstatDataFormatException("IO exception", e);
		}
	}

	@Override
	public VmstatDataImpl getData() throws VmstatDataFormatException {
		String[][] values = new String[vmstatLines.size() - 1][];
		for (int i = 1; i < vmstatLines.size(); ++i) {
			String[] myLine = vmstatLines.get(i);
			values[i - 1] = myLine;
		}
		VmstatDataImpl vmstatData = new VmstatDataImpl();
		vmstatData.setTitles(vmstatLines.get(0));
		vmstatData.setValues(values);
		return vmstatData;
	}

	private void addLine(List<String[]> lines, String line) {
		if (canTryLine(line)) {
			lines.add(filterSpaces(line.split(" ")));
		}
	}

	private static final Pattern IGNORE_LINES_PATTERN = Pattern
			.compile("(^#.*$)|(.*-------.*)|(^.*System configuration.*$)|(^.*memory.*cpu.*$)");

	private boolean canTryLine(String line) {
		boolean keep = line.trim().length() != 0
				&& !IGNORE_LINES_PATTERN.matcher(line).matches();
		if (!keep) {
			System.out.println("IGNORED: " + line);
		}
		return keep;
	}

	/**
	 * Filters out spaces : returns the array without any empty/null/blank value
	 * 
	 * @param split
	 *            the array to check.
	 * @return an array filtered out with spaces.
	 */
	private String[] filterSpaces(String[] split) {
		List<String> list = new ArrayList<String>();
		for (String s : split) {
			if (s.trim().length() != 0)
				list.add(s);
		}
		return list.toArray(new String[list.size()]);
	}
}
