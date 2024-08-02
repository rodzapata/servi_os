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

function loadFormEvent() {

    console.log("loadFormEvent");

    $("#frm1").on("submit", function (e) {
        e.preventDefault();

        $(".error-input").removeClass("error-input");

        if ($("#fullName").val() === "") {
            $("#fullName").addClass("error-input");
        }

        if ($("#bornDate").val() === "") {
            $("#bornDate").addClass("error-input");
        }

        if ($("#state").val() === "") {
            $("#state").addClass("error-input");
        }

        if ($("#email").val() === "") {
            $("#email").addClass("error-input");
        }

        if ($("#phone").val() === "") {
            $("#phone").addClass("error-input");
        }

        if ($("#avatar").val() === "") {
            $("#avatar").addClass("error-input");
        }

        if ($("#password").val() === "") {
            $("#password").addClass("error-input");
        }
        if ($("#rol").val() === "") {
            $("#rol").addClass("error-input");
        }

        if ($(".error-input").length > 0) {
            alert("Verifique los datos ingresados");
            return;
        }

        var objUsuario = {
            "fullName": $("#fullName").val(),
            "bornDate": $("#bornDate").val(),
            "state": $("#state").val(),
            "email": $("#email").val(),
            "phone": $("#phone").val(),
            "avatar": "foto.png",
            "password": $("#password").val(),
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
    $("#state").val(data.state);
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
        html += "<td>" + user.state + "</td>"
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
