package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTable;

import mainPackage.Constants;

public class Playlists implements ActionListener{

	JButton playlistButton;
	JTable listSong = new JTable();
	
	public void addButton() {
		
		playlistButton = new JButton();
		playlistButton.addActionListener(this);
		LeftPanel.leftPanel.add(playlistButton);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		String catagories = "Song Name";
		
		if(e.getSource() == playlistButton) {
			
			
			
			
		}
		
	}

}
