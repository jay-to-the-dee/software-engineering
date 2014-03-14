
package classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Main User
 * using a modified id3 algorithm
 */
public class DecisionTreeClassifier {
    
    public DecisionTreeClassifier(){
        
    }
    
    public Class getLabel(DecisionTree tree, Instance instance){
        return null;
    }
    
    public Node growTree(ExampleSet set, List<String> features, double purity){
        if (isHomogeneous(set,purity)||features.isEmpty()){
            
            return new LeafNode(set,"sdf");
        //
        }
        //get best feature to split tree on
        String purestFeature = bestSplit(set,features);
        //split tree according to purestFeature
        List<ExampleSet> l = partition(set,purestFeature);
        
        features.remove(purestFeature);
        for(ExampleSet s:l){
            growTree(s,features,purity);
        }
        return new Node(set,"asdf");
    }
    
    
    
     public List<ExampleSet> partition(ExampleSet set, String x){
         List<ExampleSet> list = new ArrayList<>();
            //get all the values of feature x
            HashSet<String> vals = set.getValues().get(x);
            for (String v:vals){
                //split data according to values of feature x
                ExampleSet values = set.getExamples(x,v);
                values.changeValues(set.getValues());
                list.add(values);
            }
        return list;
     }
     //returns best feature
    public String bestSplit(ExampleSet set, List<String> features){
        double entropy = 1;
        //ExampleSet bestSplit = new ExampleSet(set.getFeatures(),set.getLabels());
        String bestSplit = new String();
        //go trough all features to find one with best thingy
        HashMap<String,Double> entropyResults= new HashMap<>();
        for (String f:features){
            //get al instances of current feature values and split them 
            //up according to values
            HashSet<String> vals = new HashSet<>(set.getValues().get(f));
            List<ExampleSet> list = new ArrayList<>();
            
            for (String s:vals){
                //create sets for all and add values to it that have the specified
                // value
                ExampleSet values = set.getExamples(f,s);
                
                list.add(values);
            }
            ///////////////////////////////////////
            double value=0.0;
            //calculate entropy for cuttent split
            for (ExampleSet e:list){
                if(e.size()>0){
                value+=e.calculateEntropyIsh();
                }
                System.out.println(value);
            }
            System.out.println(vals.size());
            value=value/vals.size();
            entropyResults.put(f, value);
            //System.out.println("asdfa"+value);
        }
        for (Map.Entry entry : entropyResults.entrySet()) {
            //with only one feature entropy does not get updated
            if((double)entry.getValue()<entropy){
                entropy=(double)entry.getValue();
                bestSplit=(String)entry.getKey();
                System.out.println("aaaaaaaaaaaaaaa "+entropy);
            }
        }
        System.out.println("best split: "+bestSplit);
        return bestSplit;
    }
    
    public boolean isHomogeneous(ExampleSet set,double purity){
        String[] labels = set.getLabels();
            int[] count =new int[labels.length];
            for(int k=0;k<count.length;k++){
                count[k]=0;
            }
            for (Instance i:set.getExamples()){
                for(int j=0;j<labels.length;j++){
                    if (i.hasLabel(labels[j])){
                    count[j]+=1;
                    //System.out.println(labels[j]);
                    break;
                    }
                }
            }
            int mostPopularLabelValue=0;
            int mostPopularLabelIndex=-1;
            for (int l=0;l<count.length;l++){
                if(mostPopularLabelValue<count[l]){
                    mostPopularLabelValue=count[l];
                    mostPopularLabelIndex=l;
                }
            }
            Logarithm l = new Logarithm();
        return -mostPopularLabelValue/(double)set.size()*l.log2(mostPopularLabelValue/(double)set.size())<=purity;
    }
    
    public float testClassifier(DecisionTree tree, ExampleSet testData){
        return 0;
    }
    
    
    
    public float calculatePrecision(DecisionTreeClassifier classifier, ExampleSet data){
        return 0;
}
    
    public float claculateRecall(DecisionTreeClassifier classifier, ExampleSet data){
        return 0;
    }
}