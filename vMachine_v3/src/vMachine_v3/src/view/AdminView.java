package view;

import dto.JoinDto;
import dto.MachineDto;
import service.AdminService;
import service.MachineService;

import java.util.List;
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
                    updateMenu();
                    break;
                case 3:
                    System.out.println("메뉴 삭제");
                    deleteMenu();
                    break;
                case 4:
                    System.out.println("메뉴 조회");
                    viewMenu();
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

        System.out.println("메뉴를 등록해 주세요.");
        System.out.println("등록할 메뉴명을 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);

        System.out.println("등록할 메뉴 가격을 입력해 주세요.");
        int price = sc.nextInt();
        dto.setP_price(price);

        System.out.println("등록할 메뉴 재고를 입력해 주세요.");
        int stock = sc.nextInt();
        dto.setP_stock(stock);

        int result = adminService.insertService(dto);
        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }

    private void updateMenu() {
        MachineDto dto = new MachineDto();

        System.out.println("메뉴를 수정해 주세요.");
        System.out.println("수정할 메뉴명을 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);

        System.out.println("수정할 메뉴 가격을 입력해 주세요.");
        int price = sc.nextInt();
        dto.setP_price(price);

        System.out.println("수정할 메뉴 재고를 입력해 주세요.");
        int stock = sc.nextInt();
        dto.setP_stock(stock);

        int result = adminService.updateService(dto);
        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }


    private void deleteMenu() {
        MachineDto dto = new MachineDto();

        System.out.println("메뉴를 삭제해 주세요.");
        System.out.println("삭제할 메뉴명을 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);


        int result = adminService.deleteService(dto);
        if (result > 0) {
            System.out.println("자료가 삭제되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }


    }
        public void viewMenu() {
            List<MachineDto> products = adminService.viewService();
            if (products.isEmpty()) {
                System.out.println("조회할 제품이 없습니다.");
            } else {
                for (MachineDto product : products) {
                    System.out.println("제품명: " + product.getP_name() +
                            ", 가격: " + product.getP_price() +
                            ", 재고: " + product.getP_stock());
                }
            }
        }


    public void userMenu() {
        int num = 0;
        while (true) {
            System.out.println("1.회원정보 입력 2.회원정보 수정 3.회원정보 삭제 4.회원정보 조회 5.종료");
            num = sc.nextInt();
            sc.nextLine();
            switch (num) {
                case 1:
                    System.out.println("회원정보 입력");
                    addUser();
                    break;
                case 2:
                    System.out.println("회원정보 수정");
                    updateUser();
                    break;
                case 3:
                    System.out.println("회원정보 삭제");
                    deleteUser();
                    break;
                case 4:
                    System.out.println("회원정보 조회");
                    viewUser();
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
    private void addUser() {
        MachineDto dto = new MachineDto();

        System.out.println("회원정보를 등록해 주세요.");
        System.out.println("등록할 회원정보를 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);

        System.out.println("등록할 회원 아이디를 입력해 주세요.");
        int price = sc.nextInt();
        dto.setP_price(price);

        System.out.println("등록할 회원 비밀번호를 입력해 주세요.");
        int stock = sc.nextInt();
        dto.setP_stock(stock);

        int result = adminService.insertService(dto);
        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }

    private void updateUser() {
        MachineDto dto = new MachineDto();

        System.out.println("회원정보를 수정해 주세요.");
        System.out.println("수정할 회원정보를 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);

        System.out.println("수정할 회원 아이디를 입력해 주세요.");
        int price = sc.nextInt();
        dto.setP_price(price);

        System.out.println("수정할 회원 비밀번호를 입력해 주세요.");
        int stock = sc.nextInt();
        dto.setP_stock(stock);

        int result = adminService.updateService(dto);
        if (result > 0) {
            System.out.println("자료가 저장되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }
    }


    private void deleteUser() {
        MachineDto dto = new MachineDto();

        System.out.println("회원정보를 삭제해 주세요.");
        System.out.println("삭제할 회원정보를 입력해 주세요.");
        String name = sc.next();
        dto.setP_name(name);


        int result = adminService.deleteService(dto);
        if (result > 0) {
            System.out.println("자료가 삭제되었습니다.");
        } else {
            System.out.println("실패했습니다. 관리자에게 문의하세요.");
        }


    }


    public void viewUser() {
        List<MachineDto> products = adminService.viewService();
        if (products.isEmpty()) {
            System.out.println("조회할 회원정보가 없습니다.");
        } else {
            for (MachineDto product : products) {
                System.out.println("제품명: " + product.getP_name() +
                        ", 가격: " + product.getP_price() +
                        ", 재고: " + product.getP_stock());
            }
        }
    }
}

