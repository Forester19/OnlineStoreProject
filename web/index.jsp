<!DOCTYPE html>
<html>
<head>
  <title>MainPage</title>
  <meta charset="utf-8">
  <link href="css/loginForm.css" rel="stylesheet" type="text/css" />
  <link href="css/header.css" rel="stylesheet" type="text/css" />
  <link href="css/font-awesome.css" rel="stylesheet" type="text/css" />
  <link href="css/main.css" rel="stylesheet" type="text/css" />
  </head>
<body>

<div class="header">
  <div class="headerText"><h2>Online Store Project</h2>
   </div>
 </div>

<div class="main">

</div>
<div class="containerLogin">
  <img src="img/1449146235_youloveit_ru_multfilm_2016_ballerina010.jpg">
  <a><h1>Log In</h1></a>
  <form action="loginForm" method="get">
    <input type="hidden" name="LOGIN_FORM" value="LOGIN_FORM">
    <div class="dws-input">
    <input type="text" name="login" placeholder="your login">
  </div>
  <div class="dws-input">
    <input type="password" name="password" placeholder="your password">
  </div>
    <br/>
    <input class= "dws_submit" type="submit" name="submit" value="LogIn">
    <br/>
    <a href="#">Forgot password?</a>
    <br/>
    <a href="#sign_in"><h3>Sing In</h3></a>

  </form>
 
</div>


<div class="containerLogin">
  <img src="img/fde2503131f76a398589941775680ada.jpg">
  <a><h1>Sign In</h1></a>
  <a name="sign_in"></a>
  <form>
    <div class="dws-input">
      <input type="text" name="login" placeholder="your login">
    </div>
    <div class="dws-input">
      <input type="password" name="password" placeholder="your password">
    </div>
    <div class="dws-input">
      <input type="email" name="email" placeholder="your email">
    </div>
    <br/>
    <input class= "dws_submit" type="submit" name="submit" value="Sign In">
    <br/>

  </form>

</div>

</body>
</html>