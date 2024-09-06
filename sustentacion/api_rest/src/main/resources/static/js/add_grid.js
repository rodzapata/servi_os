// Obtener el botón para agregar nuevas líneas y el contenedor de detalles
const addLineaBtn = document.getElementById('add-linea-btn');
const detallesContainer = document.getElementById('detalles-container');

// Función para agregar una nueva línea de detalles
addLineaBtn.addEventListener('click', function() {
    // Crear un nuevo elemento div para la línea de detalles
    const newLinea = document.createElement('div');
    newLinea.classList.add('linea-detalle');
    
    // Crear el nuevo select de actividad
    const newSelect = document.createElement('select');
    newSelect.name = 'actividad';
    newSelect.required = true;
    
    // Crear las opciones del select
    const options = [
        { value: '1', text: 'Reparación' },
        { value: '2', text: 'Mantenimiento' },
        { value: '3', text: 'Instalación' },
        { value: '4', text: 'Inspección' }
    ];
    
    options.forEach(optionData => {
        const option = document.createElement('option');
        option.value = optionData.value;
        option.text = optionData.text;
        newSelect.appendChild(option);
    });
    
    // Crear el input de descripción de actividad
    const newInput = document.createElement('input');
    newInput.type = 'text';
    newInput.name = 'descripcionActividad';
    newInput.placeholder = 'Descripción de la actividad';
    newInput.required = true;
    
    // Crear el botón para eliminar la línea
    const removeButton = document.createElement('button');
    removeButton.type = 'button';
    removeButton.classList.add('remove-linea');
    removeButton.textContent = 'Eliminar';
    
    // Evento para eliminar la línea cuando se haga clic en el botón "Eliminar"
    removeButton.addEventListener('click', function() {
        detallesContainer.removeChild(newLinea);
    });

    // Añadir el select, el input y el botón al nuevo div
    newLinea.appendChild(newSelect);
    newLinea.appendChild(newInput);
    newLinea.appendChild(removeButton);
    
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
