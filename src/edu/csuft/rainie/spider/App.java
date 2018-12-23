package edu.csuft.rainie.spider;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
			String path = String.format("%s%d", url, i*25);   //%s:�ַ���   %d:��ֵ
			pool.submit(new Spider(path,list));   //�ַ���ƴ��
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());   //�ж��߳��Ƿ���ֹ
		
		//�ȴ��߳̽���
		while (!pool.isTerminated()) {      
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//��������
		Collections.sort(list);
		System.out.println(list.size());
		
		//�������ݿ�
		//myBatis/iBatis
		try {
			
			//�����Ự�������ɴ�������Ự
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("config.xml"));
			
			//�򿪻Ự
			SqlSession session = factory.openSession();
			
			//��̬����
			FilmMapper mapper = (FilmMapper)session.getMapper(FilmMapper.class);
			
			for(Film f : list) {
				//ʹ��ע��� INSERT ���洢�����ݿ�
				mapper.save(f);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		ExecutorService pool2 = Executors.newFixedThreadPool(4);
//		
//		for(Film film : list) {
//			System.out.println(film.url);
//			pool2.execute(new Spider(film.url,null));
//		}
//		pool2.shutdown();
		
		//д���ļ�  ���ӱ��
//		String file = "d:/film.csv";     //����·��
//		file = "film.csv";             //���·��
//		
//		//����
//		Collections.sort(list);      //�ڶ���������ʾ�������
//		//io
//		try (FileWriter out = new FileWriter(file)) {   //�ӵڶ�������true��׷�ӵķ�ʽ
//			//д����
//			for (Film film : list) {
//				out.write(film.toCSV());
//			}
//			System.out.println("ok");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}

}
