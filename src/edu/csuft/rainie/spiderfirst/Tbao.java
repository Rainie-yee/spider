package edu.csuft.rainie.spiderfirst;

/**
 * �Ա�Ůװ��Ϣ
 * 
 * @author rainie
 *
 */
public class Tbao {

	/**
	 * �̵�����
	 */
	String shopname;

	/**
	 * ��Ʒ����
	 */
	String introduce;

	/**
	 * �۸�
	 */
	double price;

	/**
	 * ����
	 */
	String post;

	/**
	 * ��������
	 */
	int people;

	/**
	 * ��ʵ����
	 */
	double rate1;

	/**
	 * ����̬��
	 */
	double rate2;

	/**
	 * �����ٶ�
	 */
	double rate3;

	/**
	 * ͼƬ
	 */
	String img;

	/**
	 * ��ϸ��Ϣ
	 */
	String info;

	public Tbao() {
		super();
	}

	/**
	 * ��ʽ�����
	 * 
	 */
	public String toCSV() {
		return String.format("%s,%s,%.2f,%s,%d,%.1f,%.1f,%.1f,%s,%s\n", shopname, introduce, price, post, people, rate1,
				rate2, rate3, img, info);
	}

}
