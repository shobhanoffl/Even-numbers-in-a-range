import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = new int[size];
        for(int i=0; i<size; i++){
            array[i] = sc.nextInt();
        }

        int query = sc.nextInt();
        int[][] queries = new int[query][2];
        for(int i=0; i<query; i++){
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        int[] prefixSum=new int[size];
        if(array[0]%2==0)
            prefixSum[0] =1;
        else
            prefixSum[0]=0;
        for (int i = 1; i < size; i++) {
            if(array[i]%2==0)
                prefixSum[i] = prefixSum[i-1] + 1;
            else
                prefixSum[i] = prefixSum[i-1];
        }

        int[] evenSum = new int[query];
        for (int i=0; i<query; i++){
            if(queries[i][0]==0){
                evenSum[i]=prefixSum[queries[i][1]];
            }else{
                evenSum[i]=prefixSum[queries[i][1]]-prefixSum[queries[i][0]-1];
            }
        }

        for(int i=0; i<query; i++){
            System.out.println(evenSum[i]);
        }

    }
}