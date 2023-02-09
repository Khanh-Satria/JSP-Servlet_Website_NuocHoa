<%-- 
    Document   : san-pham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="product-big-title-area">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="product-bit-title text-center">
                        <h2>Shop</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <div class="single-product-area">
        <div class="zigzag-bottom"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">Tìm kiếm</h2>
                        <form name="formTK" action="trang-san-pham.jsp?idspx=${sp.id}" method="post">
                            <input name="txtTim" type="text" value="" placeholder="Thông tin tìm kiếm...">
                            <input name="btnTimKiem" type="submit" value="Tìm">
                        </form>
                    </div>
                   <c:if test="${sosp>0}">
                    <div class="single-sidebar">
                        <h2 class="sidebar-title">${sosp} Sản phẩm</h2>
                       	 <c:forEach items="${dsspt}" var="spt">
                        <div class="thubmnail-recent">
                            <img src="img/${spt.hinhAnh}" class="recent-thumb" alt="">
                            <h2><a href="trang-san-pham.jsp?idspx=${spt.id}">${spt.tenSanPham}</a></h2>
                            <div class="product-sidebar-price">
                                <ins>${spt.donGiaKM}</ins> <del>${spt.donGia}</del>
                            </div>                             
                        </div>
                       </c:forEach>
                    </div>
                   </c:if>
                </div>
                
                <div class="col-md-8">
                    <div class="product-content-right">
                        <div class="product-breadcroumb">
                            <a href="">Trang chủ</a>
                            <a href="">Cửa hàng</a>
                            <a href="">${sp.tenSanPham}</a>
                        </div>
                        
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="product-images">
                                    <div class="product-main-img">
                                        <img src="img/${sp.hinhAnh}" alt="">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col-sm-6">
                                <div class="product-inner">
                                    <h2 class="product-name">${sp.tenSanPham}</h2>
                                    <div class="product-inner-price">
                                        <ins>${sp.donGia}</ins> <del>${sp.donGiaKM}</del>
                                    </div>    
                                    
                                    <form action="ThemVaoGioServlet?idsp=${sp.id}&slm=1" class="cart">
                                        <div class="quantity">
                                            <input type="number" size="4" class="input-text qty text" title="Qty"  min="1" step="1">
                                        </div>
                                        <button class="add_to_cart_button" type="submit">Add to cart</button>
                                    </form>   
                                    
                                    <div class="product-inner-category">
                                        <p>Category: <a href="">Summer</a>. Tags: <a href="">awesome</a>, <a href="">best</a>, <a href="">sale</a>, <a href="">shoes</a>. </p>
                                    </div> 
                                    
                                    <div role="tabpanel">
                                        <ul class="product-tab" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Description</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <h2>Product Description</h2>  
                                                <p>${sp.mota}</p>

                                               
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="profile">
                                                <h2>Reviews</h2>
                                                <div class="submit-review">
                                                    <p><label for="name">Name</label> <input name="name" type="text"></p>
                                                    <p><label for="email">Email</label> <input name="email" type="email"></p>
                                                    <div class="rating-chooser">
                                                        <p>Your rating</p>

                                                        <div class="rating-wrap-post">
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                            <i class="fa fa-star"></i>
                                                        </div>
                                                    </div>
                                                    <p><label for="review">Your review</label> <textarea name="review" id="" cols="30" rows="10"></textarea></p>
                                                    <p><input type="submit" value="Submit"></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                        </div>
                        
                        
                        <div class="related-products-wrapper">
                            <h2 class="related-products-title">Sản phẩm liên quan</h2>
                            <div class="related-products-carousel">
                            <c:forEach items="${dssp}" var="sp">
                                <div class="single-product">
                                    <div class="product-f-image">
                                        <img src="img/${sp.hinhAnh}" alt="">
                                        <div class="product-hover">
                                            <a href="" class="add-to-cart-link"><i class="fa fa-shopping-cart"></i> Add to cart</a>
                                            <a href="" class="view-details-link"><i class="fa fa-link"></i> See details</a>
                                        </div>
                                    </div>

                                    <h2><a href="">${sp.tenSanPham}</a></h2>

                                    <div class="product-carousel-price">
                                        <ins>${sp.donGiaKM}</ins> <del>${sp.donGia}</del>
                                    </div> 
                                </div>
                                
                             </c:forEach>            
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </div>
