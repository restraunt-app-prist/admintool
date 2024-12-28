package kpi.fict.prist.admintool.menu.dto;

import lombok.Data;

import java.math.BigDecimal;

import kpi.fict.prist.admintool.common.MenuCategory;

@Data
public class UpdateMenuItemRequest {
    private String name;
    private String description;
    private BigDecimal price;
    private MenuCategory category;
    private Boolean available;
}
