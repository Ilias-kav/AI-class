/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package missionariesandcannibalsai;

import ds.tree.*;

import java.util.Arrays;

/**
 *
 * @author I-TECH
 */
public class MissionariesAndCannibalsAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyGenericNonBinaryTree<String> myTree = new MyGenericNonBinaryTree<String>();
        myTree.createTreeBFSWay();
        //System.out.println(Arrays.toString(myTree.readTreeBFSWay()));
        myTree.printPath();
    }
	
    
}
