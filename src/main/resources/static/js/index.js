// Выбранные статы
let selectedStats = new Set();

// Функция для добавления дополнительных статистических полей
function addStat() {
    let container = document.getElementById('additionalStats');
    let existingStats = document.querySelectorAll('#additionalStats select');
    let selectedStats = Array.from(existingStats).map(function (select) {
        return select.value;
    });

    // Опции для выпадающего списка статов
    let statsOptions = ['Выносливость', 'Харизма', 'Телосложение', 'Удача', 'Скрытность'];

    // Создаем выпадающий список для выбора стата
    let statSelect = document.createElement('select');
    statSelect.name = 'statName[]';
    statsOptions.forEach(function (stat) {
        // Проверяем, не был ли стат уже добавлен
        if (!selectedStats.includes(stat)) {
            let option = document.createElement('option');
            option.value = stat;
            option.text = stat;
            statSelect.appendChild(option);
        }
    });

    // Если все статы уже добавлены, не создаем новый элемент
    if (statSelect.children.length === 0) {
        alert('Все статы уже добавлены.');
        return;
    }
    // Создаем поле ввода для значения стата
    let statValueInput = document.createElement('input');
    statValueInput.type = 'number';
    statValueInput.name = 'statValue[]';
    statValueInput.placeholder = 'Введите значение стата';

    // Добавляем элементы в DOM
    let statDiv = document.createElement('div');
    statSelect.setAttribute('data-previous-value', '');
    statDiv.appendChild(statSelect);
    statDiv.appendChild(statValueInput);
    container.appendChild(statDiv);
    update(statSelect);
    // Назначаем слушатель события 'change' только что созданному select
    statSelect.addEventListener('change', function () {
        update(statSelect)
    });
}

function update(currentSelect) {
    let selectedOption = currentSelect.value;

    // Получаем и сохраняем предыдущий выбранный option
    let previousOption = currentSelect.getAttribute('data-previous-value');

    // Обновляем data-previous-value до текущего выбранного option
    currentSelect.setAttribute('data-previous-value', selectedOption);

    selectedStats.add(selectedOption);
    selectedStats.delete(previousOption)

    // Получаем все select элементы
    let allSelects = document.querySelectorAll('select[name="statName[]"]');

    // Удаляем выбранный option из всех остальных select
    allSelects.forEach(select => {
        if (select !== currentSelect) {
            Array.from(select.options).forEach(option => {
                if (option.value === selectedOption) {
                    option.remove();
                }
            });
        }
    });

// Добавляем предыдущий выбранный option обратно во все остальные select
    allSelects.forEach(select => {
            if (select !== currentSelect) {
                let optionExists = Array.from(select.options).some(option => option.value === previousOption);
                if (!optionExists && previousOption) {
                    let option = document.createElement('option');
                    option.value = previousOption;
                    option.text = previousOption;
                    select.appendChild(option);
                }
            }
        }
    )
    console.log(selectedStats)
    console.log(selectedOption)
    console.log(previousOption)
}

// Функция для добавления полей снаряжения
function addItem() {
    let container = document.getElementById('equipmentItems');
    let fieldset = document.createElement('fieldset');
    fieldset.className = 'item-fieldset';

    // Название предмета
    let nameLabel = document.createElement('label');
    nameLabel.textContent = 'Название предмета:';
    fieldset.appendChild(nameLabel);

    let itemNameInput = document.createElement('input');
    itemNameInput.type = 'text';
    itemNameInput.name = 'itemName[]';
    fieldset.appendChild(itemNameInput);

    // Описание предмета
    let descriptionLabel = document.createElement('label');
    descriptionLabel.textContent = 'Описание предмета:';
    fieldset.appendChild(descriptionLabel);

    let itemDescriptionTextarea = document.createElement('textarea');
    itemDescriptionTextarea.name = 'itemDescription[]';
    itemDescriptionTextarea.className = 'item-description-textarea';
    fieldset.appendChild(itemDescriptionTextarea);

    // Категория снаряжения
    let categoryLabel = document.createElement('label');
    categoryLabel.textContent = 'Категория снаряжения:';
    fieldset.appendChild(categoryLabel);

    let itemCategorySelect = document.createElement('select');
    itemCategorySelect.name = 'itemCategory[]';

    // Опции для категории снаряжения
    let categories = [
        'Шлем', 'Нагрудник', 'Оружие', 'Щит', 'Перчатки', 'Сапоги'
    ];

    categories.forEach(function (category) {
        let option = document.createElement('option');
        option.value = category;
        option.text = category;
        itemCategorySelect.appendChild(option);
    });

    fieldset.appendChild(itemCategorySelect);

    container.appendChild(fieldset);
}

// Функция для добавления нового предмета в рюкзак
function addBagItem() {
    let container = document.getElementById('bagItems');
    let input = document.createElement('input');
    input.type = 'text';
    input.name = 'bagItems[]';
    container.appendChild(input);
}

// Функция для добавления полей информации о навыке
function addSkill() {
    // Отправляем AJAX запрос на сервер для получения нового фрагмента навыка
    fetch('/character/get-skill-fragment')
        .then(response => response.text())
        .then(htmlFragment => {
            // Вставляем HTML фрагмент в контейнер навыков
            document.getElementById('skillsContainer').insertAdjacentHTML('beforeend', htmlFragment);
            // Обновляем индексы для Thymeleaf
            updateSkillIndexes();
        })
        .catch(error => console.error('Error fetching skill fragment:', error));
}

function updateSkillIndexes() {
    // Получаем все fieldSets внутри контейнера навыков
    var skillFieldSets = document.querySelectorAll('#skillsContainer > .skill-fieldset');
    skillFieldSets.forEach((fieldset, index) => {
        // Обновляем атрибуты Thymeleaf с новыми индексами
        fieldset.querySelectorAll('input, select, textarea').forEach(input => {
            var name = input.getAttribute('name');
            if (name) {
                // Заменяем старый индекс новым
                name = name.replace(/\[\d+\]/, '[' + index + ']');
                input.setAttribute('name', name);
            }
        });
    });
}

// Функция для обновления общей суммы денег
function updateTotalMoney() {
    let gold = document.getElementById('gold').value || 0;
    let silver = document.getElementById('silver').value || 0;
    let bronze = document.getElementById('bronze').value || 0;

    // Ограничение значений серебра и бронзы до 99
    silver = Math.min(silver, 99);
    bronze = Math.min(bronze, 99);

    // Обновление полей с ограниченными значениями
    document.getElementById('silver').value = silver;
    document.getElementById('bronze').value = bronze;

    // Переводим все в бронзу для упрощения подсчета
    let totalBronze = bronze + silver * 100 + gold * 10000;

    // Форматируем общую сумму в формате г,ссбб
    document.getElementById('totalMoney').textContent = (totalBronze / 10000).toFixed(4).replace('.', ',');
}

// Добавьте обработчики событий для вызова функции updateTotalMoney при изменении значений полей
document.getElementById('gold').addEventListener('input', updateTotalMoney);
document.getElementById('silver').addEventListener('input', updateTotalMoney);
document.getElementById('bronze').addEventListener('input', updateTotalMoney);