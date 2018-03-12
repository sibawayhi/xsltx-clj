package fib;

import java.math.BigInteger;

public class FibonacciNumber {

  public static BigInteger calculate(int n) {
  
    if (n <= 0) {
      throw new IllegalArgumentException(
       "Fibonacci numbers are only defined for positive integers"
      );
    }
    BigInteger low  = BigInteger.ONE;
    BigInteger high = BigInteger.ONE;
    
    for (int i = 3; i <= n; i++) {
      BigInteger temp = high;
      high = high.add(low);
      low = temp;
    }
    
    return high;
  
  }

}
