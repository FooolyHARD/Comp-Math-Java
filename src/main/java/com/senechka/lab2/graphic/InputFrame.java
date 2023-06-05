package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InputFrame extends JFrame {

    private JPanel panel1;
    private JRadioButton ручкамиНапишуRadioButton;
    private JRadioButton файлRadioButton;
    private JButton далееButton;
    public InputFrame() {
        setContentPane(panel1);
        setTitle("Выбор");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Plot2DPanel plot = new Plot2DPanel();

        GraphicDrawer.starting(plot, (Double x, Double y) -> GlobalStore.equation.f(x));

        JFrame frame = new JFrame("Изначальный график");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setContentPane(plot);
        frame.setVisible(true);

        далееButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ручкамиНапишуRadioButton.isSelected()) {
                    SelfInputFrame selfInputFrame = new SelfInputFrame();
                    selfInputFrame.show();
                    dispose();
                } else {
                    FileFrame fileFrame = new FileFrame();
                    fileFrame.show();
                    dispose();
                }
            }
        });
    }
}
