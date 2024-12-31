package repository;

import dbcon.DbCon;
import dto.AdminDto;
import dto.JoinDto;
import dto.MachineDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    int result = 0; //쿼리실행 결과를 담을 변수 ( 성공 : 양수 , 실패 : 0)
    Connection dbConn = DbCon.getConnection();

    PreparedStatement psmt = null;

    String sql;

    public int insertData(MachineDto dto) {

        try {
            sql = "INSERT INTO product(p_name,p_price,p_stock)";
            sql = sql + "VALUES(?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, dto.getP_name());
            psmt.setInt(2, dto.getP_price());
            psmt.setInt(3, dto.getP_stock());


            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }

    public int updateData(MachineDto dto) {
        try {
            sql = "UPDATE PRODUCT SET p_name = ?, p_price = ?, p_stock = ? WHERE p_name = ? ";
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, dto.getP_name());
            psmt.setInt(2, dto.getP_price());
            psmt.setInt(3, dto.getP_stock());
            psmt.setString(4, dto.getP_name());

            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;


    }

    public int deleteData(MachineDto dto) {
        try {
            sql = "DELETE FROM product WHERE p_name = ?";
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, dto.getP_name());


            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
    public List<MachineDto> viewMenu() {
        List<MachineDto> dtoList = new ArrayList<>();

        ResultSet rs = null;
        try {
            sql = "SELECT * FROM product ";
            psmt = dbConn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                MachineDto dto = new MachineDto();

                dto.setP_id(rs.getString("p_id"));
                dto.setP_name(rs.getString("p_name"));
                dto.setP_price(rs.getInt("p_price"));
                dto.setP_stock(rs.getInt("p_stock"));


                dtoList.add(dto);
            }

            rs.close();
            psmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }


    }

