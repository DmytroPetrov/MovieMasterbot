import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MovieMasterBOT extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {

        String command = update.getMessage().getText();
        sendResponse(update.getMessage().getChatId().toString(), command);

        /*if (command.equals("/genre")){
            System.out.println("Here is genres!");
            message.setText("Here is your genres");

        }

        message.setChatId(update.getMessage().getChatId());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/

    }

    public synchronized void sendResponse(String chatId, String string){
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(string);

        if (string.equals("/genre")){
            sendMessage.setText("Here it is");
            setButtons(sendMessage);
        }

        /*try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/
    }

    public synchronized void setButtons(SendMessage sendMessage) {
        // Make a menu
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Make Array of Arrays Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Драма"));
        keyboardFirstRow.add(new KeyboardButton("Драма"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Бойовик"));
        keyboardSecondRow.add(new KeyboardButton("Дорама"));

        KeyboardRow keyboardThirdRow = new KeyboardRow();

        keyboardThirdRow.add(new KeyboardButton("Бойепік"));
        keyboardThirdRow.add(new KeyboardButton("Документалка"));

        KeyboardRow keyboardFourthRow = new KeyboardRow();
        keyboardFourthRow.add(new KeyboardButton("Мікс"));


        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        keyboard.add(keyboardFourthRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }




    public String getBotUsername() {
        return "MovieMasterBot";
    }

    public String getBotToken() {
        return "750498635:AAGsBOUU8aWGy9zBIApHp-SHxOycs2GSf6k";
    }
}
