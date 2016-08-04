/**
* Author:zougang
* Date:2016/08/02
* Email:b.zougang@gmail.com
* 有序链表, 保证数据在插入有序性, 可以用来实现优先级队列
* 实现功能:
*   1. 有序的插入数据 算法复杂度O(n)
*   2. 删除头部元素   算法复杂度O(1)
*/

public class SortedLinkListApp{
    public static void main(String[] args){
        SortedLinkList ll = new SortedLinkList();
        ll.insert(1);
        ll.insert(3);
        ll.insert(6);
        ll.insert(4);
        ll.insert(5);
        ll.insert(9);
        ll.insert(8);
        ll.displayList();
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

