package com.example.buensaboruno.presentation.base;

import com.example.buensaboruno.domain.dtos.BaseDTO;
import com.example.buensaboruno.domain.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController<D extends BaseDTO, ID extends Serializable> {
    public ResponseEntity<?> getAll();
    public ResponseEntity<?> getOne(@PathVariable ID id);
    public ResponseEntity<?> save(@RequestBody D entity);
    public ResponseEntity<?> update(@PathVariable ID id, @RequestBody D entity);
    public ResponseEntity<?> delete(@PathVariable ID id);
}
