Lisp Development Experience &mdash; vim
---
Allan Jiang, 10/11/16

### Goals:
- Edit code effectively
  - syntax highlighting and indentation
  - `paredit`
- Strong REPL integration
  - evaluate source code from IDE
  - evaluate arbitrary code from IDE
  - **connect IDE to runtime!**
  - in both Clojure and ClojureScript

### Installation
This tutorial already assumes you have `vim`. If you don't know what vim is, you
might find the Counterclockwise IDE tutorial more accessible.

The plugins you'll want to install are:
- [vim-clojure-static][vim-clojure-static]
- [vim-fireplace][vim-fireplace]
- [vim-paredit][vim-paredit]

Use the vim package manager of your choosing to install these plugins. I
personally use [vim-pathogen][vim-pathogen].

Also install Leiningen! Follow the instructions on [its
website][leiningen] to get installed. As a quick note/side rant, installing
`lein` with a package manager might not work super well and I don't know what
the `lein` people are thinking [end side rant].

### Setting up
Once you have `lein` installed, you can create a project from a template, and do
much more!

In this tutorial, we'll be running the command.

    lein new devcards hearts

This creates a new project with the `devcards` template called `hearts`.

### Interacting with `lein`

The main thing you'll be doing with `lein` during development is using it to
start your REPL!

Just run

    lein repl

in your project directory.

### Talking to the REPL!
We generated a ClojureScript project with the `devcards` template.
Hence, this code can only be evaluated by a ClojureScript REPL, and NOT the
Clojure REPL that `lein repl` fires up by default.

> Note: If we had generated a Clojure project, you could directly start
> evaluating the Clojure code as discussed below

To start a ClojureScript repl, we enter the commands

    (fig-start)
    (cljs-repl)

into the lein REPL one at a time.

Once the REPL output indicates that it has launched a ClojureScript REPL, you
may try typing some basic commands into the ClojureScript REPL to verify that it
works.

Surprisingly, the ClojureScript REPL environment started by Figwheel is
*connected live* to the runtime of the Javascript in browser! So if you type

    (js/alert "wowzers!")

into the ClojureScript REPL, you'll get an alert from the browser window.

This is amazing, but it'd be even better if we could just evaluate the code from
vim itself! Enter `vim-fireplace`.

`vim-fireplace` will automatically connect to a Clojure REPL started by `lein
repl` in the project directory. So, if we had a normal Clojure project we could
immediately start evaluating code with `cpp` as discussed below.

Alas, we are currently in ClojureScript land, and Fireplace doesn't know how to
connect to ClojureScript REPLs!

Fear not, Tim Pope and Chas Emerick have devised a great solution to this issue.
First close the existing ClojureScript REPL with

    :cljs/quit

Now, we will use `vim-fireplace` and `piggieback` to send a command to the
Clojure REPL to start a new ClojureScript REPL, from our vim editor itself!

Simply type the vim command

    :Piggieback (figwheel-sidecar.repl-api/repl-env)

into vim. Wait a second or two until the command is cleared. This indicates that
we have sent the lein Clojure REPL the command to start a new ClojureScript REPL
that vim is now connected to! You said what? Magic!!

Now you can evaluate arbitrary Clojure forms from vim! Navigate over any form
and type

    cpp

and you will see the result!

Now, try and write

    (js/alert "Hello, REPL! <3")

into the file, navigate your cursor to that form, and type `cpp`.

If done correctly, the connected devcards page should alert `"Hello, REPL! <3"`.
Wow, vim connected to browser runtime, what sorcery is this??
Welcome to the world of "live programming"!

Fireplace can do *much* more, so be sure to check out this Fireplace
[cheatsheet][vim-cheatsheet]! Some personal favorites that I'll mention:
- `cpr` evaluates the whole file!
- `K` prints the source code for the form under the cursor
- `cqq` puts the current form into a "quasi-repl" that can be edited and
    evaluated
- `[d` prints the source for the form under the cursor

### Editing code
Everybody seems to have different text editing habits, so you can choose to
accept or reject all or parts of my advice here.

One thing I will strongly recommend though is `paredit`, a tried-and-true editor
mode for writing Lisp. You can learn more about how to use it in vim with the
[paredit cheatsheet][vim-cheatsheet]. Favorite commands that I'll mention:
- `,W` wraps the given form into `()`
- `,w[` wraps the given form into `[]`
- `,w{` wraps the given form into `{}`
- `,S` removes the matching set of delimiters under the cursor
- `,<` moves the delimiter under the cursor one form to the left
- `,>` moves the delimiter under the cursor one form to the right

There are a lot more. Incorporate them up gradually!

### You're all set!
Now you're ready to take on the world! Or err, follow the examples in class.
Same difference tbh :)

[vim-clojure-static]: https://github.com/guns/vim-clojure-static
[vim-fireplace]: https://github.com/tpope/vim-fireplace
[vim-paredit]: https://github.com/vim-scripts/paredit.vim
[vim-pathogen]: https://github.com/tpope/vim-pathogen
[leiningen]: http://leiningen.org/
[vim-cheatsheet]: https://gist.github.com/nblumoe/5450099
[piazza]: https://piazza.com/class/ithengu9egm2v3
