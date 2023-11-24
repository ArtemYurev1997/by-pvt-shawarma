package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.CommentRequest;
import by.pvt.shawarma.api.dto.CommentResponse;
import by.pvt.shawarma.core.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMappers {
    CommentResponse toResponse(Comment comment);
    Comment toEntity(CommentRequest commentRequest);
}
