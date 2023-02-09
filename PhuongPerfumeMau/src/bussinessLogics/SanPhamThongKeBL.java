package bussinessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javaBeans.SanPham;
import javaBeans.SanPhamThongKe;

public class SanPhamThongKeBL {
	
	public static List<SanPhamThongKe> thongKe(Date date1, Date date2){
		List<SanPhamThongKe> dssp = new ArrayList<SanPhamThongKe>();
		try(Connection kn = CSDL.getKN()){
			
			String sql="select sp.tensanpham, sp.dongia, ctdh.soluong, dh.ngaydathang from "
			+"donhang dh inner join chitietdonhang ctdh on dh.id=ctdh.id_donhang "
			+"inner join sanpham sp on sp.id= ctdh.id_sanpham where dh.ngaydathang between ? and ?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setDate(1, date1);
			pstm.setDate(2, date2);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				
				SanPhamThongKe sp = new SanPhamThongKe();
				sp.setTenSanPham(rs.getString("sp.tensanpham"));
				sp.setDonGia(rs.getDouble("sp.dongia"));
				sp.setSoLuong(rs.getInt("ctdh.soluong"));
				sp.setNgayDat(rs.getDate("dh.ngaydathang"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public static void main(String[] args) {
		String str = "2016-01-20";
		Date date = Date.valueOf(str);
		String str1 = "2016-01-22";
		Date date1 = Date.valueOf(str1);
		
		List<SanPhamThongKe> dssp = SanPhamThongKeBL.thongKe(date, date1);
		for (SanPhamThongKe sanPhamThongKe : dssp) {
			System.out.println(sanPhamThongKe.getNgayDat());
		}
	}
}
