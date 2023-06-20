package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Изменить комментарий
     * @param pk идентификатор объявления
     * @param commentId идентификатор комментария
     * @return сущность комментария
     */
    @Modifying
    @Query("UPDATE Comment c SET " +
            "c.text = :text WHERE c.commentId = :comment_id")
    Comment updateCommentById(
            @Param("text") String text,
            @Param("comment_id") Integer commentId);

    Comment findByAuthor_Id(Integer id);
    List<Comment> findByAdId(Integer id);
}

