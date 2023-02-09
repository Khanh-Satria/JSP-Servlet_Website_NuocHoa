package controllers;

import java.io.IOException;
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
 * Servlet implementation class ChiTietServlet
 */
@WebServlet("/ChiTietServlet")
public class ChiTietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		SanPham sp = SanPhamBL.docTheoID(id);
		ThuongHieu th = ThuongHieuBL.docTheoID(sp.getId_thuongHieu());
		Loai l = LoaiBL.docTheoID(sp.getId_loai());
		request.setAttribute("th", th.getTenThuongHieu());
		request.setAttribute("l", l.getTenLoai());
		request.setAttribute("sp", sp);
		request.getRequestDispatcher("Views/chi-tiet-san-pham.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
