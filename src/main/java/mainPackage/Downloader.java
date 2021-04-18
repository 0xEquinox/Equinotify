package mainPackage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
	public void download_thumbnail() throws IOException {
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
			stdin.println("youtube-dl --write-thumbnail --skip-download -o \"%(song)s.%(ext)s\" "+ Constants.url);
			stdin.close();
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ImageIO.write(ImageIO.read(new File(Constants.thumbnailDownloadPath + "\\" + "NA.webp")), "png", new File(Constants.thumbnailDownloadPath + "\\" + "NA.png"));
	}
	
}
