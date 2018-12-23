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
 * 程序的入口
 * 
 * @author rainie
 * 
 */
public class App {
    //	alt+/ 代码提示
	public static void main(String[] args) {
		//线程池
		//固定大小
		ExecutorService pool = Executors.newFixedThreadPool(4);
		//无限(缓存)
		pool = Executors.newCachedThreadPool();
		//一个线程
//		pool = Executors.newSingleThreadExecutor();
		
		ArrayList<Film> list = new ArrayList();
		String url = "https://movie.douban.com/top250?start=";
		
		for(int i = 0;i < 10; i++) {
			String path = String.format("%s%d", url, i*25);   //%s:字符串   %d:数值
			pool.submit(new Spider(path,list));   //字符串拼接
		}
		pool.shutdown();
		System.out.println(pool.isTerminated());   //判断线程是否终止
		
		//等待线程结束
		while (!pool.isTerminated()) {      
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//数据排序
		Collections.sort(list);
		System.out.println(list.size());
		
		//导入数据库
		//myBatis/iBatis
		try {
			
			//创建会话工厂，可创建多个会话
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("config.xml"));
			
			//打开会话
			SqlSession session = factory.openSession();
			
			//动态代理
			FilmMapper mapper = (FilmMapper)session.getMapper(FilmMapper.class);
			
			for(Film f : list) {
				//使用注解的 INSERT 语句存储到数据库
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
		
		//写入文件  电子表格
//		String file = "d:/film.csv";     //绝对路径
//		file = "film.csv";             //相对路径
//		
//		//排序
//		Collections.sort(list);      //第二个参数表示排序规则
//		//io
//		try (FileWriter out = new FileWriter(file)) {   //加第二个参数true，追加的方式
//			//写数据
//			for (Film film : list) {
//				out.write(film.toCSV());
//			}
//			System.out.println("ok");
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	}

}
