package view;

import dto.JoinDto;
import dto.MachineDto;
import service.MachineService;
import java.util.Scanner;

public class MachineView {
    Scanner sc = new Scanner(System.in);
    MachineService machineService = new MachineService();
    AdminView adminView = new AdminView();

    public void selectMenu() {
        int num = 0;
        while (true) {
            System.out.println("1.금액충전 2.잔액확인 3.메뉴선택 4.관리자메뉴 5.종료");
            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("금액충전");
                    chargeBalance();
                    break;
                case 2:
                    System.out.println("잔액확인");
                    check();
                    break;
                case 3:
                    System.out.println("메뉴선택");
                    chooseProduct();
                    break;
                case 4:
                    System.out.println("관리자메뉴");
                    adminView.selectMenu();
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

    private void chargeBalance() {
        System.out.println("아이디를 입력하세요.");
        String id = sc.next();
        System.out.print("충전할 금액을 입력하세요 (천 원 단위): ");
        int amount = sc.nextInt();
        if (amount <= 0 || amount % 1000 != 0) {
            System.out.println("유효하지 않은 금액입니다. 천 원 단위로 입력해주세요.");
        } else {
            int result = machineService.chargeBalance(id, amount);  // 사용자 객체를 넘김

            if (result != 0) {
                System.out.println(amount + "원이 충전되었습니다.");
            } else {
                System.out.println("충전 실패!");
            }
        }
    }

    private void check() {
        System.out.println("잔액확인 할 아이디를 입력하세요.");
        String id = sc.next();

        int result = machineService.check(id);

        System.out.println(id + "의 잔액은" + result + "원 입니다.");


    }

    private void chooseProduct() {
        System.out.println("= 메뉴 ============");
        try {
            // 1. 제품 목록 출력
            for (MachineDto product : machineService.viewService()) {
                System.out.printf("제품명 : %s / 가격 : %d / 재고 개수 : %d%n",
                        product.getP_name(), product.getP_price(), product.getP_stock());
            }
            System.out.println("===========================");

            // 2. 사용자 입력
            System.out.print("원하는 제품명을 입력하세요: ");
            String productName = sc.next();

            

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("구매 중 오류가 발생했습니다. 다시 시도해주세요.");
        }
    }
}

