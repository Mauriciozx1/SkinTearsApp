import numpy as np
import cv2

#     Capturo la imagen Original
inputImage = cv2.imread('00053.jpg')
#     Muestro la Imagen Original
#cv2.imshow('1.- Imagen Original', inputImage)

#     Guardo la imagen original redimensionada ESTE PASO PUEDE ESTAR DE MAS SE REPITE ABAJO
#cv2.imwrite( "00053_500x500.jpg", inputImage );

#     Genero una Imagen redimensionada
resizedImage = cv2.resize(inputImage, (500,500))
#     Muestro la Imagen redimensionada
#cv2.imshow('1.- Imagen redimensionada', resizedImage)

#     Convertimos la imagen redimensionada de color a gris
grayImage = cv2.cvtColor(resizedImage, cv2.COLOR_BGR2GRAY)
#cv2.imshow('2.- De color a gris', grayImage)


#                 NO LO ESTOY OCUPANDO
#     Filtro gaussiano para eliminar el ruido sobre imagen Redimensionada
#filtroGauss = cv2.GaussianBlur(grayImage, (5, 5), 15)
#     Muestro resultado de filtro gaussiano aplicado
#cv2.imshow('3.- Aplicado Filtro Gaussiano', filtroGauss)


#                 NO LO ESTOY OCUPANDO
#     Filtrado Bilateral sobre imagen Redimensionada
#filtroBilateral = cv2.bilateralFilter (grayImage, 9,75,75)
#     Muestro resultado de filtro Bilateral aplicado
#cv2.imshow('4.- Filtrado Bilateral', filtroBilateral)


#     umbralizacion mejorada
#retval, dst = cv2.umbral(grayImage, 10,255, cv2.THRESH_BINARY)

t, binaryImage = cv2.threshold(grayImage, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_TRIANGLE)
cv2.imshow('4.- Imagen Binaria', binaryImage)


#     Invierto los colores de la imagen Binaria
binaryImageInv = cv2.bitwise_not(binaryImage)
cv2.imshow('5.- Imagen Binaria Invertida', binaryImageInv)

#     Convierto imagenes de tipo uint8 a bool 
resImgBool = resizedImage.astype(np.bool)
invImgBool = binaryImageInv.astype(np.bool)

mascara = np.where(invImgBool >= 128, True, False)
#finalimage = mascara * resizedImage
#cv2.imshow('6.- Imagen Final', finalimage)


cv2.waitKey(0)
cv2.destroyAllWindows()








# puedo binarizar de forma invertida con este parametro THRESH_BINARY_INV
# OJO SI APLICO FILTRO GAUSSIANO PIERDO LA DEFINICION DE LA IMAGEN AL PASARLA A GRIS
#probar primero aplicar fiiltro gauss luego convertir a gris

#BInarizar la imagen
#invertir binarizacion
#dst.astype(np.bool) * color

#resultado = imagenRed and imagenInv

#cv2.imwrite( "Gray_Image.jpg", imagenInv );
