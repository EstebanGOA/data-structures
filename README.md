### Lenguaje e IDE utilizado

El programa está escrito con Java utilizando el SDK 17.
Para la realización de la práctica hemos usado el Intellij.

### Instrucciones

## Ficheros

Los ficheros los teníamos cargados dentro de una carpeta data dentro del proyecto. Si creamos esta carpeta y cargamos
todos los datasets dentro del paquete io, el proyecto debería estar preparado para compilar. 

Para cada uno de los sistemas implementados hemos creado una clase donde especificamos el fichero que cargamos. Estas clases
están dentro del paquete io, que se encuentra en la carpeta src.

Si queremos cambiar el fichero que cargamos tendremos que dirigirnos a esta clase y modificar la variable global path que 
se encuentra en cada una de estas clases.

## Grafos

Para el apartado de 'Contextualización de drama' tendremos que cambiar el fichero que cargamos en UserReader por alguno que 
esté dentro del dataset especial que nos proporcionaron en clase para grados acíclicos. 

## Tablas

En las tablas está implementado el linear probing, quadratic probing y double hashing, si queremos cambiar cuál de estos queremos
utilizar tendremos que ir a la clase Table y buscar la función collision, aquí solo tendremos que descomentar el que queramos
usar y comentar el resto. 

## Árboles binarios

Tenemos implementados los árboles autobalanceados y no balanceados, si queremos cambiar entre estos tendremos que ir a la 
clase TreeReader y, en la línea 46 y 47 tendremos que comentar una y des-comentar la otra. Por otro lado, tendremos que ir al
TreeDelete y en la función deleteById proceder de la misma forma con la línea 108 y 109, esto es para evitar que al eliminar se 
autobalance. 

### Control de excepciones

No hemos implementado ningún control de excepciones por parte del usuario, es decir, si al compilar el usuario introduce
un valor diferente al esperado desconocemos como se comportara el sistema. 

Del mismo modo, cuando pedimos identificadores si dicho identificador no existe dentro de las listas es probable que 
salte una excepción que tampoco está controlado y se parará el sistema. 