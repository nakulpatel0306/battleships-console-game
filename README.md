# Battleships - Java Console Game

Classic Battleships in the terminal on a 10x10 grid. Place your fleet, trade shots with the computer, and sink its ships before it sinks yours.

## At a Glance

- **Stack:** Java (no external libraries)
- **State:** Complete

## Features

- Four ships per side: a 4-long and a 3-long horizontal, and a 3-long and a 2-long vertical
- You place your ships by row and column, with overlap and bounds checks
- The computer places its ships at random without overlaps
- Your ship board and target board printed every turn, with hit and sink messages
- ASCII-art menu screen loaded from `menuScreen.txt`
- Scoreboard in `scores.txt`: your name, then the turns you took to win, `LOSE`, or `Exited`
- Built-in instructions screen

## The Computer Opponent

The computer is not a search-based AI. Each turn it fires at a random square it hasn't tried yet, with no follow-up on hits. It's there so you can play alone, not to be hard to beat.

## Project Structure

```
Battleships/
├── Battleships.iml      # IntelliJ module file
└── src/
    ├── Main.java        # Menu, instructions and scoreboard
    ├── game.java        # Ship placement, turns, sinking and win logic
    ├── menuScreen.txt   # ASCII-art menu
    └── scores.txt       # Saved names and scores
```

## Running Locally

1. Clone the repo and move into the source folder:
   ```bash
   git clone https://github.com/nakulpatel0306/battleships-console-game.git
   cd battleships-console-game/Battleships/src
   ```
2. Compile and run (any recent JDK). Run from `src` so the game finds its text files:
   ```bash
   javac *.java
   java Main
   ```

## How to Play

- Enter your name, then `1` to play
- Place each ship by typing the row and column of its top-left square
- Each turn, enter the row and column to fire at on the computer's board: `X` is a hit, `O` is a miss
- The computer then fires back at your board
- First to sink all four enemy ships wins; fewer turns means a better score

## Team

Nakul Patel and Mihir Patel
