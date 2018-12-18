package edu.csuft.rainie.spider;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ��������
 * 
 * @author rainie
 * 
 */
public class App {
    //	alt+/ ������ʾ
	public static void main(String[] args) {
		//�̳߳�
		//�̶���С
		ExecutorService pool = Executors.newFixedThreadPool(4);
		//����(����)
		pool = Executors.newCachedThreadPool();
		//һ���߳�
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList();
		String url = "https://movie.douban.com/top250?start=";
		
		for(int i = 0;i < 10; i++) {
			String path = String.format("%s=%d", url, i*25); //%s:�ַ���   %d:��ֵ
		pool.submit(new Spider(path,list));   //�ַ���ƴ��
		}
		
		
	}

}
