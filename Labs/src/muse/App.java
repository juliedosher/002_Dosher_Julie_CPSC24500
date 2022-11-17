package muse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class App {
	
    public static void printHeading() {
        System.out.println("********************************************************************************");
        System.out.println("                        MUSE Social Media Platform, v1.0");
        System.out.println("********************************************************************************");
        System.out.println();
        System.out.println("Welcome to MUSE, the social media platform where artists and authors of all");
        System.out.println("kinds and from all over the world come together to share their inspirations and");
        System.out.println("ideas. Post your own original works and comment on what others are doing. Only");
        System.out.println("one rule: be kind!");
    }
    public static void showMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Create a new post");
        System.out.println("2. Comment on a post");
        System.out.println("3. Read posts from a text, binary, xml, or json file");
        System.out.println("4. Write post to a text, binary, xml, or json file");
        System.out.println("5. List all posts and comments to screen");
        System.out.println("6. Clear posts");
        System.out.println("7. Quit");
        System.out.print("Enter the number of your choice: ");
    }
    public static void showNewPostMenu() {
        System.out.println("\nWhat would you like to a post?");
        System.out.println("1. Song");
        System.out.println("2. Movie");
        System.out.println("3. Poem");
        System.out.println("4. Short story");
        System.out.print("Enter the number of your choice: ");
    }
    public static LinkedHashMap<String,String> getCommonInputs(Scanner sc) {
        LinkedHashMap<String,String> result = new LinkedHashMap<String,String>();
        System.out.print("Enter the name of the creator: ");
        result.put("creator", sc.nextLine());
        System.out.print("Enter the date: ");
        result.put("date", sc.nextLine());
        System.out.print("Enter the title: ");
        result.put("title", sc.nextLine());
        System.out.print("Enter a description: ");
        result.put("description", sc.nextLine()); 
        return result;
    }
    public static LinkedHashMap<String,String> getCommonRecordedInputs(Scanner sc) {
        LinkedHashMap<String,String> result = getCommonInputs(sc);
        System.out.print("Enter duration: ");
        result.put("duration", sc.nextLine());
        System.out.print("Enter filename: ");
        result.put("filename",sc.nextLine());
        System.out.print("Enter file size: ");
        result.put("filesize", sc.nextLine());
        return result;
    }
    public static LinkedHashMap<String,String> getCommonWrittenInputs(Scanner sc) {
        LinkedHashMap<String,String> result = getCommonInputs(sc);
        System.out.print("Enter language: ");
        result.put("language", sc.nextLine());
        System.out.print("Enter text: ");
        result.put("text", sc.nextLine());
        return result;
    }
    public static void listWorks(ArrayList<ArtisticWork> works) {
        System.out.println("Here is what has been posted to MUSE: ");
        int count = 1;
        for (ArtisticWork work : works) {
            System.out.printf("%2d. %s\n",count,work.getShortString());
            count = count + 1;
        }
    }
    public static void main(String[] args) {
        printHeading();
        int choice, artType;
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,String> responses;
        ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();
        Song song;
        Poem poem;
        ShortStory story;
        Movie movie;
        int workNum;
        String commenterName, commenterDate, commentText;
        Comment comment;
        ArtisticWork theWork;  // the work chosen to comment on
        do {
            showMainMenu();
            choice = sc.nextInt();
            if (choice == 1) {
                showNewPostMenu();
                artType = sc.nextInt();
                sc.nextLine();
                if (artType == 1) {
                    responses = getCommonRecordedInputs(sc);
                    System.out.print("Enter beats per minute: ");
                    responses.put("bpm",sc.nextLine());
                    System.out.print("Enter the key: ");
                    responses.put("key", sc.nextLine());
                    song = new Song(responses);
                    works.add(song);
                } else if (artType == 2) {
                    responses = getCommonRecordedInputs(sc);
                    System.out.print("Enter framerate: ");
                    responses.put("framerate", sc.nextLine());
                    System.out.print("Enter resolution: ");
                    responses.put("resolution", sc.nextLine());
                    movie = new Movie(responses);
                    works.add(movie);
                } else if (artType == 3) {
                    responses = getCommonWrittenInputs(sc);
                    System.out.print("Enter meter: ");
                    responses.put("meter",sc.nextLine());
                    poem = new Poem(responses);
                    works.add(poem);
                } else if (artType == 4) {
                    responses = getCommonWrittenInputs(sc);
                    System.out.print("Describe the setting: ");
                    responses.put("setting", sc.nextLine());
                    story = new ShortStory(responses);
                    works.add(story);
                }
            } else if (choice == 2) {
                listWorks(works);
                System.out.print("Which one do you want to comment on? ");
                workNum = sc.nextInt() - 1;
                sc.nextLine();
                theWork = works.get(workNum);
                System.out.println("\nHere is the work you have chosen to comment on: ");
                System.out.println(theWork);
                System.out.print("\nEnter your name: ");
                commenterName = sc.nextLine();
                System.out.print("Enter the date: ");
                commenterDate = sc.nextLine();
                System.out.print("Enter your comment: ");
                commentText = sc.nextLine();
                comment = new Comment(commenterName,commenterDate,commentText);
                theWork.addComment(comment);
                System.out.println("The new comment has been added. Here is the updated post:\n ");
                System.out.println(theWork);
            
            } else if (choice == 6) {
            	System.out.print("Are you sure (y or n)? ");
            	if (sc.nextLine().equals("y")) {
            		works.clear();
            		System.out.println("All posts have been cleared.");
            	} else {
            		System.out.println("Canceled. Posts were not cleared.");
            	}
            }
            
        } while (choice != 7);
        System.out.println();
        System.out.println("Thank you for using MUSE. Be inspired to inspire everyone everywhere always.");
    }
}
