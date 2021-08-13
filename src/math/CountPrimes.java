package math;

public class CountPrimes {
    public static int countPrimes(int n) {
        boolean[] primes = new boolean[n+1];
        int count = 0;

        for (int i = 0; i <= n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i]) {
                for (int j = i*i; j <= n;  j+=i) {
                    primes[j] = false;
                }
            }
        }

        for (int i=2; i<n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(3));
    }
}
