package com.senechka.lab2.graphic;

import com.senechka.lab2.dto.AnswerEquation;
import com.senechka.lab2.dto.AnswerSystem;
import com.senechka.lab2.dto.InputData;
import com.senechka.lab2.system.SystemTask;
import org.math.plot.Plot2DPanel;

import javax.swing.*;
import java.awt.*;
import java.util.function.BiFunction;

public class GraphicDrawer {



    public static void showEquation(AnswerEquation answer) {

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        addEquationOnGraph(plot, (Double x, Double y) -> answer.getEquation().f(x), answer.getInterval());

//        Point2D point2D = new Point2D.Double(answer.getX(), 0);

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("Ответ");
        frame.setSize(800, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    public static void showSystem(AnswerSystem answer) {

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();


//        Point2D point2D = new Point2D.Double(answer.getX(), 0);

        addSystemOnGraph(plot, answer.getSystem(), new InputData(answer.getInterval().getA(), answer.getInterval().getB()));

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("Ответ");
        frame.setSize(800, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }

    private static void addEquationOnGraph(Plot2DPanel plot, BiFunction<Double, Double, Double> f, InputData interval) {
        double[] x = new double[80];
        double[] y = new double[80];
        double start = interval.getA() - 0.5;
        for (int i = 0; i < 80; i++) {
            x[i] = start;
            y[i] = f.apply(start, 0d);
            start += 0.1;
        }

        plot.addLinePlot("", Color.BLUE, x, y);

        double[] x0 = {interval.getA(), 0};
        double[] y0 = {interval.getB(), 0};
        plot.addLinePlot("y=0", Color.DARK_GRAY, x0, y0);


    }

    public static void starting(Plot2DPanel plot, BiFunction<Double, Double, Double> f) {
        double[] x = new double[80];
        double[] y = new double[80];
        double start = -5;
        for (int i = 0; i < 80; i++) {
            x[i] = start;
            y[i] = f.apply(start, 0d);
            start += 0.1;
        }

        plot.addLinePlot("", Color.BLUE, x, y);

        double[] x0 = {-5, 0};
        double[] y0 = {5, 0};
        plot.addLinePlot("y=0", Color.DARK_GRAY, x0, y0);


    }

    private static void addSystemOnGraph(Plot2DPanel plot, SystemTask system, InputData interval) {
        addEquationOnGraph(plot, system::firstEquation, interval);
        addEquationOnGraph(plot, system::secondEquation, interval);
    }
}
