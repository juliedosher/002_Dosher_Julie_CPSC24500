/*
 * The class that defines Movie, inherited from RecordedArtisticWork
 */

package muse;

import java.util.LinkedHashMap;

public class Movie extends RecordedArtisticWork {
    private int frameRate; // frames per second
    private String resolution;  // 720p, 1040p, 2048p, etc
    public int getFrameRate() {
        return frameRate;
    }
    public void setFrameRate(int frameRate) {														// getters and setters:
        if (frameRate < 0) {
            frameRate = 0;
        } else {
            this.frameRate = frameRate;
        }
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String res) {
        resolution = res;
    }
    public Movie() {																				// default constructor
        frameRate = 30;
        resolution = "720p";
    }
    public Movie(String creator, String date, String title, String description,						// constructor using individual data members
            int duration, String fileName, double fileSize, int frameRate, String resolution) {
        super(creator,date,title,description,duration,fileName,fileSize);
        setFrameRate(frameRate);
        setResolution(resolution);
    }
    public Movie(LinkedHashMap<String,String> settings) {											// constructor using Linked Hash Map of all data
       super(settings);
       setFrameRate(Integer.parseInt(settings.get("framerate")));
       setResolution(settings.get("resolution"));
    }
    @Override
    public String getType() {																		// returns media type as  a String
        return "movie";
    }
    @Override
    public String getSpecificInfoString() {															// returns data as nicely formatted String
        return String.format("filmed with %s resolution at %d frames per second", resolution, frameRate);
    }
    
    public String toTabbedString() {
    	
    	
    	
    	return "";
    }
}
