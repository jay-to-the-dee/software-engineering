package classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Test {

	private String file = "C://Users/Main User/Desktop/Classification/Report/DataSets/CarEvaluation/car.data.txt/";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Test t = new Test();
		t.run();
	}
	
	public Test() {

	}
	
	public void run() {
            List<ExampleSet> list = ExampleSet.getData(file);
            ArrayList<String> s = new ArrayList<String>();
            
		ExampleSet testData = list.get(0);
                ExampleSet trainData = list.get(1);
                for(String a:testData.getFeatures()){
                s.add(a);
            }
                DecisionTreeClassifier d = new DecisionTreeClassifier();
                System.out.println(d.growTree(testData, s, 0.35));
                //for (String g:testData.getLabels()){
                //System.out.println(g);
                //}
                
                //System.out.println(d.bestSplit(testData, Arrays.asList(testData.getFeatures())));
                
		String[] feats = testData.getFeatures();
		//System.out.println("\nfeatures:");
                //for (int i=0; i<feats.length; i++) System.out.println(feats[i]);
		//String[] labels = trainData.getLabels();
                
                //System.out.println("\nlabels: ");
		//for (int i=0; i<labels.length; i++ ) System.out.println(labels[i]);
                
		HashMap<String,HashSet<String>> values = testData.getValues();
		//for (String f : feats) {
		//	System.out.print(f + " : ");
		//	HashSet<String> vals = values.get(f);
		//	for (String v : vals) {
		//		System.out.print(v + ", ");
		//	}
		//	System.out.println();
		//}
                
                
                
                
                
                
                
		System.out.println(testData.size());
                
                //iterate over the test data 
                //Iterator it = testData.getValues().entrySet().iterator();
                
                //while (it.hasNext()) {
                //Map.Entry entry = (Map.Entry) it.next();
                //String key = (String)entry.getKey();
                //HashSet val = (HashSet)entry.getValue();
                //System.out.println("key,val: " + key + "," );
//}
                        
		//ExampleSet ex1 = testData.getExamples(labels[0]);
		//System.out.println(labels[0] + " : " + ex1.size());
		
	
		//ExampleSet ex2 = testData.getExamples(labels[1]);
		//System.out.println(labels[1] + " : " + ex2.size());
                
                //ExampleSet ex3 = testData.getExamples(labels[2]);
		//System.out.println(labels[2] + " : " + ex3.size());
                
                //ExampleSet ex4 = testData.getExamples(labels[3]);
		//System.out.println(labels[3] + " : " + ex4.size());
	}

}
