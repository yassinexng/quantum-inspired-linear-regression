import java.util.Arrays;
//The simplest class, really. It just stores the parameters and the amplitude. 
public class MemoryQuantumState {
    public final double[] parameters;
    public final double amplitude;

    public MemoryQuantumState(double[] params, double amplitude) {
        this.parameters = Arrays.copyOf(params, params.length);
        this.amplitude = amplitude;
    }
}
