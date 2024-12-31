package repository;

import dbcon.DbCon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginRepository {
    Connection dbConn = DbCon.getConnection();

    PreparedStatement psmt = null;

    String sql;

    public boolean confirm(String id, String pw) {
        ResultSet rs = null;

        sql = "SELECT * FROM user WHERE u_id =? and u_password=?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, id);
            psmt.setString(2, pw);
            rs = psmt.executeQuery();

            if (rs != null) {
                while (rs.next()){
                    // id, pw 가 존재할 때
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

