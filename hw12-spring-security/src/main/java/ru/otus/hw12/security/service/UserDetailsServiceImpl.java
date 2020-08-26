package ru.otus.hw12.security.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.otus.hw12.model.User;
import ru.otus.hw12.security.model.SecurityUserDetails;
import ru.otus.hw12.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  @Override
  @SneakyThrows
  public UserDetails loadUserByUsername(String username) {
    Optional<User> optionalUser = userService.findUserByUsername(username);
    return optionalUser.map(SecurityUserDetails::new).orElseGet(() -> new SecurityUserDetails(new User()));
  }
}