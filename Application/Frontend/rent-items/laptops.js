let openShopping = document.querySelector('.shopping');
let closeShopping = document.querySelector('.closeShopping');
let list = document.querySelector('.list');
let listCard = document.querySelector('.listCard');
let body = document.querySelector('body');
let total = document.querySelector('.total');
let quantity = document.querySelector('.quantity');

openShopping.addEventListener('click', ()=>{
    body.classList.add('active');
})
closeShopping.addEventListener('click', ()=>{
    body.classList.remove('active');
})

let products = [
    {
        id: 1,
        name: 'HP Victus Gaming Laptop, 12th Gen Intel Core i5-12450H, NVIDIA RTX 3050 GPU, 15.6-inch (39.6 cm), FHD, IPS, 144Hz, 9 ms Response time, 16GB DDR4, 512GB SSD, Backlit KB (MSO, Blue, 2.29 kg) fa0666TX get it at -33% off per month',
        image: 'lap1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'Acer Aspire Lite 11th Gen Intel Core i3 Premium Metal Laptop (8GB RAM/512GB SSD/Windows 11 Home) AL15-51, 39.62cm (15.6") Full HD Display, Metal Body, Steel Gray, 1.59 Kg get it at -13% off per month',
        image: 'lap2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'HP 15 Laptop, 11th Gen i3-1115G4 15.6 inch(39.6cm) FHD Laptop, 8GB DDR4, 512GB SSD, Intel UHD Graphics, Dual Speakers (Win 11, MSO 21, 1.69Kgs) 15s-fr2515TU get it at -28% off per month ',
        image: 'lap3.png',
        price: 20000
    },
    {
        id: 4,
        name: 'Lenovo ThinkPad E14 Intel Core i5 12th Gen 14" FHD Thin and Light Laptop (8GB RAM/512GB SSD/Windows 11 Home/MS Office H&S 2021/FPR/Backlit Keyboard/Black/1.59 kg), 21E3S04X00 get it at -70% off per month',
        image: '1.png',
        price: 15000
    },
    {
        id: 5,
        name: 'Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage, 1080p FaceTime HD Camera. Works Space Grey get it at -6% off per month',
        image: 'macbook.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'Dell Inspiron 7420 2in1 Touch Laptop,12th Gen Intel Core i3-1215U, 8GB/256GB SSD/14.0" (35.56Cms) FHD+ WVA 250 nits/Backlit KB + FPR/Windows 11 + MSO 21/15 Month McAfee get it at -5% off per month',
        image: 'lap6.PNG',
        price: 1499
    }
];
let listCards  = [];
function initApp(){
    products.forEach((value, key) =>{
        let newDiv = document.createElement('div');
        newDiv.classList.add('item');
        newDiv.innerHTML = `
            <img src="../assets/img/${value.image}">
            <div class="title">${value.name}</div>
            <div class="price">${value.price.toLocaleString()}</div>
            <button onclick="addToCard(${key})">Add To Card</button>`;
        list.appendChild(newDiv);
    })
}
initApp();
function addToCard(key){
    if(listCards[key] == null){
        // copy product form list to list card
        listCards[key] = JSON.parse(JSON.stringify(products[key]));
        listCards[key].quantity = 1;
    }
    reloadCard();
}
function reloadCard(){
    listCard.innerHTML = '';
    let count = 0;
    let totalPrice = 0;
    listCards.forEach((value, key)=>{
        totalPrice = totalPrice + value.price;
        count = count + value.quantity;
        if(value != null){
            let newDiv = document.createElement('li');
            newDiv.innerHTML = `
                <div><img src="../assets/img/${value.image}"/></div>
                <div>${value.name}</div>
                <div>${value.price.toLocaleString()}</div>
                <div>
                    <button onclick="changeQuantity(${key}, ${value.quantity - 1})">-</button>
                    <div class="count">${value.quantity}</div>
                    <button onclick="changeQuantity(${key}, ${value.quantity + 1})">+</button>
                </div>`;
                listCard.appendChild(newDiv);
        }
    })
    total.innerText = totalPrice.toLocaleString();
    quantity.innerText = count;
}
function changeQuantity(key, quantity){
    if(quantity == 0){
        delete listCards[key];
    }else{
        listCards[key].quantity = quantity;
        listCards[key].price = quantity * products[key].price;
    }
    reloadCard();
}
