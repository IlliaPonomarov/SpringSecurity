package ua.ponomarov.illia.springsecuritycourse.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ua.ponomarov.illia.springsecuritycourse.service.PersonDetailsService;

import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.config.AuthConfigProvider;
import javax.security.auth.message.config.ClientAuthConfig;
import javax.security.auth.message.config.ServerAuthConfig;
import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private final PersonDetailsService personDetailsService;

    @Autowired
    public AuthProviderImpl(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        /// Получили данные  пользователя с формы
        String username = authentication.getName();

        // Ищем пользователя по его нику в БД.
        UserDetails personDetails = personDetailsService.loadUserByUsername(username);

        // Если пользователь был найден ,то получаем пароль с формы.
        String password = authentication.getCredentials().toString();

        // Сравниваем пароль с формы , с паролем пользователя, который в БД
        if (!password.equals(personDetails.getPassword()))
             throw new BadCredentialsException("Incorrect Password");


        return new UsernamePasswordAuthenticationToken(personDetails, password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
