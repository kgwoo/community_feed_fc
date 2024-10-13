package com.gunoo.service.user.application;

import com.gunoo.service.user.application.dto.CreateUserRequestDto;
import com.gunoo.service.user.application.interfaces.UserRepository;
import com.gunoo.service.user.domain.User;
import com.gunoo.service.user.domain.UserInfo;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequestDto dto) {
        UserInfo info = new UserInfo(dto.name(), dto.profileImageUrl());
        User user = new User(null, info);
        return userRepository.save(user);
    }
}
