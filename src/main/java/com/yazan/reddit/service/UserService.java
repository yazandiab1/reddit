package com.yazan.reddit.service;

import com.yazan.reddit.domain.User;

public interface UserService {
    public User register(User user);
    User save(User user);
    public void saveUsers(User... users);

}
