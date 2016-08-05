/**
* Author:zougang
* Date:2016/08/04
* Email:b.zougang@gmail.com
* 双端队列, 基于双向列表实现的双端队列
*     1. 从头部插入结点  算法复杂度O(1)
*     2. 从尾部插入结点  算法复杂度O(1)
*     3. 从头部删除结点  算法复杂度O(1)
*     4. 从尾部删除结点  算法复杂度O(1)
*     5. 从头开始遍历结点   算法复杂度O(n)
*     6. 从尾部开始遍历结点 算法复杂度O(n)
*/



public class DoubleEndQueueApp{
    public static void main(String[] args){
        /*DoublyLinked dl = new DoublyLinked();
        dl.insertFirst(1);
        */
        DoubleEndQueue deq = new DoubleEndQueue();
        deq.leftInsert(1);

        deq.rightInsert(10);
        deq.leftInsert(11);
        deq.rightInsert(9);
        while(!deq.isEmpty()){
            deq.leftRemove().displayLink();
        }
    }
}

class DoubleEndQueue{

    public DoublyLinked dl;

    public DoubleEndQueue(){
        this.dl = new DoublyLinked();
    }

    public void leftInsert(int d){
        this.dl.insertFirst(d);
    }

    public Link leftRemove(){
        return this.dl.deleteFirst();
    }

    public void rightInsert(int d){
        this.dl.insertLast(d);
    }

    public Link rightRemove(){
        return dl.deleteLast();
    }

    public boolean isEmpty(){
        return dl.isEmpty();
    }

}


/* 链表结点实现 */
class Link{
    public int dData;
    public Link next;
    public Link previous;

    /* 构造函数 */
    public Link(int d){
        this.dData = d;
        this.next = null;
        this.previous = null;
    }

    /* 显示结点数据 */
    public void displayLink(){
        System.out.print("Link:{"+this.dData+"} ");
    }
}


/* 双向链表实现 */
class DoublyLinked{
    public Link first;
    public Link last;

    /* 构造函数 */
    public DoublyLinked(){
        this.first = null;
        this.last = null;
    }

    /* 从链表头部插入 */
    public void insertFirst(int d){
        Link newLink = new Link(d);
        if (this.isEmpty()){
            this.last = newLink; 
        }else{
            this.first.previous = newLink;
        }
        newLink.next = this.first;
        this.first = newLink;
    }

    /* 从链表尾部插入 */
    public void insertLast(int d){
        Link newLink = new Link(d);
        if (this.isEmpty()){
            this.first = newLink;
        }else{
            newLink.previous = this.last;
            this.last.next = newLink;
        }
        this.last = newLink;
    }


    /* 从特定位置插入 */
    public boolean insertAfter(int key, int d){
        Link current = this.first;
        while (current.dData != key){
            current = current.next;
            if (current == null){
                return false;
            }
        }
        Link newLink = new Link(d);
        if (current == this.last){
            this.last = newLink;
        }else{
             current.next.previous = newLink;
             newLink.next = current.next; 
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }
    

    /* 从链表头部删除 */
    public Link deleteFirst(){
        Link temp = this.first;
        if (this.first.next == null){
            this.last = null;
        }else{
            this.first.next.previous = null;
        }
        this.first = this.first.next;
        return temp;
    }

    /* 从链表尾部删除 */
    public Link deleteLast(){
        Link temp = this.last;
        if (this.first.next == null){
            this.first = null;
        }else{
            this.last.previous.next = null;
        }
        this.last = this.last.previous;
        return temp;
    }

    /* 删除某个特定结点 */
    public Link deleteKey(int key){
        Link current = this.first;
        while (current.dData != key){
            current = current.next;
            if(current == null){
                return current;
            }
        }
        //隐含当结点引用计数为0零,整个结点
        //对象都会销毁.
        if (current == this.first){
            this.first = current.next;
        }else{
            current.next.previous = current.previous;;
        }
        if (current == this.last){
            this.last = current.previous;
        }else{
            current.previous.next = current.next;
        }
        return current; 
    }

    /* 向前显示链表元素 */
    public void displayFoward(){
        Link current = this.first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }

    /* 向后显示链表元素 */
    public void displayBackward(){
        Link current = this.last;
        while (current  != null){
            current.displayLink();
            current = current.previous;
        }
        System.out.println("");
    }

    /* 是否为空链表 */
    public boolean isEmpty(){
        return this.first == null;
    }
}
