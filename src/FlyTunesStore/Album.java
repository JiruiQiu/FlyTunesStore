package FlyTunesStore;

import java.util.*;

public class Album {
	
	public Album(String name, String band, ArrayList<Song> songs) {
		this.name = name;
		this.band = band;
		this.songs = songs;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBandName() {
		return band;
	}
	
	public void addSong(Song newSong) {
		songs.add(newSong);
	}
	
	public void removeSong(Song delSong) {
		songs.remove(delSong);
	}
	
	public void printSongs() {
		for(int i = 0; i < songs.size(); i++) {
			System.out.println(songs.get(i).toString());
		}
	}
	
	public String toString() {
		String result = "Album name: " + name + ". Band name: " + band;
		if (songs.size() > 0) {
			result += "\nSongs in the albums are:\n";
			for(int i = 0; i < songs.size(); i++) {
				result += (songs.get(i).toString() + "\n");
			}
		} else {
			result += ". Sorry, no songs are in the album.";
		}
		return result + "\n";
	}
	
	// Private variables.
	private final String name;
	private final String band;
	private ArrayList<Song> songs;
}
