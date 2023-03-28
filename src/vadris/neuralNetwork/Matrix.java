package vadris.neuralNetwork;

public class Matrix {
    private double[][] values;

    public Matrix(int columns, int rows){
        values = new double[columns][rows];
    }
    public Matrix(double[][] values){
        this.values = new double[values.length][values[0].length];
        for(int row = 0; row < values.length; row++)
            System.arraycopy(values[row], 0, this.values[row], 0, values[0].length);
    }

    public double getValue(int column, int row){
        return values[row][column];
    }
    public int getRows(){
        return values.length;
    }
    public int getColumns(){
        return values[0].length;
    }

    public void setValue(int column, int row, double value){
        values[row][column] = value;
    }
}
