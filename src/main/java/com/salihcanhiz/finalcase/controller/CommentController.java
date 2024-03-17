package com.salihcanhiz.finalcase.controller;

import com.salihcanhiz.finalcase.client.RestaurantClient;
import com.salihcanhiz.finalcase.controller.contract.CommentControllerContract;
import com.salihcanhiz.finalcase.dto.CommentDTO;
import com.salihcanhiz.finalcase.general.RestResponse;
import com.salihcanhiz.finalcase.request.CommentSaveRequest;
import com.salihcanhiz.finalcase.request.CommentUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Tag(name ="Comment Controller" )
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final RestaurantClient restaurantClient;
    private final CommentControllerContract commentControllerContract;
    @PostMapping
    @Operation(summary = "Save Comment")
    public ResponseEntity<RestResponse<CommentDTO>> addCommentToRestaurant(@Valid @RequestBody CommentSaveRequest request){
        CommentDTO commentDTO = commentControllerContract.saveComment(request);

        return ResponseEntity.ok(RestResponse.of(commentDTO));

    }

    @PutMapping("/{debugCommentId}")
    @Operation(summary = "Update Comment")
    public ResponseEntity<RestResponse<CommentDTO>> updateCustomer(@Valid @PathVariable Long debugCommentId,@RequestBody CommentUpdateRequest request){
        CommentDTO commentDTO = commentControllerContract.updateComment(request);

        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Comment")
    public void deleteComment(@PathVariable @NotNull Long id){
        commentControllerContract.deleteComment(id);

    }
    @GetMapping("/restaurant-rates")
    @Operation(summary = "Get All Restaurants Rate")
    public Map<String, Double> getRestaurantRate(){

        return commentControllerContract.getRestaurantRate();

    }




}
