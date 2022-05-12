package com.example.basic.Controllers;

import com.example.basic.Entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface UsersController <E extends Base, ID extends Serializable> {

}
