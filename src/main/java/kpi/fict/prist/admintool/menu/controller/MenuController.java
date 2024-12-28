package kpi.fict.prist.admintool.menu.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kpi.fict.prist.admintool.menu.dto.CreateMenuItemRequest;
import kpi.fict.prist.admintool.menu.dto.UpdateMenuItemRequest;
import kpi.fict.prist.admintool.menu.entity.MenuItemEntity;
import kpi.fict.prist.admintool.menu.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping
    public List<MenuItemEntity> getAllMenuItems() {
        return menuService.getAllMenuItems();
    }

    @GetMapping("{id}")
    public ResponseEntity<MenuItemEntity> getMenuItemById(@PathVariable String id) {
        return menuService.getMenuItemById(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MenuItemEntity> createMenuItem(@RequestBody CreateMenuItemRequest request) {
        return ResponseEntity.ok(menuService.createMenuItem(request));
    }

    @PutMapping("{id}")
    public MenuItemEntity updateMenuItem(@PathVariable String id, @RequestBody UpdateMenuItemRequest request) {
        return menuService.updateMenuItem(id, request);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenuItem(@PathVariable String id) {
        menuService.deleteMenuItem(id);
    }
}
