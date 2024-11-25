package com.example.nerosilva.presentation.screen.chatbot

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nerosilva.presentation.screen.chatbot.component.ChatUiEvent
import com.example.nerosilva.presentation.screen.chatbot.component.ChatViewModel
import com.example.nerosilva.R
import com.example.nerosilva.ui.theme.NeroSilvaTheme

@Composable
fun ChatbotPage(modifier: Modifier = Modifier, viewModel: ChatViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarNeroSilva()

        Spacer(modifier = Modifier.height(220.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            contentAlignment = Alignment.Center
        )   {

            Text(
                text = "Tanya Seputar Hidroponik",
                fontSize = 32.sp,
                fontWeight = FontWeight(500),
                style = TextStyle(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF0757D0), Color(0xFF42B3FF), Color(0xFF28C76F)),
                    )
                ),
                modifier = Modifier
                    .width(231.dp)
                    .height(176.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 16.dp, end = 60.dp)
            ) {
                Text(
                    text = "With ",
                    fontSize = 24.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFD9D9D9),
                    modifier = Modifier
                )

                Image(
                    painter = painterResource(id = R.drawable.geminiai),
                    contentDescription = "Gemini AI",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(109.dp)
                        .height(68.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        MessageInput(
            onMessageSend = { message ->
                viewModel.onEvent(ChatUiEvent.SendPrompt(message))
            }
        )
    }
}

@Composable
fun ChatScreen() {
    val chatViewModel = viewModel<ChatViewModel>()
    val chatState = chatViewModel.chatState.collectAsState().value

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MessageInput(onMessageSend : (String)-> Unit, modifier: Modifier = Modifier) {
    var message by remember {
        mutableStateOf("")
    }

    Row (
        modifier = Modifier.padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            modifier = Modifier
                .weight(1f)
                .width(379.dp)
                .height(56.dp)
                .shadow(elevation = 64.dp, spotColor = Color(0x0F000000), ambientColor = Color(0x0F000000))
                .background(color = Color(0x0D17181D), shape = RoundedCornerShape(size = 500.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFFF0F0F0),
                unfocusedContainerColor = Color(0xFFF0F0F0),
            )
            ,
            value = message,
            onValueChange = {
                message = it
            },
            placeholder = { Text("Tulis pertanyaan anda") }
        )
        IconButton(onClick = {
            onMessageSend(message)
            message = ""
        }) {
            Icon(
                imageVector = Icons.Default.Send,
                contentDescription = "Send",
                modifier = Modifier
                    .weight(1f)
                    .width(30.dp)
                    .height(30.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarNeroSilva() {
    TopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu Icon",
                        tint = Color(0xFF299673)
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(start = 8.dp)
                        .width(64.dp)
                        .height(28.dp)
                )
            }},
        actions = {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    tint = Color(0xFF299673)
                )
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ChatbotPreview() {
    NeroSilvaTheme {
        ChatbotPage(
            viewModel = ChatViewModel()
        )
    }
}