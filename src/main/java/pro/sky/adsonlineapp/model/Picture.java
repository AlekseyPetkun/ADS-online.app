package pro.sky.adsonlineapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "pictures")
public class Picture {

    @Id
    private String id;

    @Lob
    @Column(name = "image")
    private byte[] image;
}
