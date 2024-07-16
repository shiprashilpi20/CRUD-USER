package in.learning.Restful_Webservices.service.impl;

import in.learning.Restful_Webservices.entity.User;
import in.learning.Restful_Webservices.repository.UserRepository;
import in.learning.Restful_Webservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
/**-- Single Parametrized constructor here spring bean have hence using Constructor based
       dependency injection not autowiring from spring 4.3 onwards --**/
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
       return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
      User existingUser =  userRepository.findById(user.getId()).get();
      existingUser.setFirst_name(user.getFirst_name());
      existingUser.setLast_name(user.getLast_name());
      existingUser.setEmail(user.getEmail());
      User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
