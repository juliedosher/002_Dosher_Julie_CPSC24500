/*
 * The class that defines Song, inherited from RecordedArtisticWork
 */


package muse;

import java.util.LinkedHashMap;

public class Song extends RecordedArtisticWork {
    private int bpm;  // beats per minute
    private String key;
    
    public int getBPM() {
        return bpm;
    }
    public void setBPM(int bpm) {													// getters and setters:
        if (bpm < 0) {
            this.bpm = 0;
        } else {
            this.bpm = bpm;
        }
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;   // could add checking for valid key
    }
    public Song() {																	// default constructor
        key = "Cmaj";
        bpm = 120;
    }
    public Song(String creator, String date, String title, String description,		// constructor using individual data members
            int duration, String fileName, double fileSize, int bpm, String key) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setBPM(bpm);
        setKey(key);
    }
    public Song(LinkedHashMap<String,String> settings) {							// constructor using Linked Hash Map of data
        super(settings);
        setBPM(Integer.parseInt(settings.get("bpm")));
        setKey(settings.get("key"));
    }
    @Override
    public String getType() {														// returns media type as a String
        return "song";
    }
    @Override
    public String getSpecificInfoString() {											// returns data as nicely formatted String
        return String.format("%d bpm, key of %s", bpm,key);
    }
    
    public String toTabbedString() {
    	String tabbedString = getType();
    	tabbedString += "\t" + getTitle();
    	tabbedString += "\t" + getCreator();
    	tabbedString += "\t" + getDate();
    	tabbedString += "\t" + getDescription();
    	tabbedString += "\t" + getDuration();
    	tabbedString += "\t" + getFileName();
    	tabbedString += "\t" + getFileSize();
    	tabbedString += "\t" + getBPM();
    	tabbedString += "\t" + getKey();
    	
    	for (Comment comment : getComments()) {
    		tabbedString += comment.toTabbedString();
    	}
    	
    	return tabbedString;
    }
}
