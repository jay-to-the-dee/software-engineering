package classification;


import java.util.HashMap;


/**
 * Instance represent a (labelled) data instance. 
 * 
 * @author billk
 * @version February 2013
 */
public class Instance {
	
	private HashMap<String,String> instance;
	private String label;
	
	/**
	 * Construct an instance object using the specified features and values. Note that the value array should 
	 * have length one greater than the features array. This is because the final element of the values array
	 * is treated as the label.
	 * @param features the feature names, in order.
	 * @param values the feature values, in order, followed by the instance label
	 */
	public Instance(String[] features, String[] values) {
		instance = new HashMap<String,String>();
		if (features.length != values.length-1) {
			System.out.println("Inconsistent numbers of features and values!");
		} else {
			for (int i=0; i<features.length; i++) {
				instance.put(features[i], values[i]);
			}
		}
		this.label = values[values.length-1];
	}
        
	/**
	 * Check that a instance contains a particular feature and value combination
	 * @param feature the feature name
	 * @param value the value
	 * @return true if feature=value and false otherwise
	 */
	public boolean contains(String feature, String value) {
		return instance.get(feature).equals(value);
	}

	
	/**
	 * Check whether an instance has a particular label
	 * @param label the label to check
	 * @return true if the instance has the given label and false otherwise.
	 */
	public boolean hasLabel(String label) {
		return this.label.equals(label);
	}
	
	

}
