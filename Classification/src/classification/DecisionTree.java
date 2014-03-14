/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classification;

import java.util.ArrayList;

/**
 *
 * @author Main User
 */
class DecisionTree {
    private Node rootNode;
    private Node childNode;
    
    public DecisionTree(Node rootData){
    //root = new Node(rootData.getLabel());
    rootNode = rootData;
    //root.children = new ArrayList<Node>();
    }
    
    public DecisionTree addChildNode(){
        return null;
    }
}