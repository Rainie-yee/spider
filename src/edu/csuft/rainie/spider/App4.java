package edu.csuft.rainie.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class App4 {
	public static void main(String[] args) {
		String url = "http://www.acfun.cn/v/list196/index.htm";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements es = doc.select("#list-video");
			
			ArrayList<Video> list = new ArrayList<>();
			for(Element e :es) {
				Video v = new Video();
				v.title = e.select(".fl img-wp ").first().text();
				v.poster = e.select(".fl img-wp").first().text();
			    System.out.println(v);
			    list.add(v);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
