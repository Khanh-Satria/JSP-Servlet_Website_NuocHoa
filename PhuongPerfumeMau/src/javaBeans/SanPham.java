package javaBeans;

import java.io.Serializable;
import java.sql.Date;

public class SanPham implements Serializable{
	
	private int id_thuongHieu;
	private int id;
	private int id_loai;
	private int hienthi;
	private Date ngaytao;
	private int soLuong;
	private double donGiaKM;
	private double donGia;
	private String hinhAnh;
	private String mota;
	private String tenSanPham;
	public int getId_thuongHieu() {
		return id_thuongHieu;
	}
	public void setId_thuongHieu(int id_thuongHieu) {
		this.id_thuongHieu = id_thuongHieu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_loai() {
		return id_loai;
	}
	public void setId_loai(int id_loai) {
		this.id_loai = id_loai;
	}
	public int getHienthi() {
		return hienthi;
	}
	public void setHienthi(int hienthi) {
		this.hienthi = hienthi;
	}
	public Date getNgaytao() {
		return ngaytao;
	}
	public void setNgaytao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGiaKM() {
		return donGiaKM;
	}
	public void setDonGiaKM(double donGiaKM) {
		this.donGiaKM = donGiaKM;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	
	public SanPham() {
		
	}
}
