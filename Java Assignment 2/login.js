document.querySelector('form').addEventListener('submit', async function (e) {
    e.preventDefault(); 
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    try {
        const response = await fetch(`http://localhost:9093/hr/login?email=${encodeURIComponent(email)}&password=${encodeURIComponent(password)}`, {
            method: 'POST'
        });

        const result = await response.text();
        
        if (result === 'Login successful!') {
            showPopup('Login Successful!', true);
        } else {
            showPopup('Invalid email or password!', false);
        }
    } catch (error) {
        console.error('Error:', error);
        showPopup('An error occurred while logging in.', false);
    }
});

function showPopup(message, success) {
    const popup = document.getElementById('custom-popup');
    const popupMessage = document.getElementById('popup-message');

    popupMessage.textContent = message;
    popup.style.display = 'flex';

    if (success) {
        setTimeout(() => {
            window.location.href = 'employeeTable.html';
        }, 1500);
    }
}

function closePopup() {
    document.getElementById('custom-popup').style.display = 'none';
}
