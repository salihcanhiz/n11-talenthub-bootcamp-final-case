package com.salihcanhiz.finalcase.mapper;

import com.salihcanhiz.finalcase.dto.CommentDTO;
import com.salihcanhiz.finalcase.entity.Comment;
import com.salihcanhiz.finalcase.request.CommentSaveRequest;
import com.salihcanhiz.finalcase.request.CommentUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);


    Comment convertToComment(CommentSaveRequest request);

    CommentDTO convertToCommentDTO(Comment comment);

    List<CommentDTO> convertToCommentDTOs(List<Comment> comments);

    @Mapping(target = "id", ignore = true)
    void updateComment(@MappingTarget Comment comment, CommentUpdateRequest request);
}
