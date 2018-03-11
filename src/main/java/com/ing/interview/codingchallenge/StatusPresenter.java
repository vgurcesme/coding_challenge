package com.ing.interview.codingchallenge;

import java.util.List;


import twitter4j.Status;

public class StatusPresenter {

	public String getContent(List<Status> statuses)
	{
		 
		StringBuffer sb = new StringBuffer();

		    try {  

		        

		        for (Status status : statuses) {
		        	
		        	sb.append(status.getUser().getId());
		        	sb.append("\t");
		        	sb.append(status.getUser().getCreatedAt().getTime());
		        	sb.append("\t");
		        	sb.append(status.getUser().getName());
		        	sb.append("\t");
		        	sb.append(status.getUser().getScreenName());
		        	sb.append("\t");
		        	sb.append(status.getId());
		        	sb.append("\t");
		        	sb.append(status.getCreatedAt().getTime());
		        	sb.append("\t");
		        	sb.append(status.getText());
		        	sb.append("\n");

		        	
		        }
					
					
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    }
		    
		    return sb.toString();
	}
}
