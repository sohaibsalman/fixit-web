<!DOCTYPE html>
<html lang="en">

<head>

    <title>Sign in</title>
</head>

<body>

    <form action="DBController" method="post">
        <input type="hidden" name="command" value="LOGIN-FIXER">
        <label for="username">Username</label>
        <input type="text" name="username" placeholder="Username">
        <label for="password">Password</label>
        <input type="password" name="password" placeholder="Password">
        <input type="submit" value="Sign in">
    </form>


</body>

</html>