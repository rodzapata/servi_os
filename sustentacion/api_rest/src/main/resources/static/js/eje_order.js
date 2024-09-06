function createObjectOrden() {
    // Capturar los valores del formulario
    const id = document.getElementById('id').value;
    const customerId = document.getElementById('customerId').value;
    const equipmentId = document.getElementById('equipmentId').value;
    const date = new Date(document.getElementById('date').value).toISOString(); // Formato ISO
    const customerFullName = document.getElementById('customerFullName').value;
    const serialNumber = document.getElementById('serialNumber').value;
    const equipmentTypeName = document.getElementById('equipmentTypeName').value;
    const brandName = document.getElementById('brandName').value;
    const refrigerantName = document.getElementById('refrigerantName').value;

    // Capturar los detalles (aquí se asume que hay al menos un detalle)
    const detailElements = document.querySelectorAll('#details .detail');
    const details = Array.from(detailElements).map(detail => {
        return {
            id: parseInt(detail.querySelector('input[name="detailId"]').value),
            activityId: parseInt(detail.querySelector('input[name="activityId"]').value),
            description: detail.querySelector('input[name="description"]').value
        };
    });

    // Crear el objeto con los valores capturados
    const ordenDeServicio = {
        id: parseInt(id),
        customerId: parseInt(customerId),
        equipmentId: parseInt(equipmentId),
        date: date,
        customerFullName: customerFullName,
        serialNumber: serialNumber,
        equipmentTypeName: equipmentTypeName,
        brandName: brandName,
        refrigerantName: refrigerantName,
        details: details
    };

    // Mostrar el objeto en la consola (o hacer cualquier otra acción necesaria)
    console.log(ordenDeServicio);
    return ordenDeServicio;
}
