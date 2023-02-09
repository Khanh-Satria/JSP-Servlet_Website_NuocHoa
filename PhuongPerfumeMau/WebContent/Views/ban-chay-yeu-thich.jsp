<%-- 
    Document   : ban-chay-yeu-thich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <div class="product-widget-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Top Sellers</h2>
                        <a href="" class="wid-view-more">View All</a>
                        
                        <c:forEach items="${dsbc}" var="sp">
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="img/${sp.hinhAnh}" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">${sp.tenSanPham}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>${sp.donGiaKM}</ins> <del>${sp.donGia}</del>
                            </div>                            
                        </div>
                        </c:forEach>
                       
                    </div>
                </div>
               
                <div class="col-md-4">
                    <div class="single-product-widget">
                        <h2 class="product-wid-title">Top New</h2>
                        <a href="#" class="wid-view-more">View All</a>
                        <c:forEach items="${dsspm}" var="sp">
                        <div class="single-wid-product">
                            <a href="single-product.html"><img src="img/${sp.hinhAnh}" alt="" class="product-thumb"></a>
                            <h2><a href="single-product.html">${sp.tenSanPham}</a></h2>
                            <div class="product-wid-rating">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="product-wid-price">
                                <ins>${sp.donGiaKM}</ins> <del>${sp.donGia}</del>
                            </div>                            
                        </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div> <!-- End product widget area -->
