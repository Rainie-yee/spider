package edu.csuft.rainie.spider;

public class Film {
/**
 * ӰƬ����
 * 
 * @author rainie
 * 
 */
	String title;
	
	/**
	 * �����Ϣ
	 */
	String info;
	
	/**
	 * ����
	 */
	double rating;
	
	/**
	 * ��������
	 */
	int num;
	
	/**
	 * ����
	 */
	int id;
	
	/**
	 * ����
	 */
	String poster;
	
	/**
	 * ������¼
	 */
	String quote;

	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}

}
