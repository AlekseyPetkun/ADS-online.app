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
    @Query(value = "UPDATE comments SET text = :text WHERE comment_id = :commentId and ad_id = :adId", nativeQuery=true)
    Comment updateCommentById(
            @Param("adId") Integer pk,
            @Param("commentId") Integer commentId);
}

