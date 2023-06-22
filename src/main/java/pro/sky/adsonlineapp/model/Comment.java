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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @Column(name = "text")
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ad_id")
    private Ad ad;

    @Column(name = "create_at")
    private Instant createdAt; // localDateTime
}

