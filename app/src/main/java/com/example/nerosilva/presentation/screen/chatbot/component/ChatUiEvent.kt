package com.example.nerosilva.presentation.screen.chatbot.component

sealed class  ChatUiEvent {
    data class UpdatePrompt(val newPrompt: String): ChatUiEvent()
    data class SendPrompt(val prompt: String): ChatUiEvent()
}