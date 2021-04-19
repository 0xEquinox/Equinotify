package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class LeftPanel {

	public static Integer leftPanelX = 0;
	public static Integer leftPanelY = TopPanel.topPanelHeight;
	public static Integer leftPanelWidth = 200;
	public static Integer leftPanelHeight = Constants.windowHeight-TopPanel.topPanelHeight-BottomPanel.bottomPanelHeight;
	public static JPanel leftPanel = new JPanel();
	Playlists playlists = new Playlists();

	public void init() {
		leftPanel.setBackground(Color.white);
		leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		leftPanel.setBounds(leftPanelX, leftPanelY, leftPanelWidth, leftPanelHeight);
		leftPanel.setLayout(null);
		addComponents();
		Window.f.add(leftPanel);
	}
	
	public void addComponents() {
		
		playlists.addButton();
		
	}
	
}
