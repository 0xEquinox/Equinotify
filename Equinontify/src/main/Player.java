package main;


import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.Scanner;


public class Player {

	 
	public void music() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		Scanner input = new Scanner(System.in);
		File file = new File(Constants.downloadPath + "\\NA.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		
		String playing = input.nextLine();
		
		
	}
	
}
