package com.example.chatplannercitizen;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import data.ChatMessage;
import viewmodel.ChatViewModel;
import java.util.ArrayList;

public class CitizenActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private MessageAdapter messageAdapter;
    private ChatViewModel chatViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citizen);

        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        messageAdapter = new com.example.chatplannercitizen.MessageAdapter(new ArrayList<>());
        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(messageAdapter);

        chatViewModel = new ViewModelProvider(this).get(ChatViewModel.class);

        chatViewModel.getAllMessages().observe(this, messages -> {
            messageAdapter.setMessages(messages);
            recyclerViewMessages.scrollToPosition(messages.size() - 1);
        });

        buttonSend.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            ChatMessage chatMessage = new ChatMessage(messageText, "ciudadano", System.currentTimeMillis());
            chatViewModel.insert(chatMessage);
            editTextMessage.setText("");
        }
    }
}
