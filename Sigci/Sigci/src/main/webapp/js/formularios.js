const formulario = document.getElementById('FormLogin');
const inputs = document.querySelectorAll('#FormLogin input');
const selects = document.querySelectorAll('#FormLogin select');

const expresiones = {
    nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    apellidos: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    curp: /^[a-zA-Z0-9]{18}$/, // Letras y números, exactamente 18 caracteres.
    nombre_usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, números, guion y guion bajo.
    email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/, // Formato de correo electrónico.
};

const campos = {
    nombre: false,
    apellidos: false,
    curp: false,
    email: false,
    nombre_usuario: false,
    fecha_nacimiento: false,
    id_division: false,
    id_grupo: false
};

const validarFormulario = (e) => {
    switch (e.target.name) {
        case "nombre":
            validarCampo(expresiones.nombre, e.target, 'nombre');
            break;
        case "apellidos":
            validarCampo(expresiones.apellidos, e.target, 'apellidos');
            break;
        case "curp":
            validarCampo(expresiones.curp, e.target, 'curp');
            break;
        case "nombre_usuario":
            validarCampo(expresiones.nombre_usuario, e.target, 'nombre_usuario');
            break;
        case "email":
            validarCampo(expresiones.email, e.target, 'email');
            break;
    }
};

const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo] = true;
    } else {
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo] = false;
    }
};

const validarSelects = () => {
    document.querySelectorAll('#FormLogin select').forEach(select => {
        if (select.value === '') {
            campos[select.name] = false;
            select.classList.add('formulario__input-error');
        } else {
            campos[select.name] = true;
            select.classList.remove('formulario__input-error');
        }
    });
};

const validarFecha = () => {
    const fecha = document.getElementById('fecha_nacimiento').value;
    campos.fecha_nacimiento = fecha !== '';
    document.getElementById('fecha_nacimiento').classList.toggle('formulario__input-error', !campos.fecha_nacimiento);
};

inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});

selects.forEach((select) => {
    select.addEventListener('change', validarSelects);
});

document.getElementById('fecha_nacimiento').addEventListener('change', validarFecha);

formulario.addEventListener('submit', (e) => {
    // Validar todos los campos antes de enviar
    validarFormulario({ target: { name: 'nombre', value: document.getElementById('nombre').value } });
    validarFormulario({ target: { name: 'apellidos', value: document.getElementById('apellidos').value } });
    validarFormulario({ target: { name: 'curp', value: document.getElementById('curp').value } });
    validarFormulario({ target: { name: 'email', value: document.getElementById('email').value } });
    validarFormulario({ target: { name: 'nombre_usuario', value: document.getElementById('nombre_usuario').value } });
    validarSelects();
    validarFecha();

    if (Object.values(campos).every(value => value === true)) {
        // Mostrar mensaje de éxito
        document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
        }, 5000);

        // El formulario se enviará automáticamente
        // Si necesitas hacer algo más antes de enviar, agrégalo aquí
    } else {
        e.preventDefault(); // Evitar el envío si el formulario no es válido
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
    }
});
