package Gui.Panels;

import Compressor.ffmpeg;
import Gui.Frames.errorFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class audioOptionsPanel extends JPanel implements ActionListener {

    JTextField sampleRateInput;
    JTextField bitRateInput;
    JButton confirmButton;

    ffmpeg compressor = new ffmpeg();

    public audioOptionsPanel() {

        this.setBounds(2,307,340,155);
        this.setLayout(null);
        this.setBackground(new Color(53, 53, 53));

        /*
            BORDER
        */

        TitledBorder optionsBorder = BorderFactory.createTitledBorder("Audio Options");
        optionsBorder.setTitleJustification(TitledBorder.LEFT);
        optionsBorder.setTitleColor(new Color(143, 144, 144));
        optionsBorder.setBorder(new LineBorder(new Color(143, 144, 144), 1));

        /*
            LABELS
        */

        JLabel sampleRateLabel = new JLabel();
        sampleRateLabel.setText("Sample Rate:");
        sampleRateLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        sampleRateLabel.setBounds(15, 35, 200, 20);
        sampleRateLabel.setForeground(Color.white);

        JLabel bitRateLabel = new JLabel();
        bitRateLabel.setText("Bit Rate:");
        bitRateLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        bitRateLabel.setBounds(15, 60, 200, 20);
        bitRateLabel.setForeground(Color.white);

        /*
            TEXT FIELDS
        */

        sampleRateInput = new JTextField();
        sampleRateInput.setBounds(150, 35, 185, 20);
        sampleRateInput.setText("48000");
        sampleRateInput.setBackground(new Color(25, 24, 25));
        sampleRateInput.setForeground(Color.white);
        sampleRateInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        bitRateInput = new JTextField();
        bitRateInput.setBounds(150, 60, 185, 20);
        bitRateInput.setText("32768");
        bitRateInput.setBackground(new Color(25, 24, 25));
        bitRateInput.setForeground(Color.white);
        bitRateInput.setBorder(new LineBorder(new Color(31, 31, 31),2));

        /*
            BUTTONS
        */

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(15, 115, 110, 25);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);
        confirmButton.setBackground(new Color(70, 69, 70));
        confirmButton.setForeground(Color.white);
        confirmButton.setBorder(new LineBorder(new Color(48, 48, 48),2));

        /*
            ADDING
        */

        this.setBorder(optionsBorder);
        this.add(sampleRateLabel);
        this.add(sampleRateInput);
        this.add(bitRateLabel);
        this.add(bitRateInput);
        this.add(confirmButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton) {

            sampleRateInput.setEnabled(false);
            bitRateInput.setEnabled(false);

            try {

                int sampleRate = Integer.parseInt(sampleRateInput.getText());
                int bitRate = Integer.parseInt(bitRateInput.getText());

                compressor.setAudioSampleRate(sampleRate);

                compressor.setAudioBitRate(bitRate);

            } catch(Exception err) {

                errorFrame errorWindow = new errorFrame();

                sampleRateInput.setEnabled(true);
                bitRateInput.setEnabled(true);

                System.out.println(err);

            }

        }
    }
}
