<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="stylesheet" href="css/facebook.css">
    <title>Facebook - Home</title>

</head>
<body>
<%
    if(session.getAttribute("regError") != null){%>
        <div class="bootstrap-alert" role="alertdialog">
            <%=session.getAttribute("regError")%>
        </div>
    <%}
%>

<div class="container">
    <div class="row login-page">
        <div class="col-lg-7 left">
            <h2>facebook</h2>
            <p>Facebook helps you connect and share with the people in your life.</p>
        </div>
        <div class="col-lg-5 right shadow p-3 mb-5 bg-body rounded">
            <form action="/LoginServlet" method="POST">
                <div class="mb-3">
                    <input type="text" name="email" required class="form-control textBoxFormatter" id="formGroupExampleInput" placeholder="Email Address or Phone Number">
                </div>
                <div class="mb-3">
                    <input type="password"  name ="password" required class="form-control textBoxFormatter" id="formGroupExampleInput2" placeholder="Password">
                </div>
                <div class="mb-3">
<%--                    <button class="btn btn-primary form-control textBoxFormatter" type="submit">Login</button>--%>
                    <input type="submit" class="btn btn-primary form-control textBoxFormatter" value="Submit">
                </div>
                <div class="mb-3 forgot">
                    <p>Forgotten password?</p>
                </div>
                <div class="mb-3">
                    <hr>
                </div>
                <div class="mb-3 create">
                    <button type="button" class="btn btn-primary btnRegister" data-bs-toggle="modal" data-bs-target="#registerModal">Create New Account</button>
                </div>
            </form>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="registerModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Sign Up</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                <%--    modal header ends here   --%>
                    <form action="/RegisterServlet" method="post">

                        <div class="modal-body">
                            <div class="row mb-3">
                                <div class="col-md-6"><input type="text" required class="form-control validate textBoxFormatter" name="fname" id="exampleFormControlInput1" placeholder="Firstname"></div>
                                <div class="col-md-6"> <input type="text"  required class="form-control validate textBoxFormatter" name="lname"id="exampleFormControlInput2" placeholder="Surname">  </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-12"><input type="email"  required class="form-control validate textBoxFormatter" name="email" id="exampleFormControlInput3" placeholder="Mobile Number or Email Address"></div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-12"><input type="password" required class="form-control validate textBoxFormatter" name="password" id="exampleFormControlInput4" placeholder="Password"></div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-lg-12">
                                    <label for="dob" class="form-label">Date of birth</label>
                                    <input type="date" name="dob" id="dob" class="textBoxFormatter">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <label class="form-check-label" for="male">Gender</label>
                                <div class="col-md-3">
                                    <input class="form-check-input" type="radio" value="male" name="gender" id="male">
                                    <label class="form-check-label" for="male">
                                        Male
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <input class="form-check-input" type="radio" value="female"  name="gender" id="female" checked>
                                    <label class="form-check-label" for="female">
                                        Female
                                    </label>
                                </div>
                            </div>
                        </div>

                    <!-- modal body ends here-->

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <input type="submit" class="btn btn-primary" value="Register">
                    </div>
                    </form>
    <%-- the form closes after the form --%>
                </div>
            </div>
        </div>
        <!-- Before content -->
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
</body>
</html>