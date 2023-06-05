package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.math.HalfDivisionMethod;
import com.senechka.lab2.math.SecantMethod;
import com.senechka.lab2.math.SimpleIterationMethod;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MethodFrame extends JFrame {
    private JPanel panel1;
    private JRadioButton методПоловинногоДеленияRadioButton;
    private JRadioButton методСекущихRadioButton;
    private JRadioButton методПростойИтерацииRadioButton;
    private JButton далееButton;

    public MethodFrame() {
        setContentPane(panel1);
        setTitle("Метод решения");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        далееButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (методПоловинногоДеленияRadioButton.isSelected()) {
                    GlobalStore.method = new HalfDivisionMethod();
                } else if(методСекущихRadioButton.isSelected()) {
                    GlobalStore.method = new SecantMethod();
                } else {
                    GlobalStore.method = new SimpleIterationMethod();
                }

                AnsEqFrame ansEqFrame = new AnsEqFrame();
                ansEqFrame.show();
                dispose();
            }
        });
    }
}
