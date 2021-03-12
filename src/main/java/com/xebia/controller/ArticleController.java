package com.xebia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.model.Article;
import com.xebia.model.ArticleOccurence;
import com.xebia.model.ArticleRequest;
import com.xebia.model.ArticleResponse;
import com.xebia.model.ArticleTimePeriod;
import com.xebia.service.ArticleService;

@RestController
@RequestMapping("/")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@PostMapping("{slug}")
	public ArticleResponse createArtice(@RequestBody ArticleRequest article, @PathVariable("slug") String slug) {
		return articleService.createArtice(article,slug);
	}
	
	@PutMapping("{slug}")
	public ArticleResponse updateArtice(@RequestBody ArticleRequest request) {
		return articleService.updateArtice(request);
	}
	
	@GetMapping("{id}")
	public ArticleResponse getArticeById(@PathVariable String id) {
		return articleService.getArticeById(id);
	}
	
	@GetMapping("delete/{id}")
	public Article deleteArticeById(@PathVariable String id) {
		return articleService.deleteArticeById(id);
	}
	
	@GetMapping("list")
	public Page<Article> getArticeList(@RequestParam(name ="pageNo",required=true,defaultValue="0")Integer pageNo, @RequestParam(name ="size",required=true,defaultValue="1")Integer pageSize) {
		return articleService.getArticeList(pageNo,pageSize);
	}
	
	@GetMapping("time/{id}/average-speed/{speed}")
	public ArticleTimePeriod getTimePeriod(@PathVariable("id") String id, @PathVariable("speed") int speed) {
		return articleService.getTimePeriod(id,speed);
	}
	
	@GetMapping("occurences")
	public List<ArticleOccurence> getOccurrence(){
		return articleService.getOccurrences();
	}
}
