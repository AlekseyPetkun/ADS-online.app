package pro.sky.adsonlineapp.mapper;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.sky.adsonlineapp.dto.*;
import pro.sky.adsonlineapp.model.User;
import pro.sky.adsonlineapp.model.Comment;
import pro.sky.adsonlineapp.model.Ad;

@Configuration
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        addAllMappings(mapper);
        mapper.getConfiguration().setSkipNullEnabled(true);

        return mapper;
    }

    private void addAllMappings(ModelMapper mapper) {
        addMappingsAdsToAdsDto(mapper);
        addMappingsAdsToFullAdsDto(mapper);
        addMappingsRegisterReqToUser(mapper);
        addMappingsCommentToCommentDto(mapper);
        addMappingsUserToUserDto(mapper);
    }


    private void addMappingsUserToUserDto(ModelMapper mapper) {
        TypeMap<User, UserDto> typeMap = mapper.createTypeMap(User.class, UserDto.class);
        Converter<Long, String> idToUrl = userIdToAvatarConverter();

       // typeMap.addMappings(m -> m.using(idToUrl).map(User::getId, UserDto::setImage));
    }

    private void addMappingsCommentToCommentDto(ModelMapper mapper) {
        TypeMap<Comment, CommentDto> typeMap = mapper.createTypeMap(Comment.class, CommentDto.class);
        Converter<Long, String> idToUrl = userIdToAvatarConverter();

        typeMap.addMappings(m -> {
            m.using(idToUrl).map(src -> src.getAuthor().getId(), CommentDto::setAuthorImage);
            m.map(src -> src.getAuthor().getId(), CommentDto::setAuthor);
            m.map(src -> src.getAuthor().getFirstName(), CommentDto::setAuthorFirstName);
            m.map(Comment::getCommentId, CommentDto::setPk);
        });
    }

    private void addMappingsRegisterReqToUser(ModelMapper mapper) {
        TypeMap<RegisterReq, User> typeMap = mapper.createTypeMap(RegisterReq.class, User.class);
        typeMap.addMappings(m -> m.map(RegisterReq::getUsername, User::setEmail));
    }

    private void addMappingsAdsToAdsDto(ModelMapper mapper) {
        TypeMap<Ad, AdsDto> typeMap = mapper.createTypeMap(Ad.class, AdsDto.class);
        Converter<Long, String> idToUrl = adsIdToImageUrlConverter();
        typeMap.addMappings(m -> {
            m.using(idToUrl).map(Ad::getId, AdsDto::setImage);
            m.map(src -> src.getAuthor().getId(), AdsDto::setAuthor);
            m.map(Ad::getId, AdsDto::setId);
        });
    }

    private void addMappingsAdsToFullAdsDto(ModelMapper mapper) {
        TypeMap<Ad, FullAds> typeMap = mapper.createTypeMap(Ad.class, FullAds.class);
        Converter<Long, String> idToUrl = adsIdToImageUrlConverter();

        typeMap.addMappings(m -> {
            m.using(idToUrl).map(Ad::getId, FullAds::setImage);
            m.map(Ad::getId, FullAds::setPk);
            m.map(src -> src.getAuthor().getFirstName(), FullAds::setAuthorFirstName);
            m.map(src -> src.getAuthor().getLastName(), FullAds::setAuthorLastName);
            m.map(src -> src.getAuthor().getEmail(), FullAds::setEmail);
            m.map(src -> src.getAuthor().getPhone(), FullAds::setPhone);
        });
    }

    private Converter<Long, String> userIdToAvatarConverter() {
        return new AbstractConverter<>() {
            @Override
            protected String convert(Long source) {
                return "/users/%d/image".formatted(source);
            }
        };
    }

    private Converter<Long, String> adsIdToImageUrlConverter() {
        return new AbstractConverter<>() {
            @Override
            protected String convert(Long source) {
                return "/ads/%d/image".formatted(source);
            }
        };
    }
}
