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
        name: 'Godrej 6.5 Kg(WTEON 650 AP 5.0 GPGR, Eco Wash, Semi Automatic) get it at -33% off per month',
        image: 'wm1.PNG',
        price: 6000
    },
    {
        id: 2,
        name: 'LG 8 Kg 5 Star Inverter Direct Drive Fully Automatic (FHM1408BDW) get it at -13% off per month',
        image: 'wm2.PNG',
        price: 4000
    },
    {
        id: 3,
        name: 'Samsung 7 kg Fully-Automatic Top Load(WA70A4002GS) get it at -28% off per month ',
        image: 'wm3.png',
        price: 2000
    },
    {
        id: 4,
        name: 'Whirlpool 9 Kg Semi-Automatic Top Load (HYDROWASH ELITE 9.0) get it at -70% off per month',
        image: 'wm4.png',
        price: 15000
    },
    {
        id: 5,
        name: 'Samsung 7 kg Fully Automatic Top Loading Machine (WA70BG4441YYTL) get it at -6% off per month',
        image: 'wm5.PNG',
        price: 3000
    },
    {
        id: 6,
        name: 'Whirlpool 6.5 Kg Fully-Auto Top Load (5YMW, Eco wash, ZPF Technology) get it at -5% off per month',
        image: 'wm6.PNG',
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
