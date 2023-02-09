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
       
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="col21">
       
            <table width="100%">
                <tbody>
                <c:forEach items="${dh}" var="d">
                  <tr>
                  	<td>
                  		</br><label>Đơn hàng của</label>
                  	</td>
                  </tr>
                  <tr>
                  	<td>
                  		</br><label>Tên Khách Hàng</label></br>
                  		<input type="text" readonly="readonly" value="${d.tenNguoiNhanHang}" size="60">
                  	</td>
                  </tr>
                  
                  <tr>
                  	<td>
                  		</br><label>Số điện thoại</label></br>
                  		<input type="text" readonly="readonly" value="${d.dienThoaiNguoiNhan}" size="60">
                  	</td>
                  </tr>
                  
                  <tr>
                  	<td>
                  		</br><label>Địa chỉ</label></br>
                  		<input type="text" readonly="readonly" value="${d.diaChiGiaoHang}" size="60">
                  	</td>
                  </tr>
                  
                  <tr>
                  	<td>
                  		</br><label>Ngày đặt</label></br>
                  		<input type="text" readonly="readonly" value="${d.ngayDatHang }" size="60">
                  	</td>
                  </tr>
                  <tr>
                  	<td>
                  		</br><label>Ma don</label></br>
                  		<input name="madon" type="text" readonly="readonly" value="${d.id }" size="60">
                  	</td>
                  </tr>
                   <form action="trang-don-hang-admin.jsp?maDonHang=${d.id}"  method="post">
                   <tr>
                  	<td>
                  		</br><label>Trạng thái</label></br>
                  		<select name="trangthai" id="trangthai">
 							<option value="1">Nhận đơn hàng</option>
						  	<option value="2">Đang giao hàng</option>
						 	<option value="3">Đã giao hàng</option>
						 	<option value="4">Hủy đơn hàng</option>
						</select>
                  	</td>
                  </tr>
                    <tr>
                  	<td>
                  		</br>
                  		<input name="btnLuu" type="submit" readonly="readonly" value="  Lưu  ">
                  	</td>
                  </tr>
                   </form>
                  </c:forEach>
                </tbody>
            </table>
          
        </div>
         <div class="col22">
            <%@include file="hinh-anh.html"%>
        </div>
    </div>
</div>