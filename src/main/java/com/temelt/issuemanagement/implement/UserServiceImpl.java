package com.temelt.issuemanagement.implement;

import com.temelt.issuemanagement.entity.User;
import com.temelt.issuemanagement.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }


    public User save(User user) {
        return user;
    }

    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
