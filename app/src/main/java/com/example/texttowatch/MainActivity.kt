package com.example.texttowatch

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel()

        setContent {
            val isDarkMode = isSystemInDarkTheme()
            val colorScheme = if (isDarkMode) darkColorScheme() else lightColorScheme()

            MaterialTheme(colorScheme = colorScheme) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TextToWatchApp { text ->
                        sendMessage(text)
                    }
                }
            }
        }
    }

    private fun sendMessage(text: String) {
        val database = FirebaseDatabase.getInstance("https://texttowatch-18bd2-default-rtdb.europe-west1.firebasedatabase.app").getReference("messages")
        val messageId = database.push().key

        if (messageId != null) {
            database.child(messageId).setValue(text)
                .addOnSuccessListener {
                    Toast.makeText(this, "Отправлено!", Toast.LENGTH_SHORT).show()
                    sendNotification(text)
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun sendNotification(text: String) {
        val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        val builder = NotificationCompat.Builder(this, "watch_channel")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("Сообщение")
            .setContentText(text)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        notificationManager.notify((System.currentTimeMillis()).toInt(), builder.build())
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "watch_channel",
                "Watch Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }
}

@Composable
fun TextToWatchApp(onSendMessage: (String) -> Unit) {
    var textInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "TextToWatch",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 52.dp)
        )

        TextField(
            value = textInput,
            onValueChange = { textInput = it },
            label = { Text("Введи текст") },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp),
            maxLines = 5
        )

        Button(
            onClick = {
                if (textInput.isNotEmpty()) {
                    onSendMessage(textInput)
                    textInput = ""
                } else {
                    Toast.makeText(null, "Введи текст", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Отправить")
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}