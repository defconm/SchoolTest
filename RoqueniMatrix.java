
/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 * 
 * @author David Roqueni, Ruben Acuna
 * @version 1.0
 */
public class RoqueniMatrix implements Matrix {
    private int[][] matrix;
    public RoqueniMatrix(int[][] matrix)
    {
    	if(matrix.length == 0)
    		this.matrix = null;
    	else
    		this.matrix = new int[matrix.length][matrix[0].length];
    	if(this.matrix != null)
    	{
    		for(int i = 0; i < matrix.length; i++)
    		{
    			for(int j = 0; j< matrix[0].length; j++)
    			{
    				this.matrix[i][j] = matrix[i][j];
    			}
    		}
    		
    	}
    }

	@Override
	public int getElement(int y, int x) {
		if(matrix == null || matrix.length < y && matrix[y].length < x)
			return -1;
		
		return matrix[y][x];
	}

	@Override
	public int getRows() {
		if(matrix == null)
			return 0;
		return matrix.length;
	}

	@Override
	public int getColumns() {
		if(matrix == null)
			return 0;
		return matrix[0].length;
	}

	@Override
	public Matrix scale(int scalar) {
		if(matrix == null)
			return null;
		int[][] creating = new int[getRows()][getColumns()];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				creating[i][j] = scalar * matrix[i][j]; 
			}
		}
		return new RoqueniMatrix(creating);
	}

	@Override
	public Matrix plus(Matrix other) {
		if(matrix == null || other.getRows() == 0)
			throw new RuntimeException("Empty Array");
		if(matrix.length != other.getRows() || matrix[0].length != other.getColumns())
			throw new RuntimeException();
		int[][] creating = new int[other.getRows()][other.getColumns()];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				creating[i][j] = matrix[i][j] + other.getElement(i, j); 
			}
		}
		return new RoqueniMatrix(creating);
	}

	@Override
	public Matrix minus(Matrix other) {
		if(matrix == null || other.getRows() == 0)
			throw new RuntimeException("Empty Array");
		if(matrix.length != other.getRows() || matrix[0].length != other.getColumns())
			throw new RuntimeException();
		int[][] creating = new int[other.getRows()][other.getColumns()];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				creating[i][j] = matrix[i][j] - other.getElement(i, j); 
			}
		}
		return new RoqueniMatrix(creating);
	}

	@Override
	public Matrix multiply(Matrix other) {
		if(matrix == null || other.getRows() == 0)
			throw new RuntimeException("Empty Array");
		if(matrix[0].length != other.getRows())
			throw new RuntimeException();
		int[][] newMatrix = new int[this.getColumns()][other.getRows()];
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j< other.getColumns(); j++)
			{
				for(int k = 0; k < matrix[0].length; k++)
				{
					newMatrix[i][j] += matrix[i][k] * other.getElement(k, j);
				}
			}
			
		}
		return new RoqueniMatrix(newMatrix);
	}
    
	@Override
	public boolean equals(Object other)
	{
		if(matrix == null)
			return false;
		Matrix o;
		if(other instanceof Matrix)
			o = (Matrix) other;
		else
			return false;
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(matrix[i][j] != o.getElement(i, j))
					return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString()
	{
		if(matrix == null)
			return null;
		String str = "";
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				str += matrix[i][j] + " ";
				if(j+1 == matrix[i].length && i != matrix.length-1)
					str+= "\n";
			}
		}
		return str;
	}
    /**
     * Entry point for matrix testing.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        
        Matrix m1 = new RoqueniMatrix(data1);
        Matrix m2 = new RoqueniMatrix(data2);
        Matrix m3 = new RoqueniMatrix(data3);
        Matrix m4 = new RoqueniMatrix(data4);
        
        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());
        
        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true
        
        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        
        //test multiply
        System.out.println("m2*m3:\n" + m2.multiply(m3));
        //System.out.println("m2*m3:\n" + m2.multiply(m1));
        
        //test operations (invalid)
       // System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }

}