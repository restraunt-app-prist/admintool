package kpi.fict.prist.admintool.user.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kpi.fict.prist.admintool.user.dto.UserWithOrdersResponse;
import kpi.fict.prist.admintool.user.entity.OrderEntity;
import kpi.fict.prist.admintool.user.entity.UserProfileEntity;
import kpi.fict.prist.admintool.user.repository.OrderEntityRepository;
import kpi.fict.prist.admintool.user.repository.UserProfileEntityRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserProfileEntityRepository userRepository;
    private final OrderEntityRepository orderRepository;

    public List<UserProfileEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserWithOrdersResponse> findById(String userId) {
        return userRepository.findById(userId).map(user -> {
            List<OrderEntity> orders = orderRepository.findByUserExternalId(user.getExternalId());
            return mapToDTO(user, orders);
        });
    }

    private UserWithOrdersResponse mapToDTO(UserProfileEntity user, List<OrderEntity> orders) {
        return UserWithOrdersResponse.builder()
                .id(user.getId())
                .name(user.getFirstName() + " " + user.getLastName())
                .email(user.getEmail())
                .orders(orders.stream().map(this::mapToOrderDTO).collect(Collectors.toList()))
                .build();
    }

    private UserWithOrdersResponse.OrderDTO mapToOrderDTO(OrderEntity order) {
        return UserWithOrdersResponse.OrderDTO.builder()
                .id(order.getId())
                .items(order.getItems())
                .totalPrice(order.getTotalPrice())
                .paymentId(order.getPaymentId())
                .status(order.getStatus().name())
                .location(order.getLocation())
                .notes(order.getNotes())
                .creationDate(order.getCreationDate().toString())
                .lastUpdateDate(order.getLastUpdateDate().toString())
                .build();
    }
}
