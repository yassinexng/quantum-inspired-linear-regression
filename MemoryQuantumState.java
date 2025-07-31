import java.util.Arrays;

public class MemoryQuantumState {
    public final double[] parameters;
    public final double amplitude;

    public MemoryQuantumState(double[] params, double amplitude) {
        this.parameters = Arrays.copyOf(params, params.length);
        this.amplitude = amplitude;
    }
}
