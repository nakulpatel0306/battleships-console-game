# 🚢 Battleships - Console Game (Java)

A classic **Java-based console Battleships game**. Play against the computer in the terminal, place your ships, and try to sink the opponent's fleet before yours is destroyed.

---

## ✨ Features

- Text-based console interface  
- Randomized or manual ship placement  
- Turn-based gameplay vs Computer  
- Tracks scores in `scores.txt`  
- Menu system (loaded from `menuScreen.txt`)  

---

## 🧱 Project Structure

```
Battleships/
├── src/
│   ├── Main.java          # Entry point of the game
│   ├── game.java          # Core game logic
│   ├── menuScreen.txt     # Menu display text
│   └── scores.txt         # Persistent score tracking
└── out/                   # Compiled class files
```

---

## 🚀 Getting Started

1. **Compile the game** from the `src` folder:
   ```bash
   javac *.java
   ```

2. **Run the game**:
   ```bash
   java Main
   ```

---

## 🎮 How to Play

- Place your ships on the board (either manually or randomized).  
- Take turns with the computer calling out grid coordinates.  
- A hit will mark the opponent’s ship; a miss is recorded as water.  
- The first player to sink all enemy ships wins.  
