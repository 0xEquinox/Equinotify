package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.JButton;

import mainPackage.Constants;


public class AddSong implements ActionListener{

	JButton addSong;
	int framPos;
	
	public void addSongButton() {
			
			addSong = new JButton("add");
			addSong.addActionListener(this);
			BottomPanel.bottomPanel.add(addSong);
			
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Path songFile = Paths.get(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
		Path playlist = Paths.get(Constants.songDownloadPath + "\\..\\playlists");
		
		if(!Files.exists(playlist)) {
			try {
				Files.createDirectory(playlist);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		File songFileCopy = new File(Constants.songDownloadPath + "\\..\\playlists\\" + Constants.title + ".wav");
		
		if(e.getSource() == addSong) {
			
			
			try {
				Files.copy(songFile, songFileCopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			
			Constants.playlistSongTitles.add(Constants.title);
			Constants.playlistSongPaths.add(Constants.songDownloadPath + "\\" + Constants.title + ".wav");
			
		}	
	}
}
