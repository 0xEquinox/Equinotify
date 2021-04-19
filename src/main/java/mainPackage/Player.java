package mainPackage;


import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static userInterface.Thumbnail.thumbnailLabel;


public class Player {
	
	public Clip clip;
	public AudioInputStream audioStream;
	
	public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException{

		Path songTitle = Paths.get(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
		Path thumbnailTitle = Paths.get(Constants.thumbnailDownloadPath + "\\" + Constants.title + ".png");
		Path songRenameMe = Paths.get(Constants.songDownloadPath + "\\NA.wav");
		Path thumbnailRenameMe = Paths.get(Constants.thumbnailDownloadPath + "\\NA.png");

		if(!songTitle.toFile().exists()) {
			Files.move(songRenameMe, songTitle);
			Files.move(thumbnailRenameMe, thumbnailTitle);
			try {
				Files.delete(songRenameMe);
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.jpg"));
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.webp"));
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.png"));
			}catch (IOException ignored) {}
		}
		
		File file = new File(Constants.songDownloadPath + "\\" + Constants.title + ".wav");

		thumbnailLabel.setIcon((new ImageIcon(new ImageIcon(Constants.thumbnailDownloadPath + "//" + Constants.title + ".png").getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH))));

		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
	}
}
