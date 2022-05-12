package com.example.basic.Controllers;

import com.example.basic.Entities.Profile;

import com.example.basic.Services.ProfileServiceImpl;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/profiles")
public class ProfilesControllerImpl extends BaseControllerImpl<Profile, ProfileServiceImpl> {

}
