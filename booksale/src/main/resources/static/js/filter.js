const filterButton = document.querySelector('.filter-button');
filterButton.addEventListener('click', filterClicked);

const filterList = document.querySelector('.filter-list');
const filterText = filterButton.querySelector('text');

function filterClicked(){
    filterList.classList.toggle(INVISIBLE);
    if(filterList.classList.contains(INVISIBLE))
        filterText.innerText = "▼";
    else
        filterText.innerText = "▲";
}
