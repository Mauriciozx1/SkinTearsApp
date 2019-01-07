import numpy as np
import cv2

#cargar imagen en escala de grises

img = cv2.imread('messi5.JPG',0)
cv2.imshow("Messi", img)
key = cv2.waitKey(0) & 0xFF
if key == 27:  #tecla ESC
    cv2.destroyAllWindows()
elif key == ord('s'):
    cv2.imwrite('messi5.png', img)
    cv2.destroyAllWindows()
