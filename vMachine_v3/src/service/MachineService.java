package service;

import dto.MachineDto;
import dto.JoinDto;
import repository.MachineRepository;

import java.util.List;

public class MachineService {
    private MachineRepository machineRepository = new MachineRepository();

    // 모든 제품 조회
    public List<MachineDto> getAllProducts() {
        return machineRepository.getAllProducts();
    }

    // 특정 제품 정보 조회
    public MachineDto getProduct(String productId) {
        return machineRepository.getProduct(productId);
    }

    // 제품 구매 처리
    public boolean purchaseProduct(String productId) {
        MachineDto product = machineRepository.getProduct(productId);

        if (product == null) {
            System.out.println("제품을 찾을 수 없습니다.");
            return false;
        }

        if (product.getP_stock() <= 0) {
            System.out.println("재고 부족으로 구매할 수 없습니다.");
            return false;
        }

        // 재고 감소
        return machineRepository.decreaseStock(productId, 1);
    }

    // 제품 추가 (관리자용)
    public boolean addProduct(MachineDto product) {
        return machineRepository.addProduct(product);
    }

    // 제품 수정 (관리자용)
    public boolean updateProduct(String productId, MachineDto updatedProduct) {
        return machineRepository.updateProduct(productId, updatedProduct);
    }

    // 제품 삭제 (관리자용)
    public boolean deleteProduct(String productId) {
        return machineRepository.deleteProduct(productId);
    }

    public int chargeBalance(String id, int amount) {
        return machineRepository.chargeBalance(id, amount);
    }

    public int check(String id) {
        return machineRepository.check(id);
    }

    public List<MachineDto> viewService() {
        return machineRepository.viewMenu();


    }
}
