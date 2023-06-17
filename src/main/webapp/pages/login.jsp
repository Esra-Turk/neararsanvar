<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../css/crud.css" />

    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
      rel="stylesheet"
    />

    <link
      href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;700&display=swap"
      rel="stylesheet"
    />

    <title>Giriş Yap</title>
  </head>
  <body>
    <section class="container">
      <div class="form-section">
        <h4 class="brand-text">Ne Ararsan Var</h4>
        <form action="Login" class="form" method="get">
          <input
            class="form-input"
            name="email"
            type="email"
            placeholder="Enter Email Here"
          />
          <input
            class="form-input"
            name="password"
            type="password"
            placeholder="Enter Password Here"
          />
          <button class="form-submit-btn" type="submit">Login</button>
          <p class="form-description">Don't have an account?</p>
          <p class="form-description">
            <a href="register.jsp" class="form-switch-mode-btn" type="button"
              >Sign up
            </a>
            here
          </p>
        </form>
      </div>

      <img class="login-bg" src="../images/login_bg.jpg" alt="" />
    </section>
    <script
      type="module"
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"
    ></script>
    <script
      nomodule
      src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"
    ></script>
  </body>
</html>
