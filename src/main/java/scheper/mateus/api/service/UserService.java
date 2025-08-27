package scheper.mateus.api.service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scheper.mateus.api.dto.UserResponse;
import scheper.mateus.api.entity.User;
import scheper.mateus.api.entity.UserInformation;
import scheper.mateus.api.enums.ProviderEnum;
import scheper.mateus.api.exception.BusinessException;
import scheper.mateus.api.repository.AuthRepository;
import scheper.mateus.api.repository.UserRepository;

import java.util.Optional;

import static scheper.mateus.api.constant.Messages.EMAIL_ALREADY_REGISTERED;

@Service
public class UserService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;

    public UserService(AuthRepository authRepository, UserRepository userRepository) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void registerUser(String name, String email, String password, ProviderEnum providerEnum, String idExternal) {
        User user = authRepository.findByEmail(email);
        if (user != null) {
            if (user.hasLocalInformation()) {
                throw new BusinessException(EMAIL_ALREADY_REGISTERED);
            }
        } else {
            user = new User();
            user.setName(name);
            authRepository.persist(user);
        }

        UserInformation userInformation = new UserInformation();
        userInformation.setUser(user);
        userInformation.setEmail(email);
        userInformation.setProvider(providerEnum);

        if (!StringUtils.isBlank(idExternal)) {
            userInformation.setIdExternal(idExternal);
        }

        if (!StringUtils.isBlank(password)) {
            userInformation.setPassword(password);
        }

        authRepository.persist(userInformation);
    }

    public UserResponse getUser(Long userId) {
        if (userId == null) {
            throw new BusinessException("User ID cannot be null");
        }

        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional
                .map(User::asResponse)
                .orElseThrow(() -> new BusinessException("User not found with ID: " + userId));
    }
}
