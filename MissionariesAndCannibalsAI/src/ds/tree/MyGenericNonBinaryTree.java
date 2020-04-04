/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds.tree;
import missionariesandcannibalsai.*;

/**
 *
 * @author I-TECH
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Created by aelaf on 5/5/18.
 *uses MyGenericQueue<E> class as aggregate
 */

public class MyGenericNonBinaryTree<E> {
   private TreeNode<E> root;
   private TreeNode<E> goal;
    private MyGenericQueue<TreeNode<E>> myGenericQueue;
    public MyGenericNonBinaryTree() {
        this.root = new TreeNode<>();
        root.parent = null;
        root.children = new ArrayList<>();
        myGenericQueue = new MyGenericQueue<>();
    }

    public class TreeNode<E>{
        TreeNode<E> parent;
        E data;
        List<TreeNode<E>> children;

        public String getData(){
            return "" + data;
        }
        
        @Override
        public String toString() {
            return  "data=" + data ;
        }
    }

    public void createTreeBFSWay(){
        //System.out.println("type the root node");
        //String scannerRootData = new Scanner(System.in).next();
        //root.data = (E)scannerRootData;
        VectorOp initState = new VectorOp(3,3,1,0,0,0);
        int add = -1;
        VectorOp[] act = {new VectorOp(1,0,1,0,0,0), new VectorOp(2,0,1,0,0,0),
            new VectorOp(0,1,1,0,0,0), new VectorOp(0,2,1,0,0,0), new VectorOp(1,1,1,0,0,0)};
        
        root.data = (E)initState;
        root.parent = null;
        
        //VectorOp currState = initState;
        //VectorOp child = new VectorOp(-1,-1,-1);

        final int MaxSuccessor = 5;
        //int depth = 1;
        //enqeuing the root element
        myGenericQueue.enqueue(root);
        while(myGenericQueue.getSize()!=0){  
            TreeNode<E> dequeuedTreeNode = myGenericQueue.dequeue();
            VectorOp currState = (VectorOp)dequeuedTreeNode.data;
            
            int miss = currState.getMissionaries();
            int cann = currState.getCannibals();
            int boat = currState.getBoat();
            int missA = currState.getMissionariesAcross();
            int cannA = currState.getCannibalsAcross();
            int boatA = currState.getBoatAcross();
            if(currState.isGoal()){
                goal = dequeuedTreeNode;
                break;
            }
            //System.out.println(child.toString());
            for(int count = 0; count < MaxSuccessor; count++){
                VectorOp child = new VectorOp(miss, cann, boat, missA, cannA, boatA);
                //System.out.println(count);
                //System.out.println(currState.toString());
                //System.out.println(child.toString());
                //System.out.println(act[count].toString());
                if(add == 1){
                    child.addVec(act[count]);
                }
                else{
                    child.subVec(act[count]);
                }
                if(child.isValid()){
                    //System.out.println(child.toString());
                    TreeNode<E> childTreeNode = new TreeNode<>();
                    childTreeNode.data = (E)child;
                    childTreeNode.parent = dequeuedTreeNode;
                    childTreeNode.children = new ArrayList<>();
                    dequeuedTreeNode.children.add(childTreeNode);
                    myGenericQueue.enqueue(childTreeNode);
                }
            }
            if(dequeuedTreeNode.children.isEmpty()){
                //System.out.println("Changed Depth!");
                //depth++;
                //System.out.println(depth);
                if(add == 1)
                    add = -1;
                else
                    add = 1;
            }
        }

    }
    public String[] readTreeBFSWay(){
        ArrayList<String> elements = new ArrayList<>();
        elements.clear();
        myGenericQueue.enqueue(root);
        System.out.println(myGenericQueue.getSize());

        while(myGenericQueue.getSize()!=0){
            TreeNode<E> ptrQeueue = myGenericQueue.dequeue();
            elements.add(ptrQeueue.data.toString());
            for (TreeNode<E> child:
                 ptrQeueue.children) {
                myGenericQueue.enqueue(child);
            }
        }
        String[] ele = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            ele[i]= elements.get(i);
        }
       return ele;
    }
    public void printPath(){
        ArrayList<VectorOp> arr = new ArrayList<VectorOp>();
        int i=0;
        while(goal.parent!=null){
            arr.add((VectorOp)goal.data);
            //System.out.println(goal);
            goal = goal.parent;
            i++;
        }
        //System.out.println(goal);
        arr.add((VectorOp)root.data);
        Collections.reverse(arr);
        System.out.println("Creating search tree using Breadth-first method.");
        System.out.println("Representation Format: MCBMCB");
        System.out.println("(where M = missionaries, C = cannibals, B = the boat,");
        System.out.println("first three numbers represent left bank, rest the right)");
        System.out.println("Starting position: 331000");
        System.out.println(arr);
        System.out.println("Path length: "+arr.size());
    }
    
    /* public static void main(String[] args) {
        MyGenericNonBinaryTree<String> myTree = new MyGenericNonBinaryTree<>();
        myTree.createTreeBFSWay();
        //System.out.println(Arrays.toString(myTree.readTreeBFSWay()));
        myTree.printPath();
    } */
}
