import numpy as np
import cv2

# Filtro gaussiano para eliminar el ruido
src = cv2.imread('herramientas.jpg')

gray = cv2.cvtColor(src, cv2.COLOR_BGR2GRAY)
gray = cv2.GaussianBlur(gray, (7, 7), 3)

cv2.imshow('Filtro Gaussiano', src)

t, dst = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_TRIANGLE)

# obtener los contornos
_, contours, _ = cv2.findContours(dst, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)

# dibujar los contornos
cv2.drawContours(src, contours, -1, (0, 0, 255), 2, cv2.LINE_AA)


# Para filtrar contornos no deseados calculo el area y calculo un area min y max
for c in contours:
    area = cv2.contourArea(c)
    if area > 1000 and area < 10000:
        cv2.drawContours(src, [c], 0, (0, 255, 0), 2, cv2.LINE_AA)

# Veo el rectangulo de contorno mas pequeno posible
for c in contours:
    area = cv2.contourArea(c)
    if area > 1000 and area < 10000:
        (x, y, w, h) = cv2.boundingRect(c)
        cv2.rectangle(src, (x, y), (x + w, y + h), (0, 255, 0), 1, cv2.LINE_AA)

        
cv2.imshow('Imagen Contorno reducido', src)
cv2.imshow('Imagen umbral', dst)

cv2.waitKey(0)
