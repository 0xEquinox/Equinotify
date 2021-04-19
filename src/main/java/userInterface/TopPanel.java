package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class TopPanel {

	public static Integer topPanelX = 0;
	public static Integer topPanelY = 0;
	public static Integer topPanelWidth = Constants.windowWidth;
	public static Integer topPanelHeight = 50;
	public static JPanel topPanel = new JPanel();
	SearchBox searchBox = new SearchBox();

	public void init() {
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBounds(topPanelX, topPanelY, topPanelWidth, topPanelHeight);
		topPanel.setLayout(null);
		addComponents();
		Window.f.add(topPanel);
	}
	
	public void addComponents() {
		
		searchBox.addSearch();
		
	}
}
