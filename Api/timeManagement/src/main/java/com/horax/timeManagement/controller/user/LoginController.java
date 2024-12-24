package com.horax.timeManagement.controller.user;

import com.horax.timeManagement.api.user.LoginResource;
import com.horax.timeManagement.api.user.TokenDto;
import com.horax.timeManagement.api.user.UserCredentialsDto;
import com.horax.timeManagement.domain.user.CustomUser;
import com.horax.timeManagement.domain.user.UserRepository;
import com.horax.timeManagement.security.JwtTokenManager;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LoginController implements LoginResource {

    private final UserRepository repo;
    private final AuthenticationManager authManager;
    private final JwtTokenManager tokenManager;

    public LoginController(UserRepository repo, AuthenticationManager authManager, JwtTokenManager tokenManager) {
        this.repo = repo;
        this.authManager = authManager;
        this.tokenManager = tokenManager;
    }

    @Override
    public TokenDto loginUser(UserCredentialsDto user)
    {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword()));
        CustomUser userDetails = repo.getByEmail(user.getEmailAddress());
        String token = tokenManager.createToken(userDetails.getEmailAddress(), userDetails.getId());
        return new TokenDto(token);
    }
}
