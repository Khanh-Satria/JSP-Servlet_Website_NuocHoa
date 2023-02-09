package bussinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javaBeans.Loai;

public class LoaiBL {
	public static List<Loai> taoDanhSach(String sql){
		List<Loai> dsl = null;
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsl = new ArrayList<Loai>();
			while(rs.next()) {
				Loai l = new Loai();
				l.setId(rs.getInt("id"));
				l.setTenLoai(rs.getString("tenloai"));
				dsl.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsl; 
	}
	
	public static List<Loai> docTatCa(){
		String sql="select * from loai";
		List<Loai> dsl = LoaiBL.taoDanhSach(sql);
		return dsl;
	}
	
	public static Loai docTheoID(int id) {
		Loai l = null;
		String sql="select * from loai where id='"+id+"'";
		List<Loai> dsl = LoaiBL.taoDanhSach(sql);
		if(dsl.size() >0) {
			l=dsl.get(0);
		}
		return l;
	}
}
