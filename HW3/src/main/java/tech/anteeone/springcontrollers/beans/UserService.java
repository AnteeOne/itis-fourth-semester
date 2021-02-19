package tech.anteeone.springcontrollers.beans;

import tech.anteeone.springcontrollers.dto.UserDto;
import tech.anteeone.springcontrollers.repository.user.UserRepository;
import tech.anteeone.springcontrollers.repository.user.UserRepositoryImpl;

public class UserService {

    private UserRepositoryImpl userRepository = new UserRepositoryImpl();

    public void saveUser(UserDto user){
        userRepository.create(user);
    }
    public UserDto findUserByEmail(String email){
        return userRepository.readByEmail(email);
    }

}
