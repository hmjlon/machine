package view;

import dto.JoinDto;
import dto.MachineDto;
import service.AdminService;
import java.util.Scanner;

public class AdminView {

    Scanner sc = new Scanner(System.in);
    AdminService adminService = new AdminService();

    public void selectMenu() {
        int num = 0;
        while (true) {
            System.out.println("1.메뉴 등록 2.메뉴 수정 3.메뉴 삭제 4.메뉴 조회 5.종료");
            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("메뉴 등록");
                    addMenu();
                    break;
                case 2:
                    System.out.println("메뉴 수정");
                    break;
                case 3:
                    System.out.println("메뉴 삭제");

                    break;
                case 4:
                    System.out.println("메뉴 조회");

                    break;
                case 5:
                    System.out.println("종료");
                    return;
                default:
                    System.out.println("잘못누르셨습니다.");
                    break;
            }
        }
    }

    private void addMenu() {
        MachineDto dto = new MachineDto();

        System.out.println("메뉴를 등록해주세요.");
        System.out.println("등록할 메뉴명을 입력해주세요.");
        String name = sc.next();
        dto.setP_name(name);

        System.out.println("등록할 메뉴 가격을 입력해주세요.");
        int price = sc.nextInt();
        dto.setP_price(price);

        System.out.println("등록할 메뉴 재고를 입력해주세요.");
        int stock = sc.nextInt();
        dto.setP_stock(stock);

        int result = adminService.insertService(dto);
        if(result >0){
            System.out.println("자료가 저장되었습니다.");
        }else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }

}


