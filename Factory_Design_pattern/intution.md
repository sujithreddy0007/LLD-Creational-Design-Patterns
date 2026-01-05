# Factory Design Pattern

## 📖 Definition
The **Factory Design Pattern** is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

It promotes **loose coupling** by removing the direct instantiation of specific classes from the client code. Instead of the client using the `new` keyword, it asks a "Factory" to provide the required instance.



---

## 💡 The Intuition
Think of a **Toy Factory**:

* **The Problem:** If you want a toy car, you shouldn't have to build the engine, mold the plastic, and paint the wheels yourself. You shouldn't need to know the complex manufacturing details of a car vs. a doll vs. a puzzle.
* **The Solution:** You go to the factory outlet and say, *"I want a Car."* The factory handles the internal logic of which materials to use and which machines to run, and simply hands you the finished toy.

In software, the `VehicleFactory` is that outlet. The `Client` doesn't care how a `Truck` is built; it just wants a `Vehicle` that can `start()` and `stop()`.

---

## 🌍 Real-World Example: Vehicle Management System
Imagine a transportation logistics application that needs to handle different types of transport methods.

### Without a Factory (Tight Coupling)
The client code would be littered with:
`Vehicle v = new Car();` or `Vehicle v = new Truck();`
If the constructor of `Truck` changes (e.g., you now need to pass a "MaxLoad" parameter), you have to find and change every single place in your entire project where you wrote `new Truck()`.

### With a Factory (Encapsulation)
The logic for "which object to create" is centralized. The client only interacts with the `Vehicle` interface and the `VehicleFactory`. If you add a new vehicle type, like `ElectricScooter`, you only update the factory logic; the client code remains untouched.



---

## 🛠️ Implementation Logic
To implement the Factory Pattern, follow these steps:

1.  **Define a Common Interface:** Create an interface (e.g., `Vehicle`) that all concrete products will implement.
2.  **Create Concrete Products:** Implement the interface in various classes (e.g., `Car`, `Bike`, `Truck`).
3.  **Build the Factory:** Create a class (`VehicleFactory`) with a static method that takes an input (like a String or Enum) and returns an instance of the interface.
4.  **Use the Factory:** The `Client` calls the factory method to get objects, treating them as the interface type rather than the concrete type.

---

## ✅ Benefits of this Implementation
* **Abstraction:** The client is shielded from the complexities of object creation.
* **Open/Closed Principle:** You can introduce new vehicle types without breaking existing client code.
* **Centralization:** All instantiation logic is in one place, making the code much easier to maintain and debug.
* **Consistency:** Ensures that objects are created correctly with all necessary initializations every single time.

---