package edu.csuft.rainie.spider;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
			String path = String.format("%s=%d", url, i*25); //%s:字符串   %d:数值
		pool.submit(new Spider(path,list));   //字符串拼接
		}
		
		
	}

}
