# Quantum-Inspired Linear Regression

This repository implements a quantum-inspired linear regression algorithm, blending quantum mechanics principles with machine learning optimization to address local minima challenges.

## Key Features

- **Superposition of States**: Explores multiple parameter states in parallel for a broader solution search.
- **Quantum Tunneling**: Uses stochastic noise to escape local minima.
- **Modular Architecture**: Organized Java classes for clarity and extensibility.
- **Detailed Explanation**: Includes a PDF with theoretical and mathematical insights.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/yassinexng/quantum-inspired-linear-regression.git
   cd quantum-inspired-linear-regression


Compile and run from the project root:
javac src/*.java
java -cp src Main


Explore the project:

Read QuantumInspiredLinearRegression.pdf for a detailed explanation of the quantum-inspired approach.



Implementation Details
Core Components

gradientdescent.java: Implements batch gradient descent and a singleStep() method for individual parameter updates.

QuantumEnhancedTrainer.java: Manages multiple parameter vectors, applying tunneling via noise when solutions plateau:
double noise = (Math.random() * 2 - 1) * scale;


Memory System (MemoryBank.java, MemoryQuantumState.java): Stores top parameter vectors with amplitudes proportional to 1/cost.

prediction.java: Computes the linear prediction: f_w,b(x) = w * x + b.

costcalculator.java: Calculates the Mean Squared Error (MSE) cost: J(θ) = (1/(2m)) * Σ(h_θ(x_i) - y_i)^2.


Quantum Enhancements

Superposition: Maintains N parallel parameter vectors {θ_1, θ_2, ..., θ_N} to explore the loss landscape.
Amplitude Probabilities: Assigns P(θ_i) ∝ 1/J(θ_i) to prioritize low-cost states.
Tunneling: Adds controlled noise to stuck solutions, enabling jumps to new parameter regions.

About
This project explores quantum-inspired optimization for machine learning. The QuantumInspiredLinearRegression.pdf provides theoretical background and implementation details. Contributions and feedback are welcome!```
