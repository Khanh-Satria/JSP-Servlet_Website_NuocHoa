package javaBeans;

import java.sql.Date;

public class DonHang {
	private int idTrangThai;
	private int thanhToan;
	private String ghiChu;
	private String diaChiGiaoHang;
	private String dienThoaiNguoiNhan;
	private String tenNguoiNhanHang;
	private Date ngayDatHang;
	private int idKhachHang;
	private int id;
	public int getIdTrangThai() {
		return idTrangThai;
	}
	public void setIdTrangThai(int idTrangThai) {
		this.idTrangThai = idTrangThai;
	}
	public int getThanhToan() {
		return thanhToan;
	}
	public void setThanhToan(int thanhToan) {
		this.thanhToan = thanhToan;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}
	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}
	public String getDienThoaiNguoiNhan() {
		return dienThoaiNguoiNhan;
	}
	public void setDienThoaiNguoiNhan(String dienThoaiNguoiNhan) {
		this.dienThoaiNguoiNhan = dienThoaiNguoiNhan;
	}
	public String getTenNguoiNhanHang() {
		return tenNguoiNhanHang;
	}
	public void setTenNguoiNhanHang(String tenNguoiNhanHang) {
		this.tenNguoiNhanHang = tenNguoiNhanHang;
	}
	public Date getNgayDatHang() {
		return ngayDatHang;
	}
	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public DonHang() {
		
	}
}
