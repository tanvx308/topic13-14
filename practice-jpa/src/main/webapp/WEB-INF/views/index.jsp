<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
  	<div class="container">
  		<div class="col-6 offset-3 mt-5">
	  		<form action="/account/add" method="post">
			  <div class="mb-3">
			    <label class="form-label">Account Name</label>
			    <input type="text" class="form-control" name="accountName">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">Account Number</label>
			    <input type="text" class="form-control" name="accountNumber">
			  </div>
			  <input type="submit" class="btn btn-primary" value="Submit"></input>
			</form>
  		</div>
  		<div class="col-10 offset-1 mt-5">
  		<table class="table">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">AccountNumber</th>
      <th scope="col">AccountName</th>
      <th scope="col">Balance</th>
       <th scope="col">Status</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach items="${account }" var="item">
    <tr>
      <th scope="row">${item.id }</th>
      <td>${item.accountNumber}</td>
      <td>${item.accountName }</td>
      <td>${item.balance }</td>
       <td>${item.status }</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
  		</div>
  	</div>	
  </body>
</html>