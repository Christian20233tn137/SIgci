document.getElementById('FormLogin').addEventListener('submit', function(event) {
    // Validar el campo nombre
    var nombre = document.getElementById('nombre').value;
    if (/\d/.test(nombre) || nombre.length > 50) {
        alert('El nombre no debe contener números y no debe tener más de 50 caracteres.');
        event.preventDefault();
    }

    // Validar el campo apellidos
    var apellidos = document.getElementById('apellidos').value;
    if (/\d/.test(apellidos) || apellidos.length > 50) {
        alert('El apellido no debe contener números y no debe tener más de 50 caracteres.');
        event.preventDefault();
    }

    // Validar el campo CURP
    var curp = document.getElementById('curp').value;
    if (curp.length > 25) {
        alert('El CURP no debe tener más de 25 caracteres.');
        event.preventDefault();
    }

    // Validar el campo email
    var email = document.getElementById('email').value;
    if (email.length > 50) {
        alert('El correo electrónico no debe tener más de 50 caracteres.');
        event.preventDefault();
    }

    // Validar el campo usuario
    var usuario = document.getElementById('nombre_usuario').value;
    if (usuario.length > 15) {
        alert('El nombre de usuario no debe tener más de 15 caracteres.');
        event.preventDefault();
    }
});
