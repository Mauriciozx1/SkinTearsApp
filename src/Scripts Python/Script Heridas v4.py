import numpy as np
import cv2

#     Capturo la imagen Original
inputImage = cv2.imread('00053.jpg')

#     Genero una Imagen redimensionada
resizedImage = cv2.resize(inputImage, (500,500))
cv2.imshow('1.- Imagen Original redimensionada', resizedImage)

#     Convertimos la imagen redimensionada de color a gris
grayImage = cv2.cvtColor(resizedImage, cv2.COLOR_BGR2GRAY)

t, binaryImage = cv2.threshold(grayImage, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_TRIANGLE)
cv2.imshow('4.- Imagen Binaria', binaryImage)

#     Invierto los colores de la imagen Binaria
binaryImageInv = cv2.bitwise_not(binaryImage)
cv2.imshow('5.- Imagen Binaria Invertida', binaryImageInv)

#     Convierto imagenes de tipo uint8 a bool 
resImgBool = resizedImage.astype(np.bool)
invImgBool = binaryImageInv.astype(np.bool)

invImgBool = np.expand_dims(invImgBool, axis=2)
finalimage = invImgBool * resizedImage

cv2.imshow('6.- Imagen Final', finalimage)


#mask = np.where(invImgBool >= 128, True, True)
#cv2.imshow('6.- Imagen Final', mask)

#finalimage = mask * resImgBool
#cv2.imshow('6.- Imagen Final', invImgBool)


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
