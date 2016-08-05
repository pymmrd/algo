/**
* Author:zougang
* Date:2016/08/05
* Email:b.zougang@gmail.com
* 基于有序链表实现的优先级队列
* 实现功能:
*   1. 入队列 算法复杂度O(n)
*   2. 出队列   算法复杂度O(1)
*/

public class LinkPriorityQApp{
    public static void main(String[] args){
        PriorityQueue pq = new PriorityQueue();
        pq.insert(1);
        pq.insert(3);
        pq.insert(6);
        pq.insert(4);
        pq.insert(5);
        pq.insert(9);
        pq.insert(8);
        while (!pq.isEmpty()){
            System.out.print("{" + pq.remove().iData + "}");
        }
    }
}

class PriorityQueue{
    public SortedLinkList sll;

    public PriorityQueue(){
        this.sll = new SortedLinkList();
    }

    /* 出队列 */
    public void insert(int d){
        this.sll.insert(d);
    }

    public boolean isEmpty(){
        return this.sll.isEmpty();
    }

    public Link remove(){
        return this.sll.deleteFirst();
    }
}

/* 链表结点实现 */
class Link{ 
    public int iData;
    public Link next = null;

    /* 构造函数 */
    public Link(int d){
        this.iData = d;
    }

    /* 显示结点数据 */
    public void displayLink(){
        System.out.print("Link:{"+this.iData+"} ");
    }
}

/* 链表实现 */
class SortedLinkList{
    public Link first;

    /* 构造函数 */
    public SortedLinkList(){
        this.first = null;
    }

    /* 插入数据 */
    public void insert(int d){
        Link previous = null;
        Link current = this.first;
        while (current != null && d > current.iData){
            previous = current;
            current = current.next;
        }
        Link link = new Link(d);
        if (previous == null){
            this.first = link;
        }else{
            previous.next = link;
        }
        link.next = current;
    }

    /* 删除头结点数据 */
    public Link deleteFirst(){
        Link temp = this.first;
        if(this.first != null){
            this.first = this.first.next;
        }
        return temp;
    }

    /* 判断是否为空链表 */
    public boolean isEmpty(){
        return this.first == null;
    }

    /* 显示链表元素 */
    public void displayList(){
        Link current = this.first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }
}

