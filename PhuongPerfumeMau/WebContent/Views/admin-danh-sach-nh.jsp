<%-- 
    Document   : san-pham
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="col1">
        <p id="sp">Sản phẩm theo thương hiệu</p>
        <ul>
            <c:forEach items="${dsth}" var="th">
                <li><a href="trang-chu-admin.jsp?maThuongHieu=${th.id}">${th.tenThuongHieu}</a></li>
            </c:forEach>
        </ul>
        <p>Sản phẩm theo loại</p>
        <ul>
            <c:forEach items="${dsl}" var="l">
               <li><a href="trang-chu-admin.jsp?maLoai=${l.id}">${l.tenLoai}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="col21">
            <table border="1" width="100%">
                <caption>DANH SÁCH NƯỚC HOA</caption>
                <thead>
                    <tr>
                        <th>Hình</th>
                        <th>Tên sữa</th>
                        <th>Số lượng</th>
                        <th>Đơn giá</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${dsspt}" var="sp">    
                    <tr>
                        <td style="text-align: center;"><img src="img/${sp.hinhAnh}"/></td>
                        <td><a href="trang-chi-tiet-sp.jsp?id=${sp.id}">${sp.tenSanPham}</a></td>
                        <td style="text-align: center;">${sp.soLuong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="120000" var="donGia" type="number"></fmt:formatNumber>
                        <td style="text-align: center;">${sp.donGia}</td>
                        <td width="80" style="text-align: center";>
                        <form>
                        	<input value="Sửa" type="submit">
                       		 <input value="Xóa" type="submit">
                      	</form>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
             <div class="danh-sach-trang">
            <c:if test="${tongSoTrang>1}">
                <c:forEach var="i" begin="1" end="${tongSoTrang}" step="1">
                    <c:if test="${!empty param.maThuongHieu}">
                        <a href="trang-chu-admin.jsp?maThuongHieu=${param.maThuongHieu}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${!empty param.maLoai}">
                        <a href="trang-chu-admin.jsp?maLoai=${param.maLoai}&trang=${i}"> ${i} </a>
                    </c:if>
                      <c:if test="${empty param.maThuongHieu && empty param.maLoai}">
                        <a href="trang-chu-admin.jsp?trang=${i}"> ${i} </a>
                    </c:if>
                </c:forEach>
            </c:if>
            </div>
        </div>
         <div class="col22">
            <%@include file="hinh-anh.html"%>
        </div>
    </div>
</div>