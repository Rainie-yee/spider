package edu.csuft.rainie.spider;

import org.jsoup.select.Elements;

public class Music {
	
	/**
	 * ר������
	 * 
	 * @author rainie
	 * 
	 */
		String title;
		
	/**
	* ������
	* 
	* @author rainie
	* 
	*/
	   String singer;
	   
	 /**
	  *�������� 
	  * 
	  * @author rainie
	  * 
	  */
	   String sgenre;
	   
	   /**
	    * ר������
	    * 
	    * @author rainie
	    * 
	    */
	   String atype;
	   
	   /**
	    * ����
	    * 
	    * @author rainie
	    * 
	    */
	   String media;
	   
	   /**
	    * ����ʱ��
	    * 
	    * @author rainie
	    * 
	    */
	   String time;
	   
	   /**
	    * ������
	    * 
	    * @author rainie
	    * 
	    */
	   String publisher;
	   
	   /**
	    * ��Ƭ��
	    * 
	    * @author rainie
	    * 
	    */
	   String num;
	   
	   /**
	    * ��������
	    * 
	    * @author rainie
	    * 
	    */
	   Double rating;
	   
	   /**
	    * ��������
	    * 
	    * @author rainie
	    * 
	    */
	   int rating_sum;
	   
	   /**
	    * ����
	    * 
	    * @author rainie
	    * 
	    */
	   String poster;
	   
	   /**
	    * ר����Ϣ
	    * 
	    * @author rainie
	    * 
	    */
	   String info;

	@Override
	public String toString() {
//		return "Music [ר������" + title + ", ���֣�" + singer + ", ���ɣ�" + sgenre + ", ר�����ͣ�" + atype + ", ���ʣ�"
//				+ media + ", ����ʱ�䣺" + time + ", �����ߣ�" + publisher + ", ��Ƭ��:" + num + ", ���֣�" + rating
//				+ ", ����������" + rating_sum + ", ������" + poster + "]";
		return "Music [ר������" + title + "," + info + ", ���֣�" + rating
		+ ", ����������" + rating_sum + ", ������" + poster + "]";
	}
}  
