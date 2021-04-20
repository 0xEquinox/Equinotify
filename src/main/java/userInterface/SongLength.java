package userInterface;

import mainPackage.Constants;

import javax.swing.*;

public class SongLength {

    public static JLabel songLength = new JLabel("00:00");
    public static JLabel songLocation = new JLabel("00:00");
    public static final JLabel colon = new JLabel(":");


    public void displayLength() {
        BottomPanel.bottomPanel.add(songLocation);
        BottomPanel.bottomPanel.add(colon);
        BottomPanel.bottomPanel.add(songLength);
    }
}
