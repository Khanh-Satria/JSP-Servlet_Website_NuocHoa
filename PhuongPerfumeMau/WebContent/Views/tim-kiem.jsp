<%-- 
    Document   : tim-kiem-sua
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page4" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
  
    <form name="frmTimKiem" action="trang-tim-kiem.jsp" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>TÌM KIẾM SẢN PHẨM</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Loại : 
                        <select name="cboLoai">
                            <c:forEach items="${dsl}"  var="l">
                                <option value="${l.id}">${l.tenLoai}</option>
                            </c:forEach>
                        </select>
                        Thương hiệu:
                        <select name="cboThuongHieu">
                            <c:forEach items="${dsth}" var="th">
                                <option value="${th.id}">${th.tenThuongHieu}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tên nước hoa: <input type="text" name="txtTenTim" value="" size="30"/>
                        <input type="submit" value="Tìm kiếm" name="btnTimKiem"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <c:if test="${sosp>0}">
        <p><b>Có ${sosp} sản phẩm được tìm thấy</b></p>
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
                    <c:forEach items="${dssp}" var="sp">    
                    <tr>
                        <td style="text-align: center;"><img src="img/${sp.hinhAnh}"/></td>
                        <td><a href="trang-chu-admin.jsp?idsp=${sp.id}">${sp.tenSanPham}</a></td>
                        <td style="text-align: center;">${sp.soLuong}</td>
                        <fmt:setLocale value="vi-VN"></fmt:setLocale>
                        <fmt:formatNumber value="120000" var="donGia" type="number"></fmt:formatNumber>
                        <td style="text-align: center;">${sp.donGia}đ</td>
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
            </div>
    </c:if>
    </div>
</div>