package com.example.nerosilva.data.gemini

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.nerosilva.presentation.screen.chatbot.ChatbotPage
import com.example.nerosilva.presentation.screen.chatbot.component.ChatViewModel
import com.example.nerosilva.ui.theme.NeroSilvaTheme
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object ChatData {

    private const val API_KEY = "AIzaSyB0EmhyJVlZZHmLjVqJPEIVVoSzoGQd6Fo\n"

    suspend fun getResponse(prompt: String): Chat {
        val generativeModel = GenerativeModel(
            modelName = "gemini-pro", apiKey = API_KEY
        )

        try {
            val response = withContext(Dispatchers.IO) {
                generativeModel.generateContent(prompt)
            }

            return Chat(
                prompt = response.text ?: "error",
                isFromUser = false
            )

        } catch (e: Exception) {
            return Chat(
                prompt = e.message ?: "error",
                isFromUser = false
            )
        }
    }
}