package mainPackage;

import java.io.IOException;
import org.jsoup.Jsoup;

public class WebScrapper {

	
	public void findID() throws IOException {
		
		String web = Jsoup.connect(Constants.scraperURL).get().toString();
		
		for(int i = 0; i < web.length(); i++) {
			
			if(web.substring(i, i + 7).equals("videoId")) {
				Constants.url = Constants.url + web.substring(i + 10, i + 21);
				break;
			}
			
		}
		
	}
	
	public void findSongName() throws IOException {
		
		String web = Jsoup.connect(Constants.scraperURL).get().toString();
				
		for(int i = 0; i < web.length(); i++) {
					
			if(web.substring(i, i + 14).equals("title\":{\"runs\"")) {
				boolean grabbingTitle = true;
				for(int n = 1, j = 0; grabbingTitle == true; n++, j++) {
					if(!web.substring(i + 25 + j, i + 25 + n).equals("\"")) {
						Constants.title = Constants.title + web.substring(i + 25 + j, i + 25 + n);
					}else if(web.substring(i + 25 + j, i + 25 + n).equals("\"") ) {
						grabbingTitle = false;
					}
					
					
				}
				System.out.println(Constants.title);
				break;
			}
					
		}
		
	}
	
}
