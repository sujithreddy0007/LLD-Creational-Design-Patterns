# Abstract Factory Design Pattern

## 📖 Definition
The **Abstract Factory Pattern** is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. 

In your implementation, it acts as a **Factory of Factories**. Instead of a single class handling all logic (like a Simple Factory), we define an interface for the Factory itself, allowing different concrete factories to produce specific types of products.



---

## 💡 The Intuition
Think of **Global Car Franchises**:

* **The Problem:** A car brand like Toyota or BMW has different manufacturing standards and parts. If one massive factory in the world tried to build every single brand's car in one room, the logic would be chaotic and impossible to manage.
* **The Solution:** We create a "Standard Manufacturing Protocol" (the `VehicleFactory` interface). Then, we build a **BMW Factory**, a **Toyota Factory**, and a **Honda Factory**. 
    * If you want a BMW, you go to the BMW Factory. 
    * If you want a Honda, you go to the Honda Factory.
    * Both factories follow the same protocol, but they produce different "Brands" of vehicles.

---

## 🌍 Real-World Example: Multi-Brand Dealership
Imagine you are building a system for a dealership that sells luxury and economy cars.

### Without Abstract Factory
You would have a giant `switch` statement that checks `if (type == "BMW") return new BMW()`. Every time the dealership gets a new brand contract, you have to modify that core logic, risking breakage.

### With Abstract Factory
The dealership (Client) just holds a reference to a `VehicleFactory`. If the dealership decides to sell Toyotas today, it plugs in the `ToyotaFactory`. The rest of the system doesn't need to change because it only cares that it's getting a `Vehicle` from a `VehicleFactory`.



---

## 🛠️ Implementation Logic
To implement this pattern, you follow a tiered abstraction:

1.  **Product Interface:** Define what the product does (`Vehicle` with `start()` and `stop()`).
2.  **Concrete Products:** Create specific implementations (`BMW`, `Honda`, `Toyota`).
3.  **Factory Interface:** Define a contract for creating products (`VehicleFactory` with `createVehicle()`).
4.  **Concrete Factories:** Create a factory for each specific brand (`BMWFactory`, `ToyotaFactory`).
5.  **Client:** The client code interacts only with the interfaces. It chooses a factory and receives a product, remaining completely unaware of the concrete classes being used.

---

## ✅ Benefits of this Implementation
* **Open/Closed Principle:** You can add new brands (e.g., `Tesla` and `TeslaFactory`) without modifying any existing code.
* **Loose Coupling:** The client code is not "married" to specific brands. It works with any factory that implements the interface.
* **Single Responsibility:** The creation logic for each brand is isolated in its own dedicated factory class.
* **Consistency:** It ensures that the products created by a factory are compatible with each other (e.g., a BMW factory always produces a BMW).

---