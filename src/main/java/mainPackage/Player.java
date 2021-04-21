package mainPackage;


import userInterface.MainPanel;
import userInterface.Pause;
import userInterface.SongLength;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import static userInterface.Thumbnail.*;


public class Player implements LineListener{
	
	public Clip clip;
	public AudioInputStream audioStream;
	boolean playCompleted;

	javax.swing.Timer t = new javax.swing.Timer(100, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String min =String.valueOf(TimeUnit.MICROSECONDS.toMinutes(clip.getMicrosecondPosition()));
			if(min.length() == 1){
				min="0" + min;
			}
			String sec =String.valueOf((TimeUnit.MICROSECONDS.toSeconds(clip.getMicrosecondPosition())%60));
			if(sec.length() == 1){
				sec="0" + sec;
			}
			SongLength.songLocation.setText(min + ":" + sec);
		}
	});

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
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.jpg"));
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.webp"));
			}catch (IOException ignored) {} try {
				Files.delete(Paths.get(Constants.thumbnailDownloadPath + "\\NA.png"));
			}catch (IOException ignored) {}
		}
		
		File file = new File(Constants.songDownloadPath + "\\" + Constants.title + ".wav");

		currentThumbnail.setImage(new ImageIcon(Constants.thumbnailDownloadPath + "//" + Constants.title + ".png").getImage());
		thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(MainPanel.mainPanel.getWidth()-1, MainPanel.mainPanel.getHeight()-1, java.awt.Image.SCALE_SMOOTH))));

		audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		String min =String.valueOf(TimeUnit.MICROSECONDS.toMinutes(clip.getMicrosecondLength()));
		if(min.length() == 1){
			min="0" + min;
		}
		String sec =String.valueOf((TimeUnit.MICROSECONDS.toSeconds(clip.getMicrosecondLength())%60));
		if(sec.length() == 1){
			sec="0" + sec;
		}
		t.start();
		SongLength.songLength.setText(min + ":" + sec);
		Pause.pause.setText("Pause");
		Pause.isPaused = false;
	}
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		if (type == LineEvent.Type.STOP) {
			t.stop();
		}
	}
}
