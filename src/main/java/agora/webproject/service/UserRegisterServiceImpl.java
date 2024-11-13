package agora.webproject.service;

import agora.webproject.domain.User;
import agora.webproject.dto.UserDTO;
import agora.webproject.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryServiceImpl implements {
    private final UserRepository userRepository;
    @Override
    public User saveEntity(User user) {
        return UserRepository.save(User);
    }

    @Override
    public User saveDTO(UserDTO userdto) {
        User user = User.builder()
                .email(userdto.getEmail())
                .passwd(userdto.getPasswd())
                .build();
        return saveEntity(user);
    }
}
