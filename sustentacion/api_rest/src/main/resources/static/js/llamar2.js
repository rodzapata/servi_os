const xhr = new XMLHttpRequest();
xhr.open('GET', 'http://localhost:8080/service-order', true);
xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
        const response = JSON.parse(xhr.responseText); // Parseamos la respuesta JSON
        procesarObjeto(response); // Llamamos a la función para procesar el objeto
    }
};
xhr.send();

function procesarObjeto(data) {
    // Accedemos a las propiedades principales del objeto
    data.forEach(item => {
        console.log("ID:", item.id);
        console.log("Customer ID:", item.customerId);
        console.log("Equipment ID:", item.equipmentId);
        console.log("Date:", item.date);
        console.log("Customer Full Name:", item.customerFullName);
        console.log("Serial Number:", item.serialNumber);
        console.log("Equipment Type Name:", item.equipmentTypeName);
        console.log("Brand Name:", item.brandName);
        console.log("Refrigerant Name:", item.refrigerantName);
    
        // Recorrer el array 'details' dentro de cada objeto
        item.details.forEach(detail => {
            console.log("  Detail ID:", detail.id);
            console.log("  Activity ID:", detail.activityId);
            console.log("  Description:", detail.description);
        });
    
        console.log('------------------------'); // Separador entre objetos
    });
    

}
