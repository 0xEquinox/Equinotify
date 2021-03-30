package main;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	
public static void main(String [] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		
		MakeFile mf = new MakeFile();
		UI ui = new UI();
		Downloader d = new Downloader();
		Converter c = new Converter();
		Player player = new Player();
		
		mf.dirGen();
		ui.start();
		d.download();
		player.music();
		//mf.removeDir(new File("C:\\Users\\Drago\\Documents\\tmp"));
	}
	
}
