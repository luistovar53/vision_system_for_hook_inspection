# patternTest - imagen de prueba, patternPass - patrón Válido, patternWrong - patrón No Válido
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
