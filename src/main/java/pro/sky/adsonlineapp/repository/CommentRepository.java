package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
