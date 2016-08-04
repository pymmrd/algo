/**
* Author:zougang
* Date:2016/08/02
* Email:zougang@nagain.com
* 单链表
* 实现功能如下:
*  1. 在链表头插入数据项 insertFirst函数 算法复杂度O(1)
*  2. 在链表头删除数据项 deleteFirst函数 算法复杂度O(1) 
*  3. 遍历链表显示它的内容 displayLinkList函数
*  4. 找到特定的链表结点 find函数  算法复杂度O(n)
*  5. 删除特定的链表结点 delete函数 算法复杂度O(n)
*  6. 在链表某个特定结点后插入新结点 insertAfter函数 算法复杂度O(n)
*/

public class LinkListApp{
    public static void main(String[] args){
        LinkList ll = new LinkList();
        ll.insertFirst(1, 1.0);
        ll.insertFirst(2, 2.0);
        ll.insertFirst(3, 3.0);
        ll.insertFirst(4, 4.0);
        ll.insertFirst(5, 5.0);
        ll.insertFirst(6, 6.0);
        ll.insertAfter(5, 10, 10.0);
        ll.displayList();
        Link f = ll.find(5);
        if (f != null){
            System.out.println("Found link with key " + f.iData);
        }else{
            System.out.println("Can't find link");
        }
        Link d = ll.delete(7);
        if( d != null){
            System.out.println("Deleted link with key " + d.iData);
        }else{
            System.out.println("Can't delete link");
        }
        while(!ll.isEmpty()){
            Link alink = ll.deleteFirst();
            System.out.print("Deleted ");
            alink.displayLink();
            System.out.println("");
        }
    }
}

class Link{
    public int iData;
    public double dData;
    public Link next = null ;     //链表下一个结点

    public Link(int id, double dd){
        this.iData = id;
        this.dData = dd;
    }

    public void displayLink(){
        System.out.print("{" + this.iData + ", " + this.dData + "} ");
    }
}

class LinkList{
    private Link first;

    public LinkList(){
        this.first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id, double dd){
    /*
    从链表头部插入
    */
        Link newLink = new Link(id, dd);
        newLink.next = this.first;
        this.first = newLink;
    }

    public Link deleteFirst(){
    /*
    删除头结点
    */
        Link temp = null;
        if (!this.isEmpty()){
            temp = first;
            first = first.next;
        }
        return temp;
    }

    public Link find(int key){
    /*找到特定key值结点
    */
        Link current = first;
        while(current.iData != key){
            if (current.next == null){
                return null;
            }else{
                current = current.next;
            }
        }
        return current;
    }
    
    public Link delete(int key){
    /* 删除特定key值结点
    */
        Link prev = first;
        Link current = first;
        while (current.iData != key){
            if (current.next == null){
                return null;
            }else{
                prev = current;
                current = current.next;
            }
        }
        if (current == first){
            this.first = current.next;
        }else{
            prev.next = current.next;
        }
        return current;
    }

    public void insertAfter(int key, int iData, double dData){
    /*
    插入某个特定结点之后
    */
        Link current = this.find(key);
        if (current != null){
            Link newNode = new Link(iData, dData);
            Link oldNext = current.next;
            current.next = newNode;
            newNode.next = oldNext;
        }
    }

    public void displayList(){
    /*
    重头到尾遍历链表
    */
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
} 
