# Quantum-Inspired Linear Regression

This repository implements a **quantum-inspired linear regression** algorithm, blending principles from quantum mechanics with classical machine learning optimization.

## Key Features
- Custom implementation of quantum-inspired linear regression
- Incorporation of quantum principles:
  - Superposition of parameter states
  - Quantum tunneling escape from local minima
- Detailed mathematical explanations in accompanying PDF
- Ready-to-run with all necessary files included

## Repository Structure
```
quantum-inspired-linear-regression/
├── QuantumInspiredLinearRegression.pdf  # Detailed explanation
├── src/
│   ├── gradientdescent.java            # Batch gradient descent
│   ├── QuantumEnhancedTrainer.java     # Quantum-inspired optimization
│   ├── MemoryBank.java                # Stores parameter vectors
│   ├── MemoryQuantumState.java        # Manages state amplitudes
│   ├── prediction.java                # Linear prediction function
│   └── costcalculator.java            # Cost computation
└── README.md                          # This documentation
```

## Getting Started
1. Clone the repository:
```bash
git clone https://github.com/yassinexng/quantum-inspired-linear-regression.git
cd quantum-inspired-linear-regression
```

2. Compile and run:
```bash
javac src/*.java
java src/QuantumEnhancedTrainer
```

## Implementation Details

### Core Components
- **`gradientdescent.java`**: Implements both:
  - Traditional batch gradient descent
  - Modular `singleStep()` for quantum state updates

- **`QuantumEnhancedTrainer.java`**:
  - Manages swarm of parameter vectors
  - Applies tunneling when stuck: 
    ```java
    double noise = (Math.random() * 2 - 1) * scale;
    ```

- **Memory System** (`MemoryBank.java`, `MemoryQuantumState.java`):
  - Stores top parameter vectors
  - Assigns amplitudes: `1 / cost`

### Mathematical Framework
**Prediction**:
```
f_{w,b}(x) = w·x + b
```

**Cost Function** (MSE):
```
J(θ) = 1/(2m) * Σ (h_θ(x) - y)^2
```

**Quantum Enhancements**:
- Parallel parameter vectors: {θ₁, θ₂, ..., θ_N}
- Amplitude probabilities: P(θ_i) ∝ 1/J(θ_i)

## About
This project explores the intersection of quantum concepts and machine learning. The accompanying PDF provides theoretical background and implementation details.

Contributions and feedback welcome!
