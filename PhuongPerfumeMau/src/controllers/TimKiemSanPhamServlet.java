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
 * Servlet implementation class TimKiemSanPhamServlet
 */
@WebServlet("/TimKiemSanPhamServlet")
public class TimKiemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemSanPhamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int sosp=0;
			
			
			List<Loai> dsl = LoaiBL.docTatCa();
			List<ThuongHieu> dsth = ThuongHieuBL.docTatCa();
			if(request.getParameter("btnTimKiem") != null) {
				int maLoai = Integer.parseInt(request.getParameter("cboLoai"));
				int maTH = Integer.parseInt(request.getParameter("cboThuongHieu"));
				String ten = request.getParameter("txtTenTim");
				List<SanPham> dssp = SanPhamBL.docTheoLoaiTH(maLoai, maTH, ten);
				sosp= dssp.size();
				request.setAttribute("sosp", sosp);
				request.setAttribute("dssp", dssp);
				}
		
			request.setAttribute("dsl", dsl);
			request.setAttribute("dsth", dsth);
			request.getRequestDispatcher("Views/tim-kiem.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
