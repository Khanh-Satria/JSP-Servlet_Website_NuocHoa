package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessLogics.DonHangBL;
import javaBeans.DonHang;

/**
 * Servlet implementation class CapNhatDonServlet
 */
@WebServlet("/CapNhatDonServlet")
public class CapNhatDonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CapNhatDonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maDonHang = Integer.parseInt(request.getParameter("maDonHang"));
		List<DonHang> dh = DonHangBL.docTheoMa(maDonHang);
		request.setAttribute("dh", dh);
		request.getRequestDispatcher("Views/cap-nhat-don-hang.jsp").include(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
