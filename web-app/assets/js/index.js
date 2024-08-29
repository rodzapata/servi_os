$(function () {
    $("#resetData").click(function () {
        $(".error-input").removeClass("error-input");
        $("#userId").val("");
    });

    $("#resetData2").click(function () {
        $(".error-input").removeClass("error-input");
        $("#customerId").val("");
    });

    // loadZoneTemplate("header");
    // loadZoneTemplate("footer");

    loadRoles();
    loadUsuarios();
    loadCustomers();
    loadFormEvent();

});

window.onload = function() {
    alert("¡La página se ha cargado completamente!");
    console.log("La página se ha cargado correctamente.");
};

function loadFormEvent() {

    console.log("loadFormEvent");

    $("#frm1").on("submit", function (e) {
        e.preventDefault();

        $(".error-input").removeClass("error-input");

        if ($("#nombres").val() === "") {
            $("#nombres").addClass("error-input");
        }

        if ($("#fechaNacimiento").val() === "") {
            $("#fechaNacimiento").addClass("error-input");
        }

        // if ($("#color").val() === "") {
        //     $("#color").addClass("error-input");
        // }

        if ($("#correo").val() === "") {
            $("#correo").addClass("error-input");
        }

        if ($("#telefono").val() === "") {
            $("#telefono").addClass("error-input");
        }

        if ($("#avatar").val() === "") {
            $("#avatar").addClass("error-input");
        }

        if ($("#rol").val() === "") {
            $("#rol").addClass("error-input");
        }

        if ($(".error-input").length > 0) {
            alert("Verifique los datos ingresados");
            return;
        }

        var objUsuario = {
            "fullName": $("#nombres").val(),
            "bornDate": $("#fechaNacimiento").val(),
            // "color": $("#color").val(),
            "email": $("#correo").val(),
            "phone": $("#telefono").val(),
            "avatar": "foto.png",
            "rolId": $("#rol").val()
        };

        if ($("#userId").val() === "") {
            console.log("Creando nuevo usuario " + JSON.stringify(objUsuario));
            createUsuario(objUsuario);
        } else {
            var userId = $("#userId").val();
            console.log("Editando usuario " + userId + " :: " + JSON.stringify(objUsuario));
            editUsuario(userId, objUsuario);
        }

    });

    //formulario 2 Customer
    $("#frmCustomer").on("submit", function (e) {
        e.preventDefault();
        alert('boton aceptar en Customer');
        $(".error-input").removeClass("error-input");

        if ($("#nombres").val() === "") {
            $("#nombres").addClass("error-input");
        }

        if ($("#fechaNacimiento").val() === "") {
            $("#fechaNacimiento").addClass("error-input");
        }

        // if ($("#color").val() === "") {
        //     $("#color").addClass("error-input");
        // }

        if ($("#correo").val() === "") {
            $("#correo").addClass("error-input");
        }

        if ($("#telefono").val() === "") {
            $("#telefono").addClass("error-input");
        }

        // if ($("#avatar").val() === "") {
        //     $("#avatar").addClass("error-input");
        // }

        // if ($("#rol").val() === "") {
        //     $("#rol").addClass("error-input");
        // }

        if ($(".error-input").length > 0) {
            alert("Verifique los datos ingresados");
            return;
        }

        var objCustomer = {
            "fullName": $("#nombres").val(),
            "bornDate": $("#fechaNacimiento").val(),
            // "color": $("#color").val(),
            "email": $("#correo").val(),
            "phone": $("#telefono").val(),
            "avatar": "foto.png"
            // "rolId": $("#rol").val()
        };

        if ($("#customerId").val() === "") {
            console.log("Creando nuevo Customer " + JSON.stringify(objCustomer));
            createCustomer(objCustomer);
        } else {
            var customerId = $("#customerId").val();
            console.log("Editando Customer " + customerId + " :: " + JSON.stringify(objCustomer));
            editCustomer(customerId, objCustomer);
        }

    });

    //formulario 3 Equipo
    $("#frmEquipo").on("submit", function (e) {
        e.preventDefault();
        alert('boton aceptar en Equipment');
        $(".error-input").removeClass("error-input");

        if ($("#nombres").val() === "") {
            $("#nombres").addClass("error-input");
        }

        if ($("#fechaNacimiento").val() === "") {
            $("#fechaNacimiento").addClass("error-input");
        }

        // if ($("#color").val() === "") {
        //     $("#color").addClass("error-input");
        // }

        if ($("#correo").val() === "") {
            $("#correo").addClass("error-input");
        }

        if ($("#telefono").val() === "") {
            $("#telefono").addClass("error-input");
        }

        // if ($("#avatar").val() === "") {
        //     $("#avatar").addClass("error-input");
        // }

        // if ($("#rol").val() === "") {
        //     $("#rol").addClass("error-input");
        // }

        if ($(".error-input").length > 0) {
            alert("Verifique los datos ingresados");
            return;
        }


        var objEquipment = {
            "serialNumber": $("#serial").val(),
            "installationDate": $("#fechaInstalacion").val(),
            "lastMaintenanceDate": $("#fechaUltimoMantenimiento").val(),
            "customerId": $("#cmbcliente").val(),
            "equipmentTypeId":$("#cmbtipoEquipo").val(),
            "brandId": $("#cmbMarca").val(),
            "refrigerantId": $("#cmbRefrigerante").val()
        };

        if ($("#equipmentId").val() === "") {
            console.log("Creando nuevo Equipo " + JSON.stringify(objEquipment));
            createEquipment(objEquipment);
        } else {
            var equipmentId = $("#equipmentId").val();
            console.log("Editando Equipo " + equipmentId + " :: " + JSON.stringify(objEquipment));
            editEquipment(equipmentId, objEquipment);
        }

    });

// ====== ORDEN DE SERVICIOS ===============

$("#frmServiceOrder").on("submit", function (e) {
    e.preventDefault();
    alert('boton aceptar Orden de servicios');
    $(".error-input").removeClass("error-input");

    if ($("#cmbcliente").val() === "") {
        $("#cmbcliente").addClass("error-input");
    }

    if ($("#fechaInstalacion").val() === "") {
        $("#fechaInstalacion").addClass("error-input");
    }

    if ($("#correo").val() === "") {
        $("#correo").addClass("error-input");
    }

    if ($("#telefono").val() === "") {
        $("#telefono").addClass("error-input");
    }

    // if ($("#avatar").val() === "") {
    //     $("#avatar").addClass("error-input");
    // }

    // if ($("#rol").val() === "") {
    //     $("#rol").addClass("error-input");
    // }

    if ($(".error-input").length > 0) {
        alert("Verifique los datos ingresados");
        return;
    }


    var objServiceOrder = createObjectOrden();
    console.log(objServiceOrder);
    

    console.log("Creando nuevo Orden de servicio " + JSON.stringify(objServiceOrder));
    createServiceOrder(objServiceOrder);

    // if ($("#serviceOrderId").val() === "") {
    //     console.log("Creando nuevo Orden de servicio " + JSON.stringify(objServiceOrder));
    //     createServiceOrder(objServiceOrder);
    // } else {
    //     var serviceOrderId = $("#serviceOrderId").val();
    //     console.log("Editando Oden de Servicio " + serviceOrderId + " :: " + JSON.stringify(objServiceOrder));
    //     editServiceOrder(serviceOrderId, objServiceOrder);
    // }

});


// ===== FIN ORDEN DE SERVICIO ============

    // ==== formulario Ordenes de servicio ===
    // ===== agregar linea en el formulario de ordenes de servicio ========

    document.querySelector('.add-linea').addEventListener('click', function() {
        alert("boton adicionar linea ");
        const detallesContainer = document.getElementById('detalles-container');
        const nuevaLinea = document.createElement('div');
        nuevaLinea.className = 'linea-detalle';
        nuevaLinea.innerHTML = `
            <select name="actividad" required>
                <option value="1">Reparación</option>
                <option value="2">Mantenimiento</option>
                <option value="3">Instalación</option>
                <option value="4">Inspección</option>
            </select>
            <input type="text" name="descripcionActividad" placeholder="Descripción de la actividad" required>
            <button type="button" class="remove-linea">Eliminar</button>
            `;
        detallesContainer.appendChild(nuevaLinea);

    
        // Añadir el evento para eliminar la línea
        nuevaLinea.querySelector('.remove-linea').addEventListener('click', function() {
            nuevaLinea.remove();
        });
    });

    // Añadir el evento para eliminar la línea inicial
    document.querySelector('.remove-linea').addEventListener('click', function() {
        this.parentElement.remove();
    });

    function createObjectOrden() {
        // Capturar los valores del formulario
       // const id = document.getElementById('id').value;
        const customerId = document.getElementById('cmbcliente').value;
        const equipmentId = document.getElementById('cmbEquipo').value;
        const date = new Date(document.getElementById('fechaInstalacion').value).toISOString(); // Formato ISO
    
        // Capturar los detalles (aquí se asume que hay al menos un detalle)
        const detailElements = document.querySelectorAll('#detalles-container .linea-detalle');
        const details = Array.from(detailElements).map(detail => {
            return {
                // const actividadSelect = document.querySelector('select[name="actividad"]');
                // const valorSeleccionado = actividadSelect.value;

                // id: parseInt(detail.querySelector('input[name="detailId"]').value),
                // activityId: parseInt(detail.querySelector('select[name="actividad[]"]').value),
                activityId: parseInt(detail.querySelector('select[name="actividad"]').value),
                description: detail.querySelector('input[name="descripcionActividad"]').value
            };
        });
    
    
        // Crear el objeto con los valores capturados
        const ordenDeServicio = {
            // id: parseInt(id),
            customerId: parseInt(customerId),
            equipmentId: parseInt(equipmentId),
            date: date,
            details: details
        };
    
        // Mostrar el objeto en la consola (o hacer cualquier otra acción necesaria)
        console.log(ordenDeServicio);
        return ordenDeServicio;
    }

   

}

// Función para actualizar los Equpos según el cliente seleccionado seleccionado
function actualizarEquipos() {
    //alert("update equipo");
    var id=$("#cmbcliente").val();
    var url = "http://localhost:8080/equipment/findByCustomerId/"+id;
    //callApi(url, "GET", null, listEquipoCliente);

    const clienteSeleccionado = document.getElementById('cmbcliente').value;

    if (clienteSeleccionado) {
        // Realizar la solicitud AJAX para obtener los equipos del cliente seleccionado
        const xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                const equipos = JSON.parse(xhr.responseText);
                let html = "";
                equipos.forEach(equipo => {
                    html += "<option value='" + equipo.id + "'>" + equipo.serialNumber+' - '+equipo.equipmentTypeName + "</option>";
                });
                $("#cmbEquipoCliente").html(html);

            } else {
                console.error('Error al cargar los países');
            }
        };
        xhr.send();
    }

            
}


// ==== USER =========
function viewUser(id) {
    var url = "http://localhost:8080/user/" + id;
    callApi(url, "GET", null, renderUser);
}

function deleteUser(id) {
    var url = "http://localhost:8080/user/" + id;
    callApi(url, "DELETE", null, function () {
        alert("Registro eliminado con exito!");
        loadUsuarios();
    })
}

function editUsuario(id, data) {
    var url = "http://localhost:8080/user/" + id;

    callApi(url, "PUT", data, function () {
        alert("Registro actualizado");
        $("#resetData").click();
        loadUsuarios();
    });

}

function createUsuario(data) {
    var url = "http://localhost:8080/user";

    callApi(url, "POST", data, function () {
        alert("Registro creado");
        $("#resetData").click();
        loadUsuarios();
    });
}

function renderUser(result) {
    var data = result.data;

    var birthDayUser = new Date(data.bornDate);
    var day = ("0" + birthDayUser.getDate()).slice(-2);
    var month = ("0" + (birthDayUser.getMonth() + 1)).slice(-2);
    var today = birthDayUser.getFullYear() + "-" + (month) + "-" + (day);

    $("#userId").val(data.id);
    $("#nombres").val(data.fullName);
    $("#fechaNacimiento").val(today);
    // $("#color").val(data.color);
    $("#correo").val(data.email);
    $("#telefono").val(data.phone);
    $("#rol").val(data.rolId);
}

function renderUsers(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var user = result.data[i];
        html += "<tr>";
        html += "<th scope='row'>" + (i + 1) + "</th>"
        html += "<td>" + user.id + "</td>"
        html += "<td>" + user.fullName + "</td>"
        html += "<td>" + user.bornDate + "</td>"
        html += "<td>" + 0 + "</td>"
        html += "<td>"
        // html += "<div class='userColor' style='background-color:" + user.color + "'></div>"
        // html += "<label class='detail-color'>" + user.color + "</label>"
        html += "</td>"
        html += "<td>" + user.email + "</td>"
        html += "<td>" + user.phone + "</td>"
        html += "<td>"
        html += "<img src='http://localhost/imagenes/not-found.png' class='avatar' width='50px' height='50px'>"
        html += "</td>"
        html += "<td>" + user.rolName + "</td>"
        html += "<td>"
        html += "<div data-id='" + user.id + "' class='eliminar'>Eliminar</div>"
        html += "<div data-id='" + user.id + "' class='editar'>Editar</div>"
        html += "</td>"
        html += "</tr>"
    }
    $("#bodyListUsers").html(html);
    $(".eliminar").click(function () {
        if (confirm("Desea eliminar el registro?")) {
            var id = $(this).data('id');
            deleteUser(id);
        }
    });
    $(".editar").click(function () {
        if (confirm("Desea editar el registro?")) {
            var id = $(this).data('id');
            viewUser(id);
        }
    });
}

function loadUsuarios() {
    var url = "http://localhost:8080/user";
    callApi(url, "GET", null, renderUsers);
}


// ==== CUSTOMER ===========
function viewCustomer(id) {
    var url = "http://localhost:8080/customer/" + id;
    callApi(url, "GET", null, renderCustomer);
}

function deleteCustomer(id) {
    var url = "http://localhost:8080/customer/" + id;
    callApi(url, "DELETE", null, function () {
        alert("Registro eliminado con exito!");
        loadCustomers();
    })
}

function editCustomer(id, data) {
    var url = "http://localhost:8080/customer/" + id;

    callApi(url, "PUT", data, function () {
        alert("Registro actualizado");
        $("#resetData2").click();
        loadCustomers();
    });

}

function createCustomer(data) {
    var url = "http://localhost:8080/customer";

    callApi(url, "POST", data, function () {
        alert("Registro creado");
        $("#resetData2").click();
        loadCustomers();
    });
}

function renderCustomer(result) {
    var data = result.data;

    var birthDayUser = new Date(data.bornDate);
    var day = ("0" + birthDayUser.getDate()).slice(-2);
    var month = ("0" + (birthDayUser.getMonth() + 1)).slice(-2);
    var today = birthDayUser.getFullYear() + "-" + (month) + "-" + (day);

    $("#customerId").val(data.id);
    $("#nombres").val(data.fullName);
    $("#fechaNacimiento").val(today);
    // $("#color").val(data.color);
    $("#correo").val(data.email);
    $("#telefono").val(data.phone);
    $("#rol").val(data.rolId);
}

function renderCustomers(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var customer = result.data[i];
        html += "<tr>";
        html += "<th scope='row'>" + (i + 1) + "</th>"
        html += "<td>" + customer.id + "</td>"
        html += "<td>" + customer.fullName + "</td>"
        html += "<td>" + customer.bornDate + "</td>"
        html += "<td>" + 0 + "</td>"
        html += "<td>"
        // html += "<div class='userColor' style='background-color:" + user.color + "'></div>"
        // html += "<label class='detail-color'>" + user.color + "</label>"
        html += "</td>"
        html += "<td>" + customer.email + "</td>"
        html += "<td>" + customer.phone + "</td>"
        html += "<td>"
        // html += "<img src='http://localhost/imagenes/not-found.png' class='avatar' width='50px' height='50px'>"
        html += "</td>"
        // html += "<td>" + user.rolName + "</td>"
        html += "<td>"
        html += "<div data-id='" + customer.id + "' class='eliminar'>Eliminar</div>"
        html += "<div data-id='" + customer.id + "' class='editar'>Editar</div>"
        html += "</td>"
        html += "</tr>"
    }
    $("#bodyListCustomers").html(html);
    $(".eliminar").click(function () {
        if (confirm("Desea eliminar el registro?")) {
            var id = $(this).data('id');
            deleteCustomer(id);
        }
    });
    $(".editar").click(function () {
        if (confirm("Desea editar el registro?")) {
            var id = $(this).data('id');
            viewCustomer(id);
        }
    });
}

function loadCustomers() {
    var url = "http://localhost:8080/customer";
    callApi(url, "GET", null, renderCustomers);
}



// ===== LOAD COMBOS =======
function cmbTipoMantenimiento() {
    var url = "http://localhost:8080/maintenance-type";
    callApi(url, "GET", null, listTipoMantenimiento);
}
function listTipoMantenimiento(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.maintenanceTypeName + "</option>";
    }
    $("#cmbTipoMantenimiento").html(html);
}

function loadRoles() {
    var url = "http://localhost:8080/rol";
    callApi(url, "GET", null, renderRoles);
}


function renderRoles(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.name + "</option>";
    }
    $("#rol").html(html);
}

function cmbCustomers() {
    var url = "http://localhost:8080/customer";
    callApi(url, "GET", null, litsCustomers);
}
function litsCustomers(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.fullName + "</option>";
    }
    $("#cmbcliente").html(html);
}

function cmbTipoEquipo() {
    var url = "http://localhost:8080/equipment-type";
    callApi(url, "GET", null, listTipoEquipo);
}
function listTipoEquipo(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.equipmentTypeName + "</option>";
    }
    $("#cmbtipoEquipo").html(html);
}

function cmbMarca() {
    var url = "http://localhost:8080/brand";
    callApi(url, "GET", null, listMarca);
}
function listMarca(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.brandName + "</option>";
    }
    $("#cmbMarca").html(html);
}
function cmbEquipo() {
    var url = "http://localhost:8080/equipment";
    callApi(url, "GET", null, listEquipo);
}
function listEquipo(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.serialNumber+' - '+opcion.equipmentTypeName + "</option>";
    }
    $("#cmbEquipo").html(html);
}
function listEquipoCliente(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.serialNumber+' - '+opcion.equipmentTypeName + "</option>";
    }
    $("#cmbEquipoCliente").html(html);
}
function cmbRefrigerante() {
    var url = "http://localhost:8080/refrigerant";
    callApi(url, "GET", null, listRefrigerante);
}
function listRefrigerante(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.refrigerantName + "</option>";
    }
    $("#cmbRefrigerante").html(html);
}

// ==== EQUIPMENTS (EQUIPOS) ===========
function viewEquipment(id) {
    var url = "http://localhost:8080/equipment/" + id;
    callApi(url, "GET", null, renderEquipment);
}

function deleteEqluipment(id) {
    var url = "http://localhost:8080/equipment/" + id;
    callApi(url, "DELETE", null, function () {
        alert("Registro eliminado con exito!");
        loadEquipments();
    })
}

function editEquipment(id, data) {
    var url = "http://localhost:8080/equipment/" + id;

    callApi(url, "PUT", data, function () {
        alert("Registro actualizado");
        $("#resetData3").click();
        loadEquipments();
    });

}

function createEquipment(data) {
    var url = "http://localhost:8080/equipment";

    callApi(url, "POST", data, function () {
        alert("Registro creado");
        $("#resetData3").click();
        loadEquipments();
    });
}

function renderEquipment(result) {
    var data = result.data;

    var birthDayUser = new Date(data.installationDate);
    var day = ("0" + birthDayUser.getDate()).slice(-2);
    var month = ("0" + (birthDayUser.getMonth() + 1)).slice(-2);
    var today = birthDayUser.getFullYear() + "-" + (month) + "-" + (day);

    var birthDayUser2 = new Date(data.lastMaintenanceDate);
    var day2 = ("0" + birthDayUser2.getDate()).slice(-2);
    var month2 = ("0" + (birthDayUser2.getMonth() + 1)).slice(-2);
    var today2 = birthDayUser2.getFullYear() + "-" + (month2) + "-" + (day2);
    alert(today2);

    $("#equipmentId").val(data.id);
    $("#serial").val(data.serialNumber);
    $("#fechaInstalacion").val(today);
    $("#fechaUltimoMantenimiento").val(today2);
    $("#cmbcliente").val(data.customerId);
    $("#cmbtipoEquipo").val(data.equipmentTypeId);
    $("#cmbMarca").val(data.brandId);
    $("#cmbRefrigerante").val(data.refrigerantId);

}

function renderEquipments(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var equipment = result.data[i];
        html += "<tr>";
        html += "<th scope='row'>" + (i + 1) + "</th>"
        html += "<td>" + equipment.id + "</td>"
        html += "<td>" + equipment.serialNumber + "</td>"
        html += "<td>" + equipment.customerFullName + "</td>"
        html += "<td>" + equipment.customerPhone + "</td>"
        html += "<td>" + equipment.equipmentTypeName + "</td>"
        html += "<td>" + equipment.brandName + "</td>"
        html += "<td>" + equipment.refrigerantName + "</td>"

        html += "<td>"
        html += "<div data-id='" + equipment.id + "' class='eliminar'>Eliminar</div>"
        html += "<div data-id='" + equipment.id + "' class='editar'>Editar</div>"
        html += "</td>"
        html += "</tr>"
    }
    $("#bodyListEquipos").html(html);
    $(".eliminar").click(function () {
        if (confirm("Desea eliminar el registro?")) {
            var id = $(this).data('id');
            deleteEquipment(id);
        }
    });
    $(".editar").click(function () {
        if (confirm("Desea editar el Equipo registro?")) {
            var id = $(this).data('id');
            viewEquipment(id);
        }
    });
}

function loadEquipments() {
    var url = "http://localhost:8080/equipment";
    callApi(url, "GET", null, renderEquipments);
}

// ===== ORDNES DE SERVICIO ====

function viewServiceOrder(id) {
    var url = "http://localhost:8080/service-order/" + id;
    callApi(url, "GET", null, renderServiceOrder);
}

function deleteServiceOrder(id) {
    var url = "http://localhost:8080/service-order/" + id;
    callApi(url, "DELETE", null, function () {
        alert("Registro eliminado con exito!");
        loadServiceOrders();
    })
}

function editServiceOrder(id, data) {
    var url = "http://localhost:8080/service-order/" + id;

    callApi(url, "PUT", data, function () {
        alert("Registro actualizado");
        $("#resetData4").click();
        loadServiceOrders();
    });

}

function createServiceOrder(data) {
    var url = "http://localhost:8080/service-order";

    callApi(url, "POST", data, function () {
        alert("Registro creado");
        $("#resetData4").click();
        loadServiceOrders();
    });
}

function renderServiceOrder(result) {
    var data = result.data;

    var birthDayUser = new Date(data.date);
    var day = ("0" + birthDayUser.getDate()).slice(-2);
    var month = ("0" + (birthDayUser.getMonth() + 1)).slice(-2);
    var today = birthDayUser.getFullYear() + "-" + (month) + "-" + (day);


    $("#serviceOrderId").val(data.id);
    $("#serial").val(data.serialNumber);
    $("#fechaInstalacion").val(today);
    // $("#fechaUltimoMantenimiento").val(today2);
    $("#cmbcliente").val(data.customerId);
    $("#cmbtipoEquipo").val(data.equipmentTypeId);
    $("#cmbMarca").val(data.brandId);
    $("#cmbRefrigerante").val(data.refrigerantId);

}

function renderServiceOrders(result) {
    //var data = result.data;
    console.log(typeof(result));
    let html = "";
    let i=0;
    result.forEach(item => {
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
            console.log(detail.description)
            html += "<tr>";
            html += "<th scope='row'>" + (i+1) + "</th>"
            html += "<td>" + detail.id + "</td>"
            html += "<td>" + detail.activityId + "</td>"
            html += "<td>" + detail.description + "</td>"
        
            html += "<td>"
            html += "<div data-id='" + detail.id + "' class='eliminar'>Eliminar</div>"
            html += "<div data-id='" + detail.id + "' class='editar'>Editar</div>"
            html += "</td>"
            html += "</tr>"
            i=i+1;
        });
   
    });
    console.log(html);

    //console.log(cadenaJSON);


    // var birthDayUser = new Date(order.date);
    // var day = ("0" + birthDayUser.getDate()).slice(-2);
    // var month = ("0" + (birthDayUser.getMonth() + 1)).slice(-2);
    // var today = birthDayUser.getFullYear() + "-" + (month) + "-" + (day);


    // $("#serviceOrderId").val(order.id);
    // $("#serial").val(order.serialNumber);
    // // $("#fechaInstalacion").val(today);
    // // $("#fechaUltimoMantenimiento").val(today2);
    // $("#cmbcliente").val(order.customerId);
    // $("#cmbtipoEquipo").val(order.equipmentTypeId);
    // $("#cmbMarca").val(order.brandId);
    // $("#cmbRefrigerante").val(order.refrigerantId);

    //ciclo para la lineas de detalle
    // let html = "";
    // let i=0;
    // order.details.forEach(detail => {
    //     html += "<tr>";
    //     html += "<th scope='row'>" + (i + 1) + "</th>"
    //     html += "<td>" + detail.id + "</td>"
    //     html += "<td>" + detail.activityId + "</td>"
    //     html += "<td>" + detail.description + "</td>"
    
    //     html += "<td>"
    //     html += "<div data-id='" + order.id + "' class='eliminar'>Eliminar</div>"
    //     html += "<div data-id='" + order.id + "' class='editar'>Editar</div>"
    //     html += "</td>"
    //     html += "</tr>"

    // });
    console.log(html);

    $("#bodyListServiceOrder").html(html);
    $(".eliminar").click(function () {
        if (confirm("Desea eliminar el registro?")) {
            var id = $(this).data('id');
            deleteServiceOrder(id);
        }
    });
    $(".editar").click(function () {
        if (confirm("Desea editar el Equipo registro?")) {
            var id = $(this).data('id');
            viewServiceOrder(id);
        }
    });


    // let html = "";
    // for (var i = 0; i < result.data.length; i++) {
    //     var serviceOrder = result.data[i];
    //     html += "<tr>";
    //     html += "<th scope='row'>" + (i + 1) + "</th>"
    //     html += "<td>" + serviceOrder.id + "</td>"
    //     html += "<td>" + serviceOrder.serialNumber + "</td>"
    //     html += "<td>" + serviceOrder.customerFullName + "</td>"
    //     html += "<td>" + serviceOrder.customerPhone + "</td>"
    //     html += "<td>" + serviceOrder.equipmentTypeName + "</td>"
    //     html += "<td>" + serviceOrder.brandName + "</td>"
    //     html += "<td>" + serviceOrder.refrigerantName + "</td>"

    //     html += "<td>"
    //     html += "<div data-id='" + serviceOrder.id + "' class='eliminar'>Eliminar</div>"
    //     html += "<div data-id='" + serviceOrder.id + "' class='editar'>Editar</div>"
    //     html += "</td>"
    //     html += "</tr>"
    // }
    // $("#bodyListServiceOrder").html(html);
    // $(".eliminar").click(function () {
    //     if (confirm("Desea eliminar el registro?")) {
    //         var id = $(this).data('id');
    //         deleteServiceOrder(id);
    //     }
    // });
    // $(".editar").click(function () {
    //     if (confirm("Desea editar el Equipo registro?")) {
    //         var id = $(this).data('id');
    //         viewServiceOrder(id);
    //     }
    // });
}

function loadServiceOrders() {
    var url = "http://localhost:8080/service-order";
//      var url = "http://localhost:8080/equipment";
callApi(url, "GET", null, renderServiceOrders);
}
