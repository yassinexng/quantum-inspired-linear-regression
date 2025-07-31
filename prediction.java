
import java.util.Arrays;

public class prediction {

//We simply calculate: fw,b(x) = w*x + b, the prediction function
//However, we have to define the dot product since the weight W and input X  are vectors.
 private double[] weights;
 private double bias;

public prediction(double [] w, double b) {
    if( w == null ) {
        throw new IllegalArgumentException("Error: Weights array is null.");
    }

    this.weights = Arrays.copyOf(w, w.length);
    this.bias = b;
}

private double Dotproduct(double[] vec1, double[] vec2) {
    if(vec1 == null ||  vec2 == null) {
        throw new IllegalArgumentException("Error: A vector is null.");
    }
    if (vec1.length != vec2.length) {
        throw new IllegalArgumentException("Error: Vectors' length aren't the same.");
    }
    double dotproductsum = 0.0;
    for( int i = 0; i < vec1.length; i++) {
        dotproductsum += vec1[i] * vec2[i];
    }
    return dotproductsum;
}

public double predict(double[] x ) {
    if(x == null) {
        throw new IllegalArgumentException("Error: input features are null.");
    }
    if(x.length != weights.length) {
        throw new IllegalArgumentException("Error: check the size of these two vectors.");
    }
double dotproductres = 0.0;

dotproductres = Dotproduct ( this.weights, x);
return dotproductres + this.bias;
}

public double [] getWeights()
{
    return Arrays.copyOf(this.weights, this.weights.length);
}
private double getBias() {
    return this.bias;
}
public void setWeights( double[] newWeights ) {
    if(newWeights == null ) {
        throw new IllegalArgumentException("Error: Vector is empty.");
    }
    if(newWeights.length != this.weights.length) {
        throw new IllegalArgumentException("Error: Vectors' length don't match.");
    }
    this.weights = Arrays.copyOf(newWeights, newWeights.length);
}
public void setBias(double newBias) {
    this.bias = newBias;
}




}

