# Vision system for hook inspection
Repository for the "Development and comparison of a vision system for hook inspection on cranes" article

In this repository we share the key elements of the investigation in order to give a general idea of the system and made the comparison of two vision systems for hook inspection


## Hook inspection process
<!---
![Alt text](https://github.com/luistovar53/vision_system_for_hook_inspection/blob/d42d473fa4559e5f8507fefc9244aceea6e48c3e/Inspeccion%20Gancho.png)
--->

![Alt text](https://github.com/luistovar53/vision_system_for_hook_inspection/blob/c06c37a9c89d45d5e4ef9e7ab5f583ea75edfe9d/Hook%20Inspection.png)


## Procesamiento de imágenes para inspección

> Conversión a escala de grises

> Preprocesamiento de imagen de acuerdo al ambiente de medición configurado

> Extracción de contorno

> Generar patrón válido, patrón no válido e imágen a inspeccionar

> Algoritmo kNN

Python Code
```py
def knn(patternTest, patternPass, patternWrong):
  s1 = 0.0
  s2 = 0.0
  
  for i in range(patternTest.shape[0]):
    for j in range(patternTest.shape[1]):
      s1 += math.pow((int(patternTest[i][j]) - int(patternPass[i][j])), 2)
      s2 += math.pow((int(patternTest[i][j]) - int(patternWrong[i][j])), 2)
  
  distPass = math.sqrt(s1)
  distWrong = math.sqrt(s2)
  
  print('dP= ', distPass)
  print('dW= ', distWrong)
  
  if distPass < distWrong:
    print('== OK ==')
  else:
    print('== NG ==')
```

Java Code
```java
public int knn(int[][] Pass, int[][] Wrong) { // retornará 1 si 'Pass' , 0 si 'Wrong', -1 si error
  int i, j;
  int r = -1;
  
  double distPass, distWrong, s;
  
  // Caclular distancia hacia patternPass
  s = 0.0;
  for(i = 0; i < height; i++) {
    for(j = 0; j < width; j++) {
      s += ((pattern[i][j] - Pass[i][j]) * (pattern[i][j] - Pass[i][j]));
    }
  }
    
  distPass = Math.sqrt(s);
  
  // Caclular distancia hacia patternWrong
  s = 0.0;
  for(i = 0; i < height; i++) {
    for(j = 0; j < width; j++) {
      s += ((pattern[i][j] - Wrong[i][j]) * (pattern[i][j] - Wrong[i][j]));
    }
  }
    
  distWrong = Math.sqrt(s);
  
  System.out.println("dP= " + distPass);
  System.out.println("dW= " + distWrong);
  
  if(distPass < distWrong) {
    System.out.println("== PASS ==");
    r = 1;
  }
  else {
    System.out.println("== WRONG ==");
    r = 0;
  }
    
  System.out.println("r= " + r);
  return r;
}
```

> Resultado de clasificación
