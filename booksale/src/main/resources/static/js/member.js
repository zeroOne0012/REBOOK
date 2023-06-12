const INVISIBLE = 'invisible';

const postContainer = document.querySelectorAll('.posts-container');
postContainer.forEach(postContainer => {
    const viewButton = postContainer.querySelector('.view-posts-button');
    viewButton.addEventListener('click', () => {
        const postList = postContainer.querySelector('.post-list');
        if (postList) {
            postList.classList.toggle(INVISIBLE);
            const text = viewButton.querySelector("text");
            if(postList.classList.contains(INVISIBLE))
                text.innerText = "▼";
            else
                text.innerText = "▲";
        }
    });
});