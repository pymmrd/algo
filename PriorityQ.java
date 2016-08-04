/*
* Author:zougang
* Date:2016/08/01
* Email:b.zougang@gmail.com
* 数组实现优先级队列
* 实现功能:
*  1. 队列插入
*  2. 出队列
*/

public class PriorityQ{
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue(5);
        pq.insert(1);
        pq.insert(2);
        pq.insert(10);
        pq.insert(8);
        pq.insert(7);
        pq.insert(9);
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}

class PriorityQueue{
    private int nItems;
    private int[] priArray;
    private int maxSize;


    public PriorityQueue(int maxSize){
        this.nItems = 0;
        this.priArray = new int[maxSize];
        this.maxSize = maxSize;
    }

    /* 元素插入到队列中 */
    public void insert(int item){
        //TODO 检查队列是否已满
        int j;
        if (!this.isFull()){
            for (j=this.nItems-1; j >=0; j--){
                if (item > this.priArray[j]){
                    this.priArray[j+1] = this.priArray[j];
                }else{
                    break;
                }
            }
            this.priArray[j+1] = item;
            this.nItems++;
            this.iter();
        }
    }
    
    /* 出队列  */
    public int remove(){
        //TODO 检查队列是否为空
        return this.priArray[--this.nItems];
    }

    public boolean isEmpty(){
        return this.nItems == 0;
    }

    public boolean isFull(){
        return this.nItems == maxSize;
    }
}
