package edu.csuft.rainie.spiderfirst;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AppTbao {
	public static void main(String[] args) {

		// 线程池
		// 无限缓存
		ExecutorService pool = Executors.newCachedThreadPool();

		ArrayList<Tbao> list = new ArrayList<>();

		String url = "http://re.taobao.com/search_ou?" + "spm=a231k.8165028.0782702702.205.411d"
				+ "2e63mul3rB&prepvid=300_11." + "1.226.95_22556_1545416010837" + "&extra=&refpid=mm_26632323_13476"
				+ "194_53296945&keyword=%E7%A7%8B%E5%86" + "%AC%E5%A4%96%E5%A5%97%E5%A5%B3&page=";

		for (int i = 0; i <= 1; i++) {
			String path = String.format("%s%d", url, i);
			pool.submit(new SpiderTbao(path, list));
		}

		pool.shutdown();
		System.out.println(pool.isTerminated());
		while (!pool.isTerminated()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(list.size());

		try {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder()
					.build(Resources.getResourceAsStream("config.xml"));

			SqlSession session = factory.openSession();

			TbaoMapper mapper = (TbaoMapper) session.getMapper(TbaoMapper.class);

			for (Tbao t : list) {

				mapper.save(t);
			}

			session.commit();
			session.close();
			System.out.println("完成存储");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/*		// 写入文件
		String file = "Tbao.csv"; // 相对路径
		// io
		try (FileWriter out = new FileWriter(file)) {
			// 写数据
			for (Tbao t : list) {
				out.write(t.toCSV());
			}
			System.out.println("ok");
		} catch (Exception e) {
			// TODO: handle exception
		}*/

	}

}
