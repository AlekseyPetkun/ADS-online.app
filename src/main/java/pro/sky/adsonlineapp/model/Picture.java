package pro.sky.adsonlineapp.model;

import lombok.*;

/**
 * Сущность картинка.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Picture {

    private String id; // идентификатор картинки
    private byte[] data; // картинка в байтах
}
