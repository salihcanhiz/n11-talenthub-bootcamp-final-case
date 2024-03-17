package com.salihcanhiz.finalcase.controller.contract.impl;

import com.salihcanhiz.finalcase.controller.contract.CommentControllerContract;
import com.salihcanhiz.finalcase.dto.CommentDTO;
import com.salihcanhiz.finalcase.entity.Comment;

import com.salihcanhiz.finalcase.mapper.CommentMapper;

import com.salihcanhiz.finalcase.request.CommentSaveRequest;
import com.salihcanhiz.finalcase.request.CommentUpdateRequest;
import com.salihcanhiz.finalcase.service.CommentService;
import com.salihcanhiz.finalcase.service.entityservice.CommentEntityService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Dictionary;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class CommentControllerContractImpl implements CommentControllerContract {

    private final CommentEntityService commentEntityService;
    private final CommentService commentService;

    @Override
    public CommentDTO saveComment(CommentSaveRequest request) {
        Comment comment =  CommentMapper.INSTANCE.convertToComment(request);
        comment = commentEntityService.save(comment);

        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public CommentDTO updateComment(CommentUpdateRequest request) {
        Comment comment = commentEntityService.findByIdWithControl(Long.valueOf((request.id())));
        CommentMapper.INSTANCE.updateComment(comment,request);
        commentEntityService.save(comment);
        return CommentMapper.INSTANCE.convertToCommentDTO(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentEntityService.delete(id);
    }


    @Override
    public Map<String, Double> getRestaurantRate() {
        return commentService.getRestaurantRate();
    }


}
