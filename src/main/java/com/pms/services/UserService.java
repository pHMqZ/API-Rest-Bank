package com.pms.services;

import com.pms.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
