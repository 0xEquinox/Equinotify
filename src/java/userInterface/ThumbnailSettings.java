package userInterface;

import mainPackage.Constants;

import javax.swing.*;

import java.awt.*;

import static userInterface.Thumbnail.thumbnailLabel;

public class ThumbnailSettings {
    public static void setThumbnail(){
        thumbnailLabel.setIcon(new ImageIcon(new ImageIcon(Constants.thumbnailDownloadPath + "//" + Constants.title + ".png").getImage().getScaledInstance(Constants.windowWidth-110, Constants.windowHeight-150, java.awt.Image.SCALE_SMOOTH)));
    }

    public static void setThumbnailNull(){
        thumbnailLabel.setIcon(null);
    }
}
