package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class TopPanel {

	public static JPanel topPanel = new JPanel();
	SearchBox searchBox = new SearchBox();
	
	public void init() {
		topPanel.setBackground(Color.white);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		topPanel.setBounds(0, 0, Constants.windowWidth, 50);
		topPanel.setLayout(null);
		addComponets();
		Window.f.add(topPanel);
	}
	
	public void addComponets() {
		
		searchBox.addSearch();
		
	}
}
