# Builder Design Pattern

## 📖 Definition
The **Builder Design Pattern** is a creational pattern that lets you construct complex objects step by step. Unlike other creational patterns, the Builder doesn't require products to have a common interface. This makes it possible to produce different types and representations of an object using the same construction process.

It solves the problem of "Telescoping Constructors" (having too many constructors for different combinations of parameters) by providing a clean, fluent API for object creation.



---

## 💡 The Intuition
Think of **Ordering a Custom Pizza**:

* **The Problem:** A pizza can have dozens of toppings. If you used a standard constructor, you would need one for `Pizza(dough, sauce)`, another for `Pizza(dough, sauce, cheese)`, another for `Pizza(dough, sauce, cheese, pepperoni)`, and so on. This becomes unmanageable very quickly.
* **The Solution:** You use a "Builder." You start with a base pizza and tell the chef:
    1. "Add thin crust."
    2. "Add tomato sauce."
    3. "Add extra cheese."
    4. "Now, bake it (build)."
* You only specify the parts you actually want, and the rest stay at their default values.

---

## 🌍 Real-World Example: Car Manufacturing
When buying a car, there are hundreds of options (engine type, color, seats, sunroof, GPS). 

### Without the Builder Pattern
You would have a massive, confusing constructor like this:
`Car myCar = new Car("V8", 4, 5, "Red", true, false, true, false, ...);`
It is almost impossible to remember which `boolean` represents the sunroof and which one represents the navigation system.

### With the Builder Pattern
The construction becomes fluent and readable:
`Car myCar = new CarBuilder().setEngine("V8").setColor("Red").setSunroof(true).build();`
The code clearly describes **what** is being set, and you can skip the optional features you don't need.



---

## 🛠️ Implementation Logic
To implement the Builder pattern, your code follows these steps:

1.  **Private Constructor:** The `Car` constructor is private, so it cannot be instantiated directly from outside.
2.  **Static Nested Builder:** A static class `CarBuilder` is placed inside the `Car` class. It contains the same fields as the `Car`.
3.  **Fluent Setters:** Each setter method in the builder returns `this` (the builder instance). This allows for **Method Chaining**.
4.  **The Build Method:** The `build()` method calls the private `Car` constructor, passing the builder instance itself (`this`) to transfer all the configured values.

---

## ✅ Benefits of this Implementation
* **Readability:** The client code looks like a configuration script rather than a cryptic list of arguments.
* **Immutability:** Since the `Car` is created only after all parameters are set and has no setters itself, it can be made immutable (thread-safe).
* **Parameters Handling:** It handles optional parameters gracefully without requiring multiple constructors.
* **Error Prevention:** It reduces the risk of passing the wrong value to a constructor (e.g., swapping `seats` and `wheels` because they are both integers).

---