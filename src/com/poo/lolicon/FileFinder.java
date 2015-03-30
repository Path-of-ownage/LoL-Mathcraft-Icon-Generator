package com.poo.lolicon;

import java.io.File;

public class FileFinder {
	private File folder;

	public FileFinder(String path) {
		this.folder = new File(path);
	}

	public File[] search(String query) {
		File[] matchingFiles = this.folder.listFiles((File dir, String name) -> {
			return name.startsWith(query);
		});
		return matchingFiles;
	}
}
