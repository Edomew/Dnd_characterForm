let skillIndex = 0;
document.addEventListener('DOMContentLoaded', function () {
    fetch('/enumValues/influenceType')
        .then(response => response.json())
        .then(data => {
            window.skillInfluenceTypes = data;
            // Теперь вы можете использовать skillInfluenceTypes для добавления опций в select
        })
        .catch(error => console.error('Ошибка при получении типов влияния навыков:', error));
});

function addSkill() {
    let skillsField = document.getElementById('skills-field');
    let newSkillDiv = document.createElement('div');
    newSkillDiv.classList.add('form-field', 'skill');
    newSkillDiv.setAttribute('id', 'skill' + skillIndex);

    let selectHTML = `<select id="skillInfluenceType${skillIndex}" name="characterSkills[${skillIndex}].skillInfluence" required>`;
    for (let type in window.skillInfluenceTypes) {
        selectHTML += `<option value="${type}">${window.skillInfluenceTypes[type]}</option>`;
    }
    selectHTML += `</select>`;

    newSkillDiv.innerHTML = `
        <label for="skillName${skillIndex}">Название навыка:</label>
        <input id="skillName${skillIndex}" name="characterSkills[${skillIndex}].skillName" required/>

        <label for="skillLevel${skillIndex}">Уровень навыка:</label>
        <input type="number" id="skillLevel${skillIndex}" name="characterSkills[${skillIndex}].skillLevel" required/>

        <label for="skillInfluenceType${skillIndex}">Тип влияния навыка:</label>
        ` + selectHTML + `

        <label for="skillInfluencePoint${skillIndex}">Влияние навыка:</label>
        <input type="number" id="skillInfluencePoint${skillIndex}" name="characterSkills[${skillIndex}].skillInfluencePoints" required/>

        <label for="skillDescription${skillIndex}">Описание навыка:</label>
        <textarea id="skillDescription${skillIndex}" name="characterSkills[${skillIndex}].skillDescription" placeholder="Описание навыка" required></textarea>
<p class="button-group">
        <button class="delete" type="button" onclick="removeSkill(${skillIndex});">Удалить навык</button>
        </p>
    `;
    skillsField.appendChild(newSkillDiv);
    skillIndex++;
}

function removeSkill(index) {
    let skillDiv = document.getElementById('skill' + index);
    skillDiv.remove();
    updateSkillIndexes();
}

function updateSkillIndexes() {
    let allSkills = document.querySelectorAll('.skill');
    allSkills.forEach((skillDiv, index) => {
        skillDiv.id = 'skill' + index;
        skillDiv.querySelector('[id^="skillName"]').id = 'skillName' + index;
        skillDiv.querySelector('[id^="skillLevel"]').id = 'skillLevel' + index;
        skillDiv.querySelector('button').setAttribute('onclick', 'removeSkill(' + index + ');');
    });
    skillIndex = allSkills.length;
}
