package com.poo.lolicon.imageprocessors;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.io.FilenameUtils;

public class FileRenamer extends FileTransformer implements IFileTransformer {

	public FileRenamer(String destination) {
		super(destination);
	}

	@Override
	public void rename(File file, String newFileName) {
		String newFileNameWithoutExtention = FilenameUtils.removeExtension(newFileName);
		String newFileNameExtention = FilenameUtils.getExtension(file.getName());
		
		String newFileFullPath = this.destination + "\\" + newFileNameWithoutExtention + "." + newFileNameExtention;

		
		Path newPath = Paths.get(newFileFullPath);
		//System.out.println("Renaming: " + file.toPath());
		try {
			Files.copy(file.toPath(), newPath,  StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
