import java.util.Arrays;

public class Matrix {
    private double[][] mat;

    public Matrix(int numRows, int numCols) {
        mat = new double[numRows][numCols];
    }
    
    public Matrix(double[][] mat) {
        this.mat = mat;
    }

    public int numRows() {
        return mat.length;
    }

    public int numCols() {
        return mat[0].length;
    }

    public double getElement(int row, int col) {
        return mat[row][col];
    }

    public void setElement(int row, int col, double value) {
        mat[row][col] = value;
    }

    public Matrix add(Matrix other) {
        if (other.numRows() != this.numRows() || other.numCols() != this.numCols())
            return new Matrix(0, 0);
        Matrix resultant = new Matrix(this.numRows(), this.numCols());
        for (int row = 0; row < this.numRows(); row++) {
            for (int col = 0; col < this.numCols(); col++) {
                resultant.setElement(row, col, mat[row][col] + other.getElement(row, col));
            }
        }
        return resultant;
    }

    public Matrix subtract(Matrix other) {
        other = other.multiplyByScalar(-1.0);
        return this.add(other);
    }

    public Matrix multiplyByScalar(double scalar) {
        Matrix resultant = new Matrix(this.numRows(), this.numCols());
        for(int row = 0; row < this.numRows(); row++) {
            for(int col = 0; col < this.numCols(); col++) {
                resultant.setElement(row, col, scalar * mat[row][col]);
            }
        } 
        return resultant;
    }

        public Matrix multiply(Matrix other){
        Matrix failureMatrix = new Matrix(1000, 1000); 
        if(this.numRows() == other.numRows() && this.numCols() == other.numCols()){
            Matrix productMatrix = new Matrix(this.numRows(), this.numCols());
            for(int r = 0; r < this.numRows(); r++){
                for(int c = 0; c < other.numCols(); c++){
                    double dotProduct = 0.0; 
                    for(int i = 0; i < this.numCols(); i++){
                        dotProduct += (this.mat[r][i] + other.getElement(r, i)); 
                    }
                    productMatrix.setElement(r, c, dotProduct);  
                }
            }
            return productMatrix; 
        }
        return failureMatrix; 
        

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Matrix other = (Matrix) obj;
        if (!Arrays.deepEquals(mat, other.mat))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(mat);
    }

}
