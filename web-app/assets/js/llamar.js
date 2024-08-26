// URL de la API REST
const apiUrl = "http://localhost:8080/service-order";

// Función para obtener los datos del servicio
async function fetchServiceOrder() {
  try {
    // Realiza una solicitud GET a la API
    const response = await fetch(apiUrl);

    // Verifica si la solicitud fue exitosa
    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    // Convierte la respuesta a formato JSON
    const data = await response.json();

    const jsonArray = JSON.stringify(data);
    console.log(jsonArray);
    console.log("Nombre Completo del Cliente:", data[0].customerFullName);
    console.log("Nombre Completo del Cliente:", data[0].details[0].description);

    // Imprime el objeto recibido en la consola
    console.log(data);
    console.log(data[0].brandName);



    // Ejemplo de acceso a los datos del objeto JSON
    console.log("ID del Servicio:", data.id);
    console.log("Nombre Completo del Cliente:", data.customerFullName);
    console.log("Tipo de Equipo:", data.equipmentTypeName);
    console.log("Marca del Equipo:", data.brandName);
    console.log("Detalles:");

    // Iterar sobre los detalles y mostrar la información
    data.details.forEach((detail) => {
      console.log(`  ID del Detalle: ${detail.id}`);
      console.log(`  ID de la Actividad: ${detail.activityId}`);
      console.log(`  Descripción: ${detail.description}`);
    });

  } catch (error) {
    // Manejo de errores
    console.error("Error al obtener el servicio:", error);
  }
}

// Llamar a la función para obtener los datos
fetchServiceOrder();
