/**
* Author:zougang
* Date:2016/08/02
* Email:b.zougang@gmail.com
* 双端链表, 与传统的链表非常相似,增加对最后一个连接点的引用,
* 就像对第一个连接点的应用一样
* 实现功能:
*   1. 在链表头部插入元素 insertFirst  算法复杂度O(1)
*   2. 在链表尾部插入元素 insertLast   算法复杂度O(1)
*   3. 删除链表头部元素   deleteFirst  算法复杂度O(1)
* 
*/
public class DoubleEndLinkListApp{
    public static void main(String[] args){
        DoubleEndLinkList dell = new DoubleEndLinkList();
        dell.insertLast(1);
        dell.insertLast(2);
        dell.insertLast(3);
        dell.insertLast(4);
        dell.insertLast(5);
        dell.insertLast(6);
        dell.insertFirst(7);
        dell.displayList();
    }
}

class Link{
    public long dData;
    public Link next = null;;

    public Link(long d){
        this.dData = d;
    }

    public void displayLink(){
        System.out.print(dData + " ");
    }
}

class DoubleEndLinkList{
    public Link first;
    public Link last;

    public DoubleEndLinkList(){
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public void insertFirst(long dd){
    /*
    从链表头部插入
    */
        Link newLink = new Link (dd);
        newLink.next = this.first;
        this.first = newLink;
        if (this.isEmpty()){
            //第一个插入的结点就是最后结点
            this.last = newLink;
        }
    }

    public void insertLast(long dd){
    /*
    从链表尾部插入
    */
        Link newLink = new Link (dd);
        if (isEmpty()){
            this.first = newLink;
        }else{
            this.last.next = newLink; //旧的last对象指向新结点
        }
        this.last = newLink; //新结点就是尾部结点
    }

    public long deleteFirst(){
    /*
    删除头部结点
    */
        long temp = first.dData;
        if(first.next == null){  //如果只有一个元素
            last = null; //最后的结点指向null
        }
        first = first.next; //指向删除结点的下一个结点
        return temp;
    }

    public void displayList(){
        System.out.print("List (first --> last):  ");
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}
