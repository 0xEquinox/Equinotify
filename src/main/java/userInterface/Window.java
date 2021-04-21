package userInterface;

import mainPackage.Constants;
import javax.swing.*;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import static userInterface.Thumbnail.currentThumbnail;
import static userInterface.Thumbnail.thumbnailLabel;

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
	    drawPanels();
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
		TopPanel.topPanel.setBounds(0, 0, f.getWidth(), 35);
		LeftPanel.leftPanel.setBounds(0, 34, 200, f.getHeight()-133);
		MainPanel.mainPanel.setBounds(199, 33, f.getWidth()-200, f.getHeight()-132);
		SearchBox.searchBox.setSize(f.getWidth()-105, 25);
		SearchBox.enterSearch.setBounds(f.getWidth()-100, 5, 80,25);
		thumbnailLabel.setSize(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight());
		thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(MainPanel.mainPanel.getWidth()-1, MainPanel.mainPanel.getHeight()-1, java.awt.Image.SCALE_SMOOTH))));
	}
}
