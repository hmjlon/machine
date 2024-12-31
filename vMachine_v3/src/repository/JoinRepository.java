package repository;

import dbcon.DbCon;
import dto.JoinDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JoinRepository {
    int result = 0; //쿼리실행 결과를 담을 변수 ( 성공 : 양수 , 실패 : 0)
    Connection dbConn = DbCon.getConnection();

    PreparedStatement psmt = null;

    String sql;

    public int insertData(JoinDto dto) {
        try {
            sql = "INSERT INTO user(u_id,u_password,u_name,u_phone)";
            sql = sql + "VALUES(?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, dto.getId());
            psmt.setString(2, dto.getPw());
            psmt.setString(3, dto.getName());
            psmt.setString(4, dto.getPhone());

            return psmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return 0;
    }
}
