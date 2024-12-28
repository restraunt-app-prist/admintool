package kpi.fict.prist.admintool.menu.service;

import org.springframework.stereotype.Service;

import kpi.fict.prist.admintool.common.exception.MenuItemNotFoundException;
import kpi.fict.prist.admintool.menu.dto.CreateMenuItemRequest;
import kpi.fict.prist.admintool.menu.dto.UpdateMenuItemRequest;
import kpi.fict.prist.admintool.menu.entity.MenuItemEntity;
import kpi.fict.prist.admintool.menu.repository.MenuItemEntityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    private final MenuItemEntityRepository menuItemRepository;

    public MenuService(MenuItemEntityRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public MenuItemEntity createMenuItem(CreateMenuItemRequest createMenuItemRequest) {
        MenuItemEntity menuItem = MenuItemEntity.builder()
            .name(createMenuItemRequest.getName())
            .description(createMenuItemRequest.getDescription())
            .pictureUrl(createMenuItemRequest.getPictureUrl())
            .price(createMenuItemRequest.getPrice())
            .category(createMenuItemRequest.getCategory())
            .available(createMenuItemRequest.getAvailable())
            .build();

        return menuItemRepository.save(menuItem);
    }

    public MenuItemEntity updateMenuItem(String id, UpdateMenuItemRequest updateMenuItemRequest) {
        return menuItemRepository.findById(id)
            .map(existingItem -> {
                if (updateMenuItemRequest.getName() != null) {
                    existingItem.setName(updateMenuItemRequest.getName());
                }
                if (updateMenuItemRequest.getDescription() != null) {
                    existingItem.setDescription(updateMenuItemRequest.getDescription());
                }
                if (updateMenuItemRequest.getPrice() != null) {
                    existingItem.setPrice(updateMenuItemRequest.getPrice());
                }
                if (updateMenuItemRequest.getCategory() != null) {
                    existingItem.setCategory(updateMenuItemRequest.getCategory());
                }
                if (updateMenuItemRequest.getAvailable() != null) {
                    existingItem.setAvailable(updateMenuItemRequest.getAvailable());
                }
                return menuItemRepository.save(existingItem);
            })
            .orElseThrow(() -> new MenuItemNotFoundException(id));
    }

    public void deleteMenuItem(String id) {
        menuItemRepository.deleteById(id);
    }

    public List<MenuItemEntity> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public Optional<MenuItemEntity> getMenuItemById(String id) {
        return menuItemRepository.findById(id);
    }
}
