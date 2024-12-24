package com.horax.timeManagement.controller.user;

import com.horax.timeManagement.api.user.SignupResource;
import com.horax.timeManagement.api.user.TokenDto;
import com.horax.timeManagement.api.user.UserDto;
import com.horax.timeManagement.domain.user.CustomUser;
import com.horax.timeManagement.domain.user.UserRepository;
import com.horax.timeManagement.security.JwtTokenManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupController implements SignupResource {

	private final UserRepository repo;
	private final JwtTokenManager tokenManager;
	private final UserConverter converter;
	//private final ValidatorFactory validatorFactory;

	public SignupController(UserRepository repo, JwtTokenManager tokenManager, UserConverter converter) {
		super();
		this.repo = repo;
		this.tokenManager = tokenManager;
		this.converter = converter;
	}

	@Override
	public TokenDto signUpUser(UserDto user)
	{
		//CustomValidator<UserDto, String> validator = validatorFactory.getUserDtoValidator();
		//validator.validate(user);
		//validator.verify(ErrorMessageLabel.MSG_VAL_GENERIC);
		repo.create(converter.fromUserDtoToUser(user));
		CustomUser userDetails = repo.getByEmail(user.getEmailAddress());
		String token = tokenManager.createToken(userDetails.getEmailAddress(),
				userDetails.getId());
		return new TokenDto(token);
	}
}
