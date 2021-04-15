package com.company;

import java.util.Scanner;
public class Matrix{

    private double[][] matrix;
    private int rows; private int cols;

    public Matrix(int rows, int columns)
    {
        matrix = new double[rows][columns];

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < columns; j++)
            {
                matrix[i][j] = 0;
            }
        }
    }

    public Matrix()
    {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the number of rows: ");
        rows = in.nextInt();
        System.out.print("Please enter the number of columns: ");
        cols = in.nextInt();
        matrix = new double[rows][cols];
        System.out.println("Please assign the following elements: ");
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                System.out.print("[" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = in.nextDouble();
            }
        }
    }

    public Matrix(Matrix c){
        this.matrix = c.matrix;
    }

    private int getRows(){
        return rows;
    }

    private int getColumns(){
        return cols;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    private double getElement(int rows, int columns){
        return matrix[rows][columns];
    }

    private void assignElement(double value, int i, int j){
        matrix[i][j] = value;
    }


    public static Matrix Add(Matrix x, Matrix y)
    {
        Matrix z = new Matrix(x.getRows(), x.getColumns());
        double value;
        System.out.println();
        System.out.println("The sum of the matricices is: ");

        if(x.getRows() == y.getRows() && x.getColumns() == y.getColumns())
        {
            for(int i = 0; i < x.getRows(); i++)
            {
                for(int j = 0; j < y.getColumns(); j++)
                {
                    value = x.getElement(i,j) + y.getElement(i,j);
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of rows and columns of the matricies are not equal."); return z;}
    }


    public static Matrix Subtract(Matrix x, Matrix y)
    {
        Matrix z = new Matrix(x.getRows(), x.getColumns());
        double value;
        System.out.println();
        System.out.println("The difference of the two matricices is: ");

        if(x.getRows() == y.getRows() && x.getColumns() == y.getColumns())
        {
            for(int i = 0; i < x.getRows(); i++)
            {
                for(int j = 0; j < y.getColumns(); j++)
                {
                    value = x.getElement(i,j) - y.getElement(i,j);
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of rows and columns of the matricies are not equal."); return z;}
    }

    public static Matrix Multiply(Matrix x, Matrix y)
    {
        Matrix z = new Matrix(x.getRows(), y.getColumns());
        double value;
        System.out.println();
        System.out.println("The product of the matricices is: ");

        if(x.getColumns() == y.getRows())
        {
            for(int i = 0; i < x.getRows(); i++)
            {
                for(int j = 0; j < y.getColumns(); j++)
                {
                    double sum = 0;
                    for(int k = 0; k < x.getRows(); k++)
                    {
                        sum += x.getElement(i,k) * y.getElement(k,j);
                    }
                    value = sum;
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of columns of the first matrix and the number of rows of the second matrix are not equivalent."); return z;}
    }


    public Matrix add(Matrix x)
    {
        Matrix z = new Matrix(rows, cols);
        double value;
        System.out.println();
        System.out.println("The sum of the matricices is: ");

        if(rows == x.getRows() && cols == x.getColumns())
        {
            for(int i = 0; i < x.getRows(); i++)
            {
                for(int j = 0; j < x.getColumns(); j++)
                {
                    value = matrix[i][j] + x.getElement(i,j);
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of rows and columns of the matricies are not equivalent."); return z;}
    }


    public Matrix subtract(Matrix x)
    {
        Matrix z = new Matrix(rows, cols);
        double value;
        System.out.println();
        System.out.println("The difference of the two matricices is: ");

        if(rows == x.getRows() && cols == x.getColumns())
        {
            for(int i = 0; i < x.getRows(); i++)
            {
                for(int j = 0; j < x.getColumns(); j++)
                {
                    value = matrix[i][j] - x.getElement(i,j);
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of rows and columns of the matricies are not equivalent."); return z;}
    }

    public Matrix multiply(Matrix x)
    {
        Matrix z = new Matrix(rows, x.getColumns());
        double value;
        System.out.println();
        System.out.println("The product of the matricices is: ");

        if(cols == x.getRows())
        {
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < x.getColumns(); j++)
                {
                    double sum = 0;
                    for(int k = 0; k < rows; k++)
                    {
                        sum += matrix[i][k] * x.getElement(k,j);
                    }
                    value = sum;
                    z.assignElement(value,i,j);
                    System.out.print("[" + z.getElement(i,j) + "]");
                }
                System.out.print('\n');
            }
            return z;
        }
        else{System.out.println("ERROR: The number of columns of the first matrix and the number of rows of the second matrix are not equivalent."); return z;}
    }

    public String toString()
    {
        String es = "";

        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                es += "[";
                es += matrix[i][j];
                es += "]";
            }
            es += '\n';
        }
        System.out.println();
        System.out.println("Your matrix: ");
        return es;
    }

}