$(document).ready(function() {
   // on ready
});


async function iniciarSesion() {
  document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Evita que el formulario se envíe de manera tradicional

    // Obtiene los valores de los campos de email y contraseña
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Crea el objeto JSON para enviar
    const loginData = {
        email: email,
        password: password
    };

    // Configura la solicitud POST
    fetch('http://localhost:8080/user/validar-credenciales', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
    })
    .then(response => response.json())
    .then(data => {
        // Maneja la respuesta del servidor
        if (data) {
            document.getElementById('loginMessage').textContent = 'Inicio de sesión exitoso!';
            // Redireccionar a otra página o realizar otras acciones
            window.location.href = 'menu.html'
        } else {
            alert( 'Credenciales incorrectas. Inténtalo de nuevo.');
            // document.getElementById('loginMessage').textContent = 'Credenciales incorrectas. Inténtalo de nuevo.';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('loginMessage').textContent = 'Hubo un error al intentar iniciar sesión.';
        alert('Hubo un error al intentar iniciar sesión.');
    });
});

}
