import dto.JoinDto;
import view.JoinView;
import view.LoginView;
import view.MachineView;

import java.util.Scanner;

public class MachineMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JoinView joinView = new JoinView();
        LoginView loginView = new LoginView();
        MachineView machineView = new MachineView();

        int num = 0;
        while (true) {
            System.out.println("1.회원가입 2. 로그인 3.종료");
            num = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기
            switch (num) {
                case 1:
                    joinView.join();  // 회원가입 화면 호출
                    break;
                case 2:
                    loginView.login();
                    machineView.selectMenu();  // 로그인 성공 시, 로그인한 사용자 정보를 넘겨서 메뉴 선택

                case 3:
                    System.out.println("종료");
                    return;  // 프로그램 종료
                default:
                    System.out.println("잘못누르셨습니다.");
                    break;
            }
        }
    }
}
