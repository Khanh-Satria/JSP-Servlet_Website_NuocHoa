package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bussinessLogics.SanPhamBL;
import javaBeans.SanPham;

/**
 * Servlet implementation class XemChiTietServlet
 */
@WebServlet("/XemChiTietServlet")
public class XemChiTietServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemChiTietServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idsp=Integer.parseInt(request.getParameter("idspx"));
		SanPham sp = SanPhamBL.docTheoID(idsp);
		String tenTim = request.getParameter("txtTim");
		List<SanPham> dsspt = new ArrayList<SanPham>();
		
		List<SanPham> dssp = SanPhamBL.sanPhamTheoTH(sp.getId_thuongHieu());
		if(tenTim != "") {
			dsspt = SanPhamBL.timKiemSanPham(tenTim);
		}
		request.setAttribute("sp", sp);
		request.setAttribute("dssp", dssp);
		request.setAttribute("dsspt", dsspt);
		request.setAttribute("sosp", dsspt.size());
		request.getRequestDispatcher("Views/san-pham.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
