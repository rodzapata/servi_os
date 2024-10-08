$(function () {

    $("#resetData").click(function () {
        $(".error-input").removeClass("error-input");
        $("#userId").val("");
    });

    // loadZoneTemplate("header");
    // loadZoneTemplate("footer");

    loadRoles();
    loadUsuarios();
    loadFormEvent();

});

document.addEventListener("DOMContentLoaded", function() {
    loadContent('user.html','main-content');
});

function loadZoneTemplate(zone) {
    var url = "assets/template/" + zone + ".html";
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            try {
                $("#content_" + zone).html(result);
            } catch (e) {
                console.log("Error en cbSuccess", e);
            }
        },
        error: function (xhr, status, error) {
            try {
                console.log(error);
                cbError(xhr.status);
            } catch (e) {
                console.log("Error en cbError", e);
            }
        }
    });
}

function cbErrorBase(error) {
    alert("El llamado al servidor fallo " + error);
}

function loadContent(page,elementId) {
    fetch(page)
        .then(response => response.text())
        .then(data => {
            document.getElementById(elementId).innerHTML = data;
        })
        .catch(error => console.error('Error al cargar la página:', error));

}

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

        if ($("#color").val() === "") {
            $("#color").addClass("error-input");
        }

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
            "color": $("#color").val(),
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

}

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

function loadUsuarios() {
    var url = "http://localhost:8080/user";
    callApi(url, "GET", null, renderUsers);
}

function loadRoles() {
    var url = "http://localhost:8080/rol";
    callApi(url, "GET", null, renderRoles);
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
    $("#color").val(data.color);
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
        html += "<div class='userColor' style='background-color:" + user.color + "'></div>"
        html += "<label class='detail-color'>" + user.color + "</label>"
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

function renderRoles(result) {
    let html = "";
    for (var i = 0; i < result.data.length; i++) {
        var opcion = result.data[i];
        html += "<option value='" + opcion.id + "'>" + opcion.name + "</option>";
    }
    $("#rol").html(html);
}
