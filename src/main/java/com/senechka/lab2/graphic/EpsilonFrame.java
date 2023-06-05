package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EpsilonFrame extends JFrame {
    private JPanel panel1;
    private JTextField a001TextField;
    private JButton далееButton;
    private JLabel errorLabel;

    public EpsilonFrame() {
        setContentPane(panel1);
        setTitle("Погрешность");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        далееButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double epsilon = Double.parseDouble(a001TextField.getText());

                    if (epsilon >= 1 || epsilon < 0.01) {
                        throw new NumberFormatException();
                    }

                    GlobalStore.data.setEpsilon(epsilon);

                    MethodFrame methodFrame = new MethodFrame();
                    methodFrame.show();
                    dispose();
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Эпсилон - число double. Строго больше нуля, меньше единицы");
                }
            }
        });
    }
}
