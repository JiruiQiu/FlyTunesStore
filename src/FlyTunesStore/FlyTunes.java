package FlyTunesStore;

import java.util.*;

public class FlyTunes {
	
	public static void main(String[] args) {
		Scanner snr = new Scanner(System.in);
		FlyTunes myTune = new FlyTunes(snr);
		while(true) {
			myTune.printMenu();
			int inputNum = myTune.scanInt("Please enter your selection:");
			switch(inputNum) {
				case QUIT: break;
				case PRINTSONGS: myTune.printSongs();
				     break;
				case PRINTALBUMS: myTune.printAlbums();
				     break;
				case ADDSONGS: myTune.addSongs();
					 break;
				case ADDALBUMS: myTune.addAlbums();
					 break;
				case CHANGESONGPRICE: myTune.changeSongPrice();
					 break;
				default:
					 System.out.println("Please enter a valid number!");
			}
			if(inputNum == QUIT)
				break;
		}
		snr.close();
	}
	
	public void printSongs() {
		if (songList.size() == 0) {
			System.out.println("Sorry, no songs are currently in the store.");
		} else {
			for(int i=0; i < songList.size(); i++) {
				System.out.println(songList.get(i).toString());
			}
		}
	}
	
	public void printAlbums() {
		if (albumList.size() == 0) {
			System.out.println("Sorry, no albums are currently in the store.");
		} else {
			for(int i=0; i < albumList.size(); i++) {
				System.out.println(albumList.get(i).toString());
			}
		}
	}
	
	public Song addSongs() {
		String name = this.scanStr("Please enter the name of the song:");
		String band = this.scanStr("Please enter the name of the band:");
		if(storeDic.containsKey(name+band)) {
			System.out.println("The song is already in the store.");
			return storeDic.get(name+band);
		} else {
			Double price = this.scanDouble("Please enter the price of the song:");
			Song newSong = new Song(name, band, price);
			songList.add(newSong);
			storeDic.put(name + band,  newSong);
		    System.out.println("The song has been added");
		    return newSong;
		}
	}
	
	public void addAlbums() {
		String name = this.scanStr("Please enter the name of the album:");
		String band = this.scanStr("Please enter the name of the band:");
		Album newAlbum = new Album(name, band, new ArrayList<Song>());
		while (true) {
			Song newSong = this.addSongs();
			newAlbum.addSong(newSong);
			String curInput = this.scanStr("Add another song? Enter 0 to stop: ");
			if (curInput.equals("0")) 
				break;
		}
		albumList.add(newAlbum);
	} 
	
	public void changeSongPrice() {
		String name = this.scanStr("Please enter the name of the song:");
		String band = this.scanStr("Please enter the name of the band:");
		if (storeDic.containsKey(name + band)) {
			Double price = this.scanDouble("Please enter the price of the song:");
			Song curSong = storeDic.get(name + band);
			curSong.setPrice(price);
		} else {
			System.out.println("Sorry, no such song exists in the store.");
		}
	}
	
	private int scanInt(String printStr) {
		System.out.println(printStr);
		String input = null;
		int inputNum = -1;
		while(input == null) {
			try {
				input = scan.nextLine();
				inputNum = Integer.parseInt(input);
			} catch (NumberFormatException e){
				System.out.println("Integer expected, not " + input + ". Please try again.");
				input = null;
			}
		}
		return inputNum;
	}
	
	private double scanDouble(String printStr) {
		System.out.println(printStr);
		String input = null;
		double inputNum = -1;
		while(input == null) {
			try {
				input = scan.nextLine();
				inputNum = Double.parseDouble(input);
			} catch (NumberFormatException e){
				System.out.println("Double expected, not " + input + ". Please try again.");
				input = null;
			}
		}
		return inputNum;
	}
	
	private String scanStr(String printStr) {
		System.out.println(printStr);
		String input = null;
		while(input == null) {
			try {
				input = scan.nextLine();
			} catch (Exception e){
				System.out.println("String expected. Please try again.");
				input = null;
			}
		}
		return input;
	}
	
	public void printMenu() {
		System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("Hello, welcome to FlyTunesStore!");
		System.out.println("Here are a few options for you to choose: (Enter '0' to quit)");
		System.out.println("1. Print songs in the store.");
		System.out.println("2. Print albums in the store.");
		System.out.println("3. Add song to the store.");
		System.out.println("4. Add album to the store.");
		System.out.println("5. Change the price of a song.");
	}
	
	public FlyTunes(Scanner scan) {
		this.scan = scan;
	}
	
	// Constants.
	private static final int QUIT = 0;
	private static final int PRINTSONGS = 1;
	private static final int PRINTALBUMS = 2;
	private static final int ADDSONGS = 3;
	private static final int ADDALBUMS = 4;
	private static final int CHANGESONGPRICE = 5;
	
	// Private variables.
	private ArrayList<Song> songList = new ArrayList<Song>();
	private ArrayList<Album> albumList = new ArrayList<Album>();
	private HashMap<String, Song> storeDic = new HashMap<String, Song>();
	private Scanner scan;
}
