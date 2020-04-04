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
 */

public class MyGenericSinglyLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;
    public MyGenericSinglyLinkedList() {
        head = tail;
        tail = head;
        size = 0;
    }
    public Node<E> removeHead(){
        if(size==0)
            return null;
        else{
            Node<E> removedNode = head;
            head = head.next;
            size--;
            return removedNode;
        }

    }
    public E[] getAllElements(){

       E[] allNodes = (E[])new Object[size];
        Node<E> ptr = head;

        for (int i = 0; i < size; i++) {
            allNodes[i]= ptr.data;
            ptr = ptr.next;
        }
        return allNodes;
    }
public void addTail(E element){
    Node<E> newNode = new Node<>();
    newNode.data = element;
    if(size==0){
        head = newNode;
        tail=newNode;
    }
    else{
        tail.next = newNode;
        tail = newNode;
    }
    size++;
}
    class Node<E>{
        E data;
       Node<E> next;

        @Override
        public String toString() {
            return ""+data;
        }
    }

    /*public static void main(String[] args) {
        MyGenericSinglyLinkedList<String> myLinkedList = new MyGenericSinglyLinkedList<>();
        myLinkedList.addTail("aelaf");
        myLinkedList.addTail("dave");
        myLinkedList.addTail("negash");

        System.out.println("removed head> "+myLinkedList.removeHead());
        System.out.println(myLinkedList.size+" <>  "+Arrays.toString(myLinkedList.getAllElements()));
    }*/
}
