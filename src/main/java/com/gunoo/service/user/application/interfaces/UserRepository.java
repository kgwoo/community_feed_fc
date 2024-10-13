package com.gunoo.service.user.application.interfaces;

import com.gunoo.service.user.domain.User;

public interface UserRepository {

    User save(User user);
}
