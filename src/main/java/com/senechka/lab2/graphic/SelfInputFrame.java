package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.data.UserInputWorker;
import com.senechka.lab2.dto.BigInterval;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfInputFrame extends JFrame {

    private JRadioButton укажуИнтервалСамRadioButton;
    private JRadioButton найдиИнтервалСамRadioButton;
    private JButton далееButton;
    private JPanel panel1;

    public SelfInputFrame() {
    setContentPane(panel1);
    setTitle("Способ выбора интервала");
    setSize(700, 450);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);

    далееButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (укажуИнтервалСамRadioButton.isSelected()) {
                GlobalStore.dataWorker = new UserInputWorker();
                IntervalFrame intervalFrame = new IntervalFrame();
                intervalFrame.show();
                dispose();
            } else {
                GlobalStore.interval = new BigInterval(-5, 5);
                ListIntervFrame listIntervFrame = new ListIntervFrame();
                listIntervFrame.show();
                dispose();
            }
        }
    });
}
}
