
package classification;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


 /**
 * ExampleSet: class for representing set of train or test examples (labelled instances). 
 * Methods provided for reading data from file, extracting feature information, deriving
 * subsets of the data set.
 * @author billk
 * @version Februray 2013
 */

public class ExampleSet {
	
	private static String[] features;
	private static String[] labels;
	private HashMap<String,HashSet<String>> values;
	private ArrayList<Instance> examples;
	private int size;
        private static List<ExampleSet> list = new LinkedList<>();
	
	
	/**
	 * Construct an initially empty set of examples structured around the given features and labels
	 * @param features a set of feature names
	 * @param labels a set of instance labels
	 */
	public ExampleSet(String[] features, String[] labels) {
		this.features = features;
		this.labels = labels;
                
		examples = new ArrayList<Instance>();
		values = new HashMap<String,HashSet<String>>();
		size = 0;
	}
	
	/**
	 * Build a set of examples from a file. Assumes that examples in file are stored one per line, in 
	 * comma separated format. Also assumes that two lines of information precede the data proper: 
	 * the first must be a list of the feature names (comma-separated format) and the second must be 
	 * a list of the possible labels (comma-separated format). Any blank lines are ignored.
	 * @param file the name of the file to read data from
	 * @return a set of examples.
	 */
	public static List<ExampleSet> getData(String file) {
		FileIO in = new FileIO("r", file);
		String[] features = readCommaSeparatedValues(in);
		String[] labels = readCommaSeparatedValues(in);
                
		ExampleSet dataTrain = new ExampleSet(features, labels);
                ExampleSet dataTest = new ExampleSet(features, labels);
                
		String[] example;
                Random randomGenerator = new Random();
                randomGenerator.nextInt(100);
		while ((example = readCommaSeparatedValues(in)) != null) {
                    if (randomGenerator.nextInt(100)<101){
			dataTrain.addValues(example);
			Instance instance = new Instance(features, example);
			dataTrain.addExample(instance);
                    }
                    else {
                        dataTest.addValues(example);
			Instance instance = new Instance(features, example);
			dataTest.addExample(instance);
                    }
		}
                list.add(dataTrain);
                list.add(dataTest);
		return list;	
	}
	
	
	public void addValues(String[] example) {
		for( int i=0; i<features.length; i++ ) {
			addValue(features[i], example[i]);
		}
	}

	private void addValue(String f, String v) {
		if (values.get(f) == null) {
			values.put(f, new HashSet<String>());
		}
		values.get(f).add(v);		
	}

	private static String[] readCommaSeparatedValues(FileIO in) {
		String line, empty="";
		while (empty.equals(line = in.readLine()));	
		return (line == null) ? null : line.replaceAll(" ", "").split(",");
	}
	
	public void addExample(Instance instance) {
		examples.add(instance);
		size++;
	}
	public void changeValues(HashMap values){
            this.values=values;
        }
	/**
	 * Get all of the examples meeting the condition that feature = value
	 * @param feature the name of the feature
	 * @param value the value the feature must have
	 * @return a subset of the examples
	 */
	public ExampleSet getExamples(String feature, String value) {
		ExampleSet data = new ExampleSet(features, labels);
		for (Instance instance : examples) {
			if (instance.contains(feature, value)) {
				data.addExample(instance);
			}
		}
		return data;
	}
        //return the damn instances
        public List<Instance> getExamples(){
            return examples;
        }
	
	/**
	 * Get all of the examples having the specified label
	 * @param label the label
	 * @return a subset of the examples
	 */
	public ExampleSet getExamples(String label) {
		ExampleSet data = new ExampleSet(features, labels);
		for (Instance instance : examples) {
			if (instance.hasLabel(label)) {
				data.addExample(instance);
			}
		}
		return data;
	}
	//entropy is measured as the most popular class label in the set divided
        //by the total size of the set
        //returns the probability of the most prominent label
        public double calculateEntropyIsh(){
            //get all the labels
            //value array used to find most popular label
            int[] count =new int[labels.length];
            for(int k=0;k<count.length;k++){
                count[k]=0;
            }
            for (Instance i:getExamples()){
                
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
            String mostPopularFeature="";
            for (int l=0;l<count.length;l++){
                if(mostPopularLabelValue<count[l]){
                    mostPopularLabelValue=count[l];
                    mostPopularLabelIndex=l;
                    mostPopularFeature=features[mostPopularLabelIndex];
                }
            }
            //calculate entropy for one class
            //double entropy=0;
            Logarithm l = new Logarithm();
            /*for (int m=0;m<count.length;m++){
                System.out.println("-------");
                System.out.println(count[m]/examples.size());
                System.out.println(l.log2(count[m]/examples.size()));
                entropy =+count[m]/examples.size()*l.log2(count[m]/examples.size());
            }*/
            System.out.print("most popular label value: ");
            System.out.println(mostPopularLabelValue);
            System.out.println("size: "+examples.size());
            System.out.print("most pop feature: ");
            System.out.println(mostPopularFeature);
            System.out.print("result: ");
            double f = mostPopularLabelValue/(double)examples.size();
            System.out.println(f);
            //System.out.println(l.log2(mostPopularLabelValue));///examples.size()));
            System.out.println("----------");
            return -f*l.log2(f);//*l.log2(mostPopularLabelValue/examples.size());
    }
        
	/**
	 * Get the feature names
	 * @return an array of String objects representing the features, in order.
	 */
	public String[] getFeatures() {
		return features;
	}
	/**
	 * Get the labels
	 * @return an array of String objects representing the labels
	 */
	public String[] getLabels() {
		return labels;
	}
	
	/**
	 * Get the size of the data
	 * @return integer number of examples in data set
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Get the sets of values associated with the different features
	 * @return a map from feature names to sets of values
	 */
	public HashMap<String, HashSet<String>> getValues() {
		return values;
	}
	
	
}
