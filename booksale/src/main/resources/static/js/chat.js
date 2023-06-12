const chatButton = document.querySelector(".chat-button"); //"대화내역" 버튼
const chatList = document.querySelector(".chat-list");    //채팅 목록

const INVISIBLE = 'invisible';

function clickChatButton(){ //대화내역 버튼 클릭
    chatList.classList.toggle(INVISIBLE);
    if(chatList.classList.contains(INVISIBLE))
        chatButton.innerText = "▼ 대화내역";
    else
        chatButton.innerText = "▲ 대화내역";
}
chatButton.addEventListener("click", clickChatButton);


const chatBlocks = document.querySelectorAll('.chat-block');
chatBlocks.forEach(chatBlock => {
    const chatName = chatBlock.querySelector('.chat-name');
    chatName.addEventListener('click', () => {
        // 클릭된 chat-block 요소의 chat-detail 요소 선택
        const chatDetail = chatBlock.querySelector('.chat-detail');
        
        // chat-detail 요소가 존재하면 토글
        if (chatDetail) {
            chatDetail.classList.toggle(INVISIBLE);
        }
    });
});