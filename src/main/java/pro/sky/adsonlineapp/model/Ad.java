package pro.sky.adsonlineapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;


/**
 * Сущность объявления.
 */
@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ads")
public class Ad {

    /**
     * Id объявления
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Цена объявления
     */
    @Column(name = "price")
    private Integer price;

    /**
     * Описание объявления
     */
    @Column(name = "title")
    private String title;

    /**
     * Название объявления
     */
    @Column(name = "description")
    private String description;

    /**
     * Картинка объявления
     */
    @Column(name = "image_path")
    private String imagePath;

    /**
     * Автор объявления
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    /**
     * Комментарии объявления
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ad"
            , cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Comment> comments;
}
