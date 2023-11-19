package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.CommentRequest;
import by.pvt.shawarma.api.dto.CommentResponse;

import java.util.List;

public interface CommentApi {
    CommentResponse save(CommentRequest commentRequest);

    void delete(Long id);

    CommentResponse findById(Long id);

    List<CommentResponse> getAll();
}
