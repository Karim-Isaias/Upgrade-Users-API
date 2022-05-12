package com.example.basic.Services;

import com.example.basic.Entities.Users;
import com.example.basic.Repositories.BaseRepository;

import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Users, Long> implements UsersService {

    public UsersServiceImpl(BaseRepository<Users, Long> baseRepository) {
        super(baseRepository);
    }

}