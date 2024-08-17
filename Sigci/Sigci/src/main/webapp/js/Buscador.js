function doSearch() {
    var tableReg = document.getElementById('descripcion');  // Referencia a la tabla completa
    var searchText = document.getElementById('searchTerm').value.toLowerCase();  // Se corrigió el nombre
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

            // Si la longitud del texto de búsqueda es 0 o si el texto de la celda contiene el texto de búsqueda
            if (searchText.length == 0 || (compareWith.indexOf(searchText) >= 0)) {
                found = true;
            }
        }

        // Muestra u oculta la fila según si se encontró el texto
        if (found) {
            tableReg.rows[i].style.display = '';
        } else {
            tableReg.rows[i].style.display = 'none';
        }
    }
}
