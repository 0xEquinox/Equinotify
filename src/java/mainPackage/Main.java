package mainPackage;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import userInterface.UI;

public class Main {

	
	public static void main(String [] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		start();
	}
	
	public static void start() {
		MakeFile mf = new MakeFile();
		UI ui = new UI();
		
		mf.dirGen();
		ui.startGUI();
	}
	
}
