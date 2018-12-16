package edu.csuft.rainie.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ��������
 * 
 * @author rainie
 * 
 */
public class App {
    //	alt+/ ������ʾ
	public static void main(String[] args) {
		
		//Ŀ�� URL
		String url = "https://movie.douban.com/top250";
				
		//ʹ�� JSOUP ץȡ�ĵ�
		try {
			Document doc = Jsoup.connect(url).get();
			
			Elements es = doc.select(".grid_view .item");     //������grid_view�ڲ���ͼƬ
			System.out.println(es.size());
			
			for(Element e :es) {
				// ÿһ��ӰƬ
				Element t = e.select(".title").first();   //.����class,#����id
				//ÿһ��ӰƬ������
				String num = e.select(".star span").last().text();   //ȡĳ����Χ�ڵ����һ����ǩ
				String c = e.select(".quote span").text();
				System.out.println(t.text() + "," + num + "\n" + c);
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
