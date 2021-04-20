package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Playlists implements ActionListener{

	JButton playlistButton;
	JTable listSong = new JTable();
	
	public void addButton() {
		
		playlistButton = new JButton();
		playlistButton.addActionListener(this);
		LeftPanel.leftPanel.add(playlistButton);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		String categories = "Song Name";
		
		if(e.getSource() == playlistButton) {
			
			
			
			
		}
		
	}

}
