package userInterface;


import javax.swing.JLabel;

import mainPackage.Constants;


public class SongInfo {

	public static JLabel songInfo = new JLabel(Constants.title);

	
	public void displayInfo() {
		
		BottomPanel.bottomPanel.add(songInfo);
		
	}
	
}
