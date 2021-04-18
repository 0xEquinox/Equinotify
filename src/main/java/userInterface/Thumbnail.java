package userInterface;


import javax.swing.*;

import mainPackage.Constants;

public class Thumbnail {


    //public static BufferedImage myThumbnail;

    //{
    //    try {
    //        myThumbnail = ImageIO.read(new File(Constants.thumbnailDownloadPath + "//" + "Stromae - Papaoutai" + ".png"));
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}

    public static JLabel thumbnailLabel = new JLabel(new ImageIcon(new ImageIcon(Constants.thumbnailDownloadPath + "//" + "Stromae - Papaoutai.png").getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH)));


    public void displayThumbnail() {

        MainPanel.mainPanel.add(thumbnailLabel);
        thumbnailLabel.setBounds(0,0,Constants.windowWidth-110, Constants.windowHeight-150);


    }



}
