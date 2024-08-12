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
    loadCustomer();
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



// ===== ROLES =======
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
