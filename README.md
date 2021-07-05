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

<br/>
<br/>

Table of possible methods and operations **calcApi**:
| `Method\Sign` | `Description`        | `Using`         | `Use with brackets`             |
| --------------|----------------------|-----------------|---------------------------------|
| +             | сложение             | 2 + 2           | 2+(5+1)                         |
| -             | вычитание            | 2 - (-8)        | 9.3-(10+3)                      |
| *             | умножение            | 2 * 2           | -6*(30-1)                       |
| /             | деление              | 2 / 2           | 57/(9.8 * 2)                    |
| ^             | возведение в степень | 2 ^ 2           | 7^(31+7)                        |
| !             | факториал            | 10!             | ((-8)+15.5)!                    |
| %             | процент от числа     | 4 % 5.1         | (6.9+10!)%((-6)+1)              |
| log           | обычный логорифм     | log10           | log(8+9)                        |
| lg            | десятичный логорифм  | sin7            | lg(7!+3)                        |
| sin           | синус угла           | cos10           | sin(6+4%6)                      |
| cos           | косинус угла         | cos80.698       | cos(8+9)                        |
| tan           | тангенс угла         | tan6            | tan(8*(7.9+5!)                  |
| arcsin        | арксинус угла        | arcsin50        | arcsin(76+312)                  |
| arccos        | арккосинус угла      | arccos15        | arccos(4!+53421)                |
| arctan        | арктангенс угла      | arctan8         | arctan((433+3240) * (4321+432)) |

<br/>


> **REMEMBER:**
>> *Calc.express()* accepts only **STRING** values. If necessary, you can use: *MessageFormat.format()* or *String.valueof()*! <br/>
>> The **double type is passed as the response**! <br!>
>> You can use spaces between operations and values, this will NOT affect anything!
>>> Examle:
>>>> `4 + 5`           or   `4+5`                         <br/>
>>>> `- 6 + ( -1 )`    or   `-6+(-1)`                     <br/>
>>>> `( 5 + 4 )`       or  `(5 + 4)`     or `(5+4)`       <br/>
>>>> `log 7`           or  `log7`                         <br/>
>>>> `sin ( 5 ! + 1 )` or  `sin(5 !+1)`  or  `sin (5!+1)` <br/>
>>>> `11 ! % 80`       or  `11! % 80`    or  `11!%80`     <br/>
