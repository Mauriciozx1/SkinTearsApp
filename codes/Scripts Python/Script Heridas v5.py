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

#     Expando la dimension de la imagen Invertida y binarizada
invImgBoolExpDim = np.expand_dims(invImgBool, axis=2)

#     Realizo un producto entre la Imagen Binarizada invertida y expandida contra la imagen redimensionada
#     Ejecutaba con error si convertia la imagen original redimensionada a np.bool
finalimage = invImgBoolExpDim * resizedImage

cv2.imshow('6.- Imagen Final', finalimage)

cv2.waitKey(0)
cv2.destroyAllWindows()
