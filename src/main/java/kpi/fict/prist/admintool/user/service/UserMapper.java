package kpi.fict.prist.admintool.user.service;

import org.springframework.stereotype.Service;

import kpi.fict.prist.admintool.user.dto.UserResponse;
import kpi.fict.prist.admintool.user.entity.UserProfileEntity;

@Service
public class UserMapper {

    public UserResponse toUserResponse(UserProfileEntity entity) {
        return UserResponse.builder()
            .id(entity.getId())
            .externalId(entity.getExternalId())
            .firstName(entity.getFirstName())
            .lastName(entity.getLastName())
            .email(entity.getEmail())
            .pictureUrl(entity.getPictureUrl())
            .creationDate(entity.getCreationDate())
            .lastUpdateDate(entity.getLastUpdateDate())
            .build();
    }

}
