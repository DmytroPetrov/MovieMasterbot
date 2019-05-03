import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MovieMasterBOT extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getText());
        System.out.println(update.getMessage().getFrom().getFirstName());

        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();

        if (command.equals("/genre")){
            System.out.println("Here is genres!");
            message.setText("Here is your genres");

        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public String getBotUsername() {
        return "MovieMasterBot";
    }

    public String getBotToken() {
        return "750498635:AAGsBOUU8aWGy9zBIApHp-SHxOycs2GSf6k";
    }
}
