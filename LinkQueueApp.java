/**
* Author:zougang
* Date:2016/08/03
* Email:b.zougang@gmail.com
* 通过双端链表来实现队列, 主要使用了双端链表尾部插入和头部删除
* 的特性来模拟队列的进出.
* 实现功能:
*  1. 进队列
*  2. 出队列
*  3. 队列是否为空
*/
public class LinkQueueApp{
    public static void main(String[] args){
        Queue q = new Queue();
        q.insert(1);
        q.insert(2);
        q.insert(3);
        q.insert(4);
        q.insert(5);
        q.insert(6);
        while (!q.isEmpty()){
            Link link = q.remove();
            System.out.println("Queue pop" + link.iData);
        }

    }
}

/* 队列 */
class Queue{

    DoubleEndLinkList aList;

    public Queue(){
        this.aList = new DoubleEndLinkList();
    }

    /* 进队列 */
    public void insert(int d){
        this.aList.insertLast(d);
        System.out.println("Queue in: " + d);
    }

    /* 出队列 */
    public Link remove(){
        if (!this.isEmpty()){
            return this.aList.deleteFirst();
        }else{
            System.out.println("Queue is empty");
            return null;
        }
    }

    /* 队列是否为空*/
    public boolean isEmpty(){
        return this.aList.isEmpty();
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


/* 双端链表 */
class DoubleEndLinkList{
    public Link first;
    public Link last;

    /* 构造函数 */
    public DoubleEndLinkList(){
        this.first = null;
        this.last = null;
    }

    /* 在头结点插入数据 */
    public void insertFirst(int d){
        Link link = new Link(d);
        link.next = this.first;
        if (this.isEmpty()){
            this.last = link;
        }
        this.first = link;
    }

    /* 在尾部插入数据 */
    public void insertLast(int d){
        Link link = new Link(d);
        if (this.isEmpty()){
            this.first = link;
        }else{
            this.last.next = link;
        }
        this.last = link;
    }

    /* 删除头结点数据 */
    public Link deleteFirst(){
        Link temp = this.first;
        if(this.first == null){
            this.last = null;
        }else{
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

