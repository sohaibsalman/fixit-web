<%@ page import="com.fixit.fixer.*" %>

<% 
	CredentialInfo cdata = (CredentialInfo) request.getAttribute("fixer-credentials");
	PersonalInfo data = (PersonalInfo) request.getAttribute("fixer-personal");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="h-link.html"></jsp:include>
    <title>Sign Up</title>
</head>

<body>

    <form action="DBController" method="post">
        <input type="hidden" name="command" value="ADD-FIXER">
        <div class="container u-margin-top-huge">
            <div class="row">
                <!-- Hidden Credentials -->
                <div class="col-md-12">
                    <input type="hidden" name="email" value="<%= cdata.getEmail()%>">
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="username" value="<%= cdata.getUsername()%>">
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="password" value="<%= cdata.getPassword()%>">
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="firstName" value="<%= data.getFirstName()%>"> <br>
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="lastName" value="<%= data.getLastName()%>"> <br>
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="gender" value="<%= data.getGender()%>">
                </div>
                <div class="col-md-12">
                    <input type="hidden" name="phoneNumber" value="<%= data.getPhoneNumber()%>"> <br>
                </div>
                <div class="col-md-12">
                </div>
                <!-- Work Info -->
                <div class="col-md-12">
                    Service Catagory
                    <select name="serviceCategory">
                        <option value="Technician">Technician</option>
                        <option value="Non-Technician">Non-Technician</option>
                    </select>
                </div>
                <div class="col-md-12">
                    Service Name
                    <select name="serviceName" onchange="serviceCatogary(this)">
                        <option value="Mechanic">Mechanic</option>
                        <option value="Plumber">Plumber</option>
                        <option value="Electrician">Electrician</option>
                        <option value="Driver">Driver</option>
                    </select>
                </div>
                <div class="col-md-12">
                    <select name="city">
                        <option value="Lahore">Lahore</option>
                        <option value="Karachi">Karachi</option>
                        <option value="Islamabad">Islamabad</option>
                        <option value="Peshawar">Peshawar</option>
                        <option value="Queta">Queta</option>
                    </select>
                </div>
                <div class="col-md-12">
                    <select name="workArea">
                        <option value="Shadhara">Shadhara</option>
                        <option value="Mall Road">Mall Road</option>
                        <option value="Ichara">Ichara</option>
                        <option value="Canal">Canal</option>
                        <option value="Kalma Chownk">Kalma Chownk</option>
                        <option value="Model Town">Model Town</option>
                        <option value="Qainchi">Qainchi</option>
                        <option value="Ghazi Road">Ghazi Raod</option>
                        <option value="Chungi Amar Sadhu">Chungi Amar Sadhu</option>
                    </select>
                </div>
                <div class="col-md-12">
                    <input type="text" name="workAddress" placeholder="Shop Number">
                </div>
                <div class="col-md-12 u-margin-top-medium">
                    <div class="col-md-12 u-margin-top-medium">
                        <input type="submit" value="Submit Personal Info" class="btn-submit">
                    </div>
                </div>
            </div>
        </div>
    </form>

</body>

</html>