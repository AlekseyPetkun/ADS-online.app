package pro.sky.adsonlineapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pictures")
public class Picture {

    @Id
    private String id;

    @Lob
    @Column(name = "data")
    private byte[] data;
}
