package data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatRepository {

    private ChatMessageDao chatMessageDao;
    private LiveData<List<ChatMessage>> allMessages;
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public ChatRepository(Application application) {
        ChatDatabase database = ChatDatabase.getInstance(application);
        chatMessageDao = database.chatMessageDao();
        allMessages = chatMessageDao.getAllMessages();
    }

    public LiveData<List<ChatMessage>> getAllMessages() {
        return allMessages;
    }

    public void insert(ChatMessage chatMessage) {
        executorService.execute(() -> chatMessageDao.insert(chatMessage));
    }
}
