CS95 Syllabus
---

---

**Prerequisites:** CS107 (or equivalent experience), students accepted by application

**Course Goals:**
- Explore benefits of immutability and functional programming (in contrast with stateful object-oriented programming)
  - Complexity
  - Concurrency
  - Testability
- Explore the power of Lisp
  - Macros
  - Flexibility among read time vs. compile time vs. runtime.
  - `(loop (print (eval (read)))`
- Interop with libraries written in host VM
  - Leverage all existing Java/Javascript libraries from Clojure

**NOTE: SYLLABUS BELOW WILL BE UPDATED BEFORE COURSE BEGINS**

Items 1 through 10 below represent each week of the quarter. There will be two 80 minute classes per week: a lecture and a lab session. The lab sessions will serve as a time to put lecture material into practice.

1. Introduction

    - What's Clojure?
        - High level overview - a Lisp designed to run on a VM
            - Java
            - JavaScript
            - .Net
        - What's Lisp?
            - Homoiconicity, S-expressions
            - Code is data!
            - Readings:
                - http://www.paulgraham.com/avg.html
                - http://www.paulgraham.com/diff.html
    - Why Clojure?
        - **Immutability** and **Functional Programming**
            - **Simplicity**
            - **Concurrency**
            - **Testability**
        - Lisp
            - Live Programming!!!
            - Flexibility
            - Power
            - Focus
        - Cool libraries written in Clojure
            - Overtone
            - Instaparse
            - core.async
            - core.logic
            - Onyx
            - Apache Storm
            - Riemann
            - Om next/reagent/re-frame/re-natal!!!!

    - Lab: Environment setup
        - Get leiningen
        - Start the REPL
        - Get started with LightTable, emacs, or vim
        - Play with Clojure and learn to use the REPL!

2. Welcome to Clojure

    - Basics
        - Data Structures
        - Defining functions
        - Control flow
        - Scope
        - Destructuring
        - Namespaces (bleeds into lab)
    - Clojure builtins
        - Programming to the *sequence abstraction*! (using truly polymorphic dispatch!)
            - `map`, `filter`, `reduce`, `some`, `first`, `rest`, `cons`, `conj` etc. work on vectors, maps, lists, and anything else that implements the sequence interface
        - Lazy sequences
            - `take`, `drop`, `take-while`, `drop-while`
        - Namespaces
        - References:
            - Core Library Cheatsheet: http://cljs.info/cheatsheet/
            - Exercises: https://www.4clojure.com/problems

    - Lab session!
        - Solve simple problems during class

    - **First Problem Set** on Clojure Basics. Due Friday of week 3.

3. Functional Programming

    - Concepts:
        - Simplicity:
            - "It is better to have 100 functions operate on one data structure than to have 10 functions operate on 10 data structures." - Alan J. Perlis
        - Pure functions and side effects
        - Immutability
        - Recursion!
        - Function composition
        - Higher order functions
        - Interactive code example! (Using [devcards](https://github.com/bhauman/devcards)!)
            - Pegthing

    - Lab
        - Work on a problem set during class, **introduce final project** (implement one of the following board games in Clojure!)
            - Settlers of Catan
            - Chess/Go/XiangQi

    - **Second Problem Set** on Functional Programming basis. Due Friday of week 5.

4. Bottom-Up Programming

    - A data-first approach to development
        - Store full application state in an atom
        - Design full application state for game as nested data structure
        - Build state with simple, atomic functions
        - Compose and combine functions to initialize game state.
        - Create simple functions to query application state and change application state.
        - Create a set of top level functions that constitute a state transition in the game.
        - Mock, stub, and test as you go along! Use the REPL to its fullest! Be sure that your program works!

    - Lab: get started on your final projects
    - Example:
        - [https://github.com/markbastian/pirates](https://github.com/markbastian/pirates)

5. Lisp!

    - Reading
        - `(loop (print (eval (read))))`
    - Evaluation
        - "There is no real distinction between read-time, compile-time, and runtime. You can compile or run code while reading, read or run code while compiling, and read or compile code at runtime. Running code at read-time lets users reprogram Lisp's syntax; running code at compile-time is the basis of macros; compiling at runtime is the basis of Lisp's use as an extension language in programs like Emacs; and reading at runtime enables programs to communicate using s-expressions, an idea recently reinvented as XML."

    - Lab: examples of macros!

    - **Third PSET** on bottom-up, data-driven application design and writing macros. Due Friday week 7.

6. More Lisp: Macros!

    - Anatomy of a macro
        - `macroexpand` and `macroexpand-1`
    - How to write macros
        - Backquote
        - Gensym
        - Implicit args
    - Common traps
    - Idiomatic macros
    - When should I use macros?
    - examples of macros in Clojure core
        - The whole threading family: `->`, `->>`, `cond->`, `some->`, `as->` etc

    - Lab: create user macros
        - `unless`, `with-subs`, `rotatef`

7. Concurrency!

    - Simplicity of Clojure: State, Value, and Identity
    - Delays, Futures, Promises
    - "Basic" parallelism ala pmap
    - Atoms
        - Notifications - Watches / Validators
    - Refs - Software Transactional Memory
    - Interop with Java primitives

    - Lab: Bitcore and BitcoinJ interop!

    - **Fourth PSET** on immutable data and concurrency! Due Friday of week 9.

8. More concurrency: core.async!

    - C.A.R Hoare: [Communicating Sequential Processes](http://spinroot.com/courses/summer/Papers/hoare_19-pdf)!
    - Today, software components expose asynchronous APIs for consumers
        - core.async makes handling asynchronous APIs in a concurrent manner painless!
    - Watch [Stuart Halloway’s talk](http://www.infoq.com/presentations/core-async) on core.async

    - Lab: Walk through core.async examples

9. Interop and compilers!

    - Java
        - Calling Java from Clojure
        - Calling Clojure from Java
    - Javascript
        - Google Closure Modules
        - Calling Javascript from Clojure
        - Calling Clojure from Javascript
        - Externs!
    - How to interop mutable, outside code with Clojure
    - Tips and tricks for a smoother interop experience
    - Design APIs around data if possible! (e.g. not around chained function calls that return objects!) This is the Clojure way.

    - Lab: work on final projects

10. Wrapping up

    - A deeper look at awesome Clojure projects in the wild OR an airing of the most famous Clojure talk ever given: [Simple Made Easy](http://www.infoq.com/presentations/Simple-Made-Easy)
    - **Project presentations!**

