package edu.csuft.rainie.spider;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


//ע�⣬װ����
@Mapper
public interface FilmMapper {
	
	
	//ӳ��ORM mapping
	@Insert("insert into film(id,title,num,rating,url,info) value(#{id},#{title},#{num},#{rating},#{url},#{info})")
	void save(Film film);
	
	@Select("select * from film where id = #{id}")
	Film load(int id);
	
	

}
