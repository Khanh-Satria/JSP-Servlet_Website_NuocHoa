package bussinessLogics;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javaBeans.SanPham;
import javaBeans.SanPhamMua;

public class GioHang {
		private Map<Integer, Integer> dsh;  //key:idsp value=slm;
		
		public GioHang() {
			dsh = new Hashtable<>();
		}
		
		public void them(int idsp, int slm) {
			if(dsh.containsKey(idsp)) {						//kiểm tra key có tồn tại hay k
				dsh.replace(idsp, dsh.get(idsp)+slm);		// thây đổi số lượng mua mỗi lần chọn
			}else {
				dsh.put(idsp, slm);
			}
		}
		
		public double tongTien() {
			double tt =0;
			for(int idsp: dsh.keySet()) {
				SanPham sp = SanPhamBL.docTheoID(idsp);
				tt += sp.getDonGiaKM() * dsh.get(idsp);
			}
			return tt;
		}
		
		public int soMatHang() {
			return dsh.size();
		}
		
		public  List<SanPhamMua> danhSachSanPhamMua(){
			List<SanPhamMua> dsspm = new ArrayList<>();
			for(int idspm:dsh.keySet()) {
				SanPham sp = new SanPham();
				sp = SanPhamBL.docTheoID(idspm);
				SanPhamMua spm = new SanPhamMua();
				spm.setDonGia(sp.getDonGia());
				spm.setDonGiaKM(sp.getDonGiaKM());
				spm.setHienthi(sp.getHienthi());
				spm.setId(sp.getId());
				spm.setId_loai(sp.getId_loai());
				spm.setId_thuongHieu(sp.getId_thuongHieu());
				spm.setMota(sp.getMota());
				spm.setNgaytao(sp.getNgaytao());
				spm.setSoLuong(sp.getSoLuong());
				spm.setSoLuongMua(dsh.get(idspm));
				spm.setTenSanPham(sp.getTenSanPham());
				spm.setHinhAnh(sp.getHinhAnh());
				dsspm.add(spm);
			}
			return dsspm;
		}
}
