<%-- 
    Document   : tim-kiem-sua
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="col1">
        <p id="sp">Quản lý đơn hàng</p>
        
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
       </div>
        <div class="col21">   
			   
			        <table border="1" >
			            <thead>
			                <tr>
			                    <th colspan="6" align="center">Quản lý đơn hàng</th>
			                </tr>
			                <tr>
			                   <th>Tên Khách Hàng</th>
			                   <th>Số điện thoại</th>
			                   <th>Địa chỉ</th>
			                   <th>Ngày đặt</th>
			                   <th>Trạng thái</th>
			                   <th>Thao tác</th>
			                </tr>
			            </thead>
			            <tbody>
			            <c:forEach items="${dsdh}" var="dh">
			                <tr>
			                    <td>${dh.tenNguoiNhanHang}</td>
			                    <td>${dh.dienThoaiNguoiNhan}</td>
			                    <td>${dh.diaChiGiaoHang}</td>
			                    <td>${dh.ngayDatHang}</td>
			                      <c:if test="${dh.idTrangThai==1}">
			                    	<td>Nhận đơn hàng</td>
			                     </c:if>
			                     <c:if test="${dh.idTrangThai==2}">
			                    	<td>Đang giao hàng</td>
			                     </c:if>
			                     <c:if test="${dh.idTrangThai==3}">
			                    	<td>Đã giao hàng</td>
			                     </c:if>
			                     <c:if test="${dh.idTrangThai==4}">
			                    	<td>Hủy đơn hàng</td>
			                     </c:if>
			                    <td><a href="trang-cap-nhat-admin.jsp?maDonHang=${dh.id}"><input type="submit" name="btnCapNhat" value="Cập nhật"/></a></td>
			                </tr>
			             </c:forEach> 
			            </tbody>
			        </table>
			   
    	</div>
    	<div class="col22">
            <%@include file="hinh-anh.html"%>
   		 </div>
   	</div>
</div>
    