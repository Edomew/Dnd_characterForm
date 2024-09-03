let characteristicIndex = 4;

function addCharacteristic() {
    const characteristicsField = document.getElementById('characteristics-field');
    const newCharacteristicDiv = document.createElement('div');
    newCharacteristicDiv.classList.add('characteristic');

    newCharacteristicDiv.innerHTML = `
    <p class="form-input">
         <label for="characteristicName${characteristicIndex}">Название характеристики:</label>
         <input type="text" id="characteristicName${characteristicIndex}" name="characterCharacteristics[${characteristicIndex}].characteristicName" required />
    </p>
    <p class="form-input">
        <label for="valueOfCharacteristic${characteristicIndex}">Значение:</label>
        <input type="number" id="valueOfCharacteristic${characteristicIndex}" name="characterCharacteristics[${characteristicIndex}].valueOfCharacteristic" required />
    </p>
    <p class="button-group">
        <button class="delete" type="button" onclick="removeCharacteristic(this);">Удалить характеристику</button>
    </p>
    `;
    characteristicsField.appendChild(newCharacteristicDiv);
    characteristicIndex++;
}

function removeCharacteristic(button) {
    button.closest('.characteristic').remove();
}
