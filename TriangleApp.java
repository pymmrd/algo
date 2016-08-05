/**
* Author:zougang
* Date:2016/08/05
* Email:b.zougang@gmail.com
* 三角数字: 第n项目的值等于(n-1) + n
*/

public class TriangleApp{


    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.println("iteration: " + iteration(n));
        System.out.println("recurse: " + recurse(n));
    }

    public static int iteration(int n){
        int sum = 0;
        while(n > 0){
            sum += n;
            --n;
        }
        return sum;
    }

    public static int recurse(int n){
        if (n==1){
            return 1;
        }else{
            return n + recurse(n-1);
        }
    }

}
