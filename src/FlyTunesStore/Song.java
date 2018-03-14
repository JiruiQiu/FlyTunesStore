package FlyTunesStore;

public class Song {
	
	public Song(String name, String band, double price) {
		this.name = name;
		this.band = band;
		this.price = price;
	}
	
	public String getSongName() {
		return name;
	}
	
	public String getBandName() {
		return band;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		String printStr = "Song name: " + name + ". Band name: " + band + ". Price: " + Double.toString(price);
		return printStr;
	}
	
	// Private variables.
	private final String name;
	private final String band;
	private double price;
}
