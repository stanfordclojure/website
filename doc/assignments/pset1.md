# CS95 &mdash; Functional Programming in Clojure

### Assignment 1: An Introduction to Clojure

Instructions:

- First, clone the skeleton project from [here](/assignments/pset1.zip).
- Implement your solutions as functions in the `pset1/src/pset1` directory.  For example, your solution to problem 1 will be written in the `pset1/src/pset1/1_half_truth.clj` file.
- Verify that your solutions pass the tests by running `lein test` in your project directory.
- Email your code as a compressed archive (`.zip`) to `stanfordclojure@gmail.com`.

#### Problem 1

Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.  For example:

```clojure
(= true (half-truth true false))
(= false (half-truth true true))
```

#### Problem 2

Write a function which calculates the least common multiple. Your function should accept a variable number of positive integers or ratios. For example:

```clojure
(= (lcm 5 3 7) 105)
(= (lcm 3/4 1/6) 3/2)
```

#### Problem 3

[Pascal's triangle](https://en.wikipedia.org/wiki/Pascal%27s_triangle) is a triangle of numbers computed using the following rules:

- The first row is 1.
- Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.

Write a function which returns the nth row of Pascal's Triangle.  For example:

```clojure
(= (pascal 11)
   [1 10 45 120 210 252 210 120 45 10 1])
```

#### Problem 4

Determine the best poker hand that can be made with five cards.  Write functions to identify each of the following poker hands:

**4.1**: Straight flush: All cards in the same suit, and in sequence

**4.2**: Four of a kind: Four of the cards have the same rank

**4.3**: Full House: Three cards of one rank, the other two of another rank

**4.4**: Flush: All cards in the same suit

**4.5**: Straight: All cards in sequence (aces can be high or low, but not both at once)

**4.6**: Three of a kind: Three of the cards have the same rank

**4.7**: Two pair: Two pairs of cards have the same rank

**4.8**: Pair: Two cards have the same rank

**4.9**: High card: None of the above conditions are met

&mdash;

**4.10**: Write a function, `best-poker-hand`, that uses 4.1 - 4.9 to identify the best possible poker hand.

For example:

```clojure
(= :straight-flush (best-poker-hand ["HA" "HK" "HQ" "HJ" "HT"]))
```

#### Bonus Problem

The `comp` function in `clojure.core` takes in a set of functions and returns a function that is a composition of those functions.  More formally, applying `comp` on the functions `f1, f2, ..., fn` creates a new function `g` such that

```
g(x1, x2, ..., xn) = f1(f2(...(fn(x1, x2, ..., xn)))).
```

Implement your own version of `comp`.  Hint: Read [this section of Clojure for the Brave and True](http://www.braveclojure.com/functional-programming/#comp).

For example:
```clojure
(def negative-product (my-comp - *))
(negative-product 2 3)  ;;=> -6
```

(Problem source: 4Clojure)
