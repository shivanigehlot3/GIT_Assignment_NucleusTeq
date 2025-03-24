function openFile() {
    window.location.href = './form.html'; 
}

function viewEmployee(employeeId) {
    window.location.href = `viewEmployee.html?employeeId=${employeeId}`;
}

function editEmployee(id) {
    window.location.href = `form.html?employeeId=${id}`;
}



// Send del request to backend
async function deleteEmployee(id) {
    if (confirm('Are you sure you want to delete this employee?')) {
        try {
            const response = await fetch(`http://localhost:9093/employees/${id}`, {
                method: 'DELETE'
            });
            if (response.ok) {
                alert('Employee deleted successfully!');
                fetchEmployees(); 
            } else {
                alert('Failed to delete employee.');
            }
        } catch (error) {
            console.error('Error deleting employee:', error);
            alert('Error deleting employee.');
        }
    }
}

async function fetchEmployees() {
    const spinner = document.getElementById('loading-spinner');
    spinner.style.display = 'block';

    try {
        const response = await fetch('http://localhost:9093/employees');
        const employees = await response.json();
        spinner.style.display = 'none'; 
        const tbody = document.querySelector('tbody');
        tbody.innerHTML = '';

        employees.forEach(employee => {
            const row = `
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>${employee.email}</td>
                    <td>${employee.salary}</td>
                    <td>
                        <button class="view" onclick="viewEmployee(${employee.id})"><i class="fa-regular fa-eye"></i></button>
                        <button class="edit" onclick="editEmployee(${employee.id})"><i class="fas fa-pen-to-square"></i></button>
                        <button class="delete" onclick="deleteEmployee(${employee.id})"><i class="fas fa-trash-can"></i></button>
                    </td>
                </tr>
            `;
            tbody.innerHTML += row;
        });
    } catch (error) {
        console.error('Error fetching employees:', error);
        alert('Failed to load employees.');
        spinner.style.display = 'none';
    }
}

window.onload = fetchEmployees;
