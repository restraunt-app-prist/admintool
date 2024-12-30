package kpi.fict.prist.admintool.user.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import kpi.fict.prist.admintool.user.entity.UserProfileEntity;
import kpi.fict.prist.admintool.user.repository.UserProfileEntityRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserProfileEntityRepository userRepository;

    public Optional<UserProfileEntity> findById(String id) {
        return userRepository.findById(id);
    }

    public List<UserProfileEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
