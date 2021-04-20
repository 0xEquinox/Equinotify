package userInterface;


import mainPackage.Constants;

import javax.swing.*;

public class Thumbnail {

    public static ImageIcon currentThumbnail = new ImageIcon(Thumbnail.class.getResource("/images/Equinox.png"));
    public static JLabel thumbnailLabel = new JLabel(new ImageIcon(new ImageIcon("path.png").getImage().getScaledInstance(MainPanel.mainPanelWidth, MainPanel.mainPanelHeight, java.awt.Image.SCALE_SMOOTH)));

    public void displayThumbnail() {
        MainPanel.mainPanel.add(thumbnailLabel);
        thumbnailLabel.setSize(MainPanel.mainPanelWidth, MainPanel.mainPanelHeight);
        thumbnailLabel.setIcon((new ImageIcon(currentThumbnail.getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH))));


    }



}
