package foroffer.offer;

public class _10Fibonacci {
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int x = 0,y = 1,z = 1,i = 0,end = n-2;
        while (i <= end) {
            z = x + y;
            x = y;
            y = z;
            i++;
        }
        return z;
    }

}
