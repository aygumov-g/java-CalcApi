# java-CalcApi

The official library of the [BETA] **multifunctional** calculator for java.
Opportunities **calcApi**:

  * Work with regular expressions
  ```java
  Calc.express("2+2*2")
  ```
  * Raise to a degree:
  ```java
  Calc.express("10^5")
  ```
  * Working with brackets
  ```java
  Calc.express("(-5.6+10)^7")
  ```
  * Calculate the factorial:
  ```java
  Calc.express("(2+3)!+5!")
  ```
  * Working with trigonometric functions:
  ```java
  Calc.express("sin5 + cos5 + tan(2+3) + arccos10 + arcsin5 + arctan((5+5)!)")
  ```
  * Or simply and quickly calculate very complex expressions:
  ```java
  Calc.express("arccos50 + 65 * 14 / (10.65 - 19)! * (976.8574 * 5 / 10 + tan(65.3 ^ 4.55 + 7)) + 10 / sin5.31")
  ```

  
If you need to write the received response to a variable, be sure to use the **double** type:
```java
int n1 = 10;
int n2 = 10;

double answer = 0;

for (int i = 0; i < n1; i++) {
    answer += Calc.express(MessageFormat.format("{0}+{1}", n1, n2));
}

        System.out.println(answer);
```

REMEMBER: Calc.express() ACCEPTS ONLY **string** VALUES. IF NECESSARY, YOU CAN USE: MessageFormat.format() OR String.valueof().
