package com.senechka.lab2.graphic;

import com.senechka.lab2.data.GlobalStore;
import com.senechka.lab2.file.FileWorker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileFrame extends JFrame {
    private JButton fileButton;
    private JPanel panel1;
    private JLabel errorLabel;
    private JButton далееButton;


    public FileFrame() {
        setContentPane(panel1);
        setTitle("Файл");
        setSize(700, 450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        fileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();

                int response = fileChooser.showOpenDialog(null);

                if (response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    FileWorker fileWorker = new FileWorker();
                    try {
                        GlobalStore.data = fileWorker.readInputData(file);
                        fileButton.setText(file.getName());
                        далееButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                MethodFrame methodFrame = new MethodFrame();
                                methodFrame.show();
                                dispose();
                            }
                        });
                    } catch (Exception ex) {
                        errorLabel.setText("Невалидный файл. Ожидался файл в формате: левая граница_правая граница \n эпсилон");
                    }

                }
            }
        });

    }
}
