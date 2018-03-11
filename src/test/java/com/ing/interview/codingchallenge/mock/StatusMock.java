package com.ing.interview.codingchallenge.mock;

import java.util.Date;

import twitter4j.*;

public class StatusMock implements Status {

	@Override
	public int compareTo(Status o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public RateLimitStatus getRateLimitStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAccessLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserMentionEntity[] getUserMentionEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URLEntity[] getURLEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashtagEntity[] getHashtagEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaEntity[] getMediaEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SymbolEntity[] getSymbolEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	private Date createdAt;
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date getCreatedAt() {
		// TODO Auto-generated method stub
		return createdAt;
	}
	
	public void setCreatedAt() {
		
	}
	
	

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public int getDisplayTextRangeStart() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDisplayTextRangeEnd() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTruncated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getInReplyToStatusId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getInReplyToUserId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getInReplyToScreenName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GeoLocation getGeoLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Place getPlace() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFavorited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRetweeted() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFavoriteCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	private UserMock user;
	
	public void setUser(UserMock user) {
		this.user = user;
	}

	@Override
	public UserMock getUser() {
		// TODO Auto-generated method stub
		return user;
	}

	@Override
	public boolean isRetweet() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Status getRetweetedStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long[] getContributors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRetweetCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isRetweetedByMe() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getCurrentUserRetweetId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isPossiblySensitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getLang() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Scopes getScopes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getWithheldInCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getQuotedStatusId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Status getQuotedStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private long id;
	public void setId(long id) {
		this.id = id;
	}
	
	private String text;
	public void setText(String text) {
		this.text = text;
	}

}
