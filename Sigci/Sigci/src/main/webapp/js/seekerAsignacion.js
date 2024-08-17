function doSearch() {
    var tableReg = document.getElementById('listAsignacion');  // Referencia a la tabla completa
    var searchText = document.getElementById('searchTerm').value.toLowerCase();  // Obtiene el texto de búsqueda y lo convierte a minúsculas
    var cellsOfRow = "";
    var found = false;
    var compareWith = "";

    // Itera sobre todas las filas de la tabla (comenzando desde 1 para omitir el encabezado)
    for (var i = 1; i < tableReg.rows.length; i++) {
        cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        found = false;

        // Itera sobre las celdas de la fila
        for (var j = 0; j < cellsOfRow.length && !found; j++) {
            compareWith = cellsOfRow[j].innerHTML.toLowerCase();

            // Verifica si el texto de búsqueda está contenido en el texto de la celda
            if (searchText.length == 0 || (compareWith.indexOf(searchText) >= 0)) {
                found = true;
            }
        }

        // Muestra u oculta la fila según si se encontró el texto
        tableReg.rows[i].style.display = found ? '' : 'none';
    }
}
