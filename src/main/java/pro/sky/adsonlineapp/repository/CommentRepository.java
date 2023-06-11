package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("UPDATE Comment SET " +
            "Comment.text = :text" +
            " WHERE Comment.commentId = :id and Comment.ad.pk = :pk")
    Comment updateCommentById(
            @Param("adId") Integer pk,
            @Param("commentId") Integer commentId);
}

