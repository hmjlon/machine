package view;

import dto.JoinDto;
import service.LoginService;

import java.util.Scanner;

public class LoginView {
    Scanner sc = new Scanner(System.in);
    LoginService loginService = new LoginService();

    public void login() {
        boolean flag = true;
        while (flag) {
            System.out.print("아이디 입력: ");
            String id = sc.nextLine();
            System.out.print("비밀번호 입력: ");
            String pw = sc.nextLine();


            boolean result = loginService.confirm(id, pw);

            if (result == true) {
                System.out.println("로그인 성공!");
                flag = false;
            } else {
                System.out.println("로그인 실패!");
                flag = true;
            }
        }
    }
}
