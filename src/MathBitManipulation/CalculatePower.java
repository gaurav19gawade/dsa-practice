package MathBitManipulation;

public class CalculatePower {
  public double myPow(double x, int n) {
    return binaryExponent(x, (long) n);
  }

  public double binaryExponent(double x, long n){
    if(n == 0){
      return 1;
    }

    if(n < 0){
      return 1.0 / binaryExponent(x, -n);
    }

    if(n % 2 == 0){
      return binaryExponent(x * x, n / 2);
    }else{
      return x * binaryExponent(x * x, (n - 1)/2);
    }
  }

  public static void main(String[] args){
    CalculatePower cp = new CalculatePower();
    System.out.println(cp.myPow(2.0, 6));
  }
}
