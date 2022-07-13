package com.sbs.exam.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sbs.exam.demo.vo.Article;

@Mapper
public interface ArticleRepository {
	@Insert("insert into article set regDate = now(),updateDate = now(),title=#{title},`body`=#{body}")
	public Article writeArticle(String title, String body);

	@Select("slect * from article where id = #{id}")
	public Article getArticle(@Param("id")int id);
	
	@Select("slect * from article")
	public List<Article> getArticles();

	@Delete("delete from article where id = #{id}")
	public void deleteArticle(@Param("id")int id);

	@Update("update article set title= #{title},`body`=#{body} updateDate = now() where id = #{id}")
	public Article modifyArticle(int id, String title, String body);
	
}
