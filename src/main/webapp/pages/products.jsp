<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <title>Kategori Sayfası</title>
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
    <!--===============================================================================================-->
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
      href="../vendor/daterangepicker/daterangepicker.css"
    />
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="../vendor/slick/slick.css" />
    <!--===============================================================================================-->
    <link
      rel="stylesheet"
      type="text/css"
      href="../vendor/MagnificPopup/magnific-popup.css"
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

    <!-- Product -->
    <section class="bg0 p-t-23 p-b-140">
      <div class="container">
        <div class="p-b-10">
          <h3 class="ltext-103 cl5">Ürünler</h3>
        </div>

        <div class="flex-w flex-sb-m p-b-52">
          <div class="flex-w flex-l-m filter-tope-group m-tb-10">
            <button
              class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5 how-active1"
              data-filter="*"
            >
              Hepsi
            </button>

            <button
              class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
              data-filter=".Kadın"
            >
              Kadın
            </button>

            <button
              class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
              data-filter=".Erkek"
            >
              Erkek
            </button>
            
            <button
              class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
              data-filter=".Ayakkabı"
            >
              Ayakkabı
            </button>

            <button
              class="stext-106 cl6 hov1 bor3 trans-04 m-r-32 m-tb-5"
              data-filter=".Saat"
            >
              Saat
            </button>
          </div>
        </div>

        <div class="row isotope-grid">
        <c:forEach items="${products}" var="product">
          <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item ${product.getCategory().getCategoryName()}">
            <!-- Block2 -->
            <div class="block2">
              <div class="block2-pic hov-img0">
                <img src="../${product.getProductPhoto()}" alt="IMG-PRODUCT" />

                <a
                  href="#"
                  class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1"
                >
                  Hızlı İncele
                </a>
              </div>

              <div class="block2-txt flex-w flex-t p-t-14">
                <div class="block2-txt-child1 flex-col-l">
                  <a
                    href="product-detail.html"
                    class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6"
                  >
                   <c:out value="${product.getProductName()}"/>
                  </a>
				
                  <span class="stext-105 cl3">  <c:out value="${product.getProductPrice()}"/> TRY </span>
                </div>

                <div class="block2-txt-child2 flex-r p-t-3">
                  <a
                    href="#"
                    class="btn-addwish-b2 dis-block pos-relative js-addwish-b2"
                  >
                    <img
                      class="icon-heart1 dis-block trans-04"
                      src="../images/icons/icon-heart-01.png"
                      alt="ICON"
                    />
                    <img
                      class="icon-heart2 dis-block trans-04 ab-t-l"
                      src="../images/icons/icon-heart-02.png"
                      alt="ICON"
                    />
                  </a>
                </div>
              </div>
            </div>
          </div>
		
		</c:forEach>
		
        </div>
        
        

        <!-- Load more -->
        <div class="flex-c-m flex-w w-full p-t-45">
          <a
            href="#"
            class="flex-c-m stext-101 cl5 size-103 bg2 bor1 hov-btn1 p-lr-15 trans-04"
          >
            Daha Fazla
          </a>
        </div>
      </div>
    </section>
    
    <%@ include file="../components/footer.jsp" %>

    <!-- Back to top -->
    <div class="btn-back-to-top" id="myBtn">
      <span class="symbol-btn-back-to-top">
        <i class="zmdi zmdi-chevron-up"></i>
      </span>
    </div>

    <!-- Modal1 -->
    <div class="wrap-modal1 js-modal1 p-t-60 p-b-20">
      <div class="overlay-modal1 js-hide-modal1"></div>

      <div class="container">
        <div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
          <button class="how-pos3 hov3 trans-04 js-hide-modal1">
            <img src="../images/icons/icon-close.png" alt="CLOSE" />
          </button>

          <div class="row">
            <div class="col-md-6 col-lg-7 p-b-30">
              <div class="p-l-25 p-r-30 p-lr-0-lg">
                <div class="wrap-slick3 flex-sb flex-w">
                  <div class="wrap-slick3-dots"></div>
                  <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

                  <div class="slick3 gallery-lb">
                    <div
                      class="item-slick3"
                      data-thumb="../images/product-detail-01.jpg"
                    >
                      <div class="wrap-pic-w pos-relative">
                        <img
                          src="../images/product-detail-01.jpg"
                          alt="IMG-PRODUCT"
                        />

                        <a
                          class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
                          href="../images/product-detail-01.jpg"
                        >
                          <i class="fa fa-expand"></i>
                        </a>
                      </div>
                    </div>

                    <div
                      class="item-slick3"
                      data-thumb="../images/product-detail-02.jpg"
                    >
                      <div class="wrap-pic-w pos-relative">
                        <img
                          src="../images/product-detail-02.jpg"
                          alt="IMG-PRODUCT"
                        />

                        <a
                          class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
                          href="../images/product-detail-02.jpg"
                        >
                          <i class="fa fa-expand"></i>
                        </a>
                      </div>
                    </div>

                    <div
                      class="item-slick3"
                      data-thumb="../images/product-detail-03.jpg"
                    >
                      <div class="wrap-pic-w pos-relative">
                        <img
                          src="../images/product-detail-03.jpg"
                          alt="IMG-PRODUCT"
                        />

                        <a
                          class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04"
                          href="../images/product-detail-03.jpg"
                        >
                          <i class="fa fa-expand"></i>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="col-md-6 col-lg-5 p-b-30">
              <div class="p-r-50 p-t-5 p-lr-0-lg">
                <h4 class="mtext-105 cl2 js-name-detail p-b-14">
                  Lightweight Jacket
                </h4>

                <span class="mtext-106 cl2"> 58.79 TRY </span>

                <!--  -->
                <div class="p-t-33">
                  <div class="flex-w flex-r-m p-b-10">
                    <div class="size-204 flex-w flex-m respon6-next">
                      <div class="wrap-num-product flex-w m-r-20 m-tb-10">
                        <div
                          class="btn-num-product-down cl8 hov-btn3 trans-04 flex-c-m"
                        >
                          <i class="fs-16 zmdi zmdi-minus"></i>
                        </div>

                        <input
                          class="mtext-104 cl3 txt-center num-product"
                          type="number"
                          name="num-product"
                          value="1"
                        />

                        <div
                          class="btn-num-product-up cl8 hov-btn3 trans-04 flex-c-m"
                        >
                          <i class="fs-16 zmdi zmdi-plus"></i>
                        </div>
                      </div>

                      <button
                        class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail"
                      >
                        Sepete Ekle
                      </button>
                    </div>
                  </div>
                </div>

                <!--  -->
                <div class="flex-w flex-m p-l-100 p-t-40 respon7">
                  <div class="flex-m bor9 p-r-10 m-r-11">
                    <a
                      href="#"
                      class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 js-addwish-detail tooltip100"
                      data-tooltip="Add to Wishlist"
                    >
                      <i class="zmdi zmdi-favorite"></i>
                    </a>
                  </div>

                  <a
                    href="#"
                    class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
                    data-tooltip="Facebook"
                  >
                    <i class="fa fa-facebook"></i>
                  </a>

                  <a
                    href="#"
                    class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
                    data-tooltip="Twitter"
                  >
                    <i class="fa fa-twitter"></i>
                  </a>

                  <a
                    href="#"
                    class="fs-14 cl3 hov-cl1 trans-04 lh-10 p-lr-5 p-tb-2 m-r-8 tooltip100"
                    data-tooltip="Google Plus"
                  >
                    <i class="fa fa-google-plus"></i>
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
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
    <script src="../vendor/daterangepicker/moment.min.js"></script>
    <script src="../vendor/daterangepicker/daterangepicker.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/slick/slick.min.js"></script>
    <script src="../js/slick-custom.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/parallax100/parallax100.js"></script>
    <script>
      $('.parallax100').parallax100();
    </script>
    <!--===============================================================================================-->
    <script src="../vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
    <script>
      $('.gallery-lb').each(function () {
        // the containers for all your galleries
        $(this).magnificPopup({
          delegate: 'a', // the selector for gallery item
          type: 'image',
          gallery: {
            enabled: true,
          },
          mainClass: 'mfp-fade',
        });
      });
    </script>
    <!--===============================================================================================-->
    <script src="../vendor/isotope/isotope.pkgd.min.js"></script>
    <!--===============================================================================================-->
    <script src="../vendor/sweetalert/sweetalert.min.js"></script>
    <script>
      $('.js-addwish-b2, .js-addwish-detail').on('click', function (e) {
        e.preventDefault();
      });

      $('.js-addwish-b2').each(function () {
        var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
        $(this).on('click', function () {
          swal(nameProduct, 'is added to wishlist !', 'success');

          $(this).addClass('js-addedwish-b2');
          $(this).off('click');
        });
      });

      $('.js-addwish-detail').each(function () {
        var nameProduct = $(this)
          .parent()
          .parent()
          .parent()
          .find('.js-name-detail')
          .html();

        $(this).on('click', function () {
          swal(nameProduct, 'is added to wishlist !', 'success');

          $(this).addClass('js-addedwish-detail');
          $(this).off('click');
        });
      });

      /*---------------------------------------------*/

      $('.js-addcart-detail').each(function () {
        var nameProduct = $(this)
          .parent()
          .parent()
          .parent()
          .parent()
          .find('.js-name-detail')
          .html();
        $(this).on('click', function () {
          swal(nameProduct, 'is added to cart !', 'success');
        });
      });
    </script>
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
