package com.xebia.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.xebia.model.Article;
import com.xebia.model.ArticleOccurence;
import com.xebia.model.ArticleRequest;
import com.xebia.model.ArticleResponse;
import com.xebia.model.ArticleTimePeriod;

@Service
public interface ArticleService {

	ArticleResponse createArtice(ArticleRequest article, String slug);
	
	ArticleResponse updateArtice(ArticleRequest request);

	ArticleResponse getArticeById(String id);

	Article deleteArticeById(String id);

	Page<Article> getArticeList(Integer pageNo, Integer pageSize);

	ArticleTimePeriod getTimePeriod(String id,int speed);

	List<ArticleOccurence> getOccurrences();

}
