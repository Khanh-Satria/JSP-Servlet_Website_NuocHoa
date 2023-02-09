package bussinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.QuangCao;

public class QuangCaoBL {
	
	public static List<QuangCao> docTatCa(){
		
		List<QuangCao> dsqc = new ArrayList<>();
		
	
		try(Connection kn = CSDL.getKN()){
			String sql = "select * from quangcao";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				QuangCao qc = new QuangCao();
				qc.setHinhAnh(rs.getNString("hinhanh"));
				qc.setId(rs.getInt("id"));
				qc.setNgayDang(rs.getDate("ngaydang"));
				qc.setThongDiep(rs.getNString("thongdiep"));
				qc.setThongTinChiTiet(rs.getString("thongtinchitiet"));
				dsqc.add(qc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsqc;
	}
	
	
}
