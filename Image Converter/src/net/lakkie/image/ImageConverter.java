package net.lakkie.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class ImageConverter {

	public static String createMapData(File file, String whiteString, String otherString) {
		try {
			// Use BufferedImage to get the raster
			BufferedImage image = ImageIO.read(file);
			// Load raster, ARGB
			int[] rgb = image.getRGB(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth() * image.getHeight()], 0, image.getWidth());
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < rgb.length; i++) {
				if (rgb[i] == 0xffffffff) {
					result.append(whiteString);
				} else {
					result.append(otherString);
				}
			}
			return result.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Image Path ? ");
		String path = scanner.nextLine();
		File file = new File(path);
		if (!file.exists()) {
			// err should get pushed out in time
			System.err.println("Invalid file!");
			System.exit(1);
		}
		
		System.out.print("String for White ? ");
		String white = scanner.nextLine();
		
		System.out.print("String for Other ? ");
		String other = scanner.nextLine();
		
		String data = createMapData(file, white, other);
		try {
			FileOutputStream out = new FileOutputStream("Output.txt");
			out.write(data.getBytes());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Success! Wrote output to \"Output.txt\"");
		
		scanner.close();
	}
	
}
