window.onload = async function () {
    const urlParams = new URLSearchParams(window.location.search);
    const employeeId = urlParams.get('employeeId');

    if (!employeeId) {
        alert('No Employee ID provided!');
        window.history.back();
        return;
    }

    try {
        const response = await fetch(`http://localhost:9093/employees/${employeeId}`);
        if (!response.ok) {
            throw new Error('Failed to fetch employee details.');
        }

        const employee = await response.json();
        const detailsContainer = document.getElementById('employeeDetails');
        
        // Dynamic
        detailsContainer.innerHTML = `
            <p><i class="fas fa-id-card"></i> <strong>ID : </strong> &nbsp;${employee.id}</p>
            <p><i class="fas fa-user"></i> <strong>Name : </strong>  &nbsp;${employee.name}</p>
            <p><i class="fas fa-envelope"></i> <strong>Email : </strong>  &nbsp;${employee.email}</p>
            <p><i class="fas fa-briefcase"></i> <strong>Department : </strong>  &nbsp;${employee.department}</p>
            <p><i class="fas fa-dollar-sign"></i> <strong>Salary : </strong>  &nbsp;₹${employee.salary.toLocaleString()}</p>
        `;
    } catch (error) {
        console.error('Error fetching employee details:', error);
        alert('Failed to load employee details.');
    }
};
