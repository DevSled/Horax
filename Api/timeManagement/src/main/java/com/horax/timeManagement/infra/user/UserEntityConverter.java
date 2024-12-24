package com.horax.timeManagement.infra.user;

import com.horax.timeManagement.domain.user.CustomUser;
import org.springframework.stereotype.Component;

@Component
public class UserEntityConverter {

	public UserEntityConverter() {
	}

	public UserEntity fromCustomUserToUserEntity(CustomUser user) {
		return new UserEntity(user.getId(), user.getUsername(), user.getEmailAddress(), user.getPassword());

	}

	public CustomUser fromUserEntityToCustomUser(UserEntity user) {
		return new CustomUser(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
	}

}
