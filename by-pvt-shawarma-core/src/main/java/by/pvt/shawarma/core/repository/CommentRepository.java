package by.pvt.shawarma.core.repository;

import by.pvt.shawarma.core.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
