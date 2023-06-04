package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.model.Ads;
import pro.sky.adsonlineapp.service.AdsService;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdsServiceImpl implements AdsService {

    private final List<AdsDto> dtoList = new ArrayList<>();

    private final MappingUtils<AdsDto, Ads> mapping;

    public AdsServiceImpl(MappingUtils<AdsDto, Ads> mapping) {
        this.mapping = mapping;
    }

    //    private final AdsRepository adsRepository;

    @Override
    public List<AdsDto> getAllAds() {
        dtoList.add(new AdsDto(2, "text", 123, 456, "text2"));
        dtoList.add(new AdsDto(3, "text4", 789, 42, "text5"));

        return dtoList;
    }
}
