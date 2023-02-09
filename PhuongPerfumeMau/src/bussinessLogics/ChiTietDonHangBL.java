package bussinessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javaBeans.ChiTietDonHang;
import javaBeans.DonHang;

public class ChiTietDonHangBL {
	
	public static List<ChiTietDonHang> taodanhsach(String sql){
		
		List<ChiTietDonHang> dsct = null;
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsct = new ArrayList<ChiTietDonHang>();
			while(rs.next()) {
				ChiTietDonHang ctdh = new ChiTietDonHang();
				ctdh.setId(rs.getInt("id"));
				ctdh.setId_donhang(rs.getInt("id_donhang"));
				ctdh.setId_sanpham(rs.getInt("id_sanpham"));
				ctdh.setSoluong(rs.getInt("soluong"));
				dsct.add(ctdh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsct;
	}
	
	public static List<ChiTietDonHang> docTheoMaDonHang(int maDonHang){
		
		String sql="select * from chitietdonhang where id_donhang='"+maDonHang+"'";
		List<ChiTietDonHang> dsct = ChiTietDonHangBL.taodanhsach(sql);
		return dsct;
		
	}
	
	public static void main(String[] args) {
		String str = "2016-01-20";
		Date date = Date.valueOf(str);
		String str1 = "2016-01-22";
		Date date1 = Date.valueOf(str1);
		List<DonHang> dsdh = DonHangBL.thongKe(date, date1);
		List<ChiTietDonHang> dsct = null;
		List<ChiTietDonHang> dsctAll= new ArrayList<ChiTietDonHang>();
		for (DonHang donHang : dsdh) {
			 dsct = ChiTietDonHangBL.docTheoMaDonHang(donHang.getId());
			 for (ChiTietDonHang chiTietDonHang : dsct) {
					dsctAll.add(chiTietDonHang);
				}
		}
		
		for (ChiTietDonHang chiTietDonHang : dsctAll) {
			System.out.println(chiTietDonHang.getId_sanpham());
		}
	}
}
