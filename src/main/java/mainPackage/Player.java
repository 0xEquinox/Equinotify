package mainPackage;


import userInterface.ThumbnailSettings;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Player {
	
	public Clip clip;
	public AudioInputStream audioStream;
	
	public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		if(Constants.title.contains("\\") || Constants.title.contains("|")) {
			Constants.title = Constants.title.replace("\\", " ");
			Constants.title = Constants.title.replace("|", " ");
		}
		
		Path songTitle = Paths.get(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
		Path thumbnailTitle = Paths.get(Constants.thumbnailDownloadPath + "\\" + Constants.title + ".png");
		Path songRenameMe = Paths.get(Constants.songDownloadPath + "\\NA.wav");
		Path thumbnailRenameMe = Paths.get(Constants.thumbnailDownloadPath + "\\NA.png");

		if(!songTitle.toFile().exists()) {
			Files.move(songRenameMe, songTitle);
			Files.move(thumbnailRenameMe, thumbnailTitle);
			try {
				Files.delete(songRenameMe);
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.jpg"));
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.webp"));
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.png"));
			} catch (IOException ignored) {}
		}
		
		File file = new File(Constants.songDownloadPath + "\\" + Constants.title + ".wav");

		ThumbnailSettings.setThumbnail();

		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
}
