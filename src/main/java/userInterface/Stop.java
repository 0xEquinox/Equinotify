package userInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static userInterface.Thumbnail.currentThumbnail;
import static userInterface.Thumbnail.thumbnailLabel;


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
			SongName.songInfo.setText(null);
			currentThumbnail.setImage(new ImageIcon(Thumbnail.class.getResource("/images/Equinox.png")).getImage());
			thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(MainPanel.mainPanel.getWidth(), MainPanel.mainPanel.getHeight(), java.awt.Image.SCALE_SMOOTH))));
			SongLength.songLocation.setText("00:00");
			SongLength.songLength.setText("00:00");
		}
		
	}
	
	
}
