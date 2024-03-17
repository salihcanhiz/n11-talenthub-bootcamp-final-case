package com.salihcanhiz.finalcase.controller.contract;

import com.salihcanhiz.finalcase.dto.CommentDTO;

import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.request.CommentSaveRequest;
import com.salihcanhiz.finalcase.request.CommentUpdateRequest;
import org.springframework.http.ResponseEntity;

import java.util.Dictionary;
import java.util.Map;

public interface CommentControllerContract {
     CommentDTO saveComment(CommentSaveRequest request);
     CommentDTO updateComment(CommentUpdateRequest request);
     void deleteComment(Long id);

     Map<String, Double> getRestaurantRate();
}
