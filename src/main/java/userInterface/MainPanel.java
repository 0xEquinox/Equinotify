package userInterface;

import mainPackage.Constants;

import javax.swing.*;
import java.awt.*;

public class MainPanel {

    public static Integer mainPanelX = LeftPanel.leftPanelWidth;
    public static Integer mainPanelY = TopPanel.topPanelHeight;
    public static Integer mainPanelWidth = Constants.windowWidth-200;
    public static Integer mainPanelHeight = (Constants.windowHeight -TopPanel.topPanelHeight)-BottomPanel.bottomPanelHeight;
    public static JPanel mainPanel = new JPanel();
    public static Thumbnail thumbnail = new Thumbnail();


    public void init() {
        mainPanel.setBackground(Color.white);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        mainPanel.setBounds(mainPanelX, mainPanelY, mainPanelWidth, mainPanelHeight);
        mainPanel.setLayout(null);
        //addComponents();
        Window.f.add(mainPanel);
    }

    public void addComponents() {
        thumbnail.displayThumbnail();
    }
}

