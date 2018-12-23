package edu.csuft.rainie.spiderfirst;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SpiderTbao implements Runnable {

	public static String PATH = "D:\\SongD\\Documents\\AAAAAA�γ����\\�Ա�pic\\";
	/**
	 * ҳ���·����URL��
	 */
	String url;

	/**
	 * �洢ץȡ������
	 */
	ArrayList<Tbao> list;

	/**
	 * ��������
	 * 
	 * @param url  ҳ���·��
	 * @param list �洢���б�
	 */

	public SpiderTbao(String url, ArrayList<Tbao> list) {
		super();
		this.url = url;
		this.list = list;
	}

	/*InputStream in = null;
	BufferedInputStream bu = null;
	FileOutputStream fi = null;*/

	@Override
	public void run() {

		// ���ִ�и�������̵߳�����
		String name = Thread.currentThread().getName();
		System.out.println(name + "�̣߳�����" + url);

		// Jsoup
		try {
			Document doc = Jsoup.connect(url).get();

			for (int i = 1; i <= 1; i++) {
				Tbao t = new Tbao();
				Element e = doc.select(".view .item").get(i);

				t.shopname = e.select(".shopNick").text();

				t.introduce = e.select(".title").text();

				String pr = e.select(".pricedetail strong").text();
				t.price = Double.parseDouble(pr);

				String pe = e.select(".payNum").text();
				t.people = Integer.parseInt(pe.substring(0, pe.length() - 3));

				String r1 = e.select(".dsr-info-list b").get(0).text();
				t.rate1 = Double.parseDouble(r1);

				String r2 = e.select(".dsr-info-list b").get(1).text();
				t.rate2 = Double.parseDouble(r2);

				String r3 = e.select(".dsr-info-list b").get(2).text();
				t.rate3 = Double.parseDouble(r3);

				t.info = e.select("a").first().attr("href");

				t.img = e.select(".imgLink img").attr("data-ks-lazyload");

				String po = e.select(".postalicon").text();
				if (po.equals("����"))
					t.post = po;
				else
					t.post = "������";

				System.out.println(t.toCSV());

				/*URL url = new URL(t.img);
				in = url.openConnection().getInputStream();
				bu = new BufferedInputStream(in);
				int size = 0;
				byte[] by = new byte[1024];
				fi = new FileOutputStream(PATH + t.shopname + ".jpg");
				while ((size = bu.read(by)) != -1) {
					fi.write(by, 0, size);
				}*/

				list.add(t);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*finally {
			if (fi != null) {
				try {
					fi.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bu != null) {
				try {
					bu.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}*/

	}

}
