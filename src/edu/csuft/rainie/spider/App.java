package edu.csuft.rainie.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 程序的入口
 * 
 * @author rainie
 * 
 */
public class App {
    //	alt+/ 代码提示
	public static void main(String[] args) {
		
		//目标 URL
		String url = "https://movie.douban.com/top250";
				
		//使用 JSOUP 抓取文档
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es = doc.select(".grid_view .item");     //查找在grid_view内部的图片
			System.out.println(es.size());
			
			//创建一个影片的列表
			ArrayList<Film> list = new ArrayList<>();
			for(Element e :es) {
				Film f =new Film();
				// 每一部影片
				Element t = e.select(".title").first();   //.代表class,#代表id
				//每一部影片的名字
				String num = e.select(".star span").last().text();   //取某个范围内的最后一个标签
				String c = e.select(".quote span").text();
				System.out.println(t.text() + "," + num + "\n" + c);
				
//				f.title
//				f.info
//				f.rating
//				f.num
//				f.id
//				f.poster
//				f.quote
//				list.add(f)
			}
			
//			String title = doc.title();
//			String data = doc.data();
//			
//			System.out.println(title);
//			System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
