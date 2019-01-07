import numpy as np
import cv2

original = cv2.imread('00053.jpg')

#Imagen Original
cv2.imshow('Orginals', original)


gray = cv2.imread('00053.jpg', cv2.IMREAD_GRAYSCALE)



t, dst = cv2.threshold(gray, 170, 255, cv2.THRESH_BINARY)

#Imagen en escala de grises
cv2.imshow('umbral', gray)

#umbralizacion basica
cv2.imshow('result', dst)

t, dst = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_TRIANGLE)

#umbralizacion mejorada
cv2.imshow('new result', dst)

cv2.waitKey(0)
