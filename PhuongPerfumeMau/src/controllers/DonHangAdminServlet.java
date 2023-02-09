package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessLogics.DonHangBL;
import bussinessLogics.SanPhamBL;
import javaBeans.DonHang;

/**
 * Servlet implementation class DonHangAdminServlet
 */
@WebServlet("/DonHangAdminServlet")
public class DonHangAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHangAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DonHang> dsdh = new ArrayList<DonHang>();
		
		if (request.getParameter("btnLuu") !=null) {
			int madon=Integer.parseInt(request.getParameter("maDonHang"));
			int trangthai=Integer.parseInt(request.getParameter("trangthai"));
			DonHangBL.capNhatDon(trangthai, madon);
			dsdh = DonHangBL.docTatCa();
			request.setAttribute("dsdh", dsdh);
			
		}else {
			dsdh = DonHangBL.docTatCa();
			request.setAttribute("dsdh", dsdh);
			
		}
		
		request.getRequestDispatcher("Views/admin-don-hang.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
