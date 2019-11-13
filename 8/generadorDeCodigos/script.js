function ajax(metodos, url) {
	var xmlhttp = new XMLHttpRequest();

	xmlhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			llenarDependencias(JSON.parse(this.responseText))
		}
	};
	xmlhttp.open(metodos, url, true);
	xmlhttp.send();
}

ajax('GET', './codigos.php'); 

function llenarDependencias(datos) {
	document.querySelector('.dependencias').innerHTML = "";
	for (i in datos[0].dependencias) {
		var codigo = datos[0].dependencias[i].codigo;
		var nombre = datos[0].dependencias[i].nombre;
		agregarOpciones(i, codigo, nombre, '.dependencias');
	}
	var valSel = datos[1].codigo
	//console.log(valSel);
	document.getElementById(valSel).selected = true;
	document.querySelector('.codigoAct').innerHTML = datos[0].codigo + '.' + valSel;
	document.querySelector('.codigoAct').style.backgroundColor = datos[1].color;
	
	llenarSubDependencias(datos, valSel);
}

function agregarOpciones(pos, codigo, nombre, clase) {
	document.querySelector(clase).innerHTML += '<option value=' + pos + ' id =' + codigo + ' >' + nombre + '</option>';
}

function llenarSubDependencias(file, codigoDepAct) {
	var datos = file[1].subDependencias;
	
	document.querySelector('.subDependencias').innerHTML = "";
	if (file[2].codigo === "") { document.querySelector('.subDependencias').innerHTML = '<option value=0>--Seleccione--</option>';  }
	
	for (i in datos) {
		var codigo = codigoDepAct + '.' + datos[i].codigo;
		//console.log(i);
		//console.log(codigo);
		agregarOpciones(i, codigo, datos[i].nombre, '.subDependencias');
    }
	
	if (file[2].codigo !== "") 
	{ 
		var valSel = codigoDepAct + '.' + file[2].codigo;
		//console.log(valSel);
		document.getElementById(valSel).selected = true;
		document.querySelector('.codigoAct').innerHTML = file[0].codigo + '.' + valSel + '/' + file[2].consecutivo;
	}
}

document.querySelector('.dependencias').addEventListener('change', function(event) {
	document.querySelector('.tomar').disabled = true;
	
	var valor = document.querySelector('.dependencias').value;
	
	//console.log(valor);
	ajax('GET', './codigos.php?dependencias='+valor);
});

document.querySelector('.subDependencias').addEventListener('change', function(event) {
	document.querySelector('.tomar').disabled = false;

	var valor = document.querySelector('.subDependencias').value;
	//console.log(valor);
	ajax('GET', './codigos.php?subDependencias='+valor);
});

document.querySelector('.tomar').addEventListener('click', function(event) {
	ajax('GET', './codigos.php?tomar');
	var codigo=document.querySelector('.codigoAct').innerHTML
		codigo=codigo.split("/");
	if(isNaN(codigo[1])) { alert("Para poder tomar un codigo consecutivo, debe seleccionar la sub-dependencia"); }
	else { 
		codigo=codigo[0]+"/"+(parseInt(codigo[1])+1);
		alert ("EL CODIGO "+codigo+" SE LE FUE ASIGNADO");
	}
});

