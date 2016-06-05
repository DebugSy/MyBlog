package cn.symxl.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import cn.symxl.bean.User;

public class SelectDao {
	private Connection conn;

	public User select(String username) {
		User user = new User();
		conn = JDBC.getConnection();
		String sql = "select * from user where username=?";
		Map<String, String> map = new HashMap<String, String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()){
				rs.previous();
				while(rs.next()){
					rsmd = rs.getMetaData();
					int count = rsmd.getColumnCount();
					for (int i = 1; i <= count; i++) {
						String name = rsmd.getColumnLabel(i);
						String value = rs.getString(name);
						map.put(name, value);
					}	
				}
				
			}		
			BeanUtils.populate(user, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
