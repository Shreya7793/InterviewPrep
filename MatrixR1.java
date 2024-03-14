import java.util.Arrays;

public class MatrixR1 {

    public static void main(){
        int [][]arr={{0,1,2,0},{3,4,5,6},{1,3,4,5}};
        System.out.println(arr.length);
      //  int [][]visited=;

        int rowCnt= 4;
        int colCnt=4;
        for(int i=0;i<rowCnt;i++){
            for(int j=0;j<colCnt;j++){
                if(arr[i][j]==0){

                    Arrays.fill(arr[i],-1);
                    Arrays.fill(arr[j],-1);
                }
            }
        }
    }
}
