package pro.sky.adsonlineapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
@Setter
@javax.persistence.Entity
@Slf4j
@javax.persistence.Cacheable
@javax.persistence.Table(name = "pictures")
public class Pictures {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    @Type(type = "binary")
    private byte[] picture;

    @Override
    public String toString() {
        return "Pictures{" +
                "id=" + id +
                ", picture=" + Arrays.toString(picture) +
                '}';
    }
}
