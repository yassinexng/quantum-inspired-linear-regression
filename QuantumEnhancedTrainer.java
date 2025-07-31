import java.util.*;

public class QuantumEnhancedTrainer {

    /**
     * Quantum-inspired regression trainer using superposition and tunneling.
     * This version avoids rewriting the gradient descent logic, and instead
     * wraps around the existing gradientdescent class in a smarter way.
     */
    public static gradientdescent.gradientdescentResult trainWithQuantumBoost(
        double[][] X,
        double[] y,
        double learningRate,
        int iterations,
        int numStates,
        MemoryBank memoryBank
    ) {
        int nFeatures = X[0].length;

        // We use a list to mintain multiple (w, b) candidate states (superposition)
        List<double[]> weightsList = new ArrayList<>();
        List<Double> biasList = new ArrayList<>();

        for (int i = 0; i < numStates; i++) {
            weightsList.add(new double[nFeatures]);
            biasList.add(0.0);
        }

        double[] bestWeights = new double[nFeatures];
        double bestBias = 0.0;
        double bestCost = Double.POSITIVE_INFINITY;
        double prevBestCost = bestCost;

        for (int iter = 0; iter < iterations; iter++) {
            // For each quantum state, run one step of gradient descent manually
            for (int i = 0; i < numStates; i++) {
                double[] currentWeights = weightsList.get(i);
                double currentBias = biasList.get(i);

                gradientdescent.gradientdescentResult result = gradientdescent.singleStep(
                    X, y, currentWeights, currentBias, learningRate
                );

                weightsList.set(i, result.getWeights());
                biasList.set(i, result.getBias());

                double currentCost = costcalculator.costfunction(X, y, result.getWeights(), result.getBias());

                if (currentCost < bestCost) {
                    bestCost = currentCost;
                    bestWeights = Arrays.copyOf(result.getWeights(), nFeatures);
                    bestBias = result.getBias();
                }

                memoryBank.add(result.getWeights(), currentCost);
            }

            // Tunneling: if we're stuck, shake up the states
            if (Math.abs(bestCost - prevBestCost) < 1e-6) {
                for (int i = 0; i < numStates; i++) {
                    double[] tunneledWeights = performSimpleTunneling(weightsList.get(i), 0.1);
                    weightsList.set(i, tunneledWeights);
                    biasList.set(i, 0.0); // optional reset
                }
            }

            prevBestCost = bestCost;
        }

        return new gradientdescent.gradientdescentResult(bestWeights, bestBias, new double[0]);
    }

    // Simple tunneling: random noise in [-scale, +scale] using Math.random()
    private static double[] performSimpleTunneling(double[] weights, double scale) {
        double[] newWeights = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            double noise = (Math.random() * 2 - 1) * scale;
            newWeights[i] = weights[i] + noise;
        }
        return newWeights;
    }
}
