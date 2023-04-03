package vadris.neuralNetwork.Math;

public class Matrix {
    private double[][] values;
    
    public Matrix(int columns, int rows){
        values = new double[rows][columns];
    }
    public Matrix(double[][] values){
        this.values = new double[values.length][values[0].length];
        for(int row = 0; row < values.length; row++){
            System.arraycopy(values[row], 0, this.values[row], 0, values[0].length);
        }
    }

    public int getRows(){
        return values.length;
    }
    public int getColumns(){
        return values[0].length;
    }
    public double getValue(int column, int row){
        return values[row][column];
    }
    public void setValue(int column, int row, double value){
        values[row][column] = value;
    }

    public Matrix add(Matrix a, Matrix b, boolean nvidia){
        if (nvidia) return addNVIDIA(a, b);
        else return addCPU(a, b);
    }

    public Matrix multiply(Matrix a, Matrix b, boolean nvidia){
        if(nvidia) return multiplyNVIDIA(a, b);
        else return multiplyCPU(a, b);
    }

    private Matrix addCPU(Matrix a, Matrix b){
        Matrix result = new Matrix(a.getRows(), a.getColumns());
        for(int row = 0; row < a.getRows(); row++){
            for(int column = 0; column < a.getColumns(); column++){
                result.setValue(column, row, a.getValue(column, row) + b.getValue(column, row));
            }
        }
        return result;
    }
    private Matrix addNVIDIA(Matrix a, Matrix b){
        return null;
    }
    private Matrix multiplyCPU(Matrix a, Matrix b){
        return null;
    }
    private Matrix multiplyNVIDIA(Matrix a, Matrix b){
        return null;
    }

    public Matrix copy(){
        Matrix copy = new Matrix(getColumns(),getRows());
        for(int row = 0; row < values.length; row++){
            System.arraycopy(values[row], 0, copy.values[row], 0, values[0].length);
        }
        return copy;
    }
}
