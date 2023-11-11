package Hungry.PatientAnalystic.controller;

import Hungry.PatientAnalystic.dto.UserAccountDto;
import Hungry.PatientAnalystic.repository.UserAccountRepository;
import Hungry.PatientAnalystic.service.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserAccountRepository userAccountRepository;
    private final UserAccountService userAccountService;
    //create user
    @PostMapping ("/create")
    public void createUser(UserAccountDto userAccountDto){
        userAccountRepository.save(userAccountDto.toEntity());
    }

    @GetMapping("/search")
    public void searchUser(@RequestParam String username){
        userAccountService.searchUser(username);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestParam String username){
        userAccountRepository.deleteById(username);
    }

    @PutMapping("/update")
    public void updateUser(UserAccountDto userAccountDto){
        userAccountRepository.save(userAccountDto.toEntity());
    }
}
