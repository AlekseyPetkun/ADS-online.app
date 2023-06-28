package pro.sky.adsonlineapp.exceptions;

/**
 * Ошибка несовпадения старого пароля.
 */
public class CurrentPasswordNotMatch extends RuntimeException {

    public CurrentPasswordNotMatch(String message) {
        super(message);
    }
}
