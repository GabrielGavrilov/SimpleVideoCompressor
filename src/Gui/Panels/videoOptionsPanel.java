package Gui.Panels;

import Compressor.ffmpeg;
import Gui.Frames.errorFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class videoOptionsPanel extends JPanel implements ActionListener {

    JTextField widthInput;
    JTextField heightInput;
    JTextField frameRateInput;
    JComboBox formatInput;
    JButton confirmButton;

    ffmpeg compressor = new ffmpeg();

    public videoOptionsPanel() {

        this.setLayout(null);
        this.setBounds(2,100,340,207);
        this.setBackground(new Color(53, 53, 53));

        /*
            BORDER
        */

        TitledBorder optionsBorder = BorderFactory.createTitledBorder("Video Options");
        optionsBorder.setTitleJustification(TitledBorder.LEFT);
        optionsBorder.setTitleColor(new Color(143, 144, 144));
        optionsBorder.setBorder(new LineBorder(new Color(143, 144, 144), 1));

        /*
            LABELS
        */

        JLabel widthLabel = new JLabel();
        widthLabel.setText("Width:");
        widthLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        widthLabel.setBounds(15,35,200,20);
        widthLabel.setForeground(Color.white);

        JLabel heightLabel = new JLabel();
        heightLabel.setText("Height:");
        heightLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        heightLabel.setBounds(15, 60, 200, 20);
        heightLabel.setForeground(Color.white);

        JLabel frameRateLabel = new JLabel();
        frameRateLabel.setText("Frame Rate:");
        frameRateLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        frameRateLabel.setBounds(15, 85, 200, 20);
        frameRateLabel.setForeground(Color.white);

        JLabel formatLabel = new JLabel();
        formatLabel.setText("Video Format:");
        formatLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        formatLabel.setBounds(15, 110, 200, 20);
        formatLabel.setForeground(Color.white);

        /*
            TEXT FIELDS
        */

        widthInput = new JTextField();
        widthInput.setBounds(150, 35, 185, 20);
        widthInput.setText("1280");
        widthInput.setBackground(new Color(25, 24, 25));
        widthInput.setForeground(Color.white);
        widthInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        heightInput = new JTextField();
        heightInput.setBounds(150, 60, 185, 20);
        heightInput.setText("720");
        heightInput.setBackground(new Color(25, 24, 25));
        heightInput.setForeground(Color.white);
        heightInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        frameRateInput = new JTextField();
        frameRateInput.setBounds(150, 85, 185, 20);
        frameRateInput.setText("60");
        frameRateInput.setBackground(new Color(25, 24, 25));
        frameRateInput.setForeground(Color.white);
        frameRateInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        /*
            COMBO BOXES
        */

        String[] formatOptions = {"mp4", "mov", "avi"};
        formatInput = new JComboBox(formatOptions);
        formatInput.setBounds(150,110, 185,20);
        formatInput.setBackground(new Color(25, 25, 25));
        formatInput.setForeground(Color.white);

        /*
            BUTTONS
        */

        confirmButton = new JButton();
        confirmButton.setText("Confirm");
        confirmButton.setFocusable(false);
        confirmButton.setBounds(15, 165, 110,25);
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(70, 69, 70));
        confirmButton.setForeground(Color.white);
        confirmButton.setBorder(new LineBorder(new Color(48, 48, 48),2));

        /*
            ADDING
        */

        this.setBorder(optionsBorder);
        this.add(widthLabel);
        this.add(widthInput);
        this.add(heightLabel);
        this.add(heightInput);
        this.add(frameRateLabel);
        this.add(frameRateInput);
        this.add(formatLabel);
        this.add(formatInput);
        this.add(confirmButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton) {

            widthInput.setEnabled(false);
            heightInput.setEnabled(false);
            frameRateInput.setEnabled(false);
            formatInput.setEnabled(false);

            try {

                int width = Integer.parseInt(widthInput.getText());
                int height = Integer.parseInt(heightInput.getText());
                int frameRate = Integer.parseInt(frameRateInput.getText());

                compressor.setVideoWidth(width);
                compressor.setVideoHeight(height);
                compressor.setVideoFrameRate(frameRate);
                compressor.setVideoFormat(formatInput.getSelectedItem().toString());

            } catch(Exception err) {

                errorFrame errorWindow = new errorFrame();

                widthInput.setEnabled(true);
                heightInput.setEnabled(true);
                frameRateInput.setEnabled(true);
                formatInput.setEnabled(true);

            }

        }
    }
}
