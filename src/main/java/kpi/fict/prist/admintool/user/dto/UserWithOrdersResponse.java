package kpi.fict.prist.admintool.user.dto;

import kpi.fict.prist.admintool.user.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserWithOrdersResponse {
    private String id;
    private String name;
    private String email;
    private List<OrderDTO> orders;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderDTO {
        private String id;
        private List<OrderEntity.CartItem> items;
        private Double totalPrice;
        private String paymentId;
        private String status;
        private String location;
        private String notes;
        private String creationDate;
        private String lastUpdateDate;
    }
}
