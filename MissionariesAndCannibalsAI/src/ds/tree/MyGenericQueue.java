/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.tree;

/**
 *
 * @author I-TECH
 */
import java.util.Arrays;

/**
 * Created by aelaf on 5/5/18.
 * uses MyGenericSinglyLinkedList class using adapter pattern
 */

public class MyGenericQueue<E> {
    private MyGenericSinglyLinkedList<E> mylist;

    public MyGenericQueue() {
        this.mylist = new MyGenericSinglyLinkedList<E>();
    }
    public void enqueue(E element){
        mylist.addTail(element);
    }
    public E dequeue(){
        return mylist.removeHead().data;
    }
    public int getSize(){
        return mylist.size;
    }
public E[] getAllElements(){
    return  mylist.getAllElements();
}
    /*public static void main(String[] args) {
        MyGenericQueue<String> myQueue = new MyGenericQueue<>();
        myQueue.enqueue("1");
        myQueue.enqueue("2");
        myQueue.enqueue("3");
        System.out.println("removing elements "+myQueue.dequeue());
        System.out.println(Arrays.toString(myQueue.getAllElements()));

    }*/
}
