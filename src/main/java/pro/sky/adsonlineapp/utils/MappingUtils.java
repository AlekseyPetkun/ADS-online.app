package pro.sky.adsonlineapp.utils;

/**
 * Сервис по работе с маппингом.
 *
 * @param <T> дто или сущность.
 */
public interface MappingUtils<T, R> {

    /**
     * Маппим сущность в дто
     *
     * @param entity сущность
     * @return дто
     */
    T mapToDto(R entity);

    /**
     * Маппим дто в сущность
     *
     * @param dto дто
     * @return сущность
     */
    R mapToEntity(T dto);
}
