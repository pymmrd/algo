/**
* Author:zougang
* Date:2016/08/04
* Email:b.zougang@gmail.com
* 双向链表: 允许向前遍历, 也允许向后遍历整个链表.其中秘密在于
* 每个链结点有两个指向其它结点的应用,而不是一个. 第一个像普通
* 链表一样指向下一个链结点.第二个指向前以个连结点.
* 缺点:每次插入或删除一个链结点的时候,要处理四个链结点的应用,
* 而不是两个: 两个连接前以个链结点,两个连接后一个链结点.
* 实现功能: 
*     1. 从头部插入结点  算法复杂度O(1)
*     2. 从尾部插入结点  算法复杂度O(1)
*     3. 从某个特定的元素后插入结点 算法复杂度O(n)
*     4. 从头部删除结点  算法复杂度O(1)
*     5. 从尾部删除结点  算法复杂度O(1)
*     6. 删除某个特定的结点 算法复杂度O(n)
*     7. 从头开始遍历结点   算法复杂度O(n)
*     8. 从尾部开始遍历结点 算法复杂度O(n)
*/

public class DoublyLinkedApp{
    public static void main(String[] args){
        DoublyLinked dl = new DoublyLinked();
        dl.insertFirst(1);
        dl.insertLast(10);
        dl.insertFirst(11);
        dl.displayFoward();
        dl.displayBackward();
        dl.insertAfter(1, 3);
        dl.displayFoward();
        dl.deleteKey(1);
        dl.displayFoward();
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
            this.first = this.first.next;
        }
        return temp;
    }

    /* 从链表尾部删除 */
    public Link deleteLast(){
        Link temp = this.last;
        if (this.first.next == null){
            this.last = null;
        }else{
            this.last.previous.next = null;
            this.last = this.last.previous;
        }
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
