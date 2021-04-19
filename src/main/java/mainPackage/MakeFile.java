package mainPackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MakeFile {

	
	public void dirGen() {
		  try {

			    Path songsPath = Paths.get(System.getenv("APPDATA")+"\\Equinotify\\songs");
			    Path thumbnailPath = Paths.get(System.getenv("APPDATA")+"\\Equinotify\\thumbnails");

			    //java.nio.file.Files;
			    Files.createDirectories(songsPath);
			    Files.createDirectories(thumbnailPath);

			    System.out.println("Directory is created!");

			  } catch (IOException e) {

			    System.err.println("Failed to create directory!" + e.getMessage());

			  }
	}
	
	public void removeDir() {
		File song = new File(System.getenv("APPDATA")+"\\Equinotify\\songs\\NA.wav");
	    if (song.delete()) { 
	      System.out.println("Deleted the file: " + song.getName());
	    } else {
	      System.out.println("Failed to delete the folder.");
	    }
	    
	    File tempDir = new File(System.getenv("APPDATA")+"\\Equinoify\\tmp");
	    if (tempDir.delete()) { 
		      System.out.println("Deleted the folder: " + tempDir.getName());
		    } else {
		      System.out.println("Failed to delete the folder.");
		    }
	}
	
}
