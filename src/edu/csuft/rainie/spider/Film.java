package edu.csuft.rainie.spider;

public class Film implements Comparable<Film>{           //Ĭ�ϼ̳�
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
	
	/**
	 * ӰƬ��ϸ��Ϣ��·��
	 * 
	 * @return
	 */
	String url;
	
	//�޲����Ĺ��췽��
	public Film() {
		
	}
	
	//getter 

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

//	public String toCSV() {
//	return String.format("%d,%s,%d,%.1f,%s\n",            //�ѵ�Ӱ��Ϣ����ַ�����%���ݸ�ʽ
//			id,
//			title,
//			num,
//			rating,
//			quote);
//}
	
	@Override
	public String toString() {
		return "Film [title=" + title + ", info=" + info + ", rating=" + rating + ", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}

	@Override
	public int compareTo(Film o) {
		// TODO Auto-generated method stub
		return id - o.id;                  //����
	}

}
