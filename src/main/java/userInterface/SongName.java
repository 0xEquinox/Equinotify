package userInterface;


import mainPackage.Constants;

import javax.swing.*;


public class SongName {

	public static JLabel songInfo = new JLabel(Constants.title);

	
	public void displayInfo() {
		
		BottomPanel.bottomPanel.add(songInfo);
		
	}
	
}
