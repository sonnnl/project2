package com.java_web_test.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.java_web_test.reponsitory.DistrictReponsitory;
import com.java_web_test.reponsitory.entity.DistrictEntity;
import com.java_web_test.utils.ConnectionUtil;
@Repository
public class DistrictReponsitoryImpl implements DistrictReponsitory {
    public DistrictEntity findNameById(Integer id) {
        DistrictEntity de = new DistrictEntity();
        String sqlQuery = "SELECT d.name FROM district d WHERE d.id = " + id;

        try (Connection con = ConnectionUtil.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlQuery)) {

            // Kiểm tra xem có dữ liệu trả về hay không
            if (rs.next()) { // Di chuyển con trỏ đến bản ghi đầu tiên
                de.setName(rs.getString("name")); // Lấy tên từ ResultSet
            } else {
                // Có thể xử lý nếu không tìm thấy bản ghi nào
                de.setName(null); // Hoặc có thể ném ra ngoại lệ
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return de;
    }
	
}
