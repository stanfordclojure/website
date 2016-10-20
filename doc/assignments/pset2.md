# CS95 &mdash; Functional Programming in Clojure

### Assignment 2: Implementing Texas Hold 'em Poker

**Note:** There are two parts to this assignment!
- Part 1 is due October 27th.
- Part 2 is due November 8th.

Instructions:

- First, clone the skeleton project from [github](https://github.com/stanfordclojure/poker).
- Implement your solution as functions in the `src/poker` directory.
- Email your code as a compressed archive (`.zip`) to
    `stanfordclojure@gmail.com`.

We will be implementing the Texas Hold 'em variation of poker.  See
[here](https://www.partypoker.com/how-to-play/texas-holdem.html) for a
description of the rules.

### PART 1:

We have provided an outline below that highlights some of the key functions you
will need to implement. Think of these as guidelines and feel free to structure
your code differently. Also consider organizing your code into logical separate
namespaces.

Your final submission should be a full implementation of the core game logic,
containing at least the functionality listed below.

#### 1: Initializing Card Data
We will represent a card as a string whose first character is the suit and
second character is the rank. For example, the five of diamonds would be
represented as "D5". For ranks greater than 9, we will use "T", "J", "Q", "K",
and "A" to represent 10, jack, queen, king, and ace respectively.

1.1: Create a data literal containing all of the cards in the standard 52-card
deck.

1.2: Implement a function, `card->suit`, that obtains the suit from a card
string.

1.3: Implement a function, `card->rank`, that obtains the rank from a card
string.

1.4: Create a map associating each rank to its numerical value. For example, "T"
maps to the integer 10, and "Q" maps to 12.

#### 2: Modeling Game State

Now, we will proceed to model the poker game state. Start by outlining what key
pieces of information we will need to store.

2.1: Implement a function `draw`, that draws `n` cards from the deck.

2.2: Implement a function `init-players`, to create maps of the state
associated with each player. Define a constant, `starting-chips` (set this to
1000), representing the number of starting chips that each player receives.

2.3: Implement a function `init-hands`, to initialize the hands of each player.
Recall that at the beginning of the game, each player is dealt 2 cards.

2.4: Implement a function `init-game-state`, that calls the previous two
functions to construct a map that represents the initial game state.

### PART 2:

#### 3: Gameplay

We will now implement a series of functions that model the logic of poker
gameplay. We will proceed in "bottom-up" style, implementing composable
functions that transform data representing game state.

3.1: Write a function, `wager` that makes player `p` wager `n` chips.  This
should handle both the check and raise actions. Define a constant, `min-wager`
(set this to 10), that represents the minimum of number of chips that must be
wagered by each player.

(Note that in real games this is handled a little differently, where forced bets
rotate around the table. See <a href="https://en.wikipedia.org/wiki/Blind_(poker)">here</a> for more details.
For simplicity, we will require that each player wager a minimum number of chips
at each turn.)

3.2: Write a function, `fold`, that makes player `p` forfeit the current
showdown and avoid contributing more to the pot.

3.3: Write a function, `best-poker-hand`, that determines the best poker hand
that can be made with five cards. This was problem 4 in [assignment
1](https://stanfordclojure.com/#/assignments/pset1).

3.4: Write a function, `get-winner`, that computes the winning player of the
current showdown.  If multiple players have the same hand, determine the winner
based on the highest value card in each player's hand.  If this does not resolve
the tie, return all the players that are tied and split the pot between them.

3.5: Write a function, `update-chips`, that redistributes the chips in the pot
to the winning player after a showdown.

#### Bonus: User Interface

Congrats on getting this far! You should now have a full implementation of the
core logic needed to model Texas Hold 'em poker. To impress us, create a
graphical interface for your game. For this part of the assignment, feel free
to submit early prototypes.

Some helpful starting points:
- [Reagent](https://reagent-project.github.io/), a great library that offers an
  interface between ClojureScript and Facebook's React
- [Reagent template](https://github.com/reagent-project/reagent-template) &mdash;
  helpful `lein` template for reagent
- [Introduction to React and Reagent](http://blog.scalac.io/2015/04/02/clojurescript-reactjs-reagent.html) &mdash; a useful high level introduction
- [Reagent tutorial](https://github.com/jonase/reagent-tutorial) &mdash; a more hands-on tutorial
- [Clojure Toolbox](http://www.clojure-toolbox.com/) &mdash; a compilation of helpful Clojure libraries
