package bussinessLogics;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

import controllers.DanhSachNHServlet;
import javaBeans.DonHang;

public class DonHangBL {
	
	public static List<DonHang> taoDanhSach(String sql){
		List<DonHang> dsdh = null;
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dsdh = new ArrayList<DonHang>();
			while(rs.next()) {
				DonHang dh = new DonHang();
				dh.setDiaChiGiaoHang(rs.getString("diachigiaohang"));
				dh.setDienThoaiNguoiNhan(rs.getString("dienthoainguoinhan"));
				dh.setGhiChu(rs.getString("ghichu"));
				dh.setId(rs.getInt("id"));
				dh.setIdKhachHang(rs.getInt("id_khachhang"));
				dh.setIdTrangThai(rs.getInt("id_trangthai"));
				dh.setNgayDatHang(rs.getDate("ngaydathang"));
				dh.setTenNguoiNhanHang(rs.getString("tennguoinhanhang"));
				dh.setThanhToan(rs.getInt("thanhtoan"));
				dsdh.add(dh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsdh;
	}
	
	public static List<DonHang> docTatCa(){
		String sql="select * from donhang";
		List<DonHang> dsdh = DonHangBL.taoDanhSach(sql);
		return dsdh;
	}
	
	public static List<DonHang> docTheoMa(int maDonHang){
		String sql="select * from donhang where id='"+maDonHang+"'";
		List<DonHang> dsdh = DonHangBL.taoDanhSach(sql);
		return dsdh;
	}
	
	public static void capNhatDon(int trangThai, int maDonHang) {
		
		
		try(Connection kn = CSDL.getKN()){
			String sql="update donhang set id_trangthai=? where id=?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setInt(1, trangThai);
			pstm.setInt(2, maDonHang);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<DonHang> thongKe(Date ngaydau, Date ngaycuoi) {
		List<DonHang> dsdh = new ArrayList<DonHang>();
		try(Connection kn = CSDL.getKN()){
			String sql="select * from donhang where ngaydathang between ? and ?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setDate(1, ngaydau);
			pstm.setDate(2, ngaycuoi);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				DonHang dh = new DonHang();
				dh.setDiaChiGiaoHang(rs.getString("diachigiaohang"));
				dh.setDienThoaiNguoiNhan(rs.getString("dienthoainguoinhan"));
				dh.setGhiChu(rs.getString("ghichu"));
				dh.setId(rs.getInt("id"));
				dh.setIdKhachHang(rs.getInt("id_khachhang"));
				dh.setIdTrangThai(rs.getInt("id_trangthai"));
				dh.setNgayDatHang(rs.getDate("ngaydathang"));
				dh.setTenNguoiNhanHang(rs.getString("tennguoinhanhang"));
				dh.setThanhToan(rs.getInt("thanhtoan"));
				dsdh.add(dh);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsdh;
		
	}
	
	public static void main(String[] args) throws ParseException {
		String str = "2016-01-20";
		Date date = Date.valueOf(str);
		String str1 = "2016-01-22";
		Date date1 = Date.valueOf(str1);
		List<DonHang> dsdh = DonHangBL.thongKe(date, date1);
		for (DonHang donHang : dsdh) {
			System.out.println(donHang.getId());
		}
	}
}
