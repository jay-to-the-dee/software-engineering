/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package classification;

//package classification;

/**
 *
 * @author Main User
 */
public class Node {
    private Node parent;
    public Node[] children;
    private double entropy;
    private ExampleSet data;
    
    private String label;
    
    public Node(ExampleSet set,String label){
    data=set;
    this.label=label;
    }

    public Node getParent() {
        return parent;
    }

    public double getEntropy() {
        return entropy;
    }

    public String getLabel() {
        return label;
    }

    public void setChildren(Node[] children) {
        this.children = children;
    }

    public void setEntropy(double entropy) {
        this.entropy = entropy;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
    
