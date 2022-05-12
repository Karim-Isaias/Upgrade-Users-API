package com.example.basic.Controllers;

import com.example.basic.Entities.Base;
import com.example.basic.Entities.Users;
import com.example.basic.Services.BaseServiceImpl;
import com.example.basic.Services.UsersServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/users")
public class UsersControllerImpl extends BaseControllerImpl<Users, UsersServiceImpl> {

}
