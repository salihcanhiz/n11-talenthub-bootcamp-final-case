package com.salihcanhiz.finalcase.service;

import com.salihcanhiz.finalcase.dao.CommentRepository;
import com.salihcanhiz.finalcase.entity.Comment;
import com.salihcanhiz.finalcase.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public Map<String, Double> getRestaurantRate() {

        List<Comment> commentList = commentRepository.findAll();

        List<String> restaurantIds = commentList.stream()
                .map(Comment::getRestaurantId)
                .distinct()
                .collect(Collectors.toList());

        Map<String, Double> restaurantAverages = new HashMap<>();

        for (String restaurantId : restaurantIds) {
            List<Comment> filteredId = commentList.stream().filter(comment -> comment.getRestaurantId().equals(restaurantId)).collect(Collectors.toList());

            long commentCount = filteredId.size();

            if (commentCount > 0) {
                double totalRate = filteredId.stream()
                        .mapToDouble(comment -> comment.getRate().getValue())
                        .sum();
                double averageRate = totalRate / commentCount;
                restaurantAverages.put(restaurantId, averageRate);
            }
        }
        return restaurantAverages;
    }

    public List<Comment> getCommentsByRestaurantId(String restaurantId) {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .filter(comment -> comment.getRestaurantId() == restaurantId)
                .collect(Collectors.toList());
    }


}
