package edu.csuft.rainie.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 程序入口
 * 
 * @author SongD
 *
 */

public class App2 {
	
	public static void main(String[] args) {
		//目标url
		String url = "https://music.douban.com/subject/30392082/";
		//用jsoup抓取文档
		try {
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select("#wrapper");
			
			ArrayList<Music> list = new ArrayList<>();
			
			for(Element e :es) {
				Music m = new Music();
				m.title = e.select("h1 span").first().text();
//				m.singer = e.select(".ckd-collect span a").first().text();
//			    m.sgenre = e.select(".ckd-collect span").first().text();
//				m.atype = e.select("").text();
//			    m.media
//			    m.time
//			    m.publisher
//			    m.num = e.select(".ckd-collect").last().text();
				m.info =  e.select(".ckd-collect").last().text();
			    m.rating = Double.parseDouble(e.select("#interest_sectl strong").first().text());
			    m.rating_sum = Integer.parseInt(e.select(".rating_people span").text());
				m.poster = e.select(".nbg img").attr("src");
			    System.out.println(m);
			    list.add(m);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
