/*
* Author:zougang
* Date:2016/08/01
* Email:b.zougang@gmail.com
* 数组实现优先级队列
*/

public class QueueX{
    public static void main(String[] args){
        Queue q1 = new Queue(5);
        q1.insert(1);
        q1.insert(2);
        q1.insert(3);
        q1.insert(4);
        q1.insert(5);
        q1.insert(6);
    }
}

class Queue{
    private int rear; //队列尾部
    private int front;  //对列头部
    private int [] qArray; //数组实现队列
    private int maxSize; //队列的长度
    private int nItems; //队列中实际元素个数

    public Queue(int maxSize){
        this.rear = 0;
        this.front = 0;
        this.qArray = new int[maxSize];
        this.maxSize = maxSize;
        this.nItems = 0;
    }

    /* 入队列 */
    public void insert(int item){
        if (this.rear == this.maxSize){
            this.rear = 0;
        }
        this.qArray[this.rear++] = item;
        this.nItems++;
    }

    /* 出队列 */
    public int remove(){
        if (this.front == this.maxSize){
            this.front = 0;
        }
        this.nItems--;
        int temp = this.qArray[this.front++];
        return temp;
    }

    /* 队列是否为空 */
    public void isEmpty(){
        return this.nItems == 0;
    }

    /* 队列是否已满 */
    public void isFull(){
        return this.nItems == this.maxSize;
    }
}
