/*
* Author:zougang
* Date:2016/08/02
* Email:b.zougang@gmail.com
* 迭代器
*/

import java.io.*; 

public class IteratorApp{


    public static void main(String[] args) throws IOException {
        LinkList theList = new LinkList();
        ListIterator iter1 = theList.getIterator();
        long value;
        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(80);
        iter1.insertAfter(60);
        while (true){
            System.out.print("Enter first letter of show, reset, ");
            System.out.print("next. get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch(choice){
                case 's':
                    if(!theList.isEmpty()){
                        theList.displayList();
                    }else{
                        System.out.println("List is empty");
                    }
                    break;
                case 'r':
                    iter1.reset();
                    break;
                case 'n':
                    if (!theList.isEmpty() && !iter1.atEnd()){
                        iter1.nextLink();
                    }else{
                        System.out.println("Can't go to next link");
                    }
                    break;
                case 'g':
                    if (!theList.isEmpty()){
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned" + value);
                    }else{
                        System.out.println("List is Empty");
                    }
                        break;
                case 'b':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                case 'a':
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                case 'd':
                    if (!theList.isEmpty()){
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    }else{
                        System.out.println("Can't delete");
                    }
                    break;
                default:
                        System.out.println("Invaid Entry");

            }
        }
    }

    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }
}


class Link{
    public long dData;
    public Link next;
    
    public Link(long dd){
        this.dData = dd; 
    }

    public void displayLink(){
        System.out.print("{" + this.dData + "}");
    }
}

class LinkList{
    private Link first;

    public LinkList(){
        this.first = null;
    }

    public Link getFirst(){
        return this.first;
    }

    public void setFirst(Link f){
        this.first = f;
    }

    public boolean isEmpty(){
        return this.first == null;
    }

    public ListIterator getIterator(){
        return new ListIterator(this);
    }

    public void displayList(){
        Link current = this.first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println("");
    }
}

class ListIterator{
    private Link current;
    private Link previous;
    private LinkList ourList;

    public ListIterator(LinkList list){
        this.ourList = list;
        this.reset();
    }

    public void reset(){
        current = ourList.getFirst();
        this.previous = null;
    }
    
    public boolean atEnd(){
        return this.current.next == null;
    }

    public void nextLink(){
        this.previous = this.current;
        this.current = this.current.next;
    }

    public Link getCurrent(){
        return this.current;
    }

    public void insertAfter(long dd){
        Link newLink = new Link(dd);
        if (this.ourList.isEmpty()){
            this.ourList.setFirst(newLink);
            this.current = newLink;
        }else{
            newLink.next = this.current.next;
            this.current.next = newLink;
            this.nextLink();
        }
    }

    public void insertBefore(long dd){
        Link newLink = new Link(dd);
        if (this.previous == null){
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        }else{
            newLink.next = this.previous.next;
            this.previous.next = newLink;
            this.current = newLink;
        }
    }

    public long deleteCurrent(){
        long value = current.dData;
        if (previous == null){ //链表开头
            ourList.setFirst(current.next);
            reset();
        }else{
            this.previous.next = this.current.next;
            if (atEnd()){
                reset();
            }else{
                this.current = current.next;
            }
        }
        return value;
    }
}

