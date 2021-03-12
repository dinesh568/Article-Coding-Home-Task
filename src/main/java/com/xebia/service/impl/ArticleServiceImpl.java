package com.xebia.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.xebia.model.Article;
import com.xebia.model.ArticleOccurence;
import com.xebia.model.ArticleRequest;
import com.xebia.model.ArticleResponse;
import com.xebia.model.ArticleTimePeriod;
import com.xebia.model.TimeRead;
import com.xebia.repository.ArticleRepository;
import com.xebia.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	public ArticleResponse createArtice(ArticleRequest request, String slug) {
		Article article = new Article();
		article.setSlug(slug);
		article.setTitle(request.getTitle());
		article.setBody(request.getBody());
		article.setDescription(request.getDescription());
		String tags = request.getTags().stream().map(n -> n.toLowerCase()).collect(Collectors.joining(","));
		article.setTags(tags);
		articleRepository.save(article);
		return new ArticleResponse(article,request);
	}

	public ArticleResponse updateArtice(ArticleRequest request) {
		if(Objects.nonNull(request.getSlug())) {
			Optional<Article> article = articleRepository.findById(request.getSlug());
			Article extisingArticle = article.get();
			extisingArticle.setTitle(request.getTitle());
			extisingArticle.setBody(request.getBody());
			extisingArticle.setDescription(request.getDescription());
			String tags = request.getTags().stream().map(n -> n.toLowerCase()).collect(Collectors.joining(","));
			extisingArticle.setTags(tags);
			 articleRepository.save(extisingArticle);
			 return new ArticleResponse(extisingArticle);
		}else {
			return null;
		}
		
	}

	public ArticleResponse getArticeById(String id) {
		Optional<Article> article = articleRepository.findById(id);
		return new ArticleResponse(article.get());
	}

	public Article deleteArticeById(String id) {
		articleRepository.deleteById(id);
		return null;
	}

	public Page<Article> getArticeList(Integer pageNo, Integer pageSize) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize);
		return articleRepository.findAll(paging);
	}

	@Override
	public ArticleTimePeriod getTimePeriod(String id,int speed) {
		ArticleResponse articleResponse = getArticeById(id);
		ArticleTimePeriod timePeriod = new ArticleTimePeriod();
		timePeriod.setSlugId(articleResponse.getSlug());
		TimeRead timeRead = new TimeRead();
		int speedToRead = articleResponse.getSlug().length()/speed;
		if(speedToRead >= 60) {
			int mins = speedToRead/60;
			int secs = speedToRead%60;
			timeRead.setMins(mins);
			timeRead.setSeconds(secs);
		} else {
			timeRead.setSeconds(speedToRead);
		}
		timePeriod.setTimeToRead(timeRead);
		return timePeriod;
	}

	@Override
	public List<ArticleOccurence> getOccurrences() {
		List<ArticleOccurence> occurence = new ArrayList<>();
		List<Article> articleList = articleRepository.findAll();
		List<ArticleResponse> articleResponseList = articleList.stream().map(article -> new ArticleResponse(article)).collect(Collectors.toList());
		List<List<String>> tagsList = articleResponseList.stream().map(articleResponse -> articleResponse.getTags()).collect(Collectors.toList());
		List<String> tags = tagsList.stream().flatMap(l -> l.stream()) .collect(Collectors.toList());
		Map<String, Integer> hm = new HashMap<String, Integer>(); 
		  
        for (String i : tags) { 
            Integer j = hm.get(i); 
            hm.put(i, (j == null) ? 1 : j + 1); 
        } 
        for (Map.Entry<String, Integer> val : hm.entrySet()) { 
        	occurence.add(new ArticleOccurence(val.getKey(),val.getValue().toString()));
        }
		return occurence;
	}


	

}
