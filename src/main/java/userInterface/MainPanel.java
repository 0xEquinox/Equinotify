package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class MainPanel {

    public static JPanel mainPanel = new JPanel();
    public static Thumbnail thumbnail = new Thumbnail();

    public void init() {
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setBounds(110, 50, Constants.windowWidth-110, Constants.windowHeight-150);
        mainPanel.setLayout(null);
        addComponets();
        Window.f.add(mainPanel);
    }

    public void addComponets() {
        thumbnail.displayThumbnail();
    }

}

