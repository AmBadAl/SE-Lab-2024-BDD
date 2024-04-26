# SE-Lab-2024-BDD

در این آزمایش نوشتن سناریو و تست با استفاده از ابزار Cucumber و زبان Gherkin را فرا گرفتیم. ابتدا یک پروژه Maven و با dependencyهای مورد نیاز برای Cucumber راه‌اندازی کردیم. طبق مثالی که در دستوالعمل آزمایش آمده بود فایل‌های تست و فیچر و همچنین کلاس‌هایی که تست می‌شوند را نوشتیم.

در فایل calculator.feature تعدادی سناریو به زبان Gherkin نوشتیم. سناریوی زیر را در نظر بگیرید که تست مربوطه پاس می‌شود:
```
Feature: Calculator Operations

  # Normal Scenarios for basic operations
  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3
```

کد پروژه را به گونه‌ای تکمیل می‌کنیم که به یک ماشین حساب کامل تبدیل شود. با فشردن کلیدهای ضرب (*)، تقسیم (/) و یا توان (^) نتیجه عملیات ضرب و تقسیم دو عدد بر یکدیگر و یا به توان رساندن (با کمک عملگر ضرب) به درستی نشان داده می‌شود. سناریوهای دیگری نیز به فایل calculator.feature اضافه می‌کنیم، برای مثال:
```
  Scenario: multiply two numbers
    Given Two input values, 1 and 2
    When I multiply the two values
    Then I expect the result 2

  Scenario: divide two numbers
    Given Two input values, 2 and 1
    When I divide the two values
    Then I expect the result 2

  Scenario: power two numbers
    Given Two input values, 2 and 3
    When I power the two values
    Then I expect the result 8
```
در انتهای فایل scenario outline را مشخص می‌کنیم و تعدادی example برای اتوماتیک کردن تست می‌نویسیم:
```
  # Scenario Outline for variable operations
  Scenario Outline: perform arithmetic operations with different data
    Given Two input values, <first> and <second>
    And I have selected the operation <opt>
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


## پاسخ سوال مطرح شده در مورد 2
سناریوی دوم که شامل ورودی منفی ۱ و ۶ است به error برخورده است. این ارور همان مشکلی‌ست که در گزارش کار مطرح شده است.
علت بروز این مشکل وجود عدد ورودی منفی است چرا که در ورودی @Given تابع twoInputValuesAnd در رجکس آن عدد منفی هندل نمیشود.
با عوض کردن ورودی رجکس این حالت را هندل میکنیم و در نتیجه باعث میشود که تست های maven با موفقیت پاس بشوند.
