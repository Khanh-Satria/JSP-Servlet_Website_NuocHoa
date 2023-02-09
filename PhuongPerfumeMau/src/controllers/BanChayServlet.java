package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessLogics.SanPhamBL;
import javaBeans.SanPham;

/**
 * Servlet implementation class BanChayServlet
 */
@WebServlet("/BanChayServlet")
public class BanChayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BanChayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> dsbc = SanPhamBL.sanPhamBanChay();
		List<SanPham> dsspm = SanPhamBL.danhSachSanPhamMoi();
		request.setAttribute("dsbc", dsbc);
		request.setAttribute("dsspm", dsspm);
		request.getRequestDispatcher("Views/ban-chay-yeu-thich.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
