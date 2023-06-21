<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.register.model.User" %>
<%@ page import = "cart.dao.CartDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Alışveriş Sepeti</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="../images/icons/favicon.png" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/bootstrap/css/bootstrap.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../fonts/font-awesome-4.7.0/css/font-awesome.min.css"
    />
    <!--================================================bread===============================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../fonts/iconic/css/material-design-iconic-font.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../fonts/linearicons-v1.0.0/icon-font.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/animate/animate.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/css-hamburgers/hamburgers.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/animsition/css/animsition.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/select2/select2.min.css"
    />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/perfect-scrollbar/perfect-scrollbar.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../css/util.css" />
    <link rel="stylesheet" type="text/css" href="../css/main.css" />
    <!--===============================================================================================-->
  </head>
  <body class="animsition">
    <%@ include file="../components/header.jsp" %>
  
    <!-- breadcrumb -->
    <div class="container">
      <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
        <a href="../index.jsp" class="stext-109 cl8 hov-cl1 trans-04">
          Ana Sayfa
          <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
        </a>

        <span class="stext-109 cl4"> Sepet </span>
      </div>
    </div>

    <!-- Shoping Cart -->
    <form class="bg0 p-t-75 p-b-85">
      <div class="container">
        <div class="row">
          <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
            <div class="m-l-25 m-r--38 m-lr-0-xl">
              <div class="wrap-table-shopping-cart">
                <table class="table-shopping-cart">
                  <tr class="table_head">
                    <th class="column-1">Ürün</th>
                    <th class="column-2"></th>
                    <th class="column-3">Fiyat</th>
                    <th class="column-4">Miktar</th>
                    <th class="column-5">Toplam</th>
                  </tr>
				
				<c:forEach items="${cartProducts}" var="cartProduct">
				
                  <tr class="table_row">
                    <td class="column-1">
                      <div class="how-itemcart1">
                        <img src="../${cartProduct.getProduct().getProductPhoto()}" alt="IMG" />
                      </div>
                    </td>
                    <td class="column-2"><c:out value="${cartProduct.getProduct().getProductName()}"/></td>
                    <td class="column-3"><c:out value="${cartProduct.getProduct().getProductPrice()}"/> TRY</td>
                    <td class="column-4">
                      <div class="wrap-num-product flex-w m-l-auto m-r-0">
                        <div
                          class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m"
                        >
                          <i class="fs-16 zmdi zmdi-minus"></i>
                        </div>

                        <input
                          class="mtext-104 cl3 txt-center num-product"
                          type="number"
                          name="num-product1"
                          value="${cartProduct.getItemAmount()}"
                        />

                        <div
                          class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m"
                        >
                          <i class="fs-16 zmdi zmdi-plus"></i>
                        </div>
                      </div>
                    </td>
                    <td class="column-5"><c:out value= "${cartProduct.calculateProductTotal()}"/> TRY</td>
                  </tr>
                  </c:forEach>
                </table>
              </div>

              <div
                class="flex-w flex-sb-m bor15 p-t-18 p-b-15 p-lr-40 p-lr-15-sm"
              >
                <div class="flex-w flex-m m-r-20 m-tb-5">
                  <div
                    class="flex-c-m stext-101 cl2 size-118 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-5"
                  >
                    Ana Sayfaya Dön
                  </div>
                </div>

                <div
                  class="flex-c-m stext-101 cl2 size-119 bg8 bor13 hov-btn3 p-lr-15 trans-04 pointer m-tb-10"
                >
                  Sepeti Güncelle
                </div>
              </div>
            </div>
          </div>

          <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
            <div
              class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm"
            >
              <h4 class="mtext-109 cl2 p-b-30">Sepet Tutarı</h4>

              <div class="flex-w flex-t p-t-27 p-b-33">
                <div class="size-208">
                  <span class="mtext-101 cl2"> Toplam: </span>
                </div>

                <div class="size-209 p-t-1">
                  <span class="mtext-110 cl2"> <c:out value="${totalPrice}"></c:out> TRY </span>
                </div>
              </div>

				<button
				onclick="document.location = <%=request.getContextPath()%>/ClearCartServlet"
                class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer "
              >
              
                Siparişi Tamamla
              </button>
              
              
              
            </div>
          </div>
        </div>
      </div>
    </form>
    
    <%@ include file="../components/footer.jsp" %>

    <!-- Back to top -->
    <div class="btn-back-to-top" id="myBtn">
      <span class="symbol-btn-back-to-top">
        <i class="zmdi zmdi-chevron-up"></i>
      </span>
    </div>

    <!--===============================================================================================-->
    <script src="../vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/animsition/js/animsition.min.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/bootstrap/js/popper.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/select2/select2.min.js"></script>
    <script>
      $('.js-select2').each(function () {
        $(this).select2({
          minimumResultsForSearch: 20,
          dropdownParent: $(this).next('.dropDownSelect2'),
        });
      });
    </script>
    <!--===============================================================================================-->
    <script src="../vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
    <script>
      $('.js-pscroll').each(function () {
        $(this).css('position', 'relative');
        $(this).css('overflow', 'hidden');
        var ps = new PerfectScrollbar(this, {
          wheelSpeed: 1,
          scrollingThreshold: 1000,
          wheelPropagation: false,
        });

        $(window).on('resize', function () {
          ps.update();
        });
      });
    </script>
    <!--===============================================================================================-->
    <script src="../js/main.js"></script>
  </body>
</html>
