package tests;

import java.io.File;
import java.io.IOException;


public class PathsTests  {
	
	public static void main (String [] args) throws IOException {
		
		
		String path = new File("C:\\Users\\priet\\eclipse-workspace\\Ordinario_Progra2\\src\\tests\\P&L.png").getPath();
		
		String path2 = new File("C:\\Users\\priet\\eclipse-workspace\\Ordinario_Progra2\\src\\P&L.png").getAbsolutePath();
		
		File filePath = new File("src/P&L.png");
		
		System.out.println("Absolute Path \n" + filePath.getAbsolutePath() + "\n");
		System.out.println("Canonical Path \n" + filePath.getCanonicalPath() + "\n");
		System.out.println("Free Space \n" + filePath.getFreeSpace() + "\n");
		System.out.println("Name \n" + filePath.getName() + "\n");
		System.out.println("Parent \n" + filePath.getParent() + "\n");
		System.out.println("Path \n" + filePath.getPath() + "\n");
		System.out.println("Total Space \n" + filePath.getTotalSpace() + "\n");
		System.out.println("Usable Space \n" + filePath.getUsableSpace() + "\n");
		System.out.println("Absolute File \n" + filePath.getAbsoluteFile() + "\n");
		System.out.println("Canonical File \n" + filePath.getCanonicalFile() + "\n");
		System.out.println("Class \n" + filePath.getClass() + "\n");
		System.out.println("Parent File \n" + filePath.getParentFile() + "\n");

		
		
		
	}


}
