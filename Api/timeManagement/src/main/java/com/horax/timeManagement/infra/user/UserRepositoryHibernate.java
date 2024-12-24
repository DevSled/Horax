package com.horax.timeManagement.infra.user;

import java.util.Optional;

import com.horax.timeManagement.domain.user.CustomUser;
import com.horax.timeManagement.domain.user.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryHibernate implements UserRepository {

	private final UserDao dao;
	private final UserEntityConverter converter;

	public UserRepositoryHibernate(UserDao dao, UserEntityConverter converter) {
		this.dao = dao;
		this.converter = converter;
	}

	// CREATE
	@Override
	public CustomUser create(CustomUser user) {
		Optional<UserEntity> result = dao.findByEmail(user.getEmailAddress());
		if (result.isEmpty()) {
			UserEntity entity = dao.save(converter.fromCustomUserToUserEntity(user));
			return converter.fromUserEntityToCustomUser(entity);
		} else {
//			throw new DuplicateException(
//					String.format(ErrorMessageLabel.MSG_CREATE_USER_EMAIL_ALREADY_EXISTS, user.getEmailAddress()),
//					ErrorMessageLabel.CODE_CREATE_USER_EMAIL_ALREADY_EXISTS);
			throw new RuntimeException("Temp");
		}
	}

	// GET
	@Override
	public CustomUser getBy(String id) {
		Optional<UserEntity> user = dao.findById(id);
		if (user.isPresent()) {
			return converter.fromUserEntityToCustomUser(user.get());
		}
		throw  new RuntimeException("Temp");
		//throw new ObjectNotFoundException(String.format(ErrorMessageLabel.MSG_0001_UNKNOWN_ID_GET, "User", id));
	}

	@Override
	public CustomUser getByEmail(String email) {
		Optional<UserEntity> user = dao.findByEmail(email);
		if (user.isPresent()) {
			return converter.fromUserEntityToCustomUser(user.get());
		}
		throw  new RuntimeException("Temp");

		//throw new ObjectNotFoundException(String.format(ErrorMessageLabel.MSG_0004_GET_EMAIL_DOES_NOT_EXIST, "User"));
	}

	// UPDATE
	@Override
	public void save(String id, CustomUser user) {
		Optional<UserEntity> result = dao.findById(id);
		if (result.isEmpty()) {
			//throw  new RuntimeException("Temp");
			//throw new ObjectNotFoundException(String.format(ErrorMessageLabel.MSG_0001_UNKNOWN_ID_GET, "User", id));
		}
		dao.save(converter.fromCustomUserToUserEntity(user));
	}

}
