package com.example.basic.Controllers;

import com.example.basic.Entities.Profile;

import com.example.basic.Services.ProfileServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/profiles")
public class ProfilesControllerImpl extends BaseControllerImpl<Profile, ProfileServiceImpl> {

}
