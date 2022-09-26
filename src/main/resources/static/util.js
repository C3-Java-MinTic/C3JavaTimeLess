function listar(){
    fetch('http://localhost:8080/minticspring_boot/empleado/listarEmpleados')
    .then(response=> response.json()) //convertir a json
    .then(html => {
        document.getElementById('data').innerHTML = JSON.stringify(html);
    })
    .then(json => console.log(json)) // imprimir datos en la consola
    .catch(err => console.log('Solicitud fallida', err)); // Captura los errores
}