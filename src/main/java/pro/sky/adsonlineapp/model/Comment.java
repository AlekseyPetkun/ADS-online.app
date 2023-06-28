package pro.sky.adsonlineapp.model;


import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Сущность комментария
 */
@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "comments")
public class Comment {

    /**
     * Id комментария
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Автор комментария
     */
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    /**
     * Текст комментария
     */
    @Column(name = "text")
    private String text;

    /**
     * Объявление комментария
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ad_id")
    private Ad ad;

    /**
     * Дата и время комментария
     */
    @Column(name = "create_at")
    private Instant createdAt;
}

