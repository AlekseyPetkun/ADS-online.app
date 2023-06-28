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
import java.util.Collection;

/**
 * Сущность пользователя
 */
@Entity
@Data
@EqualsAndHashCode
@NoArgsConstructor
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
    @Column(name = "username")
    private String username;

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
     * Права доступа пользователя
     */
    @Column(name = "user_role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Фото пользователя
     */
    @Column(name = "image")
    private String image;

    /**
     * Объявления пользователя
     */
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<Ad> ads;
}