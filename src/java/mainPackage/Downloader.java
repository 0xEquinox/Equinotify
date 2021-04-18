package mainPackage;

import java.io.PrintWriter;

public class Downloader {

	
	public void download_song() {
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
	                stdin.println("cd \""+Constants.songDownloadPath+"\"");
	                stdin.println("youtube-dl -x --audio-format wav --prefer-ffmpeg -o \"%(song)s.%(ext)s\" "+ Constants.url);
	                stdin.close();
	                p.waitFor();
	    	} catch (Exception e) {
	 		e.printStackTrace();
		}
	}
	public void download_thumbnail() {
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
			stdin.println("cd \""+Constants.thumbnailDownloadPath+"\"");
			stdin.println("youtube-dl --write-thumbnail -o \"%(song)s.%(ext)s\" "+ Constants.url);
			stdin.println("del NA.mkv");
			stdin.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
