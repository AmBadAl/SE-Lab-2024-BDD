# SE-Lab-2024-BDD

در فایل calculator.feature تعدادی سناریو به زبان Gherkin نوشتیم. سناریوی زیر را در نظر بگیرید که تست مربوطه پاس می‌شود:

Feature: Calculator Operations

  \# Normal Scenarios for basic operations<br />
  Scenario: add two numbers<br />
    Given Two input values, 1 and 2<br />
    When I add the two values<br />
    Then I expect the result 3<br />

در انتهای فایل scenario outline را مشخص می‌کنیم و تعدادی example برای اتوماتیک کردن تست می‌نویسیم:
```
  # Scenario Outline for variable operations<br />
  Scenario Outline: perform arithmetic operations with different data<br />
    Given Two input values, <first> and <second><br />
    And I have selected the operation <opt><br />
    When I perform the operation
    Then I expect the result <result>

    Examples:
      | first | second | opt | result |
      | 1     | 12     | +   | 13     |
      | -1    | 6      | +   | 5      |
      | 2     | 2      | +   | 4      |
      | 6     | 2      | *   | 12     |
      | -6     | 2      | *   | -12     |
      | 6     | 2      | /   | 3      |
      | -6     | 2      | /   | -3      |
      | 6     | 2      | ^   | 36     |
```



سناریوی دوم که شامل ورودی منفی ۱ و ۶ است به error برخورده است.
علت بروز این مشکل وجود عدد ورودی منفی است چرا که در ورودی @Given تابع twoInputValuesAnd در رجکس آن عدد منفی هندل نمیشود.
با عوض کردن ورودی رجکس این حالت را هندل میکنیم و در نتیجه باعث میشود که تست های maven با موفقیت پاس بشوند.
