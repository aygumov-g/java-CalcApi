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
  * Working with brackets:
  ```java
  Calc.express("(-5.6+10)^7")
  ```
  * Calculate the percentage of a number or parentheses:
  ```java
  Calc.express("(10%4+9.5)%(-2+3)+5")
  ```
  * Calculate the factorial of a number or parentheses:
  ```java
  Calc.express("(2+(-3))!+5!")
  ```
  * Calculate the logorithm, decimal logorithm:
  ```java
  Calc.express("log5 + lg(-5.1 + 10!)")
  ```
  * Working with trigonometric functions:
  ```java
  Calc.express("sin5 + cos5 + tan(2+3) + arccos10 + arcsin5 + arctan((5+(-5))!)")
  ```
  * Or simply and quickly calculate very complex expressions:
  ```java
  Calc.express("arccos50 + 65%4 * 14 / (10.65 - 19)! * (976.8574 * 5 / 10 + tan(65.3 ^ 4.55 + 7)) + 10 / sin5.31")
  ```
  
  
| `Метод\знак`  | `Описание`           |
| ------------- |:--------------------:|
| +             | сложение             |
| -             | вычитание            |
| *             | умножение            |
| /             | деление              |
| ^             | возведение в степень |
| !             | факториал            |
| %             | процент от числа     |
| log           | обычный логорифм     |
| lg            | десятичный логорифм  |
| sin           | синус угла           |
| cos           | косинус угла         |
| tan           | тангенс угла         |
| arcsin        | арксинус угла        |
| arccos        | арккосинус угла      |
| arctan        | арктангенс угла      |
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
|||
  

**REMEMBER:** *Calc.express()* ACCEPTS ONLY **STRING** VALUES. IF NECESSARY, YOU CAN USE: *MessageFormat.format()* OR *String.valueof()*.
