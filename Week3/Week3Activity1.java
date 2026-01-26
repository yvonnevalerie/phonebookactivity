public class Week3Activity1 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        
        double[][]matrix = new double [3][4];
        System.out.println("Enter a 3-by-4 matrix row by row:");
            for(int i = 0; i < matrix.length; i++ ){
                for(int j = 0; j < matrix[i].length; j++){
                    matrix[i][j] = sc.nextDouble();
                    
                }
                
        }
        System.out.println("Sum of the elements at column" + columnIndex + "is" + sumColumn(matrix, 0));

    public static double sumColumn(double[][] m, int columnIndex){
            double sum = 0;
            for (int row = 0; row < natrix.length; row++){
                sum += m[i][columnIndex];

            }
                sum += m[i][columnIndex];

        
        

                }
                return sum;
            }
            public static double sumMajorDiagonal(double [][] matrix){

            }


        }
    