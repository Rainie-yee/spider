package edu.csuft.rainie.spiderfirst;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbaoMapper {
	@Insert("insert into shop (shopname,introduce,price,post,people,rate1,rate2,rate3,img,info) values (#{shopname},#{introduce},#{price},#{post},#{people},#{rate1},#{rate2},#{rate3},#{img},#{info})")
	void save(Tbao t);
}
