<%@ include file="header.jspf" %>

<form method="post">
    <div class="mb-3">
        <label for="name" class="form-label">Name</label>
        <input type="text" class="form-control" id="name" name="name">
        <div class="text-danger">${errors.name}</div>
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
        <div class="text-danger">${errors.email}</div>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
        <div class="text-danger">${errors.password}</div>
    </div>
    <div class="mb-3">
        <label for="c_password" class="form-label">Confirm Password</label>
        <input type="password" class="form-control" id="c_password" name="c_password">
        <div class="text-danger">${errors.cpassword}</div>
    </div>
    <button type="submit" class="btn btn-primary">Register</button>
    <input type="reset" class="btn btn-link" value="reset"/>

</form>

<%@ include file="footer.jspf" %>