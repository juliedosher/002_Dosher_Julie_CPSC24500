/*
 * The class that defines ShortStory, inherited from WrittenArtisticWork
 */


package muse;

import java.util.LinkedHashMap;

public class ShortStory extends WrittenArtisticWork {
    public String setting;
    public String getSetting() {
        return setting;
    }
    public void setSetting(String setting) {											// setter
        this.setting = setting;
    }
    public ShortStory() {																// default constructor
        setting = "";
    }
    public ShortStory(String creator, String date, String title, String description,	// constructor using individual data members
            String language, String text, String setting) {
        super(creator,date,title,description,language,text);
        setSetting(setting);
    }
    public ShortStory(LinkedHashMap<String,String> settings) {							// constructor using Linked Hash Map of data
        super(settings);
        setSetting(settings.get("setting"));
    }
    @Override
    public String getType() {															// returns media type as a String
        return "short story";
    }
    @Override
    public String getSpecificInfoString() {												// returns data as nicely formatted String
        return String.format("Setting: %s\n%s", setting, super.getSpecificInfoString());
    }
    
	public String toTabbedString() {
		String tabbedString = getType();
    	tabbedString += "\t" + getTitle();
    	tabbedString += "\t" + getCreator();
    	tabbedString += "\t" + getDate();
    	tabbedString += "\t" + getDescription();
    	tabbedString += "\t" + getLanguage();
    	tabbedString += "\t" + getText();
    	tabbedString += "\t" + getSetting();
    	
    	for (Comment comment : getComments()) {
    		tabbedString += "\t" + comment;
    	}
    	
    	return tabbedString;
	}
}
