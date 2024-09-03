document.addEventListener('DOMContentLoaded', function() {
    fetch('/enumValues/equipmentCategory')
        .then(response => response.json())
        .then(data => {
            window.equipmentCategories = data;
        })
        .catch(error => console.error('Ошибка при получении категорий снаряжения:', error));
});

let equipmentIndex = 0;

function addEquipment() {
    let equipmentField = document.getElementById('equipment-field');
    let newEquipmentDiv = document.createElement('div');
    newEquipmentDiv.classList.add('form-field', 'equipment');
    newEquipmentDiv.setAttribute('id', 'equipment' + equipmentIndex);

    let selectHTML = `<select id="equipmentCategory${equipmentIndex}" name="characterEquipment[${equipmentIndex}].equipmentCategory" required>`;
    for (let category in window.equipmentCategories) {
        selectHTML += `<option value="${category}">${window.equipmentCategories[category]}</option>`;
    }
    selectHTML += `</select>`;

    newEquipmentDiv.innerHTML = `
        <label for="equipmentName${equipmentIndex}">Название снаряжения:</label>
        <input id="equipmentName${equipmentIndex}" name="characterEquipment[${equipmentIndex}].equipmentName" required/>

        <label for="equipmentDescription${equipmentIndex}">Описание:</label>
        <input id="equipmentDescription${equipmentIndex}" name="characterEquipment[${equipmentIndex}].equipmentDescription" required/>

        <label for="equipmentCategory${equipmentIndex}">Категория снаряжения:</label>
        ${selectHTML}
        <p class="button-group">
            <button class="delete" type="button" onclick="removeEquipment(${equipmentIndex});">Удалить снаряжение</button>
        </p>
        
    `;
    equipmentField.appendChild(newEquipmentDiv);
    equipmentIndex++;
}

function removeEquipment(index) {
    let equipmentDiv = document.getElementById('equipment' + index);
    equipmentDiv.remove();
}
