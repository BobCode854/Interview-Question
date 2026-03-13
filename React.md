
# React Interview Questions

---

## 1️⃣ What are Props?

**Props** are read-only data passed from a **parent component to a child component**. They make components reusable and dynamic. :contentReference[oaicite:0]{index=0}

### Key Points
- Props are **immutable (read-only)**.
- Passed as **attributes in JSX**.
- Accessed using `props.propertyName`.
- Can pass **any data type** (string, number, object, array, function, component).

---

## 2️⃣ What is State?

**State** is a built-in object that stores component data that can **change over time**.  
When the state changes, the component **re-renders** to reflect the updated UI. :contentReference[oaicite:1]{index=1}

### Key Points
- State is **mutable** (can change).
- State is **local to the component**.
- Use **`useState` hook** in functional components.
- Never mutate state directly — always use `setState` or `setSomething`.

---

## 3️⃣ Difference Between State and Props

| Feature | Props | State |
|------|------|------|
| Mutability | Immutable | Mutable |
| Source | Parent component | Component itself |
| Re-render | When parent changes props | When `setState` or state update occurs |
| Access | Read-only | Read & Write |

---

# 4️⃣ What is `useRef` Hook?

`useRef` creates a **mutable reference** that persists across renders.

### Common Uses
- Access DOM elements
- Store mutable values without causing re-renders

### Key Points
- Returns an object with `.current`
- Changing `.current` **does NOT trigger re-render**
- Useful for **DOM manipulation**

### When to Use
- Access DOM element directly
- Store mutable values that don't trigger render
- Integrate with **3rd-party DOM libraries**

### When NOT to Use
- Data that should trigger UI updates
- Anything that can be done declaratively

---

# 5️⃣ How do you make API calls in React?

Common ways:
- `fetch`
- `axios`
- Custom hooks
- React Query

### Example (fetch)

```javascript
useEffect(() => {
  fetch("api")
    .then(response => {
      if (!response.ok) throw new Error("Failed");
      return response.json();
    })
    .then(data => {
      setUser(data);
      setLoading(false);
    })
    .catch(err => {
      setError(err.message);
      setLoading(false);
    });
}, []);
