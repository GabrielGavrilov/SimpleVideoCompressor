package Gui.Panels;

import Compressor.ffmpeg;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class initializeCompressorPanel extends JPanel implements ActionListener {

    JButton compressButton;

    ffmpeg compressor = new ffmpeg();

    public initializeCompressorPanel() {

        this.setBounds(0,407,380,128);
        this.setLayout(null);
        this.setBackground(new Color(53, 53, 53));

        /*
            BUTTONS
        */

        compressButton = new JButton("Compress Video");
        compressButton.setFocusable(false);
        compressButton.setBounds(10,65,160,25);
        compressButton.addActionListener(this);
        compressButton.setBackground(new Color(70, 69, 70));
        compressButton.setForeground(Color.white);
        compressButton.setBorder(new LineBorder(new Color(48, 48, 48),2));

        /*
            ADDING
        */

        this.add(compressButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressButton) {

            try {
                compressor.compressVideo();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
}
