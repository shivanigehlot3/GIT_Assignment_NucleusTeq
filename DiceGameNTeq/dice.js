
const dice = document.getElementById("dice");
const rollBtn = document.getElementById("rollBtn");
const saveBtn = document.getElementById("saveBtn");
const resetBtn = document.getElementById("resetBtn");

const player1Name = document.getElementById("player1Name");
const player2Name = document.getElementById("player2Name");

const score1 = document.getElementById("score1");
const score2 = document.getElementById("score2");
const current1 = document.getElementById("current1");
const current2 = document.getElementById("current2");

const winnerText = document.getElementById("winner");

let currentScore = 0;
let activePlayer = 1;
let savedScores = [0, 0];

function rollDice() {
    let roll = Math.floor(Math.random() * 6) + 1;
    
    dice.src = `dice${roll}.png`;  

    if (roll === 1) {
        currentScore = 0;
        switchTurn();
    } else {
        currentScore += roll;
        document.getElementById(`current${activePlayer}`).textContent = currentScore;
    }
}



function saveScore() {
    savedScores[activePlayer - 1] += currentScore;
    document.getElementById(`score${activePlayer}`).textContent = savedScores[activePlayer - 1];

    if (savedScores[activePlayer - 1] >= 100) {
        winnerText.textContent = ` Congratulations! ${document.getElementById(`player${activePlayer}Name`).value} Wins! 🎉`;
        rollBtn.disabled = true;
        saveBtn.disabled = true;
    } else {
        currentScore = 0;
        switchTurn();
    }
}


function switchTurn() {
    document.getElementById(`current${activePlayer}`).textContent = 0;
    activePlayer = activePlayer === 1 ? 2 : 1;
}


function resetGame() {
    currentScore = 0;
    activePlayer = 1;
    savedScores = [0, 0];

    score1.textContent = "0";
    score2.textContent = "0";
    current1.textContent = "0";
    current2.textContent = "0";
    winnerText.textContent = "";

    rollBtn.disabled = false;
    saveBtn.disabled = false;
}

rollBtn.addEventListener("click", rollDice);
saveBtn.addEventListener("click", saveScore);
resetBtn.addEventListener("click", resetGame);
