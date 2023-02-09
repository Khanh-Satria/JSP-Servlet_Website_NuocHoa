package bussinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.NguoiDung;

public class DangNhapBL {
		
	
	public static NguoiDung docTheoEmailPassword(String email, String password) {
		
		NguoiDung nd = null;
		String sql="select * from nguoidung where email='"+email+"' and password='"+password+"'";
		
		List<NguoiDung> dsnd = DangNhapBL.taoDanhSach(sql);
		
		if(dsnd.size() > 0) {
			nd = dsnd.get(0);
		}
		
		return nd;
	}
	
	public static List<NguoiDung> taoDanhSach(String sql){
		
		List<NguoiDung> dsnd = new  ArrayList<>();
		
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				NguoiDung nd = new NguoiDung();
				nd.setDiaChi(rs.getString("diachi"));
				nd.setDtdd(rs.getString("dtdd"));
				nd.setEmail(rs.getString("email"));
				nd.setHoTen(rs.getString("hoten"));
				nd.setId(rs.getInt("id"));
				nd.setId_vaiTro(rs.getInt("id_vaitro"));
				nd.setPassword(rs.getString("password"));
				dsnd.add(nd);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsnd;
	}
	
}
