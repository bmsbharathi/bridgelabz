package com.bridgeit.registration.Model;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GmailProfile {

	  private String id;
	  private List<GmailEmail> emails;
	  private String displayName;
	  private String gender;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<GmailEmail> getEmails() {
		return emails;
	}
	public void setEmails(List<GmailEmail> emails) {
		this.emails = emails;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User Details[id=" + id + ", emails=" + emails + ", displayName=" + displayName + ", gender=" + gender
				+ "]";
	}
	
	  
}