package com.sbs.exam.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.demo.vo.Article;


@Controller
public class UsrArticleController {
	private List<Article> articles;
	private int articleLastId;
	
	public UsrArticleController() {
		articles = new ArrayList<>();
		articleLastId = articles.size()-1;
		
		makeTestData();
	}
	
	private void makeTestData() {
		for(int i = 1;i <= 10;i++) {
			Article article = new Article(i,"제목"+i,"내용"+i);
			articles.add(article);
		}
		
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title ,String body) {
		int id = articleLastId+1;		
		Article article = new Article(id,title,body);
		articles.add(article);
		articleLastId =id;
		return article;
	}
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public  List<Article> getArticles() {
		return articles;
	}
	
	@RequestMapping("usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id){
//		for(int i = 0 ; i < articles.size();i++) {
//			if(articles.get(i).getId()==id) {
//				articles.remove(i);
//				break;
//			}
//		}
		articles.remove(id);
		return id+"번 째 게시물을 삭제 하였습니다.";
	}
	
	
}
