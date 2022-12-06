package extracreditfinal;

public class Movie {

	Movie() {																								// default constructor
		title = "";
		releaseYear = 0;
		director = "";
		runtimeMinutes = 0;
		description = "";
	}
	
	Movie(String title, int releaseYear, String director, int runtimeMinutes, String description) {			// primary constructor
		this.title = title;
		this.releaseYear = releaseYear;
		this.director = director;
		this.runtimeMinutes = runtimeMinutes;
		this.description = description;
	}
	
	private String title;
	private int releaseYear;
	private String director;
	private int runtimeMinutes;
	private String description;
	
	
	private String runtimeToString() {																		// converts runtime minutes to a String
		String output = "";																					// containing hours and minutes and returns it
		if (runtimeMinutes < 60) {
			output = runtimeMinutes + " min";
		
		} else {
			int hours = runtimeMinutes / 60;
			int minutes = runtimeMinutes % 60;
			output += hours + " hr";
			if (minutes > 0) {
				output += ", " + minutes + " min";
			}
		}
		
		return output;
	}
	
	public String toString() {																				// converts Movie object to a nicely
		String output = title + ", " + releaseYear + ", ";													// formatted String and returns it
		output += "dir. by " + director + ".";
		output += runtimeToString() + ".\n";
		output += description + "\n";
		
		return output;
	}
	
	public String getTitle() {																				// getters and setters
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRuntimeMinutes() {
		return runtimeMinutes;
	}

	public void setRuntimeMinutes(int runtimeMinutes) {
		this.runtimeMinutes = runtimeMinutes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
