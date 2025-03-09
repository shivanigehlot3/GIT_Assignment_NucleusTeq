const API_BASE = "https://opentdb.com/api.php?amount=10&type=multiple";
let questions = [];
let currentQuestionIndex = 0;
let score = 0;
let timer;
let timeLeft = 15;

// Start Quiz
document.getElementById("start-btn").addEventListener("click", () => {
    let category = document.getElementById("category").value;
    let difficulty = document.getElementById("difficulty").value;
    fetchQuestions(category, difficulty);
    document.getElementById("start-screen").style.display = "none";
    document.getElementById("quiz").style.display = "block";
});

// Fetch questions
async function fetchQuestions(category, difficulty) {
    document.getElementById("question").innerText = "Loading question..."; 

    try {
        const response = await fetch(`${API_BASE}&category=${category}&difficulty=${difficulty}`);
        const data = await response.json();
        questions = data.results;

        if (questions.length === 0) {
            document.getElementById("question").innerText = "No questions found. Try a different category.";
            return;
        }

        loadQuestion(); 
    } catch (error) {
        document.getElementById("question").innerText = "Error loading questions.";
        console.error("Error fetching questions:", error);
    }
}

// Load question
function loadQuestion() {
    if (currentQuestionIndex >= questions.length) {
        endGame();
        return;
    }

    clearInterval(timer);
    timeLeft = 15;
    startTimer();

    let currentQuestion = questions[currentQuestionIndex];
    document.getElementById("question-number").innerText = currentQuestionIndex + 1;
    document.getElementById("question").innerText = currentQuestion.question;
    document.getElementById("count-question").innerText = currentQuestionIndex + 1;

    let options = [...currentQuestion.incorrect_answers, currentQuestion.correct_answer];
    options.sort(() => Math.random() - 0.5);

    let labels = document.querySelectorAll(".answer-lable");
    labels.forEach((label, index) => {
        label.innerText = options[index];
        label.setAttribute("data-answer", options[index]);
        label.style.backgroundColor = "#6c42ff"; 
    });

    document.querySelectorAll("input[name='option']").forEach(input => {
        input.checked = false;
        input.disabled = false; 
    });
}

// Timer function
function startTimer() {
    document.getElementById("timer").innerText = `Time Left : ${timeLeft} seconds`;
    timer = setInterval(() => {
        timeLeft--;
        document.getElementById("timer").innerText = `Time Left : ${timeLeft} seconds`;
        if (timeLeft === 0) {
            clearInterval(timer);
            showCorrectAnswer();
        }
    }, 1000);
}

// Check answer
document.querySelectorAll("input[name='option']").forEach(input => {
    input.addEventListener("change", (event) => {
        clearInterval(timer);
        let selectedAnswer = event.target.nextElementSibling.getAttribute("data-answer");
        let correctAnswer = questions[currentQuestionIndex].correct_answer;

        document.querySelectorAll("input[name='option']").forEach(input => input.disabled = true); 

        if (selectedAnswer === correctAnswer) {
            score++;
            event.target.nextElementSibling.style.backgroundColor = "#28a745"; 
        } else {
            event.target.nextElementSibling.style.backgroundColor = "#dc3545"; 
            showCorrectAnswer();
        }
    });
});

// Show correct answer
function showCorrectAnswer() {
    let correctAnswer = questions[currentQuestionIndex].correct_answer;
    document.querySelectorAll(".answer-lable").forEach(label => {
        if (label.getAttribute("data-answer") === correctAnswer) {
            label.style.backgroundColor = "#28a745"; 
        }
    });
}

// Next Question
document.getElementById("next-question-btn").addEventListener("click", () => {
    currentQuestionIndex++;
    loadQuestion();
});

// End Game Function
function endGame() {
    document.getElementById("quiz").innerHTML = `
    <h1>Game Over!</h1>
    <p class="score-text">Your Score: ${score}/10</p>
    <button class="play-again-btn" onclick="location.reload()">Play Again</button>`;
}
