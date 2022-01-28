package Gui.Frames;

import Gui.Panels.errorPanel;

import javax.swing.*;

public class errorFrame extends JFrame {

    public errorFrame() {

        this.setSize(300, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Error");
        this.setVisible(true);

        /*
            PANELS
        */

        errorPanel error = new errorPanel();

        /*
            ADDING
        */

        this.add(error);

    }

}
