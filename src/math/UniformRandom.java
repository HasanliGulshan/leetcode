package math;

public class UniformRandom {

    public static int uniformRandom(int lowerBound, int upperBound) {
        int numberOfOutcomes = upperBound - lowerBound + 1, result = 0;
        /*do {
            result = 0;
            for (int i = 0; (1 << i) < numberOfOutcomes; ++i) {
                // zeroOneRandom() is the provided random number generator.
                result = (result << 1) | zeroOneRandom();
            }
        } while (result >= numberOfOutcomes);*/
        return result + lowerBound;
    }
}
