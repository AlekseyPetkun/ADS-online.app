package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.CreateComment;
import pro.sky.adsonlineapp.dto.RegisterReq;
import pro.sky.adsonlineapp.dto.ResponseWrapperComment;
import pro.sky.adsonlineapp.service.ValidationService;

/**
 * Бизнес логика по работе с валидацией.
 */
@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public boolean validate(Object object) {

        if (object instanceof CreateAds) {
            return ((CreateAds) object).getDescription() != null
                    && ((CreateAds) object).getTitle() != null
                    && ((CreateAds) object).getPrice() != 0;

        } else if (object instanceof RegisterReq) {
            return ((RegisterReq) object).getUsername() != null
                    && ((RegisterReq) object).getPassword() != null
                    && ((RegisterReq) object).getFirstName() != null
                    && ((RegisterReq) object).getLastName() != null
                    && ((RegisterReq) object).getPhone() != null;

        } else if (object instanceof CreateComment) {
            return ((CreateComment) object).getText() != null;
        }

        return false;
    }
}
