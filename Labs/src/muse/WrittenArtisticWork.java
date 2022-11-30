/*
 * The abstract class that defines WrittenArtisticWork, inherited from ArtisticWork
 */


package muse;

import java.util.LinkedHashMap;

public abstract class WrittenArtisticWork extends ArtisticWork {
    private String language;
    private String text;  // the actual content
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String lang) {														// getters and setters
        language = lang;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public WrittenArtisticWork() {																// default constructor
        language = "English";
        text = "This is the text of the written work.";
    }
    public WrittenArtisticWork(String creator, String date, String title, String description,	// constructor using individual data members
            String language, String text) {
        super(creator,date,title,description);
        setLanguage(language);
        setText(text);
    }
    public WrittenArtisticWork(LinkedHashMap<String,String> settings) {							// constructor using Linked Hash Map of data
        super(settings);
        setLanguage(settings.get("language"));
        setText(settings.get("text"));
    }
    @Override		
    public String getGeneralInfoString() {														// returns universal info for written works as String
        return String.format("%s\nLanguage: %s",super.getGeneralInfoString(),language);
    }
    @Override
    public String getSpecificInfoString() {														// returns text as String
        return text;
    }
    
    public abstract String toTabbedString();
}
