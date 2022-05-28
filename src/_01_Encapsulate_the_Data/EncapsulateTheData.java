package _01_Encapsulate_the_Data;

public class EncapsulateTheData {

    /*
     * itemsReceived cannot be negative. All negative parameters should set
     * itemsReceived to 0.
     */
	protected int itemsReceived;
	public int setItemsReceived(int num) {
		if(num>0) {
			itemsReceived = num;
		}
		return itemsReceived;
	}
	public int getItemsReceived() {
		
		return itemsReceived;
	}

    /*
     * degreesTurned must be locked between 0.0 and 360.0 inclusive. All
     * parameters outside this range should set degreesTurned to the nearest
     * bound.
     */

	protected double degreesTurned;
	public double setDegreesTurned(double num) {
    	if(num>0 && num<360) {
    		degreesTurned = num;
    	}
    	else if(num<0){
    		degreesTurned = 0;
    	}
    	else {
    		degreesTurned = 360.0;
    	}
    	return degreesTurned;
    }
    public double getDegreesTurned() {
    	return degreesTurned;
    }

    /*
     * nomenclature must not contain an empty String. An empty String parameter
     * should set nomenclature to a String with a single space.
     */

    protected String nomenclature = "";
    public String setNomenclature(String nom) {
    	if(nom.length() != 0) {
    		nomenclature = nom;
    	}
    	else {
    		nomenclature = " ";
    	}
    	return nomenclature;
    }
    public String getNomenclature() {
    	return nomenclature;
    }

    /*
     * memberObj must not be a String. A String parameter should set memberObj
     * to a new Object(); Hint: Use the instanceof operator.
     */

    protected Object memberObj;
    public Object setMemberObj(Object randomObject) {
    	if(randomObject instanceof String) {
    		memberObj = new Object();
    	}
    	else {
    		memberObj = randomObject;
    	}
    	return memberObj;
    }
    public Object getMemberObj() {
    	return memberObj;
    }

}
