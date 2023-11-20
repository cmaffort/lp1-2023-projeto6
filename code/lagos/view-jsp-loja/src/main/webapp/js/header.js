const menu = document.getElementById("menu");
menu.style.display = 'none';

function toggleMenu() {

    menu.style.display = 'flex';
    menu.classList.add("inactive");

    if (menu.classList.contains('active')) {
        menu.classList.remove("active");
        menu.classList.add("inactive");

    } else {
        menu.classList.remove("inactive");
        menu.classList.add("active");
    }
}
