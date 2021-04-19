package mainPackage;

import userInterface.UI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

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
