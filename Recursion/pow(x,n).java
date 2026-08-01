class Solution {
    public double myPow(double x, int n) {
        long m = n;

        if (m < 0) {
            x = 1 / x;
            m = -m;
        }

        return power(x, m);
    }

    private double power(double x, long n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }

        // Recursively calculate x^(n/2)
        double half = power(x, n / 2);

        // If n is even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        }

        // If n is odd: x^n = x * (x^(n/2))^2
        return x * half * half;
    }
}