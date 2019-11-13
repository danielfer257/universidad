<?php
class Facultad{
	public $codigo;
    public $nombre;
	public $dependencias;

     function __construct($codigo = "", $nombre = "") {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
		$this->dependencias = [];
    }
}

class Dependencia{
	public $codigo;
    public $nombre;
	public $subDependencias;
	public $color;

     function __construct($codigo = "", $nombre = "", $color = "") {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
		$this->subDependencias = [];
		$this->color=$color;
    }
}

class subDependencia{
    public $codigo;
	public $nombre;
    public $consecutivo;

     function __construct($codigo = "", $nombre = "") {
        $this->codigo = $codigo;
        $this->nombre = $nombre;
		$this->consecutivo = 0;
    }
}
$nombreArchivo = "facultades.json";

if( !file_exists($nombreArchivo) ){
    $fileJson=[];
	array_push($fileJson, new Facultad("8", "Facultad de Ingenieria Electronica y Telecomunicaciones"));
	
	array_push($fileJson[0]->dependencias, new Dependencia("1", "Decanatura", "blue"));
	array_push($fileJson[0]->dependencias[0]->subDependencias, new subDependencia("1", "Decano"));
	array_push($fileJson[0]->dependencias[0]->subDependencias, new subDependencia("2", "Secretaria General"));
	
	array_push($fileJson[0]->dependencias, new Dependencia("4", "Departamento de Sistemas", "red"));
	array_push($fileJson[0]->dependencias[1]->subDependencias, new subDependencia("1", "Jefe de Departamento"));
	array_push($fileJson[0]->dependencias[1]->subDependencias, new subDependencia("2", "Tesoreria"));
	
	array_push($fileJson[0]->dependencias, new Dependencia("5", "Departamento de Electronica", "green"));
	array_push($fileJson[0]->dependencias[2]->subDependencias, new subDependencia("1", "Jefe de Departamento"));
	array_push($fileJson[0]->dependencias[2]->subDependencias, new subDependencia("2", "Tesoreria"));
	
	array_push($fileJson, $fileJson[0]->dependencias[0]);
	array_push($fileJson, $fileJson[0]->dependencias[0]->subDependencias[0]);

	file_put_contents($nombreArchivo, json_encode($fileJson));
}

if(isset($_GET["dependencias"])){
    $pos = (intval($_GET["dependencias"]));
	
    $archivo = json_decode(file_get_contents($nombreArchivo));
	
	$archivo[1]=$archivo[0]->dependencias[$pos];
	$archivo[2]=new subDependencia("", "--Seleccione--");
    
	file_put_contents($nombreArchivo, json_encode($archivo));
}

if(isset($_GET["subDependencias"])){
    $pos = (intval($_GET["subDependencias"]));
	
    $archivo = json_decode(file_get_contents($nombreArchivo));
	
	$archivo[2]=$archivo[1]->subDependencias[$pos];
    
	file_put_contents($nombreArchivo, json_encode($archivo));
}


if(isset($_GET["tomar"])){
    $archivo = json_decode(file_get_contents($nombreArchivo));
	
	$codDepAct = $archivo[1]->codigo;
	$codSubDepAct = $archivo[2]->codigo;
	
	for ($i = 0; $i < count($archivo[0]->dependencias); $i++) {
        if($archivo[0]->dependencias[$i]->codigo === $codDepAct){
			for ($j = 0; $j < count($archivo[0]->dependencias[$i]->subDependencias); $j++){
				if($archivo[0]->dependencias[$i]->subDependencias[$j]->codigo === $codSubDepAct){
					$archivo[0]->dependencias[$i]->subDependencias[$j]->consecutivo += 1;
					$archivo[1]=$archivo[0]->dependencias[$i];
					$archivo[2] = $archivo[0]->dependencias[$i]->subDependencias[$j];
				}
			}
		}
    }
	file_put_contents($nombreArchivo, json_encode($archivo));

}

echo  file_get_contents($nombreArchivo);

?>