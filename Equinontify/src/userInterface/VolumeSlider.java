package userInterface;


import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mainPackage.VolumeControl;

public class VolumeSlider implements ChangeListener{

	JSlider volSlider;
	
	public void drawSlider() {
		volSlider = new JSlider(-60, 60);
		volSlider.addChangeListener(this);
		BottomPanel.bottomPanel.add(volSlider);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(!SearchBox.player.clip.equals(null)) {
			VolumeControl volController = new VolumeControl();	
			if(e.getSource() == volSlider) {
				volController.setVolume();
				if(VolumeControl.previousVol < volSlider.getValue()) {
					volController.changeVolume((double)volSlider.getValue()/10, SearchBox.player.clip);
				}else if(VolumeControl.previousVol > volSlider.getValue()) {
					volController.changeVolume((double)volSlider.getValue()/10, SearchBox.player.clip);
				}
			}
		}		
	}
}
