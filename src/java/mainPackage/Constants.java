package mainPackage;

import java.util.ArrayList;

public class Constants {

	public static String songDownloadPath = System.getenv("APPDATA")+"\\Equinoify\\songs";
	public static String thumbnailDownloadPath = System.getenv("APPDATA")+"\\Equinoify\\thumbnails";
	public static String url = "https://www.youtube.com/watch?v=";
	public static String scraperURL = "https://www.youtube.com/results?search_query=";
	public static String title = "";
	
	public static ArrayList<String> playlistSongTitles = new ArrayList<String>();
	public static ArrayList<String> playlistSongPaths = new ArrayList<String>();

	public static int windowWidth = 850;
	public static int windowHeight = 850;

}
