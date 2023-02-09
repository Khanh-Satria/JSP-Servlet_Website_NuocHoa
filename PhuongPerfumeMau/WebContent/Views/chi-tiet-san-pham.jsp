<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
        <table border="0" width="100%">
            <tr>
                <td colspan="2" class="tieu-de-sua"><font size="+3" color="fuchsia">${sp.tenSanPham}</font></td>
            </tr>
            <tr>
                <td><img src="img/${sp.hinhAnh}" width="150" height="150"/></td>
                <td>
                   <font size="+3">Đơn giá:</font><font size="+3" color="fuchsia">${sp.donGia}đ</font></br>
                    <font size="+3">Loại:</font><font size="+3" color="fuchsia">${l}</font></br>
                     <font size="+3">Thương Hiệu:</font><font size="+3" color="fuchsia">${th}</font>
                </td>
            </tr>
        </table>
    </div>
</div>