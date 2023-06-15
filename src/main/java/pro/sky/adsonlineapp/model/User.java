package pro.sky.adsonlineapp.model;

import pro.sky.adsonlineapp.constants.Role;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
//import org.hibernate.Hibernate;
//import org.hibernate.annotations.CacheConcurrencyStrategy;
//import org.hibernate.annotations.NaturalId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * Модель пользователя
 */

@NoArgsConstructor
@AllArgsConstructor
//@Builder
@Getter
@Setter
@Entity
@Slf4j
@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "users")
public class User {

    /**
     * Id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Логин пользователя
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * mail пользователя
     */
    @Column(name = "email", nullable = false, unique = true)
//    @NaturalId
    private String email;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private String password;

    /**
     * Телефон пользователя
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Фото пользователя
     */
  //  @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
  //  @OneToOne(mappedBy = "user")
   // private Pictures pictures;


    /**
     * Права доступа пользователя
     */
    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
//    @Builder.Default
    private Role role;

    private String image;

//    @PostPersist
//    public void logUserAdded() {
//        log.info(
//                "Added user: email={}, role={}",
//                email,
//                role
//        );
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
//        User user = (User) o;
//        return getEmail() != null && Objects.equals(getEmail(), user.getEmail());
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(email);
//    }

    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
}