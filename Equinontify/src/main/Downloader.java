package main;

import java.io.PrintWriter;

public class Downloader {

	
	public void download() {
		String[] command =
	    {
	        "cmd",
	    };
	    Process p;
		try {
			p = Runtime.getRuntime().exec(command); 
		        new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
	                new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
	                PrintWriter stdin = new PrintWriter(p.getOutputStream());
	                stdin.println("cd \""+Constants.downloadPath+"\"");
	                stdin.println("youtube-dl -x --audio-format wav --prefer-ffmpeg -o \"%(song)s.%(ext)s\" "+ Constants.url);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
	}
	
}
