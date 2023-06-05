package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.system.FirstSystem;
import com.senechka.lab2.system.SecondSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemFrame extends JFrame{
    private JRadioButton x2Y2RadioButton;
    private JRadioButton sinXY1RadioButton;
    private JButton далееButton;
    private JPanel panel1;

    public SystemFrame() {
        setContentPane(panel1);
        setTitle("Система");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        далееButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x2Y2RadioButton.isSelected()) {
                    GlobalStore.system = new FirstSystem();
                } else {
                    GlobalStore.system = new SecondSystem();
                }
                IntervalFrame intervalFrame = new IntervalFrame();
                intervalFrame.show();
                dispose();
            }
        });
    }
}
