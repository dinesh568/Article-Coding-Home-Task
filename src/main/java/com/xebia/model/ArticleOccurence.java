package com.xebia.model;

public class ArticleOccurence {

	private String tags;
	private String occurence;
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getOccurence() {
		return occurence;
	}
	public void setOccurence(String occurence) {
		this.occurence = occurence;
	}
	public ArticleOccurence(String tags, String occurence) {
		super();
		this.tags = tags;
		this.occurence = occurence;
	}
	
	
}
