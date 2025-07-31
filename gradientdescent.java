import java.util.Arrays;

public class gradientdescent {

// Inner class to hold the results of the gradient descent process
public static class gradientdescentResult {
    private double[] weights;
    private double bias;
    private double[] costHistory;

    public gradientdescentResult(double[] weights, double bias, double[] costHistory) {
        this.bias = bias;
        this.weights = Arrays.copyOf(weights, weights.length);
        this.costHistory = Arrays.copyOf(costHistory, costHistory.length);
    }

    public double[] getWeights() {
        return Arrays.copyOf(weights, weights.length);
    }

    public double getBias() {
        return bias;
    }

    public double[] costHistory() {
        return Arrays.copyOf(costHistory, costHistory.length);
    }
}

// Full gradient descent over multiple iterations
public static gradientdescentResult gradientDescent(double[][] X, double[] y, double learningRate, int iterations) {
    if (X == null || y == null) {
        throw new IllegalArgumentException("Error: Input features (X) and target values (y) cannot be null.");
    }
    if (X.length == 0 || y.length == 0) {
        throw new IllegalArgumentException("Error: Input features (X) and target values (y) cannot be empty.");
    }
    if (X.length != y.length) {
        throw new IllegalArgumentException("Error: Number of examples in X (" + X.length + ") and y (" + y.length + ") must match.");
    }
    if (learningRate <= 0) {
        throw new IllegalArgumentException("Error: Learning rate must be positive. Provided: " + learningRate);
    }
    if (iterations <= 0) {
        throw new IllegalArgumentException("Error: Number of iterations must be positive. Provided: " + iterations);
    }

    int nFeatures = X[0].length;
    double[] w = new double[nFeatures];
    double b = 0.0;
    int m = X.length;
    double[] costHistory = new double[iterations];

    for (int i = 0; i < iterations; i++) {
        prediction predictor = new prediction(w, b);
        double[] fwbPredictions = new double[m];

        for (int j = 0; j < m; j++) {
            fwbPredictions[j] = predictor.predict(X[j]);
        }

        double[] dj_dw = new double[nFeatures];
        double dj_db_sum = 0.0;

        for (int j = 0; j < m; j++) {
            for (int k = 0; k < nFeatures; k++) {
                dj_dw[k] += (fwbPredictions[j] - y[j]) * X[j][k];
            }
            dj_db_sum += (fwbPredictions[j] - y[j]);
        }

        for (int k = 0; k < nFeatures; k++) {
            dj_dw[k] /= m;
        }
        double dj_db = dj_db_sum / m;

        for (int k = 0; k < nFeatures; k++) {
            w[k] -= learningRate * dj_dw[k];
        }
        b -= learningRate * dj_db;

        double currentcost = costcalculator.costfunction(X, y, w, b);
        costHistory[i] = currentcost;
    }

    return new gradientdescentResult(w, b, costHistory);
}

// Single-step gradient descent for each state existing in QuantumEnhancedTrainer
public static gradientdescentResult singleStep(double[][] X, double[] y, double[] w, double b, double learningRate) {
    int m = X.length;
    int n = X[0].length;
    double[] dj_dw = new double[n];
    double dj_db_sum = 0.0;

    prediction predictor = new prediction(w, b);
    for (int i = 0; i < m; i++) {
        double pred = predictor.predict(X[i]);
        
        dj_db_sum += pred - y[i];
        for (int j = 0; j < n; j++) {
            dj_dw[j] = dj_dw[j] + ( pred - y[i] )* X[i][j];
        }
    }

    for (int j = 0; j < n; j++) dj_dw[j] /= m;
    double dj_db = dj_db_sum / m;

    double[] newW = Arrays.copyOf(w, w.length);
    for (int j = 0; j < n; j++) newW[j] -= learningRate * dj_dw[j];
    double newB = b - learningRate * dj_db;

    return new gradientdescentResult(newW, newB, new double[0]);
    //The very same previous gradient descent algorrithn, but for different steps.
}


}
