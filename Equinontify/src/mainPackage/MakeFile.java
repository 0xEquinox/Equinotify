package mainPackage;

import java.nio.file.Path;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class MakeFile {

	
	public void dirGen() {
		  try {

			    Path path = Paths.get("C:\\Users\\Drago\\Documents\\tmp");

			    //java.nio.file.Files;
			    Files.createDirectories(path);

			    System.out.println("Directory is created!");

			  } catch (IOException e) {

			    System.err.println("Failed to create directory!" + e.getMessage());

			  }
	}
	
	public void removeDir() {
		File song = new File("C:\\Users\\Drago\\Documents\\tmp\\NA.wav"); 
	    if (song.delete()) { 
	      System.out.println("Deleted the file: " + song.getName());
	    } else {
	      System.out.println("Failed to delete the folder.");
	    }
	    
	    File tempDir = new File("C:\\Users\\Drago\\Documents\\tmp");
	    if (tempDir.delete()) { 
		      System.out.println("Deleted the folder: " + tempDir.getName());
		    } else {
		      System.out.println("Failed to delete the folder.");
		    }
	}
	
}
