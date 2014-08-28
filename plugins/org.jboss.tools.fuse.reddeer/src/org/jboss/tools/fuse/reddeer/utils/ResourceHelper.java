package org.jboss.tools.fuse.reddeer.utils;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

/**
 * Class provides resource related static method
 */
public class ResourceHelper {

	/**
	 * Provide bundle resource absolute path
	 * 
	 * @param pluginId
	 *            - plugin id
	 * @param path
	 *            - resource relative path
	 * @return resource absolute path
	 */
	public static String getResourceAbsolutePath(String pluginId, String... path) {

		// Construct path
		StringBuilder builder = new StringBuilder();
		for (String fragment : path) {
			builder.append("/" + fragment);
		}

		String filePath = "";
		try {
			filePath = FileLocator.toFileURL(Platform.getBundle(pluginId).getEntry("/")).getFile() + "resources"
					+ builder.toString();
			File file = new File(filePath);
			if (!file.isFile()) {
				filePath = FileLocator.toFileURL(Platform.getBundle(pluginId).getEntry("/")).getFile()
						+ builder.toString();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return filePath;
	}
}
