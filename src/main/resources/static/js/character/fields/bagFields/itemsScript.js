var itemIndex = 0;

function addItem() {
    var itemsField = document.getElementById('items-field');
    var newItemDiv = document.createElement('div');
    newItemDiv.classList.add('item');

    newItemDiv.innerHTML = `
        <label for="itemName${itemIndex}">Название предмета:</label>
        <input type="text" id="itemName${itemIndex}" name="characterBag.bagItems[${itemIndex}].itemName" placeholder="Название предмета" required />

        <label for="itemDescription${itemIndex}">Описание предмета:</label>
        <textarea id="itemDescription${itemIndex}" name="characterBag.bagItems[${itemIndex}].itemDescription" placeholder="Описание предмета" required></textarea>

        <label for="itemCategory${itemIndex}">Категория предмета:</label>
        <input type="text" id="itemCategory${itemIndex}" name="characterBag.bagItems[${itemIndex}].itemCategory" placeholder="Категория предмета" required />

        <button type="button" onclick="removeItem(this);">Удалить предмет</button>
    `;
    itemsField.appendChild(newItemDiv);
    itemIndex++;
}

function removeItem(button) {
    button.closest('.item').remove();
}
