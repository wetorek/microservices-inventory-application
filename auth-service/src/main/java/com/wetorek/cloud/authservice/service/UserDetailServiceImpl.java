package com.wetorek.cloud.authservice.service;

import com.wetorek.cloud.authservice.model.AuthUserDetail;
import com.wetorek.cloud.authservice.repository.UserDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserDetailRepository userDetailRepository;
    private final AccountStatusUserDetailsChecker accountStatusUserDetailsChecker;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userDetailRepository.findByUsername(username);
        log.info("Getting user details, username: {}", username);
        var userDetails = user.map(AuthUserDetail::new)
                .orElseThrow(() -> new UsernameNotFoundException("Username or password wrong"));
        accountStatusUserDetailsChecker.check(userDetails);
        return userDetails;
    }
}

