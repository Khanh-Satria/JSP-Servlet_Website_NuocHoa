<%-- 
    Document   : tim-kiem-sua
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page1" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
    	  <div class="col21">
    	  <form action="trang-thong-ke.jsp" method="post">
       	 <table width="100%">
            <thead>
                <tr>
                    <th>THỐNG KÊ DOANH THU</th>
                </tr>
            </thead>
            <tbody>
            	<tr>
             		<td>
             			</br>
             			<label>Chọn ngày</label>
             		</td>
             	</tr>
             	<tr>
             		<td>
             			<input type="date" name="ngaydau">&ensp;<input type="date" name="ngaycuoi">
             		</td>
             	</tr>
             	<tr>
             		<td>
             			<input type="submit" name="btnLoc" value="Lọc">
             		</td>
             	</tr>
            </tbody>
        </table>
        </form>
        </br>
        	 <table width="100%" border="1">
            	<tr>
             		<td>Tên sản phẩm</td>
             		<td>Đơn giá</td>
             		<td>Số lượng</td>
             		<td>Ngày đặt</td>
             	</tr>
             	<c:forEach items="${dssp}" var="sp">
             		<tr>
             		<td>${sp.tenSanPham}</td>
             		<td>${nf.format(sp.donGia)}đ</td>
             		<td>${sp.soLuong}</td>
             		<td>${sp.ngayDat}</td>
             		</tr>
             	</c:forEach>
             	<tr>
             		<td colspan="2" align="right"><h3>Tổng tiền</h3></td>
             		<td colspan="2"><h3>${nf.format(tongtien)}đ</h3></td>
             		
             	</tr>
       		 </table>
        
        </div>
        <div class="col22">
            <%@include file="hinh-anh.html"%>
   		</div>
    </div>
</div>