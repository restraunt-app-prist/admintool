package kpi.fict.prist.admintool.user.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record UserResponse(
    String id,
    String externalId,
    String firstName,
    String lastName,
    String email,
    String pictureUrl,
    LocalDateTime creationDate,
    LocalDateTime lastUpdateDate
) {

}
