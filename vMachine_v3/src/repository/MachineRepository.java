package repository;

import dbcon.DbCon;
import dto.JoinDto;
import dto.MachineDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineRepository {
    private List<MachineDto> products = new ArrayList<>();
    int result = 0; //쿼리실행 결과를 담을 변수 ( 성공 : 양수 , 실패 : 0)
    Connection dbConn = DbCon.getConnection();

    PreparedStatement psmt = null;

    String sql;

    // 모든 제품 조회
    public List<MachineDto> getAllProducts() {
        return new ArrayList<>(products);
    }

    // 특정 제품 조회
    public MachineDto getProduct(String productId) {
        for (MachineDto product : products) {
            if (product.getP_id().equals(productId)) { // p_id 사용
                return product;
            }
        }
        return null; // 제품을 찾지 못한 경우
    }

    // 제품 추가
    public boolean addProduct(MachineDto product) {
        return products.add(product);
    }

    // 제품 수정
    public boolean updateProduct(String productId, MachineDto updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getP_id().equals(productId)) { // p_id 사용
                products.set(i, updatedProduct);
                return true;
            }
        }
        return false;
    }

    // 제품 삭제
    public boolean deleteProduct(String productId) {
        return products.removeIf(product -> product.getP_id().equals(productId)); // p_id 사용
    }

    // 재고 감소
    public boolean decreaseStock(String productId, int quantity) {
        MachineDto product = getProduct(productId);
        if (product != null && product.getP_stock() >= quantity) { // p_stock 사용
            product.setP_stock(product.getP_stock() - quantity);
            return true;
        }
        return false;
    }

    public int chargeBalance(String id, int amount) {

        try {
            sql = "UPDATE USER SET U_BALANCE = u_balance + ? WHERE U_ID = ? ";

            psmt = dbConn.prepareStatement(sql);
            psmt.setInt(1,amount);
            psmt.setString(2,id);


            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

            return 0;
    }  public int check(String id) {
        ResultSet rs = null;

        sql = "SELECT u_balance FROM user WHERE u_id = ? ";
        JoinDto joinDto = new JoinDto();
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, id);

            rs = psmt.executeQuery();

            if (rs != null) {
                while (rs.next()){
                    joinDto.setPrice(rs.getInt("u_balance"));
                }
            }
            return joinDto.getPrice();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

