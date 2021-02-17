package com.trl.userserviceb.core.service;

import com.trl.userserviceb.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * This interface is designed to support service for {@literal UserDTO}.
 *
 * @author Tsyupryk Roman
 */
public interface UserService {

    void create(User user);

    User getById(Long id);

    Page<User> getAll(Pageable pageable);

    User update(Long id, User user);

    void delete(Long id);
}

