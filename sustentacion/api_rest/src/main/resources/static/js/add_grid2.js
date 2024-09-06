// Obtener el botón para agregar nuevas líneas y el contenedor de detalles
const addLineaBtn = document.getElementById('add-linea-btn');
const detallesContainer = document.getElementById('detalles-container');

// Función para agregar una nueva línea de detalles
addLineaBtn.addEventListener('click', function() {
    // Clonar el div con la clase "linea-detalle"
    const originalLinea = document.querySelector('.linea-detalle');
    const newLinea = originalLinea.cloneNode(true);
    
    // Añadir el evento al botón "Eliminar" de la nueva línea
    const removeButton = newLinea.querySelector('.remove-linea');
    removeButton.addEventListener('click', function() {
        detallesContainer.removeChild(newLinea);
    });
    
    // Agregar la nueva línea al contenedor de detalles
    detallesContainer.appendChild(newLinea);
});

// Evento para eliminar la primera línea cuando se haga clic en el botón "Eliminar"
document.querySelectorAll('.remove-linea').forEach(button => {
    button.addEventListener('click', function() {
        const parentDiv = button.parentElement;
        detallesContainer.removeChild(parentDiv);
    });
});
