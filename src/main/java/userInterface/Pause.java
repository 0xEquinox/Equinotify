package userInterface;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Pause implements ActionListener{
	
	public static JButton pause;
	int framePos;
	
	public static boolean isPaused = false;
	
	public void addButton() {
		
		pause = new JButton("Pause");
		pause.addActionListener(this);
		BottomPanel.bottomPanel.add(pause);
	}

	@Override
	public void actionPerformed(ActionEvent p) {

		if(p.getSource() == pause && !isPaused && SearchBox.player.clip != null) {
			SearchBox.player.clip.stop();
			framePos = SearchBox.player.clip.getFramePosition();
			pause.setText("Play");
			isPaused = true;
		}else if(p.getSource() == pause && isPaused && SearchBox.player.clip != null) {
			SearchBox.player.clip.setFramePosition(framePos);
			SearchBox.player.clip.start();
			pause.setText("Pause");
			isPaused = false;
		}
		
	}
	
}
