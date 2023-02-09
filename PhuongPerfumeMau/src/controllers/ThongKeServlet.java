package controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import bussinessLogics.ChiTietDonHangBL;
import bussinessLogics.DonHangBL;
import bussinessLogics.SanPhamBL;
import bussinessLogics.SanPhamThongKeBL;
import javaBeans.ChiTietDonHang;
import javaBeans.DonHang;
import javaBeans.SanPham;
import javaBeans.SanPhamThongKe;

/**
 * Servlet implementation class ThongKeServlet
 */
@WebServlet("/ThongKeServlet")
public class ThongKeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int tongtien=0;
		if(request.getParameter("btnLoc") != null) {
			String str1 = request.getParameter("ngaydau");
			String str2 = request.getParameter("ngaycuoi");
			Date date1 = Date.valueOf(str1);
			Date date2 = Date.valueOf(str2);
			
			List<SanPhamThongKe> dssp = SanPhamThongKeBL.thongKe(date1, date2);
			 
			 for (SanPhamThongKe sanPhamThongKe : dssp) {
					tongtien += sanPhamThongKe.getSoLuong()*sanPhamThongKe.getDonGia();
				}
			 
			 request.setAttribute("dssp", dssp);
		}
		
		
		 Locale lc = new Locale("vi", "VN");
	     NumberFormat nf = NumberFormat.getNumberInstance(lc);
	    request.setAttribute("nf", nf);
		request.setAttribute("tongtien", tongtien);
		request.getRequestDispatcher("Views/thong-ke.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
