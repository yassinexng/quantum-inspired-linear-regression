import java.util.*;

public class MemoryBank {
    private final LinkedList<MemoryQuantumState> memories = new LinkedList<>();
    private final int capacity;

    public MemoryBank(int capacity) {
        this.capacity = capacity;
    }

    public void add(double[] params, double cost) {
        double amplitude = 1.0 / (cost + 1e-8);  // better cost = higher amplitude, since it means the error is lower
        memories.addFirst(new MemoryQuantumState(params, amplitude));
        if (memories.size() > capacity) {
            memories.removeLast();
        }
    }

    public List<MemoryQuantumState> getMemories() {
        return Collections.unmodifiableList(memories);
    }
}
