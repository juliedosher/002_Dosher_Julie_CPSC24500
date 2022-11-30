/*
 * The class that defines Poem, inherited from WrittenArtisticWork
 */


package muse;

import java.util.LinkedHashMap;

public class Poem extends WrittenArtisticWork {
    private String meter;
    public String getMeter() {
        return meter;
    }
    public void setMeter(String meter) {											// setter
        this.meter = meter;
    }
    public Poem() {																	// default constructor
        meter = "N/A";
    }
    public Poem(String creator, String date, String title, String description,		// constructor using individual data members
            String language, String text, String meter) {
        super(creator,date,title,description,language,text);
        setMeter(meter);
    }
    public Poem(LinkedHashMap<String,String> settings) {							// constructor using Linked Hash Map of data
        super(settings);
        setMeter(settings.get("meter"));
    }
    @Override
    public String getType() {														// returns media type as a String
        return "poem";
    }
    @Override
    public String getSpecificInfoString() {											// returns info as nicely formatted String
        return String.format("Meter: %s\n%s", meter, super.getSpecificInfoString());
    }
    
    public String toTabbedString() {
    	String tabbedString = getTitle();
    	tabbedString += "\t" + getType();
    	tabbedString += "\t" + getCreator();
    	tabbedString += "\t" + getDate();
    	tabbedString += "\t" + meter;
    	tabbedString += "\t" + getText();
    	
    	return tabbedString;
    }
}
