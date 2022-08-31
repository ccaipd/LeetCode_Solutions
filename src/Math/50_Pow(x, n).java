package Math;

class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;

        double ans = power(x, n);

        if(n < 0)
            return 1 / ans;
        return ans;
    }

    public double power(double x, int n) {
        if(n == 0) return 1;

        double res = power(x, n / 2);

        if(n % 2 == 0)
            return res * res;
        else
            return res * res * x;
    }
}