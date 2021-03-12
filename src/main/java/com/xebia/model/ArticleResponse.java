package com.xebia.model;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ArticleResponse {

	private String slug;
	private String title;
	private String description;
	private String body;
	private List<String> tags;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public ArticleResponse(Article article, ArticleRequest request) {
		this.slug = article.getSlug();
		this.title = article.getTitle();
		this.body = article.getBody();
		this.description = article.getDescription();
		this.tags = request.getTags().stream().map(n -> n.toLowerCase()).collect(Collectors.toList());
	}
	
	public ArticleResponse(Article article) {
		this.slug = article.getSlug();
		this.title = article.getTitle();
		this.body = article.getBody();
		this.description = article.getDescription();
		this.tags = convertToList(article.getTags());
		this.createdAt = article.getCreatedAt();
		this.updatedAt = article.getUpdatedAt();
	}
	
	private List<String> convertToList(String tags) {
		String tag[] = tags.split(",");
		return Arrays.asList(tag);
	}
}
