package com.salihcanhiz.finalcase.controller.contract.impl;

import com.salihcanhiz.finalcase.dto.CommentDTO;
import com.salihcanhiz.finalcase.entity.Comment;
import com.salihcanhiz.finalcase.entity.Customer;
import com.salihcanhiz.finalcase.enums.Rate;
import com.salihcanhiz.finalcase.request.CommentSaveRequest;
import com.salihcanhiz.finalcase.request.CommentUpdateRequest;
import com.salihcanhiz.finalcase.service.entityservice.CommentEntityService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class CommentControllerContractImplTest {
    @Mock
    private CommentEntityService commentEntityService;

    @InjectMocks
    private CommentControllerContractImpl commentControllerContractImpl;
    @Test
    void shouldSaveComment() {
        CommentSaveRequest request = new CommentSaveRequest("c84jxhf0-sakxc","Nice", Rate.TWO_STARS);

        commentControllerContractImpl.saveComment(request);

        verify(commentEntityService,times(1)).save(any(Comment.class));
    }

    @Test
    void shouldUpdateComment() {
        CommentUpdateRequest updateRequest = new CommentUpdateRequest(2L,"text",Rate.FOUR_STARS);

        Comment comment = new Comment();
        comment.setId(2L);
        comment.setRestaurantId("12515");
        comment.setText("text");
        comment.setRate(Rate.FOUR_STARS);

        Mockito.when(commentEntityService.findByIdWithControl(Mockito.anyLong())).thenReturn(comment);
        CommentDTO result = commentControllerContractImpl.updateComment(updateRequest);

        assertEquals(2L,result.id());
        assertEquals(updateRequest.text(),result.text());
        assertEquals(updateRequest.rate(),result.rate());
    }

    @Test
    void shouldDeleteComment() {

        Long commentId = 1L;
        Comment comment = new Comment();
        comment.setId(commentId);

        Mockito.doNothing().when(commentEntityService).delete(commentId);
        commentControllerContractImpl.deleteComment(commentId);
        Mockito.verify(commentEntityService,Mockito.times(1)).delete(commentId);
    }

    @Test
    void shouldGetRestaurantRate() {


    }
}