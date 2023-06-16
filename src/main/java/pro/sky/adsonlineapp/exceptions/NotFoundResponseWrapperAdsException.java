package pro.sky.adsonlineapp.exceptions;

/**
 * Ошибка отсутствия объявления
 */
public class NotFoundResponseWrapperAdsException extends RuntimeException{

    public NotFoundResponseWrapperAdsException(String message) {
        super(message);
    }
}
