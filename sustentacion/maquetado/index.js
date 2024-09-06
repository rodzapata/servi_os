// Función para mostrar el formulario de inicio de sesión o de registro
function showForm(formType) {
    const loginForm = document.getElementById('loginForm');
    const registerForm = document.getElementById('registerForm');
    const loginTab = document.querySelector('.tab-btn:nth-child(1)');
    const registerTab = document.querySelector('.tab-btn:nth-child(2)');

    if (formType === 'login') {
        loginForm.classList.add('active');
        registerForm.classList.remove('active');
        loginTab.classList.add('active');
        registerTab.classList.remove('active');
    } else {
        registerForm.classList.add('active');
        loginForm.classList.remove('active');
        registerTab.classList.add('active');
        loginTab.classList.remove('active');
    }
}

// Evento para manejar el envío del formulario de inicio de sesión
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

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

// Evento para manejar el envío del formulario de registro
document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('registerUsername').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPassword').value;

    // Aquí harías la llamada al backend con fetch para registrar al usuario
    // Ejemplo:
    fetch('http://localhost:8080/api/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ username, email, password })
    })
    .then(response => response.json())
    .then(data => {
        if (data === true) {
            document.getElementById('registerMessage').textContent = 'Registro exitoso!';
            // Redirigir a otra página o realizar otras acciones
        } else {
            document.getElementById('registerMessage').textContent = 'Error al registrar. Inténtalo de nuevo.';
        }
    })
    .catch(error => {
        console.error('Error:', error);
        document.getElementById('registerMessage').textContent = 'Hubo un error al intentar registrar.';
    });
});
