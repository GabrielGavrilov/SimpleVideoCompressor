package Gui.Panels;

import Compressor.ffmpeg;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setupPanel extends JPanel implements ActionListener {

    JTextField videoPathInput;
    JTextField outputPathInput;
    JButton confirmButton;

    ffmpeg compressor = new ffmpeg();

    public setupPanel() {

        this.setLayout(null);
        this.setBounds(0,0,350,100);
        this.setBackground(new Color(53, 53, 53));

        /*
            LABELS
        */

        JLabel videoPathLabel = new JLabel();
        videoPathLabel.setText("Video Path:");
        videoPathLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        videoPathLabel.setBounds(10, 10, 200, 20);
        videoPathLabel.setForeground(Color.white);

        JLabel outputPathLabel = new JLabel();
        outputPathLabel.setText("Output Path:");
        outputPathLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        outputPathLabel.setBounds(10, 35, 200, 20);
        outputPathLabel.setForeground(Color.white);

        /*
            TEXT FIELDS
        */

        videoPathInput = new JTextField();
        videoPathInput.setBounds(150,10, 185, 20);
        videoPathInput.setBackground(new Color(25, 24, 25));
        videoPathInput.setForeground(Color.white);
        videoPathInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        outputPathInput = new JTextField();
        outputPathInput.setBounds(150, 35, 185, 20);
        outputPathInput.setBackground(new Color(25, 24, 25));
        outputPathInput.setForeground(Color.white);
        outputPathInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        /*
            BUTTONS
        */

        confirmButton = new JButton("Confirm");
        confirmButton.setFocusable(false);
        confirmButton.setBounds(10, 70, 110, 25);
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(70, 69, 70));
        confirmButton.setForeground(Color.white);
        confirmButton.setBorder(new LineBorder(new Color(48, 48, 48),2));

        /*
            ADDING
        */

        this.add(videoPathLabel);
        this.add(videoPathInput);
        this.add(outputPathLabel);
        this.add(outputPathInput);
        this.add(confirmButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == confirmButton) {
            videoPathInput.setEnabled(false);
            outputPathInput.setEnabled(false);

            compressor.setVideoLocation(videoPathInput.getText());
            compressor.setCompressedOutputLocation(outputPathInput.getText());
        }

    }
}
