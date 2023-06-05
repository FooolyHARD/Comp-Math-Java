package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.dto.AnswerEquation;
import com.senechka.lab2.dto.AnswerSystem;
import com.senechka.lab2.math.NewtonSystemMethod;

import javax.swing.*;

public class AnsEqFrame extends JFrame{
    private JPanel panel1;
    private JLabel ansLabel;

    public AnsEqFrame() {
        setContentPane(panel1);
        setTitle("Ответ");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if (GlobalStore.isSystem) {
            NewtonSystemMethod newtonSystemMethod = new NewtonSystemMethod();
            AnswerSystem answerSystem = newtonSystemMethod.proceed(GlobalStore.interval, GlobalStore.system);
            ansLabel.setText(answerSystem.toString());
            setVisible(true);
            GraphicDrawer.showSystem(answerSystem);
        }
        else {
            AnswerEquation answer = GlobalStore.method.solveEquation(GlobalStore.equation, GlobalStore.data);

            ansLabel.setText(answer.toString());

            setVisible(true);

            GraphicDrawer.showEquation(answer);

        }

    }
}
