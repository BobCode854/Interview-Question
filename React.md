
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

```
# 6️⃣ How do you handle async operations in React?
Ways

useEffect with async logic

Libraries like React Query

Best Practices

Clean up async process on unmount

Handle loading and error states

Avoid setting state on unmounted component

7️⃣ What is Redux?

Redux is a predictable state management library used for managing global state.

When to Use Redux

Complex state shared across many components

Large applications

Global state management

8️⃣ Core Concepts of Redux
Store

Single source of truth for application state.

Actions

Plain JavaScript object describing what happened

{ type: "INCREMENT" }
Reducers

Pure functions that update state.

Characteristics

Takes previous state + action

Returns new state

Never mutate existing state

9️⃣ Redux Flow
User Interaction
      ↓
Dispatch Action
      ↓
(Optional) Middleware
      ↓
Reducer (calculates new state)
      ↓
Store saves new state
      ↓
UI re-renders
🔟 Redux Example
actionTypes.js
export const INCREMENT = 'counter/increment';
export const DECREMENT = 'counter/decrement';
export const RESET = 'counter/reset';
actions.js
import { INCREMENT, DECREMENT, RESET } from './actionTypes';

export const increment = () => ({ type: INCREMENT });
export const decrement = () => ({ type: DECREMENT });
export const reset = () => ({ type: RESET });
reducer
const initialState = { value: 0 };

function counterReducer(state = initialState, action) {
  switch (action.type) {
    case 'counter/increment':
      return { value: state.value + 1 };
    case 'counter/decrement':
      return { value: state.value - 1 };
    case 'counter/reset':
      return { value: 0 };
    default:
      return state;
  }
}

export default counterReducer;
store.js
import { createStore } from 'redux';
import counterReducer from './counterReducer';

const store = createStore(counterReducer);

export default store;
Dispatch Actions
import store from './store.js';
import { increment, decrement, reset } from './actions.js';

console.log(store.getState());

store.dispatch(increment());
console.log(store.getState());

store.dispatch(increment());
console.log(store.getState());

store.dispatch(decrement());
console.log(store.getState());
11️⃣ useEffect vs useLayoutEffect
useEffect

Runs asynchronously after render

Used for API calls, subscriptions

useLayoutEffect

Runs synchronously after DOM mutation

Used for DOM measurements or layout updates

12️⃣ Lazy Loading in React

Lazy loading loads components only when needed to reduce bundle size.

import React, { lazy, Suspense } from 'react';

const HeavyComponent = lazy(() => import("./HeavyComponent"));

function App() {
  return (
    <div>
      <Suspense fallback={<div>Loading...</div>}>
        <HeavyComponent />
      </Suspense>
    </div>
  );
}
13️⃣ React Lifecycle Methods
Class Component Lifecycle
Mounting

constructor() → initialize state

render() → render JSX

componentDidMount() → API calls, subscriptions

Updating

shouldComponentUpdate()

render()

componentDidUpdate()

Unmounting

componentWillUnmount()

Functional Component Equivalent
useEffect(() => {
  // componentDidMount

  return () => {
    // componentWillUnmount
  };
}, []);
14️⃣ useMemo

Optimizes expensive calculations.

Recalculates only when dependencies change

Improves performance

15️⃣ useCallback

Memoizes functions.

Returns same function reference

Only changes when dependencies change

16️⃣ Prevent Unnecessary Re-renders

Techniques:

React.memo

useMemo

useCallback

17️⃣ Context API

Allows sharing data without prop drilling.

const UserContext = React.createContext();

function App() {
  const [user, setUser] = useState({ name: "John", role: "admin" });

  return (
    <UserContext.Provider value={{ user, setUser }}>
      <Header />
      <Main />
    </UserContext.Provider>
  );
}

function Profile() {
  const { user, setUser } = useContext(UserContext);
}
18️⃣ Other Important React Interview Topics

Custom Hooks

HOC (Higher Order Component)

Controlled vs Uncontrolled Components

Pure Functions

Keys in List Rendering

Reconciliation

Context vs Props

19️⃣ Sequential API Calls Example
async function callApisInOrder() {
  try {
    const res1 = await fetch("/api/1");
    const data1 = await res1.json();

    const res2 = await fetch(`/api/2?value=${data1.someField}`);
    const data2 = await res2.json();

    const res3 = await fetch(`/api/3?value=${data2.otherField}`);
    const data3 = await res3.json();

    console.log("All done:", [data1, data2, data3]);
  } catch (err) {
    console.error("API call failed:", err);
  }
}

useEffect(() => {
  callApisInOrder();
}, []);
20️⃣ Parallel API Calls (Promise.all)
const data1 = await fetch("/api/1").then(r => r.json());

const [d2, d3, d4, d5] = await Promise.all([
  fetch(`/api/2?x=${data1.x}`).then(r => r.json()),
  fetch(`/api/3?x=${data1.x}`).then(r => r.json()),
  fetch(`/api/4?x=${data1.x}`).then(r => r.json()),
  fetch(`/api/5?x=${data1.x}`).then(r => r.json())
]);
21️⃣ Context vs Redux
1. Complexity
Context

Easy setup

Minimal boilerplate

Good for small apps

Redux

More setup

Best for large apps

2. Performance
Context

Re-renders all consumers when value changes

Redux

Selective updates

Better for frequently changing data

3. Async Logic
Context

No middleware support

Async handled manually

Redux

Middleware ecosystem

redux-thunk

redux-saga

redux-observable

📌 Rule of Thumb

Use Context

Small/medium apps

Rarely changing state

Use Redux

Large applications

Complex global state

Frequent updates
