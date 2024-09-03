function updateMoney() {
    var gold = document.getElementById('gold').value;
    var silver = document.getElementById('silver').value;
    var bronze = document.getElementById('bronze').value;

    // Clamp values between min and max
    gold = Math.max(0, gold);
    silver = Math.max(0, Math.min(99, silver));
    bronze = Math.max(0, Math.min(99, bronze));

    // Update the input values if they were clamped
    document.getElementById('gold').value = gold;
    document.getElementById('silver').value = silver;
    document.getElementById('bronze').value = bronze;

    // Update the total money display
    document.getElementById('totalMoney').textContent = gold + '.' + (silver < 10 ? '0' : '') + silver + (bronze < 10 ? '0' : '') + bronze;

    // Update the hidden input for form submission
    document.getElementById('amountOfMoney').value = gold + '.' + silver + bronze;
}

// Call updateMoney on page load to initialize the values
document.addEventListener('DOMContentLoaded', updateMoney);
