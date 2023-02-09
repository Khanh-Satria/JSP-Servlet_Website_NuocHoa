package bussinessLogics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import javaBeans.SanPham;
import javaBeans.SanPhamMua;



public class SanPhamBL {
	
	public static List<SanPham> docTatCa(){
		List<SanPham> dssp = new ArrayList<>();
		
		
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			String sql = "select * from sanpham";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	
	public static SanPham docTheoID(int id) {
		String sql = "select * from sanpham where id="+id;
		SanPham sp = null;
		List<SanPham> dssp = SanPhamBL.taoDanhSach(sql);
		if(dssp.size() >0) {
			sp = dssp.get(0);
		}
		return sp;
	}
	
	public static List<SanPham> taoDanhSach(String sql){
		List<SanPham> dssp = null;
		
		try(Connection kn = CSDL.getKN()){
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			dssp= new ArrayList<>();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dssp;
	}
	
	public static List<SanPham> docTheoThuongHieu(int idThuongHieu){
		List<SanPham> dssp = new ArrayList<SanPham>();
		try(Connection kn = CSDL.getKN()){
				String sql="select * from sanpham where id_thuonghieu='"+idThuongHieu+"'";
				Statement stm = kn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					SanPham sp = new SanPham();
					sp.setDonGia(rs.getDouble("dongia"));
					sp.setDonGiaKM(rs.getDouble("dongiaKM"));
					sp.setHienthi(rs.getInt("hienthi"));
					sp.setHinhAnh(rs.getString("hinhanh"));
					sp.setId(rs.getInt("id"));
					sp.setId_loai(rs.getInt("id_loai"));
					sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
					sp.setMota(rs.getNString("mota"));
					sp.setNgaytao(rs.getDate("ngaytao"));
					sp.setSoLuong(rs.getInt("soluong"));
					sp.setTenSanPham(rs.getString("tensanpham"));
					dssp.add(sp);
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public static List<SanPham> sanPhamBanChay(){
		List<SanPham> dssp = new ArrayList<SanPham>();
		try(Connection kn = CSDL.getKN()){
			String sql="select sp.*,sum(ct.soluong) as tsl "
					+ "from sanpham sp inner join chitietdonhang ct on ct.id_sanpham = sp.id group by 1 order by tsl desc limit 0,3";
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);
			}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return dssp;
}
	
	public static List<SanPham> danhSachSanPhamMoi(){
		String sql="SELECT * from sanpham WHERE id ORDER BY id desc LIMIT 1,3";
		List<SanPham> dssp = SanPhamBL.taoDanhSach(sql);
		if(dssp.size() >0) {
			dssp.get(0);
		}
	 return dssp;
	}
	
	public static List<SanPham> sanPhamTheoTH(int idTH){
		String sql="SELECT * from sanpham WHERE id_thuonghieu='"+idTH+"'";
		List<SanPham> dssp = SanPhamBL.taoDanhSach(sql);
		if(dssp.size() >0) {
			dssp.get(0);
		}
	 return dssp;
	}
	
	
	public static List<SanPham> timKiemSanPham(String tenTim){
		List<SanPham> dssp = new ArrayList<SanPham>();
		try(Connection kn = CSDL.getKN()){
			String sql="select * from sanpham sp INNER JOIN thuonghieu th on sp.id_thuonghieu = th.id "
			+"where sp.tensanpham like ? or th.tenthuonghieu like ?";
			
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setString(1, "%"+tenTim+"%");
			pstm.setString(2, "%"+tenTim+"%");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dssp;
	}
	
	public static int tongSoTrang(int soDongTrang) {
		List<SanPham> dssp = SanPhamBL.docTatCa();
		int tongSoDong = dssp.size();
		int tongSoTrang = tongSoDong / soDongTrang + (tongSoDong % soDongTrang == 0 ? 0 : 1);
		return tongSoTrang;
	}

	public static List<SanPham> spPhanTrang(int trang, int soDongTrang) {

		List<SanPham> dsspt = new ArrayList<>();
		int viTriDau = trang == 1 ? 0 : (trang - 1) * soDongTrang;
		try (Connection kn = CSDL.getKN()) {

			String sql = "select * from sanpham limit " + viTriDau + "," + soDongTrang;
			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dsspt.add(sp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsspt;
	}
	
	public static List<SanPham> spPhanTrangTheoTH(int maThuongHieu, int trang, int soDongTrang) {
		List<SanPham> dsspt = new ArrayList<SanPham>();
		int viTriDau = trang == 1 ? 0 : (trang - 1) * soDongTrang;

		try (Connection kn = CSDL.getKN()) {

			String sql = "select * from sanpham where id_thuonghieu='" + maThuongHieu + "' limit " + viTriDau + ","
					+ soDongTrang;

			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dsspt.add(sp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsspt;
	}
	
	public static List<SanPham> spPhanTrangTheoL(int maLoai, int trang, int soDongTrang) {
		List<SanPham> dsspt = new ArrayList<SanPham>();
		int viTriDau = trang == 1 ? 0 : (trang - 1) * soDongTrang;

		try (Connection kn = CSDL.getKN()) {

			String sql = "select * from sanpham where id_loai='" + maLoai + "' limit " + viTriDau + ","
					+ soDongTrang;

			Statement stm = kn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dsspt.add(sp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsspt;
	}
	
	public static List<SanPham> docTheoLoai(int maLoai){
		String sql= "select * from sanpham where id_loai='"+maLoai+"'";
		List<SanPham> dssp = SanPhamBL.taoDanhSach(sql);
		return dssp;
	}
	
	public static List<SanPham> docTheoLoaiTH(int maLoai, int maTH, String ten){
		List<SanPham> dssp = new ArrayList<SanPham>();
		try(Connection kn = CSDL.getKN()){
			String sql="select * from sanpham where id_loai = ? and id_thuonghieu=? and tensanpham like ?";
			PreparedStatement pstm = kn.prepareStatement(sql);
			pstm.setInt(1, maLoai);
			pstm.setInt(2, maTH);
			pstm.setString(3, "%"+ten+"%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				SanPham sp = new SanPham();
				sp.setDonGia(rs.getDouble("dongia"));
				sp.setDonGiaKM(rs.getDouble("dongiaKM"));
				sp.setHienthi(rs.getInt("hienthi"));
				sp.setHinhAnh(rs.getString("hinhanh"));
				sp.setId(rs.getInt("id"));
				sp.setId_loai(rs.getInt("id_loai"));
				sp.setId_thuongHieu(rs.getInt("id_thuonghieu"));
				sp.setMota(rs.getNString("mota"));
				sp.setNgaytao(rs.getDate("ngaytao"));
				sp.setSoLuong(rs.getInt("soluong"));
				sp.setTenSanPham(rs.getString("tensanpham"));
				dssp.add(sp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dssp;
	}
	public static void main(String[] args) {
		List<SanPham> dssp = SanPhamBL.docTheoLoaiTH(1, 1, "");
		for (SanPham sanPham : dssp) {
			System.out.println(sanPham.getDonGia());
		}
	}
}
