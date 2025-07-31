Quantum-Inspired Linear Regression

This repository implements a quantum-inspired linear regression algorithm, a novel approach that blends principles from quantum mechanics with classical machine learning optimization to address the problem of getting trapped in local minima.
Key Features

    Superposition of States: Explores multiple parameter states in parallel to broaden the search for an optimal solution.

    Quantum Tunneling: Utilizes a stochastic "tunneling" mechanism to help solutions escape local minima.

    Modular Architecture: The project is composed of clear, modular Java classes for easy understanding and extension.

    Detailed Explanation: An accompanying PDF provides a theoretical background and in-depth mathematical insights.

Repository Structure

quantum-inspired-linear-regression/
├── QuantumInspiredLinearRegression.pdf
├── src/
│   ├── Main.java
│   ├── gradientdescent.java
│   ├── QuantumEnhancedTrainer.java
│   ├── MemoryBank.java
│   ├── MemoryQuantumState.java
│   ├── prediction.java
│   └── costcalculator.java
└── README.md

Getting Started

    Clone the repository:

git clone https://github.com/yassinexng/quantum-inspired-linear-regression.git
cd quantum-inspired-linear-regression

    Compile and run from the project root:

javac src/*.java
java -cp src Main

Implementation Details
Core Components

    gradientdescent.java: Implements the traditional batch gradient descent algorithm and a singleStep() method for individual parameter updates.

    QuantumEnhancedTrainer.java: Orchestrates the core quantum-inspired logic. It maintains a "superposition" of multiple parameter vectors and, when a solution plateaus, it applies a "tunneling" mechanism by injecting controlled random noise.

    Memory System (MemoryBank.java, MemoryQuantumState.java): A MemoryBank stores a limited number of the most successful parameter vectors. Each vector is assigned a probabilistic "amplitude" proportional to the inverse of its cost, ensuring better solutions have a higher chance of being retained.

    prediction.java: Implements the fundamental linear prediction function: f_w,b(x)=wcdotx+b.

    costcalculator.java: Computes the Mean Squared Error (MSE) cost function: J(theta)=frac12msum_i=1m(h_theta(x(i))−y(i))2.

Quantum Enhancements

    Superposition: The algorithm maintains a collection of parallel parameter vectors theta_1,theta_2,...,theta_N, allowing it to simultaneously explore different regions of the loss landscape.

    Amplitude Probabilities: Each state in the MemoryBank is assigned an amplitude based on its cost, where P(theta_i)propto1/J(theta_i). This prioritizes states with lower costs.

    Tunneling: When a solution gets stuck in a local minimum, controlled random noise is added to the parameter vector, allowing it to "tunnel" to a new location in the parameter space. The noise is generated using the formula:

double noise = (\text{Math.random()} * 2 - 1) * scale;

This process is repeated for each state that has stopped improving.
About

This project serves as an exploration of how concepts from quantum mechanics can be applied to classical optimization problems. The accompanying PDF provides theoretical background and implementation details.

Contributions and feedback are welcome!
