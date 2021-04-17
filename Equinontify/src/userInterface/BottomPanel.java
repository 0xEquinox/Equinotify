package userInterface;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import mainPackage.Constants;

public class BottomPanel {

	public static JPanel bottomPanel = new JPanel();
	Pause pauseButton = new Pause();
	public SongInfo songInfo = new SongInfo();
	AddSong addSong = new AddSong();
	Stop stopButton = new Stop();
	VolumeSlider volSlider = new VolumeSlider();
	
	public void init() {
		bottomPanel.setBackground(Color.white);
		bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		bottomPanel.setBounds(0, Constants.windowHeight - 100, Constants.windowWidth, 100);
		bottomPanel.setLayout(new FlowLayout());
		addComponets();
		Window.f.add(bottomPanel);
	}
	
	public void addComponets() {
		
		stopButton.addButton();
		pauseButton.addButton();
		songInfo.displayInfo();
		addSong.addSongButton();
		volSlider.drawSlider();
	}
	
}
