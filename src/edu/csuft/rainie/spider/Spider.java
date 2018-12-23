package edu.csuft.rainie.spider;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * ץȡҳ����ӰƬ��Ϣ�����棨����
 * 
 * @author rainie
 *
 */

public class Spider implements Runnable{
	
	/**
	 * ҳ���·��url
	 * 
	 */
	String url;
	
	/**
	 * �洢ץȡ������
	 */
	ArrayList<Film> list;
	
	/**
	 * ��������
	 * 
	 * @param url  ҳ���·��
	 * @param list  �洢���ݵ��б�
	 */
	public Spider(String url, ArrayList<Film> list) {
		super();
		this.url = url;
		this.list = list;
	}

	@Override
	public void run() {
		// ���ִ�и�������̵߳�����
		String name = Thread.currentThread().getName();
		System.out.println(name + "�̣߳�����" + url);
		
		//JSOUP
		try {
			Document doc = Jsoup.connect(url).get();
			
			//���ĵ����������ҽڵ�
			Elements es = doc.select(".grid_view .item"); 
			for(Element e :es) {
			Film f = new Film();
			// ÿһ��ӰƬ   select+��Ԫ��id
			f.id = Integer.parseInt(e.select(".pic em").text());   //ת��Ϊ����
			f.poster = e.select("img").first().attr("src");
			f.info = e.select(".info").first().text();
			f.title = e.select(".title").first().text();
			f.rating = Double.parseDouble( e.select(".rating_num").text());  //ת��Ϊ˫������
			String num = e.select(".star span").last().text();
			f.num = Integer.parseInt(num.substring(0, num.length()-3));
			f.quote = e.select(".quote span").text();
			f.url = e.select(".pic a").first().attr("href");
			
//			System.out.println(name + ":" + f);
			list.add(f);
		}
			
		System.out.println(name + "�̣߳���ɣ�" + url);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
