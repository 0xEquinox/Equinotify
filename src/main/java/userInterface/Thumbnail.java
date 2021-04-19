package userInterface;


import mainPackage.Constants;

import javax.swing.*;


public class Thumbnail {

    public static JLabel thumbnailLabel = new JLabel(new ImageIcon(new ImageIcon("path.png").getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH)));

    public void displayThumbnail() {

        MainPanel.mainPanel.add(thumbnailLabel);
        thumbnailLabel.setBounds(0,0,Constants.windowWidth-110, Constants.windowHeight-150);
        thumbnailLabel.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("/images/Equinox.png")).getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH))));


    }



}
