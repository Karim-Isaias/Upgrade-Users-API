package com.example.basic.Controllers;

import com.example.basic.Entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.Serializable;
import java.util.concurrent.CompletableFuture;

public interface UsersController <E extends Base, ID extends Serializable> {
    public CompletableFuture<ResponseEntity> save(@RequestBody E entity) throws Exception;
    public CompletableFuture<ResponseEntity> update(@PathVariable ID id, @RequestBody E entity) throws Exception;
    public CompletableFuture<ResponseEntity> delete(@PathVariable ID id) throws Exception;
    CompletableFuture<ResponseEntity> getAll();
    public CompletableFuture<ResponseEntity> getOneAsync(@PathVariable ID id) throws Exception;
}
