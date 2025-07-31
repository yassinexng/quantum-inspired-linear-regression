import java.util.*;

public class QuantumEnhancedTrainer {
    
    public static gradientdescent.gradientdescentResult trainWithQuantumBoost(
        double[][] X,
        double[] y,
        double learningRate,
        int iterations,
        int numStates,
        MemoryBank memoryBank
    )
    //This is the main, public method that we would use on the Main.java file. Simply put, it takes all the necessary infortmation for the training process.

    
    {
        //This section sets up the initial conditions. It gets the number of features from the data, then creates a list of weights and bias for each of the numStates.
        
        int nFeatures = X[0].length;

        // We use a list to mintain multiple (w, b) candidate states 
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
        //Each state starts with all weights and the bias set to 0.0. This collection of initial, random starting points is the analogy for "superposition" in quantum mechanics:
        //All states exist simultaneously.
        

        for (int iter = 0; iter < iterations; iter++) {
            // For each quantum state, we run one step of gradient descent manually
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

            //This is the "quantum tunneling" part of the code. It checks for a state of "stagnation," which happens if the bestCost hasn't improved by a significant amount since the last iteration.
            //When stagnation is detected, the algorithm assumes it's stuck in a local minimum. To escape, it calls performSimpleTunneling on all parallel states, which then injects random noise into their weights. 
            //This then forces the states to jump to a new, random location, giving them a chance to find a better, lower-cost region.
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

   //This Method is the actual implementation of the tunneling. It's further explained in the pdf.
    private static double[] performSimpleTunneling(double[] weights, double scale) {
        double[] newWeights = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            double noise = (Math.random() * 2 - 1) * scale;
            newWeights[i] = weights[i] + noise;
        }
        return newWeights;
    }
}
