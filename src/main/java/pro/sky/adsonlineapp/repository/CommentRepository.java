package pro.sky.adsonlineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    /**
     *
     * @param pk
     * @param commentId
     * @return
     */
    @Modifying
    @Query("UPDATE Comment a SET " +
            "a.text = :text" +
            " WHERE a.commentId = :commentId and a.ad.pk = :adId")
    Comment updateCommentById(
            @Param("adId") Integer pk,
            @Param("commentId") Integer commentId);
}

