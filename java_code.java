private int[][] pattern;


// knn(<patrón Válido>, <patrón No Válido>) <patron a clasificar en variable pattern>
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
