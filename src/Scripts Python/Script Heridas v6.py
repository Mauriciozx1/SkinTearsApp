import numpy as np
import cv2
from skimage import data, io, filters
from PIL import Image, ImageFilter


#     Capturo la imagen Original
inputImage = cv2.imread('00053.jpg')

#     Genero una Imagen redimensionada
resizedImage = cv2.resize(inputImage, (500,500))
cv2.imshow('1.- Imagen Original redimensionada', resizedImage)



#resizedImage = cv2.medianBlur(resizedImage,5) # al aumentar me redondea mucho el contorno final


"""
#     Filtro gaussiano para eliminar el ruido sobre imagen Redimensionada
filtroGauss = cv2.GaussianBlur(resizedImage, (5, 5), 0)
#     Muestro resultado de filtro gaussiano aplicado
cv2.imshow('3.- Aplicado Filtro Gaussiano', filtroGauss)
resizedImage = filtroGauss
"""


#     Convertimos la imagen redimensionada de color a gris
grayImage = cv2.cvtColor(resizedImage, cv2.COLOR_BGR2GRAY)

#     Segmentamos la imagen
t, binaryImage = cv2.threshold(grayImage, 0, 255, cv2.THRESH_BINARY  | cv2.THRESH_TRIANGLE)
cv2.imshow('4.- Imagen Binaria', binaryImage)






# OJO CON ESTOS FILTROS
binaryImage = cv2.medianBlur(binaryImage,11) # al aumentar me redondea mucho el contorno final
kernel = cv2.getStructuringElement(cv2.MORPH_RECT, (1, 1))
binaryImage = cv2.morphologyEx(binaryImage, cv2.MORPH_CLOSE, kernel)
binaryImage = cv2.morphologyEx(binaryImage, cv2.MORPH_OPEN, kernel)







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
