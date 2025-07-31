import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // We're gonna use a function that's clearly not linear:
        // y = x1 - x2 + cos(x1) - sin(x2)
        //and we're gonna see the comparison between it and the usual gradient descent
        // We make 500 data points with 2 features each
        int totalPoints = 500;
        double[][] inputData = new double[totalPoints][2]; // [x1, x2] for each point
        double[] outputData = new double[totalPoints];     // The Y values
        Random random = new Random();

        // Now onto our dataset:
        for (int i = 0; i < totalPoints; i++) {
            // Here, we generate random x1 and x2 values between 0 and 20
            double x1 = random.nextDouble() * 20;
            double x2 = random.nextDouble() * 20;
            
            // We store them
            inputData[i][0] = x1;
            inputData[i][1] = x2;
            
            // Calculate the parts separately: the linear and nonlinear(wavy) parts
            double linearPart = x1 - x2;           
            double wavePart = Math.cos(x1) - Math.sin(x2); 
            
            //Then, we combine parts and add some small random noise 
            double perfectY = linearPart + wavePart;
            double noisyY = perfectY + (random.nextDouble() - 0.5) * 0.5;
            outputData[i] = noisyY; // now we update the Y values
        }

        // Now for the regular gradient descent:
        System.out.println("Regular Training:");
        try {
            gradientdescent.gradientdescentResult regular = 
                gradientdescent.gradientDescent(inputData, outputData, 0.001, 100000);

            System.out.println("Weights: " + Arrays.toString(regular.getWeights()));
            System.out.println("Bias: " + regular.getBias());
            System.out.println("Final Score: " + 
                costcalculator.costfunction(inputData, outputData, 
                regular.getWeights(), regular.getBias()));
        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }

        //Now for the quantum-inspired version
        System.out.println("\n=== Quantum-Style Training ===");
        MemoryBank memory = new MemoryBank(15); // Remembers 15 good solutions
        
        try {
            gradientdescent.gradientdescentResult quantum =
                QuantumEnhancedTrainer.trainWithQuantumBoost, inputData, outputData, 0.001, 50000, 15, memory );   
            
            // We now show  the best found solution
            System.out.println("Best Weights: " + Arrays.toString(quantum.getWeights()));
            System.out.println("Best Bias: " + quantum.getBias());
            System.out.println("Best Score: " + 
                costcalculator.costfunction(inputData, outputData, 
                quantum.getWeights(), quantum.getBias()));

            //  what we saved in memory
            System.out.println("\nSaved Good Solutions:");
            for (MemoryQuantumState solution : memory.getMemories()) {
                double score = solution.amplitude;
                double error = 1.0 / (score + 0.00000001); // Convert to error
                System.out.println("Goodness: " + String.format("%.4f", score) + 
                                 ", Error: " + String.format("%.4f", error) + 
                                 ", Weights: " + Arrays.toString(solution.parameters));
            }
        } catch (Exception e) {
            System.out.println("Oops! Error: " + e.getMessage());
        }
    }
}
