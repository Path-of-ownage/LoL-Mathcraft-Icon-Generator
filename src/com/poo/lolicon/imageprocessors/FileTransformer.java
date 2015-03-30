package com.poo.lolicon.imageprocessors;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public abstract class FileTransformer {
	
	protected String destination;
	
	public FileTransformer(String destination) {
		this.destination = destination;
		this.clearDestination(destination.toString());
	}

	private void clearDestination(String fileDestination) {
		File file = new File(fileDestination);
		try {
			FileUtils.deleteDirectory(file);
			FileUtils.forceMkdir(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
