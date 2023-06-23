package pro.sky.adsonlineapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.adsonlineapp.constants.Role;
import pro.sky.adsonlineapp.dto.AdsDto;
import pro.sky.adsonlineapp.dto.CreateAds;
import pro.sky.adsonlineapp.dto.FullAds;
import pro.sky.adsonlineapp.dto.ResponseWrapperAds;
import pro.sky.adsonlineapp.exceptions.NotFoundEntityException;
import pro.sky.adsonlineapp.exceptions.ValidationException;
import pro.sky.adsonlineapp.model.Ad;
import pro.sky.adsonlineapp.model.Picture;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.repository.AdsRepository;
import pro.sky.adsonlineapp.repository.PictureRepository;
import pro.sky.adsonlineapp.repository.UserRepository;
import pro.sky.adsonlineapp.service.AdsService;
import pro.sky.adsonlineapp.service.ValidationService;
import pro.sky.adsonlineapp.utils.AdsMappingUtils;
import pro.sky.adsonlineapp.utils.FullAdsMappingUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static pro.sky.adsonlineapp.constants.Message.NOT_FOUND_ENTITY;

/**
 * Бизнес-логика по работе с объявлениями.
 */
@Service
@AllArgsConstructor
public class AdsServiceImpl implements AdsService {

    //    @Value("${path.to.pictures.folder}")
//    private String adsImage;

    private final ValidationService validationService;
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;
    private final AdsMappingUtils adsMapping;
    private final FullAdsMappingUtils fullAdsMapping;
    private final PictureServiceImpl pictureService;
    private final PictureRepository pictureRepository;


    @Override
    public ResponseWrapperAds getAllAds() {

        List<AdsDto> adsDto = adsRepository.findAll().stream()
                .map(adsMapping::mapToDto)
                .collect(Collectors.toList());

        return new ResponseWrapperAds(adsDto.size(), adsDto);
    }

    @Override
    public AdsDto addAd(CreateAds dto, MultipartFile image, String userDetails) {

        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }

        User user = userRepository.findByUsername(userDetails);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        Ad entity = adsMapping.mapToEntity(dto, user);

        entity.setImagePath(pictureService.addImage(image));

        adsRepository.save(entity);

        AdsDto adsDto = adsMapping.mapToDto(entity);

        return adsDto;
    }

    @Override
    public FullAds getFullAdsById(Integer id) {

        Ad entity = adsRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        FullAds dto = fullAdsMapping.mapToDto(entity);

        return dto;
    }

    @Override
    public boolean deleteAdById(Integer id, String userDetails) {

        User authorOrAdmin = userRepository.findByUsername(userDetails);
        Ad entity = adsRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        if (entity.getAuthor().getUsername().equals(userDetails)
                || authorOrAdmin.getRole() == Role.ADMIN) {

            adsRepository.deleteById(id);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    @Transactional
    public AdsDto updateAdsById(Integer id, CreateAds dto, String userDetails) {

        if (!validationService.validate(dto)) {
            throw new ValidationException(dto.toString());
        }

        User authorOrAdmin = userRepository.findByUsername(userDetails);
        Ad entity = adsRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityException(NOT_FOUND_ENTITY));

        if (entity.getAuthor().getUsername().equals(userDetails)
                || authorOrAdmin.getRole() == (Role.ADMIN)) {

            entity.setDescription(dto.getDescription());
            entity.setPrice(dto.getPrice());
            entity.setTitle(dto.getTitle());

            adsRepository.save(entity);

            AdsDto adsDto = adsMapping.mapToDto(entity);

            return adsDto;

        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
    }

    @Override
    public ResponseWrapperAds getAdsMe(String userDetails) {

        User author = userRepository.findByUsername(userDetails);
        if (author != null) {
            List<Ad> adEntity = adsRepository.findByAuthor(author);
            List<AdsDto> dto = new ArrayList<>();

            for (Ad ad : adEntity) {
                dto.add(adsMapping.mapToDto(ad));
            }
            return new ResponseWrapperAds(dto.size(), dto);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public ResponseWrapperAds findByDescriptionAd(String description) {

        List<AdsDto> dto = adsRepository
                .findByDescriptionContainingIgnoreCase(description).stream()
                .map(adsMapping::mapToDto)
                .collect(Collectors.toList());

        return new ResponseWrapperAds(dto.size(), dto);
    }

    @Override
    public byte[] getImageById(String id) {

        Picture picture = pictureRepository.findById(id).orElseThrow(()
                -> new NotFoundEntityException(NOT_FOUND_ENTITY));
        byte[] imageBytes = picture.getImage();

        return imageBytes;
    }
}