package com.sbs.exam.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.Data;

@Controller
public class UsrHomeController {
	private int count; 
	
	public UsrHomeController() {
		count = 0; 
	}
	@RequestMapping ("usr/home/getString")
	@ResponseBody
	public String getString() {
		return "String";
	}
	@RequestMapping ("usr/home/getInt")
	@ResponseBody
	public int getInteger() {
		return 1;
	}
	@RequestMapping ("usr/home/getDouble")
	@ResponseBody
	public double getDouble() {
		return 15.2;
	}
	@RequestMapping ("usr/home/getFloat")
	@ResponseBody
	public float getFloat() {
		return 10.3f;
	}
	@RequestMapping ("usr/home/getBoolean")
	@ResponseBody
	public boolean getBoolean() {
		return false;
	}
	@RequestMapping ("usr/home/getCharacter")
	@ResponseBody
	public char getCharacter() {
		return 'a';
	}
	@RequestMapping ("usr/home/getMap")
	@ResponseBody
	public Map<String, Object> getMap() {
		Map<String, Object> map = new HashMap<>();
		map.put("철수", 22);
		map.put("영희", 21);
		return map;
	}
	
	@RequestMapping ("usr/home/getList")
	@ResponseBody
	public List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("철수");
		return list;
	}
	@RequestMapping ("usr/home/getArticle")
	@ResponseBody
	public Article getArticle() {
		Article article = new Article();
		return article;
	}
	
}
@Data
class Article {
	private int id;
	private String title;
	
	public Article() {
		id = 1;
		title = "제목";
	}
}