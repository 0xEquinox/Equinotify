package mainPackage;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Player {
	
	public Clip clip;
	public AudioInputStream audioStream;
	
	public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		if(Constants.title.contains("\\")) {
			Constants.title = Constants.title.replace("\\", " ");
		}
		
		Path songTitle = Paths.get(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
		Path thumbnailTitle = Paths.get(Constants.thumbnailDownloadPath + "\\" + Constants.title + ".webp");
		Path songRenameMe = Paths.get(Constants.songDownloadPath + "\\NA.wav");
		Path thumbnailRenameMe = Paths.get(Constants.thumbnailDownloadPath + "\\NA.webp");

		if(!songTitle.toFile().exists()) {
			Files.move(songRenameMe, songTitle);
			Files.move(thumbnailRenameMe, thumbnailTitle);
		}
		
		File file = new File(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
		
		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
}
