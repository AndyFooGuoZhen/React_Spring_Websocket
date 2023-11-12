import httpClient from '../http-common';

const getChatHistory = (chatId)=>{
    return httpClient.get(`/chatHistory/${chatId}`);
}

const createChatHistory = (data)=>{
    return httpClient.post(`/chatHistory`,data);
}

export default {getChatHistory,createChatHistory};