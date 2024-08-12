// ui.js

export function renderItems(items) {
    const itemList = document.getElementById('item-list');
    itemList.innerHTML = '';
    items.forEach(item => {
        const li = document.createElement('li');
        li.textContent = item.title;
        li.dataset.id = item.id;

        const deleteButton = document.createElement('button');
        deleteButton.textContent = 'Delete';
        deleteButton.addEventListener('click', () => handleDelete(item.id));

        li.appendChild(deleteButton);
        itemList.appendChild(li);
    });
}

export function getNewItemName() {
    return document.getElementById('new-item-name').value;
}

export function clearInput() {
    document.getElementById('new-item-name').value = '';
}

export function handleDelete(itemId) {
    const itemElement = document.querySelector(`[data-id='${itemId}']`);
    if (itemElement) {
        itemElement.remove();
    }
}
