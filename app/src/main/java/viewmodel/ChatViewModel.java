package viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import data.ChatMessage;
import data.ChatRepository;
import java.util.List;

public class ChatViewModel extends AndroidViewModel {

    private ChatRepository repository; //repositorio de chats
    private LiveData<List<ChatMessage>> allMessages; //obv cambíos en mensajes

    public ChatViewModel(@NonNull Application application) {
        super(application);
        repository = new ChatRepository(application);
        allMessages = repository.getAllMessages();
    }

    public LiveData<List<ChatMessage>> getAllMessages() {
        return allMessages;
    }

    public void insert(ChatMessage chatMessage) {
        repository.insert(chatMessage);
    }
}
