<%@ page import="com.fixit.fixer.*" %>

<% 
	CredentialInfo data = (CredentialInfo) request.getAttribute("fixer-credentials");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="h-link.html"></jsp:include>
    <title>Signup</title>
</head>

<body>



    <div class="signup-header">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="signup__form">
                        <h1 class="heading-main">FIXIT</h1>
                        <h5 class="u-margin-top-small">Enter your Personal Info</h5>

                        <form action="Signup" method="post">
                            <input type="hidden" name="command" value="FIXER-PERSONAL">
                            <div class="container u-margin-top-huge">
                                <div class="row">
                                    <!-- Hidden Credentials -->
                                    <div class="col-md-12">
                                        <input type="hidden" name="email" value="<%= data.getEmail()%>">
                                    </div>
                                    <div class="col-md-12">
                                        <input type="hidden" name="username" value="<%= data.getUsername()%>">
                                    </div>
                                    <div class="col-md-12">
                                        <input type="hidden" name="password" value="<%= data.getPassword()%>">
                                    </div>
                                    <div class="col-md-12">
                                        <input type="text" name="firstName" placeholder="First Name"> <br>
                                    </div>
                                    <div class="col-md-12">
                                        <input type="text" name="lastName" placeholder="Last Name"> <br>
                                    </div>
                                    <div class="col-md-12">
                                        <input type="radio" name="gender" value="Male"> Male
                                        <input type="radio" name="gender" value="Female"> Female <br>
                                    </div>
                                    
                                    <div class="col-md-12">
                                        <input type="text" name="phoneNumber" placeholder="Phone Number"> <br>
                                    </div>
                                    <div class="col-md-12 u-margin-top-medium">
                                        <div class="col-md-12 u-margin-top-medium">
                                            <input type="submit" value="Submit Personal Info" class="btn-submit">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>

</html>