package repository;

import dbcon.DbCon;
import dto.AdminDto;
import dto.JoinDto;
import dto.MachineDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}

