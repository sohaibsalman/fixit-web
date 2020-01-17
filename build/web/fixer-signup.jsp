<!DOCTYPE html>
<html lang="en">

<head>

    <jsp:include page="h-link.html"></jsp:include>

    <title>Sign up</title>

</head>

<body>



    <header class="signup-header">
        <div class="container-fluid" style="padding: 0;">
            <div class="row no-gutters">
                <div class="col-md-6">
                    <div class="signup__img">
                        <img src="img/signup/1.png" alt="" class="img-fluid">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="signup__form">
                        <div class="form--center">
                            <h1 class="heading-main">FIXIT</h1>
                            <h5 class="u-margin-top-small">Signup as a Fixer</h5>
                            <form action="Signup" method="post">
                                <input type="hidden" name="command" value="FIXER-CREDENTIALS">
                                <div class="container u-margin-top-huge">
                                    <div class="row">
                                        <div class="col-md-12">
                                            <input type="text" name="username" placeholder="Username" required>
                                        </div>
                                        <div class="col-md-12">
                                            <input type="email" name="email" placeholder="Email" required>
                                        </div>
                                        <div class="col-md-12">
                                            <input type="password" name="password" placeholder="Password" required>
                                        </div>
                                        <div class="col-md-12 u-margin-top-medium">
                                            <input type="submit" value="Create Your Account" class="btn-submit">
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>

</body>

</html>