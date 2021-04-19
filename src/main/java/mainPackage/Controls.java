package mainPackage;

import userInterface.SongInfo;
import userInterface.ThumbnailSettings;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Scanner;

public class Controls {

	Scanner input = new Scanner(System.in);
	Downloader d = new Downloader();
	public static Player player = new Player();
	Main main = new Main();
	WebScrapper scraper = new WebScrapper();
	SongInfo si = new SongInfo();
	
	int framePos;

	boolean running = true;
	String controller = "";
	
	public void controls() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		while (running = true) {
			controller = input.nextLine();
			listener();
		}
	}
	public void listener() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(controller.length() >= 4) {
			if(controller.substring(0,4).toLowerCase().equals("play")) {
				play();
			}else if(controller.substring(0,4).toLowerCase().equals("stop")) {
				stop();
			}else if(controller.substring(0,4).toLowerCase().equals("next")) {
				next();
			}else if(controller.substring(0,5).toLowerCase().equals("pause")) {
				pause();
			}else if(controller.substring(0,7).toLowerCase().equals("unpause")) {
				unPause();
			}else {
				System.out.println("This command is not recognized");
			}
		}
	}
	public void stop(){
		System.exit(0);
	}
	public void play() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		isUrl();
		Constants.scraperURL = "https://www.youtube.com/results?search_query=";
		d.download_song();
		Constants.url = "https://www.youtube.com/watch?v=";
		SongInfo.songInfo.setText(Constants.title);
		ThumbnailSettings.setThumbnail();
		Constants.title = "";
		player.music();
	}
	public void next() {
		
	}

	public void isUrl() throws IOException {
		if(controller.substring(5).contains("https")) {
			Constants.url = controller.substring(5);
		}else {
			Constants.scraperURL = Constants.scraperURL + controller.substring(5);
			scraper.findID();
			scraper.findSongName();
		}
	}
	public void pause() {
		framePos = player.clip.getFramePosition();
		player.clip.stop();
	}
	
	public void unPause() {
		player.clip.setFramePosition(framePos);
		player.clip.start();
	}
	
	
}
