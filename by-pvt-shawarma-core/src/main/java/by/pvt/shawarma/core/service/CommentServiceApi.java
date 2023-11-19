package by.pvt.shawarma.core.service;

import by.pvt.shawarma.api.contract.CommentApi;
import by.pvt.shawarma.api.dto.CommentRequest;
import by.pvt.shawarma.api.dto.CommentResponse;
import by.pvt.shawarma.core.entity.Comment;
import by.pvt.shawarma.core.exception.ProgramException;
import by.pvt.shawarma.core.mapper.CommentMappers;
import by.pvt.shawarma.core.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceApi implements CommentApi {
    private final CommentRepository commentRepository;
    private final CommentMappers commentMappers;

    @Transactional
    @Override
    public CommentResponse save(CommentRequest commentRequest) {
        return commentMappers.toResponse(commentRepository.save(commentMappers.toEntity(commentRequest)));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentResponse findById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            return commentMappers.toResponse(comment.get());
        }
        else throw new ProgramException("Такого комментария не существует");
    }

    @Override
    public List<CommentResponse> getAll() {
        return commentRepository.findAll().stream().map(commentMappers::toResponse).collect(Collectors.toList());
    }
}
