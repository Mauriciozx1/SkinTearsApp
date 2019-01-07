import numpy as np
import cv2

#Capturo la imagen Original
imagen = cv2.imread('00053.jpg')
#Muestro la Imagen Original
#cv2.imshow('1.- Imagen Original', imagen)

#Guardo la imagen original redimensionada ESTE PASO PUEDE ESTAR DE MAS SE REPITE ABAJO
cv2.imwrite( "00053_500x500.jpg", imagen );


#Genero una Imagen redimensionada
imagenRed = cv2.resize(imagen, (500,500))
#Muestro la Imagen redimensionada
#cv2.imshow('1.- Imagen redimensionada', imagenRed)

#Convertimos la imagen redimensionada de color a gris
imagenGray = cv2.cvtColor(imagenRed, cv2.COLOR_BGR2GRAY)
#cv2.imshow('2.- De color a gris', imagenGray)

# Filtro gaussiano para eliminar el ruido sobre imagen Redimensionada
filtroGauss = cv2.GaussianBlur(imagenGray, (21, 21), 15)
# Muestro resultado de filtro gaussiano aplicado
cv2.imshow('3.- Aplicado Filtro Gaussiano', filtroGauss)


#                 NO LO ESTOY OCUPANDO
#Filtrado Bilateral sobre imagen Redimensionada
filtroBilateral = cv2.bilateralFilter (imagenGray, 9,75,75)
# Muestro resultado de filtro Bilateral aplicado
#cv2.imshow('4.- Filtrado Bilateral', filtroBilateral)


#umbralizacion mejorada
#retval, dst = cv2.umbral(imagenGray, 10,255, cv2.THRESH_BINARY)

t, dst = cv2.threshold(imagenGray, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_TRIANGLE)
cv2.imshow('4.- Umbralizacion Mejorada', dst)





#Invierto los colores de la imagen Binaria
imagenInv = cv2.bitwise_not(dst)
cv2.imshow('5.- Colores Invertido', imagenInv)






# puedo binarizar de forma invertida con este parametro THRESH_BINARY_INV
# OJO SI APLICO FILTRO GAUSSIANO PIERDO LA DEFINICION DE LA IMAGEN AL PASARLA A GRIS
#probar primero aplicar fiiltro gauss luego convertir a gris

#BInarizar la imagen
#invertir binarizacion
#dst.astype(np.bool) * color

#resultado = imagenRed and imagenInv


#cv2.imwrite( "Gray_Image.jpg", imagenInv );


imgRedBool = imagenRed.astype(np.bool)
imgGrayBool = imagenInv.astype(np.bool)

#cv2.imshow('6.- imgRedBool np.bool', imgRedBool)


#resultado = imgRedBool and imgGrayBool
#cv2.imshow('6.- Resultado', resultado)




"""
img1 = cv2.imread('00053_500x500.jpg') 
mask = cv2.imread('Gray_Image.jpg',0)
mask_inv = cv2.bitwise_not(mask)
"""

#res = cv2.bitwise_and(img1, mask) 



cv2.waitKey(0)
cv2.destroyAllWindows()




