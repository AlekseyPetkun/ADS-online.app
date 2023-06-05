package pro.sky.adsonlineapp.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Ads;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.service.AdsService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    private final ValidationService validationService;
    private final AdsRepository adsRepository;
    private final MappingUtils<CreateAds, Ads> createAdsMapping;
    private final MappingUtils<AdsDto, Ads> adsMapping;

    public AdsServiceImpl(ValidationService validationService,
                          AdsRepository adsRepository,
                          MappingUtils<CreateAds, Ads> createAdsMapping,
                          MappingUtils<AdsDto, Ads> adsMapping) {
        this.validationService = validationService;
        this.adsRepository = adsRepository;
        this.createAdsMapping = createAdsMapping;
        this.adsMapping = adsMapping;
    }


    @Override
    public List<AdsDto> getAllAds() {

        return adsRepository.findAll().stream()
                .map(adsMapping::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AdsDto addAd(CreateAds dto) {

        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }

        Ads entity = createAdsMapping.mapToEntity(dto);

        adsRepository.save(entity);

        Ads entity1 = adsRepository.getReferenceById(entity.getPk());

        AdsDto adsDto = adsMapping.mapToDto(entity1);

        return adsDto;
    }
}
