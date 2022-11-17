/*
 * The class that defines Comment
 */

package muse;

public class Comment {
    private String postedBy;
    private String dateTime;
    private String content;
    public String getPostedBy() {
        return postedBy;
    }
    public void setPostedBy(String postedBy) {										// sets author of post
        this.postedBy = postedBy;
    }
    public String getDateTime() {													// gets date/time post was made
        return dateTime;
    }
    public void setDateTime(String dateTime) {										// sets date/time post was made
        this.dateTime = dateTime;
    }
    public String getContent() {													// gets content of comment
        return content;
    }
    public void setContent(String content) {										// sets content of comment
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
}
