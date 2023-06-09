package pro.sky.adsonlineapp.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.service.AdsService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.MappingUtils;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {

    @Value("${path.to.pictures.folder}")
    private String adsImage;

    private final ValidationService validationService;
    private final AdsRepository adsRepository;
    private final MappingUtils<CreateAds, Ad> createAdsMapping;
    private final MappingUtils<AdsDto, Ad> adsMapping;

    public AdsServiceImpl(ValidationService validationService,
                          AdsRepository adsRepository,
                          MappingUtils<CreateAds, Ad> createAdsMapping,
                          MappingUtils<AdsDto, Ad> adsMapping) {
        this.validationService = validationService;
        this.adsRepository = adsRepository;
        this.createAdsMapping = createAdsMapping;
        this.adsMapping = adsMapping;
    }

    @Override
    public ResponseWrapperAds getAllAds() {
        List<AdsDto> adsDto = adsRepository.findAll().stream()
                .map(adsMapping::mapToDto)
                .collect(Collectors.toList());
        return new ResponseWrapperAds(adsDto.size(), adsDto);
    }

//    @Override
//    public List<AdsDto> getAllAds() {
//
//        return adsRepository.findAll().stream()
//                .map(adsMapping::mapToDto)
//                .collect(Collectors.toList());
//    }

    @Override
    public AdsDto addAd(CreateAds dto, MultipartFile image) {

        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }

        Ad entity = createAdsMapping.mapToEntity(dto);

        adsRepository.save(entity);

        Ad entity1 = adsRepository.getReferenceById(entity.getPk());

        AdsDto adsDto = adsMapping.mapToDto(entity1);

        return adsDto;
    }

    @Override
    public FullAds getFullAdsById(Integer id) {
        return null;
    }

    @Override
    public boolean deleteAdById(Integer id) {
        return false;
    }

    @Override
    public AdsDto updateAdsById(Integer id, CreateAds dto) {
        return null;
    }

    @Override
    public ResponseWrapperAds getAdsMe() {
        return null;
    }
}
