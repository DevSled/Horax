package com.horax.timeManagement.domain.user;

import com.horax.timeManagement.domain.UpdateRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UpdateRepository<String, CustomUser>
{
	CustomUser getByEmail(String email);
}
