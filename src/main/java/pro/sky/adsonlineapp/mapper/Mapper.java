package pro.sky.adsonlineapp.mapper;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.adsonlineapp.dto.*;


import pro.sky.adsonlineapp.model.*;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper mapper;

    public UserDto toDto(User user) {
        return mapper.map(user, UserDto.class);
    }

    public User toEntity(UserDto userDto) {
        return mapper.map(userDto, User.class);
    }

    public User toUserEntity(RegisterReq registerReq) {
        return mapper.map(registerReq, User.class);
    }

    public AdsDto toEntity(CreateAds createAds) {
        return mapper.map(createAds, AdsDto.class);
    }

    public AdsDto toDto(AdsDto adsDto) {
        return mapper.map(adsDto, AdsDto.class);
    }

    public Comment toEntity(CommentDto commentDto) {
        return mapper.map(commentDto, Comment.class);
    }

    public CommentDto toDto(Comment comment) {
        return mapper.map(comment, CommentDto.class);
    }

    public FullAds toFullAds(AdsDto adsDto) {
        return mapper.map(adsDto, FullAds.class);
    }

    public void createAdsToAdsPatch(CreateAds createAds, AdsDto targetAds) {
        mapper.map(createAds, targetAds);
    }

    public void commentDtoToCommentPatch(CommentDto commentDto, Comment targetComment) {
        mapper.map(commentDto, targetComment);
    }

    public void userDtoToUserPatch(UserDto userDto, User targetUser) {
        mapper.map(userDto, targetUser);
    }


}