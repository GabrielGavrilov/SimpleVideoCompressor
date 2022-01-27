package Gui.Frames;

import Gui.Panels.audioOptionsPanel;
import Gui.Panels.initializeCompressorPanel;
import Gui.Panels.videoOptionsPanel;
import Gui.Panels.setupPanel;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {

    public mainFrame() {

        this.setTitle("Simple Video Compressor");
        this.setSize(350, 535);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(53,53,53));

        /*
            PANELS
        */

        setupPanel setup = new setupPanel();
        videoOptionsPanel videoOptions = new videoOptionsPanel();
        audioOptionsPanel audioOptions = new audioOptionsPanel();
        initializeCompressorPanel compressorPanel = new initializeCompressorPanel();

        /*
            ADDING
        */

        this.add(setup);
        this.add(videoOptions);
        this.add(audioOptions);
        this.add(compressorPanel);

        this.setVisible(true);
    }

}
