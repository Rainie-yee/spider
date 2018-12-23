package edu.csuft.rainie.spiderfirst;

/**
 * 淘宝女装信息
 * 
 * @author rainie
 *
 */
public class Tbao {

	/**
	 * 商店名称
	 */
	String shopname;

	/**
	 * 商品描述
	 */
	String introduce;

	/**
	 * 价格
	 */
	double price;

	/**
	 * 包邮
	 */
	String post;

	/**
	 * 付款人数
	 */
	int people;

	/**
	 * 如实描述
	 */
	double rate1;

	/**
	 * 服务态度
	 */
	double rate2;

	/**
	 * 发货速度
	 */
	double rate3;

	/**
	 * 图片
	 */
	String img;

	/**
	 * 详细信息
	 */
	String info;

	public Tbao() {
		super();
	}

	/**
	 * 格式化输出
	 * 
	 */
	public String toCSV() {
		return String.format("%s,%s,%.2f,%s,%d,%.1f,%.1f,%.1f,%s,%s\n", shopname, introduce, price, post, people, rate1,
				rate2, rate3, img, info);
	}

}
