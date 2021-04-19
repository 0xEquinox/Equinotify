package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class LeftPanel {

	public static JPanel leftPanel = new JPanel();
	Playlists playlists = new Playlists();
	
	public void init() {
		leftPanel.setBackground(Color.white);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		leftPanel.setBounds(0, 0, 110, Constants.windowHeight);
		leftPanel.setLayout(null);
		addComponets();
		Window.f.add(leftPanel);
	}
	
	public void addComponets() {
		
		playlists.addButton();
		
	}
	
}
