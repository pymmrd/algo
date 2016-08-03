/*
*数组实现栈数据结构
*Author:zougang
*Date:2016/08/01
*Email:zougang@nagain.com
*/

public class StackX{
    public static void main(String[] args){
        int index = 1;
        Stack s1 = new Stack(10);
        while (!s1.isFull()){
            System.out.println("Stack Push" + index);
            s1.push(index);
            index++;
        }
        try{
            while (!s1.isEmpty()){
                System.out.println("Stack POP" + s1.pop());
            }
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}

class Stack{
    public Stack(int maxsize){
        this.top = -1;
        this.maxSize = maxsize;
        this.stackArray = new int[this.maxSize];
        
    }

    public void push(int item){
        this.stackArray[++this.top] = item; 
    }

    public int pop() throws ArrayIndexOutOfBoundsException{
        return this.stackArray[this.top--];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public boolean isFull(){
        return this.top == this.maxSize - 1 ;
    }

    private int maxSize;
    private int[] stackArray;
    private int top;
}
