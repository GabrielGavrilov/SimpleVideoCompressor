package Gui.Panels;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class errorPanel extends JPanel implements ActionListener {

    JButton closeButton;

    public errorPanel() {

        this.setLayout(null);
        this.setBackground(new Color(53, 53, 53));
        this.setBounds(0,0,300,200);

        /*
            LABELS
        */

        JLabel errorLabel = new JLabel();
        errorLabel.setText("There has been an issue.");
        errorLabel.setFont(new Font("ARIAL", Font.PLAIN, 15));
        errorLabel.setBounds(65,65, 300, 20);
        errorLabel.setForeground(Color.white);

        /*
            BUTTONS
        */

        closeButton = new JButton("Close");
        closeButton.setBounds(95,85, 110,25);
        closeButton.addActionListener(this);
        closeButton.setBackground(new Color(70, 69, 70));
        closeButton.setForeground(Color.white);
        closeButton.setBorder(new LineBorder(new Color(48, 48, 48),2));
        closeButton.setFocusable(false);

        /*
            ADDING
        */

        this.add(errorLabel);
        this.add(closeButton);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
