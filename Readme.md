# SKINTEARS APP.

Aplicación para Proyecto de Título, de la carrera de Ingeniería en Computación e informática.

Sistema educativo con capacidad de reconocimiento de heridas, como método de apoyo a su clasificación.


## APLICACIÓN ANDROID.

La Aplicacion desarrollada en Android Studio, en estos momentos tiene implementado un módulo educativo de preguntas, las cuales son del tipo selección multiple, además va guardando el estado. Las preguntas estan implementadas en un Array en el archivo String.xml.

### INSTALACIÓN DE LA APLICACIÓN EN LA VERSIÓN DE PRUEBA.

Para instalar la versión de prueba ejecute el siguiente comando.

- `git clone https://github.com/claudiocu81/SkinTearsApp.git`
- También puede descargar el archivo comprimido directamente desde el repositorio.
- Descomprima el archivo que descargo.
- Luego ejecute Android Studio y seleccione la siguiente ruta /SkinTearsApp/app/ModEducativo, para abrir un proyecto existente.
- Conecte su Smartphone Android al computador, a través de un cable USB.
- Active en las opciones de desarrollador de su Smartphone la Depuración por USB.
- Luego haga click en el botón run app, y seleccione el dispositivo que ha conectado.


## MONTAJE DEL ENTORNO DE DESARROLLO PARA IMPLEMENTAR EL RECONOCIMIENTO DE HERIDAS.

En la carpeta src del proyecto, están almacenadas las diferentes versiones de scripts desarrollados en Python, los cuales básicamente en su versión 10 realiza las siguientes acciones:

### Función readImages()

* Lee un directorio específico y almacena los nombres de los archivos contenidos en una Lista.
* Debe cambiar la ruta del directorio que lee la función editando el archivo con su editor de texto preferido, mantenga la extensión (.py).

### Función loadSaveImages()

Desde la lista creada en la Función readImages(), toma el primer archivo mediante un ciclo for y lo procesa de la siguiente forma.

* Se toma la imagen y la carga como Array.
* Se redimensiona la imagen a un tamaño de (500 x 500)px, para estandarizar los tamaños y reducir el uso de recursos al procesarlas.
* Se convierte la imagen a escala de grises.
* Se binariza la imagen en colores blanco y negro.
* Se invierten los colores de la binarización.
* Se convierte la imágen de tipo uint8 a bool.
* Se expande la dimension de la imagen invertida y binarizada.
* Se realiza un producto entre la imagen binarizada invertida y expandida contra la imagen redimensionada.
* Se genera una imagen en la que sólo debe aparecer la herida, que es la información que necesitamos realmente procesar.
* Se guarda la imagen en la ruta especificada.

El proceso anterior se repite una cantidad de veces definida en el ciclo for, el cual es equivalente a la cantidad de imagenes.

Todo el proceso explicado anteriormente se genera con el propósito de poder generar Dataset (matrices de datos) y posteriormente poder clasificar las imágenes, de acuerdo a algoritmos y predicciones que nos provee scikit-learn.

## INSTALACIÓN DEL ENTORNO DE DESARROLLO.

### OPCIÓN 1

1. Descargar OpenCV.

[OpenCV](https://sourceforge.net/projects/opencvlibrary/files/opencv-win/3.1.0/opencv-3.1.0.exe/download)

Descargar Python:

[64 bits](https://www.python.org/ftp/python/2.7.12/python-2.7.12.amd64.msi)
[32 bits](https://www.python.org/ftp/python/2.7.12/python-2.7.12.msi)

2. Una vez instalado Python y OpenCV, ingresar al directorio.

C:\opencv\build\python\2.7

(dependiendo de la arquitectura de SO 64 o 32 bits) y copiar el archivo cv2.pyd

3. Pegar el archivo en la siguiente ruta.

C:\Python27\Lib\site-packages

4. Agregar python y pip al PATH
    
(Equipo -> click derecho Propiedades -> Configuración Avanzada del sistema -> Variables de Entorno -> Path -> Editar):

;C:\Python27\;C:\Python27\Scripts\

5. Ahora mediante la consola de windows usar los siguiente comandos.

Actualizar pip:

`python -m pip install --upgrade pip`

6. Instalar numpy.

`pip install numpy`

7. Instalar Matplot.

```
python -m pip install -U pip setuptools
python -m pip install matplotlib
```
8. Instalar Imutils.

`pip install imutils`

9. Instalar scikit-learn para el clasificador de imagenes.

`pip install -U scikit-learn`

10. Instalar un módulo de scikit-learn.
   
`pip install -U scikit-image`

11. Para verificar los paquetes que fueron instalados con pip en windows.

`pip freeze`

12. Como prueba rápida, para verificar que python este bien instalado, desde la consola de windows ejecute lo siguiente.

`python --version`

### OPCIÓN 2

Existe una forma más fácil, de implementar el entorno de desarrollo.

#### Para Sistema Operativo MacOS

- Instalar Anaconda, debes elegir la versión de Python, para este proyecto se trabajo con 2.7
[Anaconda](https://www.anaconda.com/download/#macos)

- Abrir spider

- Abrir el terminal de Mac

* Ejecutar el siguiente comando para Instalar PIP.

`easy_install pip`

* Ejecutar el siguiente comando para instalar OpenCV.

`pip install opencv-contrib-python`

* Ejecutar el siguiente comando para instalar Scikit learn

`pip install -U scikit-learn`


### Continuando la configuración del entorno de desarrollo.

Una vez instalado Python, OpenCV y Scikit-learn, realizamos lo siguiente:

- Busque en la carpeta src el archivo "Script Heridas v10 separa la herida en multiples archivos.py", luego con el botón derecho del mouse seleccione Edit with IDLE, para que vea el contenido del archivo, debería poder ver claramente 2 funciones readImages() y loadSaveImages().

- Verifique el directorio de la ruta de las imagenes de origen y destino, así como la cantidad de imagenes para que las ajuste en el ciclo for.