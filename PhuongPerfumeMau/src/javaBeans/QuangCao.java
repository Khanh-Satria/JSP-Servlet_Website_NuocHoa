package javaBeans;

import java.io.Serializable;
import java.sql.Date;

public class QuangCao implements Serializable{
		
		private int id;
		private Date ngayDang;
		private String thongTinChiTiet;
		private String thongDiep;
		private String hinhAnh;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Date getNgayDang() {
			return ngayDang;
		}
		public void setNgayDang(Date ngayDang) {
			this.ngayDang = ngayDang;
		}
		public String getThongTinChiTiet() {
			return thongTinChiTiet;
		}
		public void setThongTinChiTiet(String thongTinChiTiet) {
			this.thongTinChiTiet = thongTinChiTiet;
		}
		public String getThongDiep() {
			return thongDiep;
		}
		public void setThongDiep(String thongDiep) {
			this.thongDiep = thongDiep;
		}
		public String getHinhAnh() {
			return hinhAnh;
		}
		public void setHinhAnh(String hinhAnh) {
			this.hinhAnh = hinhAnh;
		}
		
		
		public QuangCao() {
			
		}
	
}
