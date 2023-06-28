package pro.sky.adsonlineapp.exceptions;

/**
 * Ошибка отсутствия сущности.
 */
public class NotFoundEntityException extends RuntimeException {

    public NotFoundEntityException(String message) {
        super(message);
    }
}
