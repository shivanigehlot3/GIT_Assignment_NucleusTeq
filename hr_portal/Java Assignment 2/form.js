window.onload = async function () {
    const urlParams = new URLSearchParams(window.location.search);
    const employeeId = urlParams.get('employeeId');

    // Prefill
    if (employeeId) {
        try {
            const response = await fetch(`http://localhost:9093/employees/${employeeId}`);
            if (!response.ok) {
                throw new Error('Failed to fetch employee');
            }
            const employee = await response.json();

            document.getElementById('employee_id').value = employee.id;
            document.getElementById('employee_name').value = employee.name;
            document.getElementById('email').value = employee.email;
            document.getElementById('department').value = employee.department;
            document.getElementById('salary').value = employee.salary;
        } catch (error) {
            console.error('Error fetching employee:', error);
            showPopup('Failed to load employee details.');
        }
    }
};

document.getElementById('employeeForm').addEventListener('submit', async function (e) {
    e.preventDefault(); 

    const urlParams = new URLSearchParams(window.location.search);
    const employeeId = urlParams.get('employeeId'); 

    const employeeData = {
        id: document.getElementById('employee_id').value.trim(), 
        name: document.getElementById('employee_name').value,
        email: document.getElementById('email').value,
        department: document.getElementById('department').value,
        salary: parseFloat(document.getElementById('salary').value)
    };

    const method = employeeId ? 'PUT' : 'POST';
    const url = employeeId
        ? `http://localhost:9093/employees/${employeeId}`
        : 'http://localhost:9093/employees'; 

    try {
        const response = await fetch(url, {
            method: method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(employeeData)
        });

        const result = await response.text();
        console.log('Response Status:', response.status);
        console.log('Response Body:', result);

        if (response.ok) {
            const successMessage = employeeId ? 'Employee updated successfully!' : 'Employee added successfully!';
            showPopup(successMessage, true);
        } else if (response.status === 400) {
            showPopup(result); 
        } else {
            showPopup('Failed to save employee.');
        }
    } catch (error) {
        console.error('Error saving employee:', error);
        showPopup('An error occurred while saving.');
    }
});

function showPopup(message, redirect = false) {
    const popup = document.getElementById('custom-popup');
    const popupMessage = document.getElementById('popup-message');

    popupMessage.textContent = message;
    popup.style.display = 'flex';

    if (redirect) {
        setTimeout(() => {
            window.location.href = 'employeeTable.html';
        }, 1500);
    }
}

function closePopup() {
    document.getElementById('custom-popup').style.display = 'none';
    window.location.href = 'employeeTable.html';  // Redirect after closing
}