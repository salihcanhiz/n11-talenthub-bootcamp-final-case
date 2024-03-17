package com.salihcanhiz.finalcase.service.entityservice;


import com.salihcanhiz.finalcase.dao.CommentRepository;
import com.salihcanhiz.finalcase.dto.CommentDTO;
import com.salihcanhiz.finalcase.entity.Comment;

import com.salihcanhiz.finalcase.general.BaseEntityService;
import com.salihcanhiz.finalcase.general.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.List;

@Service
public class CommentEntityService extends BaseEntityService<Comment, CommentRepository> {
    protected CommentEntityService(CommentRepository repository) {
        super(repository);
    }


}
