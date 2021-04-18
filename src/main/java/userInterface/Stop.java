package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Stop implements ActionListener{

	JButton stopButton;
	
	public void addButton() {
		stopButton = new JButton("Stop");
		stopButton.addActionListener(this);
		BottomPanel.bottomPanel.add(stopButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == stopButton) {
			SearchBox.player.clip.close();
			SongInfo.songInfo.setText(null);
			ThumbnailSettings.setThumbnailNull();
		}
		
	}
	
	
}
