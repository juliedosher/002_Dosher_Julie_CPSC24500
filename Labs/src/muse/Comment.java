/*
 * The class that defines Comment
 */

package muse;

import java.io.Serializable;

public class Comment implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private String postedBy;
    private String dateTime;
    private String content;
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {										// getters and setters:
        this.postedBy = postedBy;
    }
    public String getDateTime() {													
        return dateTime;
    }
    public void setDateTime(String dateTime) {										
        this.dateTime = dateTime;
    }
    public String getContent() {												
        return content;
    }
    public void setContent(String content) {										
        this.content = content;
    }
    public Comment() {																// default constructor
        postedBy = "";
        dateTime = "";
        content = "";
    }
    public Comment(String postedBy, String dateTime, String content) {				// constructor
        setPostedBy(postedBy);
        setDateTime(dateTime);
        setContent(content);
    }
    @Override
    public String toString() {														// returns comment info as a String
        return String.format("On %s, %s commented ...\n\t\"%s\"", 	
        		dateTime, postedBy, content);
    }
    
    public String toTabbedString() {
    	
    	
    	
    	return "";
    }
}
