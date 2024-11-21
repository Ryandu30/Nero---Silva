package com.example.nerosilva.presentation.screen.chatbot.component

import com.example.nerosilva.data.gemini.Chat

data class ChatState (
    val chatList: MutableList<Chat> = mutableListOf(),
    val prompt: String = "",
)
