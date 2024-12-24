package com.horax.timeManagement.domain.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomUser {

	private String id;
	private String username;
	private String emailAddress;
	private String password;

	public CustomUser(String id, String username, String emailAddress, String password) {
		this.id = id;
		this.username = username;
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}


	public Collection<GrantedAuthority> getGrantedAuthority() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return authorities;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null || getClass() != object.getClass())
			return false;

		CustomUser receivedItem = (CustomUser) object;

		return receivedItem.id.equals(this.id) && receivedItem.username.equals(this.username)
				&& receivedItem.emailAddress.equals(this.emailAddress) && receivedItem.password.equals(this.password);
	}
}
