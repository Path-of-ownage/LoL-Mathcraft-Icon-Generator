package com.poo.lolicon.imageprocessors;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;

public class FileConverter extends FileTransformer implements IFileTransformer {

	public FileConverter(String destination) {
		super(destination);
	}

	@Override
	public void rename(File file, String newFileName) {
		String newFileNameWithoutExtention = FilenameUtils
				.removeExtension(newFileName);
		String newFileNameExtention = FilenameUtils
				.getExtension(file.getName());

		String newFileFullPath = this.destination + "\\"
				+ newFileNameWithoutExtention + "." + newFileNameExtention;

		Path newPath = Paths.get(newFileFullPath);
		// read a jpeg from a inputFile
		BufferedImage bufferedImage;
		try {
			bufferedImage = ImageIO.read(file);
			// write the bufferedImage back to outputFile
			ImageIO.write(bufferedImage, "png", new File(newPath.toString()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
