package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class BottomPanel {

	public static Integer bottomPanelX = 0;
	public static Integer bottomPanelY = Constants.windowHeight - 100;
	public static Integer bottomPanelWidth = Constants.windowWidth;
	public static Integer bottomPanelHeight = 500;
	public static JPanel bottomPanel = new JPanel();
	Pause pauseButton = new Pause();
	public SongName songName = new SongName();
	AddSong addSong = new AddSong();
	Stop stopButton = new Stop();
	VolumeSlider volSlider = new VolumeSlider();
	SongLength songLength = new SongLength();

	public void init() {
		bottomPanel.setBackground(Color.white);
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.setBounds(bottomPanelX, bottomPanelY, bottomPanelWidth, bottomPanelHeight);
		bottomPanel.setLayout(new FlowLayout());
		addComponents();
		Window.f.add(bottomPanel);
	}
	
	public void addComponents() {
		
		stopButton.addButton();
		pauseButton.addButton();
		songName.displayInfo();
		addSong.addSongButton();
		volSlider.drawSlider();
		songLength.displayLength();
	}
	
}
