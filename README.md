# Battleships - Java Console Game

Classic Battleships in the terminal. Place your fleet, trade shots with the computer, and sink its ships before it sinks yours.

## At a Glance

- **Stack:** Java (no external libraries)
- **State:** Complete

## Features

- Manual or random ship placement
- Turn-based play against a computer opponent
- Menu screen loaded from `menuScreen.txt`
- Scores saved between runs in `scores.txt`

## Project Structure

```
Battleships/
└── src/
    ├── Main.java        # Entry point
    ├── game.java        # Board, turns and win logic
    ├── menuScreen.txt   # Menu text
    └── scores.txt       # Saved scores
```

## Running Locally

1. Clone the repo and move into the source folder:
   ```bash
   git clone https://github.com/nakulpatel0306/battleships-console-game.git
   cd battleships-console-game/Battleships/src
   ```
2. Compile and run:
   ```bash
   javac *.java
   java Main
   ```

## How to Play

- Place your ships on the grid, by hand or at random
- Take turns calling coordinates with the computer
- Hits mark the enemy ship, misses mark water
- First to sink the whole enemy fleet wins
