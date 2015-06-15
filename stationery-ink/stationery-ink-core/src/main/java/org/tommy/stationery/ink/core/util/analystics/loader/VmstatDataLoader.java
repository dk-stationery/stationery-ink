package org.tommy.stationery.ink.core.util.analystics.loader;


import org.tommy.stationery.ink.core.util.analystics.model.VmstatData;

/**
 * Implementors must support having lines beginning with # ignored.
 */
public interface VmstatDataLoader {
	/**
	 * Returns {@link VmstatData} instance retrieved from whatever the source is.
	 * @return
	 * @throws VmstatDataFormatException
	 */
	VmstatData getData() throws VmstatDataFormatException;
}
