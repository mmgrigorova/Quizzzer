# QUIZZZER!

Quizzzer is a console trivia game developed by team Loki. This is the first project for Telerik Academy Alpha - Java 2018.

## Gameplay

User starts the game
The Welcome screen allows picking one of the following options:
  * Start New game - game walks player through picking the game options:
    * Select Player Mode
      - Single Player
      - Dual Player
    * Player picks category
      - Questions from random categories
      - Geography
      - Tech
      - etc...
  * Ranklist
    * Show ranklist of all players and their points
  * Instructions
  * Exit game

### Single Player game

game asks question
      * Show username, show player type, show badges, show Total Points for Player
    * Question
      * Show question's rating, show how many points the question gives
    * Answers
      * Show 4 possible answers
    * Mark place where player enters their answer.
      Press ‘h’ for hint?

Player picks answer and enters it
    * game evaluates answer
      * If answer correct
         Player receives points
      * If answer is incorrect
         Show info on correct answer
      * if next question ? 
              Next question : 
              games ends

#### Single Player game Ends
* Show and Save player rank
* show Congrats & ranks & points
          *   Result summary - best know topic and least know topic
* Evaluate if player receives any badges. 
 *  E.g: if they answer questions correctly in a row or 
 *  if they rock in certain category


### Dual Player game

game asks question
     * Show username, show player type, show badges, show Total Points for Player
   * Question
    *   Show question's rating, show how many points the question gives
   *  Prompt Player 1 to enter answer
    *  Player 1 enters answer
    * Prompt Player 2 to enter answer
     * Player 2 enters answer

game evaluates answer
   * Whomever is closer to the correct answer receives the question points.
     * If both are correct, then both players receive points.
     * If both are equally incorrect, nobody gets the points

#### Dual Player game Ends
* Show who is the winner
* show Congrats & ranks & points
    *        Result summary - best know topic and least know topic
* Evaluate if any player receives badges. 
* E.g: if they answer questions correctly in a row or 
* if they rock in certain category

#### Administrative View
* Administrators create questions 
* Add Question

-------------------------------------------
## Not Doing:

* Add Question Categories
* Delete users

