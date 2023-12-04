<jsp:useBean id="usuarioLoja" scope="session" type="br.cefetmg.lagos.model.dto.loja.UsuarioLoja"
             class="br.cefetmg.lagos.model.dto.loja.UsuarioLoja" />

<div id="header-items">
    <div id="user-data">
    </div>

    <a href="${pageContext.request.contextPath}/servletweb?acao=Home" id="logo-div">
        <img src="${pageContext.request.contextPath}/images/lagos-semfundo.svg" alt="logo lagos" />
    </a>

    <div id="menu-button" onclick="toggleMenu()">
        <div></div>
        <div></div>
        <div></div>
    </div>
</div>

<div id="linha-header"></div>

<div id="menu">
    <div><a href="#"> _Link 1_ </a></div>
    <div><a href="#"> _Link 2_ </a></div>
    <div><a href="#"> _Link 3_ </a></div>
</div>