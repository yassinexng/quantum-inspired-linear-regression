import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numSamples = 500;
        int numFeatures = 2;
        double[][] X = new double[numSamples][numFeatures];
        double[] y = new double[numSamples];
        Random rand = new Random();

        // We're gonna use a function that's clearly not linear:
        // y = x1 - x2 + cos(x1) - sin(x2)
        //and we're gonna see the comparison between it and the usual gradient descent
        for (int i = 0; i < numSamples; i++) {
            X[i][0] = rand.nextDouble() * 20;
            X[i][1] = rand.nextDouble() * 20;

            double linearPart = X[i][0] - X[i][1];
            double nonLinearPart = Math.cos(X[i][0]) - Math.sin(X[i][1]);
            double trueY = linearPart + nonLinearPart;
            
            y[i] = trueY + (rand.nextDouble() - 0.5) * 0.5;
        }

        System.out.println("=Traditional Gradient Descent ===");
        try {
            gradientdescent.gradientdescentResult classicResult =
                gradientdescent.gradientDescent(X, y, 0.001, 100000);

            System.out.println("Weights: " + Arrays.toString(classicResult.getWeights()));
            System.out.println("Bias: " + classicResult.getBias());
            System.out.println("Final Cost: " + costcalculator.costfunction(X, y, classicResult.getWeights(), classicResult.getBias()));
        } catch (IllegalArgumentException e) {
            System.err.println("Error in Traditional Gradient Descent: " + e.getMessage());
        }

        System.out.println("\n=Quantum-Enhanced Optimization:");
        int numQuantumStates = 15;
        double quantumLearningRate = 0.001;
        int quantumIterations = 50000;

        MemoryBank memoryBank = new MemoryBank(numQuantumStates);

        try {
            gradientdescent.gradientdescentResult quantumResult =
                QuantumEnhancedTrainer.trainWithQuantumBoost(
                    X, y,
                    quantumLearningRate,
                    quantumIterations,
                    numQuantumStates,
                    memoryBank
                );

            System.out.println("Best Weights: " + Arrays.toString(quantumResult.getWeights()));
            System.out.println("Best Bias: " + quantumResult.getBias());
            System.out.println("Final Best Cost: " + costcalculator.costfunction(X, y, quantumResult.getWeights(), quantumResult.getBias()));

            System.out.println("\nMemory Bank States:");
            for (MemoryQuantumState state : memoryBank.getMemories()) {
                double cost = 1.0 / (state.amplitude + 1e-8);
                System.out.println(String.format("Amplitude = %.4f, Cost = %.4f, Weights = %s",
                                                state.amplitude,
                                                cost,
                                                Arrays.toString(state.parameters)
                                                ));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error in Quantum-Enhanced Gradient Descent: " + e.getMessage());
        }
    }
}
