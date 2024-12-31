package service;

import dto.JoinDto;
import repository.LoginRepository;

import java.util.Scanner;

public class LoginService {
    LoginRepository loginRepository = new LoginRepository();

    public boolean confirm(String id, String pw) {
        return loginRepository.confirm(id, pw);
    }
}
