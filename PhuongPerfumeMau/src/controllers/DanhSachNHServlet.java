package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessLogics.LoaiBL;
import bussinessLogics.SanPhamBL;
import bussinessLogics.ThuongHieuBL;
import javaBeans.Loai;
import javaBeans.SanPham;

import javaBeans.ThuongHieu;


/**
 * Servlet implementation class DanhSachNHServlet
 */
@WebServlet("/DanhSachNHServlet")
public class DanhSachNHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachNHServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(request.getParameter("trang") == null) {
	        	List<SanPham> dsspt = SanPhamBL.spPhanTrang(1, 5);
	        	int tongSoTrang = SanPhamBL.tongSoTrang(5);
	        	request.setAttribute("dsspt", dsspt);
	        	request.setAttribute("tongSoTrang", tongSoTrang);
	        }else {
	        	int trang = Integer.parseInt(request.getParameter("trang"));
	        	List<SanPham> dsspt = SanPhamBL.spPhanTrang(trang, 5);
	        	int tongSoTrang = SanPhamBL.tongSoTrang(5);
	        	request.setAttribute("dsspt", dsspt);
	        	request.setAttribute("tongSoTrang", tongSoTrang);
	        }
		
		 
		 if(request.getParameter("maThuongHieu") != null) {
	        	if(request.getParameter("trang") == null) {
	        		int maThuongHieu = Integer.parseInt(request.getParameter("maThuongHieu"));
	        		int tongSoDong = SanPhamBL.docTheoThuongHieu(maThuongHieu).size();
	        		int tongSoTrang = tongSoDong/2 + (tongSoDong%2==0?0:1);
	        		List<SanPham> dsspt = SanPhamBL.spPhanTrangTheoTH(maThuongHieu, 1, 2);
	        		request.setAttribute("tongSoTrang", tongSoTrang);
	        		request.setAttribute("dsspt", dsspt);
	        	}else {
	        		int trang = Integer.parseInt(request.getParameter("trang"));
	        		int maThuongHieu = Integer.parseInt(request.getParameter("maThuongHieu"));
	        		int tongSoDong = SanPhamBL.docTheoThuongHieu(maThuongHieu).size();
	        		int tongSoTrang = tongSoDong/2 + (tongSoDong%2==0?0:1);
	        		List<SanPham> dsspt = SanPhamBL.spPhanTrangTheoTH(maThuongHieu, trang, 2);
	        		request.setAttribute("tongSoTrang", tongSoTrang);
	        		request.setAttribute("dsspt", dsspt);
	        	}
	        }
	        
		 
		if(request.getParameter("maLoai") != null) {
			
			if(request.getParameter("trang") == null) {
				int maLoai = Integer.parseInt(request.getParameter("maLoai"));
				int tongSoDong = SanPhamBL.docTheoLoai(maLoai).size();
				int tongSoTrang = tongSoDong/2 + (tongSoDong%2==0?0:1);
				List<SanPham> dsspt = SanPhamBL.spPhanTrangTheoL(maLoai, 1, 2);
				request.setAttribute("dsspt", dsspt);
				request.setAttribute("tongSoTrang", tongSoTrang);
			}else {
				int trang = Integer.parseInt(request.getParameter("trang"));
				int maLoai = Integer.parseInt(request.getParameter("maLoai"));
				int tongSoDong = SanPhamBL.docTheoLoai(maLoai).size();
				int tongSoTrang = tongSoDong/2 + (tongSoDong%2==0?0:1);
				List<SanPham> dsspt = SanPhamBL.spPhanTrangTheoL(maLoai, trang, 2);
				request.setAttribute("dsspt", dsspt);
				request.setAttribute("tongSoTrang", tongSoTrang);
			}
		}
	        
	        List<ThuongHieu> dsth = ThuongHieuBL.docTatCa();
	        request.setAttribute("dsth", dsth);
	        
	        List<Loai> dsl = LoaiBL.docTatCa();
	        request.setAttribute("dsl", dsl);
		 
		request.getRequestDispatcher("Views/admin-danh-sach-nh.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
