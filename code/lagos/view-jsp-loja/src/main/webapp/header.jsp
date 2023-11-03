<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <link rel="stylesheet" type="text/css" href="css/header.css" />
    <title></title>
</head>
<body>
    
    <header>
        
        <div class="logo"><img src="images/lagos-semfundo.svg" alt="logo lagos" id="logo"></div>
        
        <div class="menu-button" onclick="toggleMenu()">
            <div class="menu-icon"></div>
            <div class="menu-icon"></div>
            <div class="menu-icon"></div>
        </div>
        
    </header>
    
    <div class="linha"></div>
    
    <div class="menu" id="menu">
        <div class="menu-item"><a href="#">   _Link 1_   </a></div>
        <div class="menu-item"><a href="#">   _Link 2_   </a></div>
        <div class="menu-item"><a href="#">   _Link 3_   </a></div>
    </div>
    
    <script>
        
        const menu = document.getElementById("menu");
        menu.style.display = 'none';
        
        function toggleMenu() {

            menu.style.display = 'flex';
            menu.classList.add("inactive");

            if (menu.classList.contains('active')) {
                menu.classList.remove("active");
                menu.classList.add("inactive");

            }
            else{
                menu.classList.remove("inactive");
                menu.classList.add("active");
            }
        }
    </script>
    
</body>
</html>