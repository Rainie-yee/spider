package edu.csuft.rainie.spider;

import org.jsoup.select.Elements;

public class Music {
	
	/**
	 * 专辑名称
	 * 
	 * @author rainie
	 * 
	 */
		String title;
		
	/**
	* 表演者
	* 
	* @author rainie
	* 
	*/
	   String singer;
	   
	 /**
	  *歌曲流派 
	  * 
	  * @author rainie
	  * 
	  */
	   String sgenre;
	   
	   /**
	    * 专辑类型
	    * 
	    * @author rainie
	    * 
	    */
	   String atype;
	   
	   /**
	    * 介质
	    * 
	    * @author rainie
	    * 
	    */
	   String media;
	   
	   /**
	    * 发行时间
	    * 
	    * @author rainie
	    * 
	    */
	   String time;
	   
	   /**
	    * 出版者
	    * 
	    * @author rainie
	    * 
	    */
	   String publisher;
	   
	   /**
	    * 唱片数
	    * 
	    * @author rainie
	    * 
	    */
	   String num;
	   
	   /**
	    * 豆瓣评分
	    * 
	    * @author rainie
	    * 
	    */
	   Double rating;
	   
	   /**
	    * 评分人数
	    * 
	    * @author rainie
	    * 
	    */
	   int rating_sum;
	   
	   /**
	    * 海报
	    * 
	    * @author rainie
	    * 
	    */
	   String poster;
	   
	   /**
	    * 专辑信息
	    * 
	    * @author rainie
	    * 
	    */
	   String info;

	@Override
	public String toString() {
//		return "Music [专辑名：" + title + ", 歌手：" + singer + ", 流派：" + sgenre + ", 专辑类型：" + atype + ", 介质："
//				+ media + ", 发行时间：" + time + ", 出版者：" + publisher + ", 唱片数:" + num + ", 评分：" + rating
//				+ ", 评分人数：" + rating_sum + ", 海报：" + poster + "]";
		return "Music [专辑名：" + title + "," + info + ", 评分：" + rating
		+ ", 评分人数：" + rating_sum + ", 海报：" + poster + "]";
	}
}  
