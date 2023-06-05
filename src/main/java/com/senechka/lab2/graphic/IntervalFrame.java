package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.dto.BigInterval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntervalFrame extends JFrame{
    private JPanel panel1;
    private JTextField leftField;
    private JTextField rightField;
    private JButton button1;
    private JLabel errLabel;

    public IntervalFrame() {
        setContentPane(panel1);
        setTitle("Интервал");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double left = 0;
                double right = 0;
                try {
                    left = Double.parseDouble(leftField.getText());
                    right = Double.parseDouble(rightField.getText());
                    if (left > 100 || left < -100) {
                        errLabel.setText("Введите число от -100 до 100");
                        throw new NumberFormatException();
                    }
                    if (right > 100 || right < -100) {
                        errLabel.setText("Введите число от -100 до 100");
                        throw new NumberFormatException();
                    }
                    if (left >= right) {
                        errLabel.setText("Правая граница должна быть больше левой");
                        throw new NumberFormatException();
                    }
                    GlobalStore.interval = new BigInterval(left, right);
                    System.out.println(left+right);
                    if (GlobalStore.isSystem) {
                        AnsEqFrame ansEqFrame = new AnsEqFrame();
                        ansEqFrame.show();
                        dispose();
                    } else {
                        ListIntervFrame listIntervFrame = new ListIntervFrame();
                        listIntervFrame.show();
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    errLabel.setText("Введите числа double в формате 0.01. От -100 до 100. Правая граница больше левой.");
                }

            }
        });
    }
}
