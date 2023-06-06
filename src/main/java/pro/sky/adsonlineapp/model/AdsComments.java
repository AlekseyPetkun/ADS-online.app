package pro.sky.adsonlineapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ads_comments")
public class AdsComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ads_id", referencedColumnName = "id")
    private Ads ads;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private Comments comments;

}
