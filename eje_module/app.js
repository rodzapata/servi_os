// app.js
import { getItems, createItem, deleteItem } from './apiService.js';
import { renderItems, getNewItemName, clearInput, handleDelete } from './ui.js';

console.log("cargando ...");

async function loadItems() {
    const items = await getItems();
    renderItems(items);
}

async function addItem() {
    const itemName = getNewItemName();
    if (itemName) {
        const newItem = await createItem({ title: itemName });
        loadItems();
        clearInput();
    }
}

document.getElementById('add-item').addEventListener('click', addItem);

document.addEventListener('DOMContentLoaded', loadItems);
