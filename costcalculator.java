
//it's the cost function: 1/(2*m) * the sum of (fw,b(xi) - yi)
public class costcalculator {
    
    public static double costfunction(double[][] X, double[] y, double[] w, double b) {
        if(X == null || y == null || w == null) {
            throw new IllegalArgumentException("Error: Input and target values cannot be null.");
        }
        if(X.length == 0 || X.length != y.length) {
            throw new IllegalArgumentException("Error: inpu correct values.");
        }
        if(w.length == 0 ) {
            throw new IllegalArgumentException("Error: weights aren't corect.");
        }
        int m = X.length;
        double costSum = 0.0;
        prediction predictor = new prediction(w, b);

        for(int i = 0; i< m;i++) {
            

            double actualprediction = predictor.predict(X[i]);
            double sum = Math.pow( (actualprediction - y[i]), 2);
            costSum += sum;
        }
        double totalcost = (1.0) / (2.0 * m) * costSum;
        return totalcost;

    } 
}
