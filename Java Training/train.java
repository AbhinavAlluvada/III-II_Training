import java.util.Scanner;
public class train {
    static boolean prime(int n){
        boolean isprime = true;
        for(int i =2;i<n;i++){
            if(n%i==0){
                return false;
            }
        }
        return isprime;
    }
    static void primerange(int lower,int upper){
        if(lower>upper){
            System.out.println("Really bro!");
        }
        for(int i =2;i<upper;i++){
            if(i>lower && prime(i)){
                System.out.println(i);
            }
        }
    }
    static int pow(int val, int power){
        int result = 1;
        for(int i = 0;i<power;i++){
            result = result * val;
        }
        return result;
    }
    static void armstrong(int n){
        int temp = n;
        int arm = 0;
        while(temp!=0){
            int digit = temp%10;
            arm = arm + pow(digit,3);
            temp /= 10;
        }
        if(arm == n){
            System.out.println("Armstrong it is!");
        }
        else{
            System.out.println("Hard pass!");
        }
    }
    static void automorphic(long n){
        long sq = n * n;
        long temp = n;
        long div = 1;
        while(temp!=0){
            div = div * 10;
            temp = temp/10;
        }
        if(sq % div == n){
            System.out.println("Automorphic");
        }
        else{
            System.out.println("Nah!");
        }
    }
    static void init(int[] arr){
        Scanner scanner = new Scanner(System.in);
        for(int i =0;i<5;i++){
            arr[i] = scanner.nextInt();
        }
        scanner.close();
    }

    static void evensum(int[] arr,int n){
        int sum =0;
        int count = 0;
        for(int i =0;i<n;i++){
            if(arr[i]%2==0){
                sum = sum + arr[i];
                count++;
            }
        }
        int avg = sum/count;
        System.out.println(avg);

    }
    static void find(int[] arr,int n){
        int max = arr[0];
        for(int i =0;i<n;i=i+2){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int min = arr[0];
        for(int i = 1;i<n;i=i+2){
            if(arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("Sum: "+(max + min));
    }
    static void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }
    static void transpose(int[][] arr,int row, int col){
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                swap(arr[i][j],arr[j][i]);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        int row = 2, col = 2;
        int[][] arr = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                System.out.print("Enter element for row["+(i+1)+"] and col["+(j+1)+"]: ");
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        transpose(arr, row, col);
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }}