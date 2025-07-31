import java.util.*;

//The memorybank's role is quite simple: we store the weights and bias of the best performing parameter sets, during the training set.

public class MemoryBank {
    private final LinkedList<MemoryQuantumState> memories = new LinkedList<>();
    private final int capacity;

    public MemoryBank(int capacity) {
        this.capacity = capacity;
    }

    public void add(double[] params, double cost) {
        double amplitude = 1.0 / (cost + 1e-8); 
        //1e-8 is a very small number added to the denominator just in case the cost is exactly 0
        // a lower cost (a better solution) should have a higher influence( a higher amplitude)
        
        memories.addFirst(new MemoryQuantumState(params, amplitude));
        //we simply bundle 'params' and its calculated amplitude in the new 'MemoryQuantumState' object
        if (memories.size() > capacity) {
            memories.removeLast();
            //Checking on the list's size to see if it's overgrown its original maximum size. if it did we remove the end of the list containing the oldest state
        }
    }

    public List<MemoryQuantumState> getMemories() {
        return Collections.unmodifiableList(memories);
    }
}
