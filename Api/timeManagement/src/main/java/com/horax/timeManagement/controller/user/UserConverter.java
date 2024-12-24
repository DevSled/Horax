package com.horax.timeManagement.controller.user;

import java.util.UUID;

import com.horax.timeManagement.api.user.FullUserDto;
import com.horax.timeManagement.api.user.LightUserDto;
import com.horax.timeManagement.api.user.UserDto;
import com.horax.timeManagement.domain.user.CustomUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserConverter {

	private final PasswordEncoder passwordEncoder;

	public UserConverter(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public LightUserDto fromUserToLightDto(CustomUser user) {
		return new LightUserDto(user.getId(), user.getUsername());
	}

	public FullUserDto fromUserToFullUserDto(CustomUser user) {
		return new FullUserDto(user.getId(), user.getUsername(), user.getEmailAddress(), "******");
	}

	public CustomUser fromLightUserDtoToUser(LightUserDto user) {
		return new CustomUser(user.getId(), user.getUsername(), null, null);
	}

	public CustomUser fromFullDtoUserToUser(FullUserDto user) {
		return new CustomUser(user.getId(), user.getUsername(), user.getEmailAddress(),
				passwordEncoder.encode(user.getPassword()));
	}

	public CustomUser fromUserDtoToUser(UserDto user) {
		return new CustomUser(UUID.randomUUID().toString(), user.getUsername(), user.getEmailAddress(),
				passwordEncoder.encode(user.getPassword()));
	}

}
