<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <title>Clean Blog - MyInfo</title>
  <link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
  <!-- Font Awesome icons (free version)-->
  <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
  <!-- Google fonts-->
  <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
  <!-- Core theme CSS (includes Bootstrap)-->
  <link href="../css/styles.css" rel="stylesheet" />
</head>
<body>
<!-- Navigation-->
<%@include file="../main/nav.jsp"%>
<!-- Page Header-->
<header class="masthead" style="background-image: url('../assets/img/show.jpg')">
  <div class="container position-relative px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="page-heading">
          <h1>Detail</h1>
          <span class="subheading">상세 정보 확인</span>
        </div>
      </div>
    </div>
  </div>
</header>
<!-- Main Content-->
<main class="mb-4">
  <div class="container px-4 px-lg-5">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <p>Want to get in touch? Fill out the form below to send me a message and I will get back to you as soon as possible!</p>
        <div class="my-5">
          <!-- * * * * * * * * * * * * * * *-->
          <!-- * * SB Forms Contact Form * *-->
          <!-- * * * * * * * * * * * * * * *-->
          <!-- This form is pre-integrated with SB Forms.-->
          <!-- To make this form functional, sign up at-->
          <!-- https://startbootstrap.com/solution/contact-forms-->
          <!-- to get an API token!-->
          <form action="update.do" method="post" id="contactForm">
            <div class="form-floating">
              <input class="form-control" name="email" id="email" value="${m.email}" readonly type="email" placeholder="Enter your email..." data-sb-validations="required,email" />
              <label for="email">Email address</label>
              <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
              <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
            </div>
            <div class="form-floating">
              <input class="form-control" name="pw" value="${m.pw}" id="pw" type="password" placeholder="Enter your password..." data-sb-validations="required" />
              <label for="pw">Password</label>
              <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
            </div>
            <div class="form-floating">
              <input class="form-control" name="name" id="name"value="${m.name}" type="text" placeholder="Enter your name..." data-sb-validations="required" />
              <label for="name">Name</label>
              <div class="invalid-feedback" data-sb-feedback="name:required">A name is required.</div>
            </div>
            <div class="form-floating">
              <input class="form-control" name="phone" value="${m.phone}" id="phone" type="tel" placeholder="Enter your phone..." data-sb-validations=" " />
              <label for="phone">Phone</label>
              <div class="invalid-feedback" data-sb-feedback=" ">A phone number is required.</div>
            </div>
            <div class="form-floating">
              <input class="form-control" name="address" value="${m.address}"  type="text" id="address" placeholder="Enter your address here..." data-sb-validations=" "/>
              <label for="address">Address</label>
              <div class="invalid-feedback" data-sb-feedback=" ">A message is required.</div>
            </div>
            <br />
            <!-- Submit success message-->
            <!---->
            <!-- This is what your users will see when the form-->
            <!-- has successfully submitted-->
            <div class="d-none" id="submitSuccessMessage">
              <div class="text-center mb-3">
                <div class="fw-bolder">Form submission successful!</div>
                To activate this form, sign up at
                <br />
                <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
              </div>
            </div>
            <!-- Submit error message-->
            <!---->
            <!-- This is what your users will see when there is-->
            <!-- an error submitting the form-->
            <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
            <!-- Submit Button-->
            <input class="btn btn-primary text-uppercase" id="submitButton" type="submit" value="수정"></input>
            <a href="/members/delete-form.jsp">삭제</a>
          </form>
        </div>
      </div>
    </div>
  </div>
</main>
<!-- Footer-->
<%@include file="../main/footer.jsp"%>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../js/scripts.js"></script>
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<!-- * *                               SB Forms JS                               * *-->
<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
