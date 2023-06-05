package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.math.IntervalCounter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListIntervFrame extends JFrame{
    private JList list1;
    private JPanel panel1;
    private JButton далееButton;
    private JLabel topLabel;

    public ListIntervFrame() {
        setContentPane(panel1);
        setTitle("Список интервалов");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        IntervalCounter intervalCounter = new IntervalCounter();
        GlobalStore.intervals = intervalCounter.countIntervals(GlobalStore.equation, GlobalStore.interval);
        if (GlobalStore.intervals.isEmpty()) {
            topLabel.setText("На этом интервале не нашлось корней, попробуйте снова");
            далееButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    IntervalFrame intervalFrame = new IntervalFrame();
                    intervalFrame.show();
                    dispose();
                }
            });


        } else {
            list1.setListData(GlobalStore.intervals.toArray(new InputData[0]));

            setVisible(true);


            далееButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GlobalStore.data = (InputData) list1.getSelectedValue();

                    EpsilonFrame epsilonFrame = new EpsilonFrame();
                    epsilonFrame.show();

                    dispose();
                }
            });
        }
    }
}
