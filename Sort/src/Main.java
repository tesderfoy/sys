public class Main {
    static int x = 0;

    public static void main(String[] args) {
        int array[] = {7,5,10,7,5,9,10,10};
        array = sort(array);
        int b[][] = new  int[array.length][2];


        b[x][0] = array[0];
        b[x][1] = 1;
        for ( int i = 1;i<array.length;i++){
            if (array[i] == array[i-1]){
                b[x][1] = b[x][1] +1;

            }else {
                x++;
                b[x][0] = array[i];
                b[x][1] = 1;
            }

        }
        x++;


        b = sortMatr(b);


        for (int i = 0; i<x;i++){
            for (int j = 1; j<=b[i][1];j++){
                System.out.print(" " + b[i][0]);
            }

        }

    }
    public static int[] sort(int a[]){
        for (int i = 0; i<a.length-1; i++){
            for (int j = i+1; j<a.length-1; j++){
                if (a[i]>a[j]){
                    int temp;
                    temp = a[i];
                    a[i] = a[j];
                    a[j]= temp;
                }

            }
        }
        return a;
    }

    public static int[][] sortMatr(int b [][]){
        int c [] = new int[2];
        for (int i = 0; i<x-1; i++){
            for (int j =i+1; j<x; j++){
                if(b[i][1] < b[j][1]){
                    c = b[i];
                    b[i] = b[j];
                    b[j]= c ;

                }
            }
        }
        return b;

    }
}