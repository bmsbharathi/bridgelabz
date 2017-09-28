package com.bridgeit.registration.Model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GmailToken {

	private String access_token, expires_in, id_token, token_type;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getId_token() {
		return id_token;
	}

	public void setId_token(String id_token) {
		this.id_token = id_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}


	public GmailToken() {
		super();

	}

	@Override
	public String toString() {
		return "GmailToken [access_token=" + access_token + ", expires_in=" + expires_in + ", id_token=" + id_token
				+ ", token_type=" + token_type + "]";
	}

}
