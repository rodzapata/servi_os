const sideMenu = document.querySelector("aside");
const menuBtn = document.querySelector("#menu-btn");
const closeBtn= document.querySelector("#close-btn");
const themetoggler= document.querySelector(".theme-toggler");


menuBtn.addEventListener('click',()=>{
    sideMenu.style.display='block';

})

closeBtn.addEventListener('click',()=>{
    sideMenu.style.display='none';
    
})

themetoggler.addEventListener('click',()=>{
    document.body.classList.toggle('dark-theme-variables');

    themetoggler.querySelector('span:nth-child(1)').classList.toggle('active');
    themetoggler.querySelector('span:nth-child(2)').classList.toggle('active');

})

function loadMenu(page) {
    fetch(page)
        .then(response => response.text())
        .then(data => {
            document.getElementById('main-content').innerHTML = data;
            loadRoles();
            loadUsuarios();
            loadCustomer();
            loadFormEvent();
        
        })
        .catch(error => console.error('Error al cargar la página:', error));
        
}


function loadContent(page,elemenId) {
    fetch(page)
        .then(response => response.text())
        .then(data => {
            document.getElementById(elemenId).innerHTML = data;
            // loadRoles();
            // loadUsuarios();
            // loadFormEvent();
        
        })
        .catch(error => console.error('Error al cargar la página:', error));

}

document.addEventListener("DOMContentLoaded", function() {
    // loadContent('user.html','main-content');
});


