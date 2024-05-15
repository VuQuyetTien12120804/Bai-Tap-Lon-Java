package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.KhachHang;
import Database.JDBCUtilnew;

public class KhachHangDAO implements DAOInterface<KhachHang>{
	public static KhachHangDAO getIntance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		int ketQua=0;
		try {
			//Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtilnew.getConnection();
			System.out.println(con);
					
			//Buoc 2: tao ra doi tuong statement
			Statement st = con.createStatement();
			
			//Buoc 3: thuc thi cau lenh SQL
			String sql = "INSERT INTO player(Name, Password)"
						+ " VALUES ('"+t.getName()+"' , '"+t.getPassword()+"')";
			
			ketQua = st.executeUpdate(sql);
			
			//Buoc 4: xu li ket qua
			
			//Buoc 5: ngat ket noi
			JDBCUtilnew.closeConnection(con);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	
	public boolean check(KhachHang t) {
		int kq = 0;
		try {
			//Buoc 1: Tao ket noi den CSDL
			Connection con = JDBCUtilnew.getConnection();
					
			//Buoc 2: tao ra doi tuong statement
			Statement st = con.createStatement();
			
			//Buoc 3: thuc thi cau lenh SQL
			String sql = "select * from player";
			ResultSet rs = st.executeQuery(sql);
			
			//Buoc 4: xu li ket qua
			while(rs.next()) {
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				if (t.getName().equals(name) && !t.getPassword().equals(password)) {
					kq++;
				}
			}
			
			//Buoc 5: ngat ket noi
			JDBCUtilnew.closeConnection(con);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (kq==0) return false;
		else return true;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String cindition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
