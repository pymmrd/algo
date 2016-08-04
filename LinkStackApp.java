/**
* Author:zougang
* Date:2016/08/03
* Email:b.zougang@gmail.com
* 通过链表来实现栈, 相比以数组实现栈的方式, 没有了最大空间限制, 可以最大扩展内存
* 实现功能
*   1. 数据入栈  算法复杂度O(1)
*   2. 数据从栈顶出战 算法复杂度O(1)
*   3. 栈是否为空
*/
public class LinkStackApp{
    public static void main(String[] args){
        LinkStack stack = new LinkStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while (!stack.isEmpty()){
            Link link = stack.pop();
            System.out.println("Stack Pop: " + link.iData);
        }
    }
}

class LinkStack{
    public LinkList aList;

    /* 构造函数 */
    public LinkStack(){
        this.aList = new LinkList();
    }

    /* 进栈 */
    public void push(int d){
        this.aList.insertFirst(d);
    }

    /* 出栈 */
    public Link pop(){
        if (!this.isEmpty()){
            return this.aList.deleteFirst();
        }else{
            System.out.println("Stack is empty");
            return null;
        }
    }

    /* 判断栈是否为空 */
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

/* 链表实现 */
class LinkList{
    public Link first;

    /* 构造函数 */
    public LinkList(){
        this.first = null;
    }

    /* 在头结点插入数据 */
    public void insertFirst(int d){
        Link link = new Link(d);
        link.next = this.first;
        this.first = link;
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
