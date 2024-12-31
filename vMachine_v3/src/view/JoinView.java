package view;

import dto.JoinDto;
import service.JoinService;

import java.util.Scanner;

public class JoinView {
    Scanner sc = new Scanner(System.in);
    JoinService joinService = new JoinService();


    public void join(){

        JoinDto dto = new JoinDto();

        System.out.println("회원 아이디");
        String id = sc.next();
        dto.setId(id);

        System.out.println("비밀번호");
        String pw = sc.next();
        dto.setPw(pw);

        System.out.println("회원명");
        String name = sc.next();
        dto.setName(name);

        System.out.println("전화번호");
        String phone = sc.next();
        dto.setPhone(phone);

        int result = joinService.insertService(dto);
        if(result >0){
            System.out.println("자료가 저장되었습니다.");
        }else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }
}
