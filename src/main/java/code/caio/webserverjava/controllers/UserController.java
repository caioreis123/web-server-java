package code.caio.webserverjava.controllers;

import code.caio.webserverjava.dtos.UserDTO;
import code.caio.webserverjava.repositories.UserRepository;
import code.caio.webserverjava.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    @Transactional
    public void registerUser(@RequestBody UserModel user){
        userRepository.save(user);
    }

    @GetMapping
    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable long id){
        UserDTO userDto = UserDTO.covertUserToDTO(userRepository.findById(id));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
}
