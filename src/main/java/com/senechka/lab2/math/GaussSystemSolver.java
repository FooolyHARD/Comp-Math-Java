package com.senechka.lab2.math;

public class GaussSystemSolver {

    public double[] solve(double[][] matrix) {
        int n = matrix.length;
        triangMatrix(matrix);

        for (int i = 1; i < n; i++) {
            for (int j_before_i = 0; j_before_i < i; j_before_i++) {
                double i_head = matrix[j_before_i][i];
                for (int k = i; k < n + 1; k++) {
                    matrix[j_before_i][k] = matrix[j_before_i][k] - matrix[i][k] * i_head;
                }
            }
        }

        double[] answer = new double[n];
        for (int i = 0; i < matrix.length; i++) {
            answer[i] = matrix[i][n];
        }
        return answer;
    }

    private void triangMatrix(double[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] == 0) {
                swapLines(matrix, i);
            }

            double i_i = matrix[i][i];

            for (int j_in_i_line = i; j_in_i_line < n + 1; j_in_i_line++) {
                matrix[i][j_in_i_line] = matrix[i][j_in_i_line] / i_i;
            }

            for (int j_after_i = i + 1; j_after_i < n; j_after_i++) {
                double j_line_head = matrix[j_after_i][i];

                for (int k = i; k < n + 1; k++) {
                    matrix[j_after_i][k] = matrix[j_after_i][k] - j_line_head * matrix[i][k];
                }
            }

        }
    }

    private void swapLines(double[][] matrix, int i) {
        for (int j = i + 1; j < matrix.length; j++) {
            if (matrix[j][i] != 0) {
                double[] j_matrix = matrix[j];
                matrix[j] = matrix[i];
                matrix[i] = j_matrix;

                return;
            }
        }
    }
}


//            for j_in_i_line in range(i, n + 1):
//            matrix[i][j_in_i_line] = matrix[i][j_in_i_line]/i_i
//
//            for j_after_i in range(i + 1, n):
//            j_line_head = matrix[j_after_i][i]
//            for k in range(i, n + 1):
//            matrix[j_after_i][k] = matrix[j_after_i][k] - j_line_head*matrix[i][k]
//            print_matrix("", matrix)
//            print("------------Triangulize matrix end--------------")
//            return matrix
