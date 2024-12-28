package kpi.fict.prist.admintool.menu.dto;

import lombok.Builder;
import lombok.Data;

import kpi.fict.prist.admintool.common.MenuCategory;

import java.math.BigDecimal;

@Data
@Builder
public class CreateMenuItemRequest {
    private String name;
    private String description;
    private String pictureUrl;
    private BigDecimal price;
    private MenuCategory category;
    private Boolean available;
}
