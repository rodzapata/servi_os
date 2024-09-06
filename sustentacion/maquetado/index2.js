// Evento para manejar el envío del formulario de inicio de sesión
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    // Aquí harías la llamada al backend con fetch para validar las credenciales
    // Ejemplo:
    fetch('http://localhost:8080/api/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ email, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data === true) {
            document.getElementById('loginMessage').textContent = 'Inicio de sesión exitoso!';
            // Redirigir a otra página o realizar otras acciones
        } else {
            document.getElementById('loginMessage').textContent = 'Credenciales incorrectas. Inténtalo de nuevo.';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('loginMessage').textContent = 'Hubo un error al intentar iniciar sesión.';
    });
});
