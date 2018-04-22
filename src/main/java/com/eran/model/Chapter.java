package com.eran.model;

public class Chapter {

	public Chapter() {

	};

	public Chapter(String summary, String keywords, String content) {
		super();
		this.summary = summary;
		this.keywords = keywords;
		this.content = content;
	}

	private String summary;

	private String keywords;

	private String content;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
