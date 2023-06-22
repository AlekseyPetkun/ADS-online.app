package pro.sky.adsonlineapp.model;


import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * Сущность объявления.
 */
@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id") //, foreignKey = @ForeignKey(name = "fk_ads_users"))
    private User author;

//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "image")
//    private Picture picture;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ad"
            , cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Comment> comments;

}
