package com.sbs.exam.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sbs.exam.demo.vo.Article;

@Component
public class ArticleRepository {
	//메개변수 시작
		private int articleLastId;
		private List<Article> articles;
		//메개변수 끝
		
		// 서비스 메서드 시작
		public ArticleRepository() {
			articles = new ArrayList<>();
			articleLastId = articles.size()-1;
			makeTestData();

		}
		public void makeTestData() {
			for(int i = 1;i <= 10;i++) {
				String title = "제목"+i;
				String body = "내용"+i;
				writeArticle(title,body);
			}
			
		}

		public Article writeArticle(String title ,String body) {
			int id = articleLastId+1;
			Article article = new Article(id,title,body);
			
			articles.add(article);
			articleLastId = id;
			
			return article;
		}
		
		public Article getArticle(int id) {
			for(Article article : articles) {
				if( article.getId() == id) {
					return article;
				}
			}
			return null;
		}
		public List<Article> getArticles() {
				return articles;
		}

		public void deleteArticle(int id) {
			Article article = getArticle(id);
			articles.remove(article);
			
		}

		public Article modifyArticle(int id,String title,String body) {
			Article article = getArticle(id);
			article.setTitle(title);
			article.setBody(body);
			return article;
		}
		
		// 서비스 메서드 끝
}
