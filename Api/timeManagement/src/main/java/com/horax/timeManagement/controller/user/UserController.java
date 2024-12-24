package com.horax.timeManagement.controller.user;

import com.horax.timeManagement.api.user.FullUserDto;
import com.horax.timeManagement.api.user.LightUserDto;
import com.horax.timeManagement.api.user.UserDto;
import com.horax.timeManagement.api.user.UserResource;
import com.horax.timeManagement.domain.user.CustomUser;
import com.horax.timeManagement.domain.user.UserRepository;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements UserResource {

	private final UserRepository repo;
	private final UserConverter converter;
	//private final ValidatorFactory validatorFactory;

	public UserController(UserRepository repo, UserConverter converter) {
		this.repo = repo;
		this.converter = converter;

	}

//	public UserController(UserRepository repo, UserConverter converter, ValidatorFactory validatorFactory) {
//		this.repo = repo;
//		this.converter = converter;
//		this.validatorFactory = validatorFactory;
//	}

	// CREATE
	@Override
	public void createUser(UserDto user) {
		//CustomValidator<UserDto, String> validator = validatorFactory.getUserDtoValidator();
		//validator.validate(user);
		//validator.verify(ErrorMessageLabel.MSG_VAL_GENERIC);
		CustomUser converted = converter.fromUserDtoToUser(user);
		repo.create(converted);
	}

	// GET
	@Override
	public LightUserDto getUser(String id) {
		//CustomValidator<UserDto, String> validator = validatorFactory.getUserDtoValidator();
		//validator.validateId(id);
		//validator.verify(ErrorMessageLabel.MSG_VAL_GENERIC);
		return converter.fromUserToLightDto(repo.getBy(id));
	}

	// UPDATE
	@Override
	public void modifyPassword(String userId, FullUserDto user) {
	//	CustomValidator<FullUserDto, String> validator = validatorFactory.getFullUserDtoValidator();
	//	validator.validate(userId, user);
		//validator.verify(ErrorMessageLabel.MSG_VAL_GENERIC);
		repo.save(userId, converter.fromFullDtoUserToUser(user));
	}

	@Override
	public void modifyUserInfos(String userId, LightUserDto user) {
	//	CustomValidator<LightUserDto, String> validator = validatorFactory.getLightUserDtoValidator();
	//	validator.validate(userId, user);
	//	validator.verify(ErrorMessageLabel.MSG_VAL_GENERIC);
		repo.save(userId, converter.fromLightUserDtoToUser(user));
	}

}
