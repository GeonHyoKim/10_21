package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.Article;

@Controller
public class UsrArticleController {
	private List<Article> lists = new ArrayList<>();
	private int id;
	
	@GetMapping("/usr/article/doWrite")
	@ResponseBody
	public Article doWrite(String title, String body) {
		id++;
		Article writeArticle = new Article(id, title, body);
		lists.add(writeArticle);
		return writeArticle; 
	}
	
	@GetMapping("/usr/article/showList")
	@ResponseBody
	public List<Article> showList() {
		return lists;
	}
	
	@GetMapping("/usr/article/detail")
	@ResponseBody
	public Object detail(int id) {
		for(Article article : lists) {
			if(article.getId() == id) {
				return article;
			}
		}
		return "글이 존재하지 않습니다.";
	}
	
}
