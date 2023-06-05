package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.equation.QuadraticEquation;
import com.senechka.lab2.equation.ThirdDegreeEquation;
import com.senechka.lab2.equation.TranscendentalEquation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EquationFrame extends JFrame{
    private JPanel panel1;
    private JRadioButton x3228RadioButton;
    private JRadioButton x28XRadioButton;
    private JRadioButton sin2xCosXRadioButton;
    private JButton button1;
public EquationFrame() {
    setContentPane(panel1);
    setTitle("Уравнение");
    setSize(700, 450);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (x3228RadioButton.isSelected()) {
                GlobalStore.equation = new ThirdDegreeEquation();
            } else if (x28XRadioButton.isSelected()) {
                GlobalStore.equation = new QuadraticEquation();
            }
            else {
                GlobalStore.equation = new TranscendentalEquation();
            }
            InputFrame inputFrame = new InputFrame();
            inputFrame.show();
            dispose();
        }
    });
}
}
