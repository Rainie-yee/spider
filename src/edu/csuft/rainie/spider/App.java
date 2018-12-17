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
				// 每一部影片   select+类元素id
				f.id = Integer.parseInt(e.select(".pic em").first().text());   //转换为整型
				f.poster = e.select("img").first().attr("src");
				f.info = e.select(".bd p").first().text();
				f.title = e.select(".title").first().text();
				f.rating = Double.parseDouble( e.select(".rating_num").first().text());  //转换为双精度型
				String num = e.select(".star span").last().text();
				f.num = Integer.parseInt(num.substring(0, num.length()-3));
				f.quote = e.select(".quote span").first().text();
				
				System.out.println(f);
				list.add(f);
//				Element t = e.select(".title").first();   //.代表class,#代表id
//				//每一部影片的名字
//				String num = e.select(".star span").last().text();   //取某个范围内的最后一个标签
//				String c = e.select(".quote span").text();
//				System.out.println(t.text() + "," + num + "\n" + c);
				
			

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
