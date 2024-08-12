// apiService.js

const API_URL = 'https://jsonplaceholder.typicode.com/posts'; // URL de ejemplo

export async function getItems() {
    const response = await fetch(API_URL);
    return await response.json();
}

export async function createItem(item) {
    const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    });
    return await response.json();
}

export async function updateItem(id, item) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(item)
    });
    return await response.json();
}

export async function deleteItem(id) {
    const response = await fetch(`${API_URL}/${id}`, {
        method: 'DELETE'
    });
    return response.ok;
}
