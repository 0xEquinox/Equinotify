package userInterface;

import mainPackage.Constants;

import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import static userInterface.BottomPanel.*;
import static userInterface.Thumbnail.currentThumbnail;
import static userInterface.Thumbnail.thumbnailLabel;
import static userInterface.TopPanel.*;
import static userInterface.LeftPanel.*;
import static userInterface.MainPanel.*;

public class Window {

	public static JFrame f = new JFrame();
	Pause pause = new Pause();
	BottomPanel bottomPanel = new BottomPanel();
	TopPanel topPanel = new TopPanel();
	LeftPanel leftPanel = new LeftPanel();
	MainPanel mainPanel = new MainPanel();
	
	public void drawWindow() {
		f.setSize(Constants.windowWidth,Constants.windowHeight);
	    f.setTitle("Equinotify");
	    f.setIconImage(new ImageIcon(getClass().getResource("/images/Equinox.png")).getImage());
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setResizable(true);
	    f.setLayout(null);
	    //f.pack();
	    drawPanels();
		System.err.println(Window.f.getWidth()-LeftPanel.leftPanelWidth);
		System.err.println(Window.f.getWidth());
		System.err.println(mainPanelWidth);
		f.setVisible(true);

		f.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent componentEvent) {
				f.setSize(f.getWidth(),f.getHeight());
				Constants.windowWidth=f.getWidth();
				Constants.windowHeight=f.getHeight();
				redrawPanels();
			}
		});
	}
	
	public void drawPanels() {
		bottomPanel.init();
		topPanel.init();
		leftPanel.init();
		mainPanel.init();
	}

	public void redrawPanels() {
		BottomPanel.bottomPanel.setBounds(0, f.getHeight()-100, f.getWidth(), 61);
		TopPanel.topPanel.setBounds(0, 0, f.getWidth(), 50);
		LeftPanel.leftPanel.setBounds(0, 50, 200, f.getHeight()-150);
		MainPanel.mainPanel.setBounds(200, 50, f.getWidth()-200, f.getHeight()-150);
		thumbnailLabel.setSize(f.getWidth()-200, f.getHeight()-150);
		thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight(), java.awt.Image.SCALE_SMOOTH))));;
	}
}
