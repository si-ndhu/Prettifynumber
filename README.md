# NumberPrettifier

## Overview: 
The problem involves prettifying numbers based on their magnitude, with specific formatting rules applied. To accomplish this, I adopted the following approach:

1. **Conversion to BigDecimal**: Start by converting the input `double` number to a `BigDecimal` object to ensure precision in arithmetic operations.

2. **Magnitude Check**: Then check the magnitude of the number to determine the appropriate prettification strategy:
   - If the absolute value of the number is less than 1 million, I further check if it's an integer or has a fractional part. If it's an integer, return it as an integer; otherwise, return the original number.
   - If the absolute value is between 1 million and 1 billion, format it as millions (e.g., 2.5M).
   - If the absolute value is between 1 billion and 1 trillion, format it as billions (e.g., 1.1B).
   - If the absolute value is greater than or equal to 1 trillion, format it as trillions (e.g., 1T).

3. **Formatting with Decimal**: For numbers formatted as millions, billions, or trillions, divide the number by the appropriate threshold to obtain the scaled number. I then check if the scaled number is an integer or has a fractional part and format it accordingly:
   - If the scaled number is an integer, format it without any decimal points (e.g., 2M, 1B).
   - If the scaled number has a fractional part, format it with one decimal point (e.g., 2.5M, 1.1B).

4. **Output**: Return the prettified number as a string.

This approach allows to handle numbers of varying magnitudes and prettify them according to the specified rules. By using `BigDecimal` for precision and implementing checks for integer and fractional parts, I ensure accurate prettification of numbers in the desired format.

### Assumptions:
1. The function assumes that the input is a numeric type (integer or float or double).
2. It assumes that numbers larger than 6 digits need to be prettified.
3. It assumes that the prettified format follows the convention of using M for millions, B for billions, and T for trillions.
4. It assumes that only one decimal place should be included in the output when the truncated number is not an integer.
5. It assumes that the input numbers would be within the range supported by double data type.
6. The code assumes that it needs to handle negative numbers, as it uses the absolute value function to ensure consistent prettification.

### Design Decisions:
1. The function truncates the number to one decimal place if it's not an integer.
2. The function returns the original number if it has a fractional part and is less than 1 million.
3. The function uses BigDecimal for precise arithmetic and comparison to avoid floating-point inaccuracies.
4. The function utilizes a private helper method formatWithDecimalIfNeeded to format the number with the appropriate suffix and one decimal place if necessary.
5. The function uses a threshold value (1e6, 1e9, 1e12) to determine whether the number should be prettified to millions, billions, or trillions.
6. The function formats the number with or without a decimal place based on whether the scaled number has a fractional part.

### Questions:
1. Does the code need to handle very large numbers efficiently, considering the usage of BigDecimal for precise arithmetic?
2. Should the function support non-numeric inputs or negative numbers explicitly, or is the current behavior of handling negative numbers by taking their absolute value sufficient?
3. Is there any specific desired behavior for numbers smaller than 1e6? Should they be prettified in any specific way, or is it acceptable to return them as they are?
4. Are there any specific edge cases or inputs that need special handling, such as very large or very small numbers, or inputs outside the supported numeric range?
5. Does the code need to support other suffixes beyond millions, billions, and trillions, as the current implementation does not include them?