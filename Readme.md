# SKINTEARS APP

Aplicación para proyecto de Título

Sistema educativo con capacidad de reconocimiento de heridas, como método de apoyo a su clasificación.

## APLICACIÓN ANDROID

La Aplicacion desarrollada en Android Studio, en estos momentos tiene implementado un módulo educativo de preguntas, las cuales son del tipo selección multiple, además va guardando el estado. Las preguntas estan implementadas en un Array en el archivo String.xml.

### Instalación de la Aplicación en la versión de prueba.

Para instalar la versión de prueba ejecute el siguiente comando.

- git clone https://github.com/claudiocu81/SkinTearsApp.git
- Luego abra Android Studio y abra la siguiente ruta /SkinTearsApp/app/ModEducativo.
- Conecte su Smartphone Android al computador, a través de un cable USB.
- Active en las opciones de desarrollador de su Smartphone Depuracion por USB.
- Luego ejecute el boton run app, y selecciones su dispositivo.



## TRATAMIENTO DE IMÁGENES

En la carpeta src, estan almacenadas las diferentes versiones de scripts desarrollados en Python, los cuales básicamente en su version 10 realiza las siguientes acciones:

### Para usar el script programado en lenguaje Python, debe instalar lo siguiente:

 1. Descargar OpenCV.

    https://sourceforge.net/projects/opencvlibrary/files/opencv-win/3.1.0/opencv-3.1.0.exe/download

    Descargar Python:

    * 64 bits: https://www.python.org/ftp/python/2.7.12/python-2.7.12.amd64.msi
    * 32 bits: https://www.python.org/ftp/python/2.7.12/python-2.7.12.msi

 2. Una vez instalado python y opencv, ingresar al directorio.

    C:\opencv\build\python\2.7
    (dependiendo de la arquitectura de SO 64 o 32 bits) y copiar el archivo cv2.pyd

 3. Pegar el archivo en la siguiente ruta.

    C:\Python27\Lib\site-packages

 4. Agregar python y pip al PATH (Equipo -> click derecho Propiedades -> Configuración Avanzada del sistema -> 

    Variables de Entorno -> Path -> Editar):
    ;C:\Python27\;C:\Python27\Scripts\

 5. Ahora mediante la consola de windows usar los siguiente comandos.

    actualizar pip:
    python -m pip install --upgrade pip

 6. Instalar numpy.

    pip install numpy

 7. Matplot.

    python -m pip install -U pip setuptools
    python -m pip install matplotlib

 8. Instalar imutils.

    pip install imutils

 9. Instalar scikit-learn para el Clasificador de imagenes.

    pip install -U scikit-learn

 10. Instalar un módulo de scikit-learn.
   
    pip install -U scikit-image

 11. Para verificar los pqeuetes que fueron instalados con pip en windows.

     pip freeze

 12. Como prueba rápida, para verificar que python est bien instalado, desde la consola de windows ejecute lo siguiente.

     python --version

### Continuando la configuración del entorno de desarrollo.

- Busque en la carpeta scr el archivo "Script Heridas v10 separa la herida en multiples archivos.py", luego con el botón derecho del mouse seleccione Edit with IDLE, para que vea el contenido del archivo, debería poder ver claramente 2 funciones readImages() y loadSaveImages().

### Función readImages()

- Lee un directorio específico y almacena los nombres de los archivos contenidos en una Lista.
- Debe cambiar la ruta del directorio que lee la funcion editando el archivo con su editor de texto preferido, mantenga la extensión.

### Función loadSaveImages()

  Desde la lista creada en la Función readImages(), toma el primer archivo mediante un ciclo for y lo procesa de la siguiente forma.

  * Se toma la imagen y la carga como Array.
  * Se redimensiona la imagen a un tamaño de 500 px * 500 px, para estandarizar los tamaños y reducir el uso de recursos.
  * Se convierte la imagen a escala de grises.
  * Se binariza la imagen en blanco y negro.
  * Se invierte los colores de la binarización.
  * Se convierte las imágenes de tipo uint8 a bool.
  * Se expande la dimension de la imagen invertida y binarizada.
  * Se realiza un producto entre la imagen binarizada invertida y expandida contra la imagen redimensionada.
  * Se genera una imagen en la que sólo debe aparecer la herida, que es la información que necesitamos realmente procesar.
  * Se guarda la imagen en la ruta especificada.

  El proceso anterior se repite una cantidad de veces definida en el ciclo for, el cual es equivalente a la cantidad de imagenes.

  Todo el proceso explicado anteriormente se genera con el propósito de poder generar Dataset (matrices de datos) y posteriormente poder clasificar las imágenes, de acuerdo a algoritmos y predicciones que nos provee scikit-learn.