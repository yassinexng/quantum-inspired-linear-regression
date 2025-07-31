# Quantum-Inspired Linear Regression

This repository implements a quantum-inspired linear regression algorithm, blending ideas from quantum mechanics with gradient descent to overcome optimization challenges like local minima.

---

## 🚀 Features

- **Superposition of States**: Explores multiple parameter vectors in parallel.
- **Quantum Tunneling**: Adds controlled random noise to escape stagnation.
- **Memory Bank**: Stores and reuses high-performing models based on cost.
- **Java Implementation**: Pure Java with no external libraries required.
- **Human-Readable Documentation**: Includes both code and theory in a structured way.

---

## 🧪 How It Works

The core idea is to simulate two key quantum concepts:

### 1. Superposition  
Instead of training just one parameter vector `θ`, we train `N` of them simultaneously. Each evolves separately using gradient descent.

### 2. Quantum Tunneling  
If a state stagnates (its cost doesn't improve), we inject a small amount of random noise:

```java
double noise = (Math.random() * 2 - 1) * scale;
````

This lets the model escape bad local minima, just like a quantum particle can tunnel through a potential barrier.

### 3. Memory Bank

We save the best parameter states so far, with their amplitude (probability of reuse) proportional to `1 / cost`.

---

## 🧠 Core Components

| File                          | Role                                                |
| ----------------------------- | --------------------------------------------------- |
| `gradientdescent.java`        | Main optimization logic + one-step update method    |
| `QuantumEnhancedTrainer.java` | Quantum-inspired training loop w/ noise + memory    |
| `MemoryBank.java`             | Stores best parameter vectors with their cost       |
| `prediction.java`             | Predicts `y = w·x + b`                              |
| `costcalculator.java`         | Computes cost using MSE formula                     |
| `Main.java`                   | Uses hardcoded training data to run both optimizers |

---

## 🏁 How to Run

1. **Open the project**

   Make sure you are in the root folder of the project.

2. **Compile and run**

```bash
javac src/*.java
java -cp src Main
```

This will output weights and bias found by:

* Traditional Gradient Descent
* Quantum-Enhanced Optimization

⚠️ **Note**: The training data is already provided inside `Main.java` as an array. You don't need to load from a CSV.

---

## 🔬 Quantum Enhancements in Simple Terms

* **Superposition**: Keeps N parameter vectors `{θ₁, θ₂, ..., θₙ}` and trains them in parallel.
* **Amplitude-Based Selection**: Best-performing vectors are reused more often:
  `P(θᵢ) ∝ 1 / J(θᵢ)`
* **Tunneling**: If a state gets stuck, we let it jump randomly by adding noise:

```java
double noise = (Math.random() * 2 - 1) * scale;
```

This keeps the model exploring new possibilities even when some solutions are trapped.

---

## 📘 Learn More

Check out [`QuantumInspiredLinearRegression.pdf`](./QuantumInspiredLinearRegression.pdf) for:

* Core quantum mechanics principles (superposition, tunneling)
* Why traditional gradient descent can get stuck
* How this project uses physics ideas to improve ML training

---

## 🤝 Contribute

Suggestions, issues, or pull requests are always welcome!
