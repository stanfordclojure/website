Lisp Development Experience &mdash; Counterclockwise
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
Get [counterclockwise][ccw-download], an eclipse plugin.
  - You must have Java 8
  - if you don't have Eclipse, there are binaries for Linux, Mac, Windows

This tutorial assumes you have downloaded the standalone version. Although
counterclockwise should smooth away OS differences, let it be known that I have
only verified the tutorial works on OSX Yosemite. If you run into any issues,
please let us know on [Piazza][piazza].

### Setting up
Follow the instructions to [create your first project][ccw-first-proj].
When you create the Clojure project, set

    Project name: hearts
    Leiningen template: devcards

### Interacting with `lein`

The main thing you'll be doing with `lein` during development is using it to
start your REPL!

In Counterclockwise you can do this with the Alt+L H shortcut.
If you can't get the keyboard shortcut to work, you can right click on
`core.cljs`, navigate to "Leiningen" and "Launch Headless REPL for the project".

Also, the Alt+L L keyboard shortcut allows you to execute an arbitrary `lein`
command as if from the terminal.

### Talking to the REPL!
We generated a ClojureScript project with the `devcards` template.
Hence, this code can only be evaluated by a ClojureScript REPL, and NOT the
Clojure REPL that Counterclockwise creates by default.

> Note: If we had generated a Clojure project, you could directly start
> evaluating the Clojure code as discussed below

To start a ClojureScript repl, we enter the commands

    (fig-start)
    (cljs-repl)

into the interactive REPL at the bottom of the screen one at a time.

Once the REPL output indicates that it has launched a ClojureScript REPL, you
can evaluate arbitrary code in the namespace with

    Cmd + Enter / Ctrl + Enter

Now, try and write

    (js/alert "Hello, REPL! <3")

into the file, navigate your cursor to that form, and hit Cmd + Enter!

If done correctly, the connected devcards page should alert `"Hello, REPL! <3"`.
Welcome to the world of "live programming"!

### Editing code
Everybody seems to have different text editing habits, so I'll defer to the
Counterclockwise [keyboard shortcuts reference][ccw-keyboard].

One thing I will recommend though is `paredit`, a tried-and-true editor mode
for writing Lisp. You can learn more about how to use it for Counterclockwise at
[their page][ccw-paredit].

### You're all set!
Now you're ready to take on the world! Or err, follow the examples in class.
Same difference tbh :)

[ccw-download]: http://doc.ccw-ide.org/documentation.html#install-as-standalone-product
[ccw-first-proj]: http://doc.ccw-ide.org/documentation.html#first-project
[ccw-keyboard]: http://doc.ccw-ide.org/keyboard-shortcuts.html
[ccw-paredit]: http://doc.ccw-ide.org/keyboard-shortcuts.html#_strict_structural_editing_mode_paredit_style
[piazza]: https://piazza.com/class/ithengu9egm2v3
