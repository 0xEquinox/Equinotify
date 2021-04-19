package mainPackage;

import userInterface.SearchBox;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class VolumeControl {

	public static double previousVol;
	public static FloatControl gainControl;
	
	public void setVolume() {
		gainControl = (FloatControl) SearchBox.player.clip.getControl(FloatControl.Type.MASTER_GAIN);
	}
	
	public void changeVolume(double vol, Clip clip) {
		previousVol = vol;
		gainControl.setValue((float)vol);
	}


	
}
