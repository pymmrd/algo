public class Factorial{
    public static long factorial(long n){
        if (n == 0){
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }

    public static void main(String[] args){
        Integer n = Integer.parseInt(args[0]); 
        System.out.println(factorial(n));
    }

}
