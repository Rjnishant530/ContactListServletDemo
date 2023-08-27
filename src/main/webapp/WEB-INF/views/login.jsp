<%@include file="header.jspf"%>
<h3> Existing Users login here</h3>
<form method="post">
    <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value="${param.email}">
        <div class="text-danger">${errors.email}</div>
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name="password">
        <div class="text-danger">${errors.password}</div>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>
<%@include file="footer.jspf"%>