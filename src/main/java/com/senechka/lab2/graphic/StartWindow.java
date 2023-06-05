package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartWindow extends JFrame{
    private JRadioButton radioButton1;
    private JPanel panel1;
    private JButton button1;
    private JRadioButton RadioButton;

    public StartWindow() {
        setContentPane(panel1);
        setTitle("Lab 2");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (radioButton1.isSelected()) {
                EquationFrame equationFrame = new EquationFrame();
                equationFrame.show();

                dispose();
            } else {
                GlobalStore.isSystem = true;

                SystemFrame systemFrame = new SystemFrame();
                systemFrame.show();
                dispose();
            }
        }
    });
}
}
