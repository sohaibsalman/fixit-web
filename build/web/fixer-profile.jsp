<!DOCTYPE html>
<html lang="en">

<%@ page import="com.fixit.fixer.*" %>

<head>

    <jsp:include page="h-link.html"></jsp:include>
    <title>Profile</title>
</head>

<body>



    <%
        if(session.getAttribute("username") == null)
        {
            response.sendRedirect("fixer-signin.jsp");
        }
        Fixer f = (Fixer) session.getAttribute("fixer");
%>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h1>FIXIT</h1>
            </div>

            <ul class="list-unstyled components">
                <div class="profile-name">
                    <img src="img/fixer/profile.png" class="pic-thumb">
                    <p> <%=f.getPersonal().getFirstName()%> <%=f.getPersonal().getLastName() %> <p>
                </div>
                <div class="sidebar-links">
                    <li>
                        <a href="#">Home</a>
                    </li>
                    <li class="active">
                        <a href="#">Profile</a>
                    </li>
                    <li>
                        <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false"
                            class="dropdown-toggle">Pages</a>
                        <ul class="collapse list-unstyled" id="pageSubmenu">
                            <li>
                                <a href="#">Page 1</a>
                            </li>
                            <li>
                                <a href="#">Page 2</a>
                            </li>
                            <li>
                                <a href="#">Page 3</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">Request new service</a>
                    </li>
                    <li>
                        <a href="#">Logout</a>
                    </li>
                </div>

            </ul>

        </nav>

        <!-- Page Content  -->
        <div id="content">
            <div class="container-fluid">

                <div class="container-fluid">
                    <!-- MENU ICON -->
                    <button type="button" id="sidebarCollapse" class="btn">
                        <i class="fas fa-bars"></i>
                    </button>
                </div>

                <div class="profile-summary">
                    <div class="row">
                        <div class="col-md-2">
                            <div class="profile-pic">
                                <img src="img/fixer/profile.png" alt="" class="dp">
                            </div>
                        </div>
                        <div class="col-md-8">
                            <h4>
                                <%=f.getPersonal().getFirstName()%> <%=f.getPersonal().getLastName()%>
                            </h4>
                            <h6 class="service-name">
                                <%=f.getWork().getServiceName() %>
                                <br>
                                <%=f.getWork().getWorkArea() %>
                            </h6>
                            <div class="button u-margin-top-small">
                                <a href="#" class="btn-text btn--orange">Update Info</a>
                            </div>
                        </div>
                        <div class="col-md-2">
                            <div class="fixer-rating">
                                <i class="fa fa-star"></i>
                                <h5>Rating</h5>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Page Data -->
            <h4>First Name</h4>
            <%=f.getPersonal().getFirstName()%> <br>
            <h4>Last Name</h4>
            <%=f.getPersonal().getLastName()%> <br>
            <h4>Username</h4>
            <%=f.getCredential().getUsername()%> <br>
            <h4>Email Address</h4>
            <%=f.getCredential().getEmail()%> <br>
            <h4>Phone Number</h4>
            <%=f.getPersonal().getPhoneNumber()%> <br>
            <h4>Gender</h4>
            <%=f.getPersonal().getGender()%> <br>
            <h4>Service Category</h4>
            <%=f.getWork().getServiceCategory() %> <br>
            <h4>Service Name</h4>
            <%=f.getWork().getServiceName()%> <br>
            <h4>City</h4>
            <%=f.getWork().getCity()%> <br>
            <h4>Work Area</h4>
            <%=f.getWork().getWorkArea()%> <br>
            <h4>Work Address</h4>
            <%=f.getWork().getWorkAddress() %> <br>


        </div>


</body>

</html>