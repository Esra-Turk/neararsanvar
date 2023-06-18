<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Header -->
<header class="header-v4">
  <!-- Header desktop -->
  <div class="container-menu-desktop">
    <!-- Topbar -->
    <div class="top-bar">
      <div class="content-topbar flex-sb-m h-full container">
        <div class="left-top-bar">
          100 TL üzerindeki siparişlerinizde kargo bedava!
        </div>

        <div class="right-top-bar flex-w h-full">
          <a href="/neararsanvar/pages/login.jsp" class="flex-c-m trans-04 p-lr-25"> Hesabım </a>
		  <a href="/neararsanvar/admin/index.jsp" class="flex-c-m trans-04 p-lr-25"> Yönetici Paneli </a>
          <a href="#" class="flex-c-m trans-04 p-lr-25"> TRY </a>
        </div>
      </div>
    </div>

    <div class="wrap-menu-desktop how-shadow1">
      <nav class="limiter-menu-desktop container">
        <!-- Logo desktop -->
        <a href="/neararsanvar/index.jsp" class="logo">
          <img src="/neararsanvar/images/icons/logo-01.png" alt="IMG-LOGO" />
        </a>

        <!-- Menu desktop -->
        <div class="menu-desktop">
          <ul class="main-menu">
            <li>
              <a href="pages/products.jsp">Ürünler</a>
            </li>
          </ul>
        </div>

        <!-- Icon header -->
        <div class="wrap-icon-header flex-w flex-r-m">
          <div
            class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart"
            data-notify="2"
          >
            <a href="/neararsanvar/pages/shopping-cart.jsp">
            	<i class="zmdi zmdi-shopping-cart" style="color: black"></i>
            </a>
          </div>
        </div>
      </nav>
    </div>
  </div>

  <!-- Header Mobile -->
  <div class="wrap-header-mobile">
    <!-- Logo moblie -->
    <div class="logo-mobile">
      <a href="index.html"
        ><img src="images/icons/logo-01.png" alt="IMG-LOGO"
      /></a>
    </div>

    <!-- Icon header -->
    <div class="wrap-icon-header flex-w flex-r-m m-r-15">
      <div
        class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart"
        data-notify="2"
      >
        <i class="zmdi zmdi-shopping-cart"></i>
      </div>
    </div>

    <!-- Button show menu -->
    <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
      <span class="hamburger-box">
        <span class="hamburger-inner"></span>
      </span>
    </div>
  </div>

  <!-- Menu Mobile -->
  <div class="menu-mobile">
    <ul class="topbar-mobile">
      <li>
        <div class="left-top-bar">
          Free shipping for standard order over $100
        </div>
      </li>

      <li>
        <div class="right-top-bar flex-w h-full">
          <a href="#" class="flex-c-m p-lr-10 trans-04"> Help & FAQs </a>

          <a href="#" class="flex-c-m p-lr-10 trans-04"> My Account </a>

          <a href="#" class="flex-c-m p-lr-10 trans-04"> EN </a>

          <a href="#" class="flex-c-m p-lr-10 trans-04"> USD </a>
        </div>
      </li>
    </ul>

    <ul class="main-menu-m">
      <li>
        <a href="/neararsanvar/products.jsp">Ürünler</a>
      </li>
    </ul>
  </div>
</header>
