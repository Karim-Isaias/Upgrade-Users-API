package com.example.basic.Repositories;

import org.springframework.stereotype.Repository;
import com.example.basic.Entities.Users;
@Repository
public interface UsersRepository extends BaseRepository<Users,Long> {

}