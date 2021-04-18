package userInterface;

import javax.swing.JFrame;

import mainPackage.Constants;

public class Window {

	public static JFrame f = new JFrame();
	Pause pause = new Pause();
	BottomPanel bottomPanel = new BottomPanel();
	TopPanel topPanel = new TopPanel();
	LeftPanel leftPanel = new LeftPanel();
	
	public void drawWindow() {
		f.setSize(Constants.windowWidth,Constants.windowHeight);
	    f.setTitle("Equinotify");
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setResizable(false);
	    f.setLayout(null);
	    drawPanels();
	    f.setVisible(true);
	}
	
	public void drawPanels() {
		
		bottomPanel.init();
		topPanel.init();
		leftPanel.init();
	}
	
}
