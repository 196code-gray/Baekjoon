import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int arr1[][]=new int[n][m];
        int arr2[][]=new int[n][m];
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr1[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr2[i][j]=scanner.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(arr1[i][j]+arr2[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}