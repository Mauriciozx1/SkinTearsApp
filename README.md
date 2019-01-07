# SkinTearsApp
Aplicación para proyecto de Título

Sistema educativo con capacidad de reconocimiento de heridas, como método de apoyo a su clasificación

## Aplicación Android
La Aplicacion desarrollada en Android Studio, en estos momentos tiene implementado un módulo educativo de preguntas, las cuales son del tipo selección multiple, además va guardando el estado de las preguntas. Las preguntas estan implementadas en un Array en el archivo Strings.xml.

## Tratamiento de imagenes
En la carpeta Codes, estan almacenadas las diferentes versiones de scripts desarrollados en Python, los cuales básicamente en su version 10 realiza las siguientes acciones:

### Función readImages()
- Lee un directorio especifico y almacena los nombres de los archivos contenidos en una Lista.

### Función loadSaveImages()
- Desde la lista creada en la Función readImages(), toma el primer archivo y lo procesa de la siguiente forma.
  * Toma la imagen y la carga como Array.
  * Redimensiono la imagen a un tamaño de 500 px por 500 px, para estandarizar los tamaños.
  * Convierto la imagen a escala de grises.
  * Binarizo la imagen en blanco y negro.
  * Invierto los colores de la binarización.
  * Convierto las imagenes de tipo uint8 a bool.
  * Expando la dimension de la imagen invertida y binarizada.
  * Realizo un producto entre la imagen binarizada invertida y expandida contra la imagen redimensionada.
  * Genero una imagen en la que solo debe aparecer la herida, que es la informacion que necesitamos realmente procesar.
  * Guardamos la imagen en la ruta especificada.

- El proceso anterior es para poder generar Dataset y posteriormente poder clasificar las imagenes



