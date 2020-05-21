package tech.z_temp;

public class TestTemp{

    public static void main(String args[]) {
//        char[][] a = new char[][]{{'a', 'b', 'c'}, {'e', 'f', 'g'},{'i', 'j', 'k'}};
        char[][] a = new char[][]{{'a', 'b', 'c', 'd'}, {'e', 'f', 'g', 'h'},{'i', 'j', 'k', 'l'},{'m', 'n', 'o', 'p'}};
        printMatrix(a);
        roatate(a);
        printMatrix(a);

    }

    public static void roatate(char[][] a){
        for (int i =0; i < a.length/2; i++){
            int min = i;
            int max = a.length-1-i;

            int j=0;
            char temp = a[min][j];
            a[min][j] = a[max-j][min];
            a[max-j][min] = a[max][max-j];
            a[max][max-j] = a[j][max];
            a[j][max] = temp;


//            for (int j=i; j<a[0].length-2; j++){
//                char tempV = a[min][j];
//
//
//
//
//                char temp = a[min][j];
//                a[min][j] = a[max-j][min];
//                a[max-j][min] = a[max][max-j];
//                a[max][max-j] = a[j][max];
//                a[j][max] = temp;
//            }
        }


//        char temp = a[min][min];
//        a[min][min] = a[max][min];
//        a[max][min] = a[max][max];
//        a[max][max] = a[min][max];
//        a[min][max] = temp;
    }



    private static void printMatrix(char[][] a) {
        for (int row = 0; row < a.length; row++) {
            for (int clm = 0; clm < a[0].length; clm++) {
                System.out.print(a[row][clm]+" ");
            }
            System.out.println("");
        }
        System.out.println("\n");
    }
}