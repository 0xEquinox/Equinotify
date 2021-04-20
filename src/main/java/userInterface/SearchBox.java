package userInterface;

import mainPackage.Constants;
import mainPackage.Downloader;
import mainPackage.Player;
import mainPackage.WebScrapper;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static userInterface.Thumbnail.currentThumbnail;
import static userInterface.Thumbnail.thumbnailLabel;

public class SearchBox implements ActionListener{

	public static JButton enterSearch;
	public static JTextField searchBox;
	WebScrapper scraper = new WebScrapper();
	Downloader d = new Downloader();
	public static Player player = new Player();
	Pause pause = new Pause();
	boolean firstSong = true;

	public void addSearch() {
		searchBox = new JTextField();
		enterSearch = new JButton("Submit");
		enterSearch.setBounds(Constants.windowWidth-100, 5, 80,25);
		enterSearch.addActionListener(this);
		searchBox.setBounds(5, 5, TopPanel.topPanelWidth-enterSearch.getWidth()-25, 25);
		searchBox.addActionListener(this);
		TopPanel.topPanel.add(searchBox);
		TopPanel.topPanel.add(enterSearch);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Constants.title = "";
		
		
		if(e.getSource().equals(enterSearch) || e.getSource().equals(searchBox)){
			
			if(!firstSong) {
				player.clip.close();
			}firstSong = false;
			
			try{
				isUrl();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			String checkTitle = Constants.title;

			if(checkTitle.contains("\\") || checkTitle.contains("|")) {
				checkTitle = checkTitle.replace("\\", " ");
				checkTitle = checkTitle.replace("|", " ");
			}

			File song = new File(Constants.songDownloadPath + "\\" + checkTitle + ".wav");


			if(song.exists()) {
				SongInfo.songInfo.setText(Constants.title);
				currentThumbnail.setImage(new ImageIcon(Constants.thumbnailDownloadPath + "//" + Constants.title + ".png").getImage());
				thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight(), java.awt.Image.SCALE_SMOOTH))));
				Constants.scraperURL = "https://www.youtube.com/results?search_query=";
				Constants.url = "https://www.youtube.com/watch?v=";

				try {
					player.music();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
			}else{	
				Constants.scraperURL = "https://www.youtube.com/results?search_query=";
				d.download_song();
				try {
					d.download_thumbnail();
				} catch (IOException ioException) {
					ioException.printStackTrace();
				}
				Constants.url = "https://www.youtube.com/watch?v=";
				SongInfo.songInfo.setText(Constants.title);
				
				try {
					player.music();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
					e1.printStackTrace();
				}
				pause.isPaused = false;
			}
		}
	}
	
	public void isUrl() throws IOException {
		if(searchBox.getText().contains("https")) {
			Constants.url = searchBox.getText();
		} else {
			Constants.scraperURL = Constants.scraperURL + searchBox.getText();
			scraper.findID();
			scraper.findSongName();
		}
	}
	
}
