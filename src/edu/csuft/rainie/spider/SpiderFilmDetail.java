package edu.csuft.rainie.spider;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 抓取影片详细信息
 * 
 * @author rainie
 *
 */

public class SpiderFilmDetail implements Runnable{
	
	/**
	 * 影片的 url
	 * 
	 */
	String url;
	
	/**
	 * 影片列表
	 * 
	 */
	List<Film> list;
	
	public SpiderFilmDetail(String url, List<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Document doc = Jsoup.connect(url).get();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
