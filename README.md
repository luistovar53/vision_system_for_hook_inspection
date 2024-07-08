# Vision system for hook inspection
Repository for the "Development and comparison of a vision system for hook inspection on cranes" article

In this repository we share the key elements of the investigation in order to give a general idea of the system and made the comparison of two vision systems for hook inspection


## Hook inspection process
![Alt text](https://github.com/luistovar53/vision_system_for_hook_inspection/blob/97bd8d7e48c95c57c08506d9302dd5476268b677/Hook%20Inspection.png)


The hook used is a model from the Green Pin mark, the step file is here: [hkk03a010.stp](https://github.com/luistovar53/vision_system_for_hook_inspection/blob/ad5de15a89968ac877822f64803ab47092c37bf1/hkk03a010.stp)

## Image processing for inspection

> Gray levels convertion


> Image processing based on environment settings


> Profile extraction


> Valid, Not-Valid and 'Image for inspection' pattern generation


> kNN Algorithm

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
public int knn(int[][] Pass, int[][] Wrong) { // returns 1 if 'Pass' , 0 if 'Wrong', -1 if 'error'
  int i, j;
  int r = -1;
  
  double distPass, distWrong, s;
  
  // Distance to patternPass calculation
  s = 0.0;
  for(i = 0; i < height; i++) {
    for(j = 0; j < width; j++) {
      s += ((pattern[i][j] - Pass[i][j]) * (pattern[i][j] - Pass[i][j]));
    }
  }
    
  distPass = Math.sqrt(s);
  
  // Distance to patternWrong calculation
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


> Clasification result
