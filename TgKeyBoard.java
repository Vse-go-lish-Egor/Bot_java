import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.*;


public class TgKeyBoard {
    public TgKeyBoard(){

    }

    public ReplyKeyboardMarkup helloKeyboard() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList();
        KeyboardRow first = new KeyboardRow();
        KeyboardRow second = new KeyboardRow();
        KeyboardRow third = new KeyboardRow();
        KeyboardRow forth = new KeyboardRow();
        first.add(new KeyboardButton("Помощь"+Emoji.QUESTION.get()));
        second.add(new KeyboardButton("Информация о нас"));
        third.add(new KeyboardButton("Выбрать по дате посещения"));
        forth.add(new KeyboardButton("Выбрать по нашим форматам"));
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        keyboardRows.add(first);
        keyboardRows.add(second);
        keyboardRows.add(third);
        keyboardRows.add(forth);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup dateFormat() {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList();
        KeyboardRow first = new KeyboardRow();
        KeyboardRow second = new KeyboardRow();
        KeyboardRow third = new KeyboardRow();
        KeyboardRow forth = new KeyboardRow();
        first.add(new KeyboardButton("Стендап"));
        first.add(new KeyboardButton("Прямой эфир"));
        second.add(new KeyboardButton("Корпоративный юмор"));
        second.add(new KeyboardButton("Тематический стендап"));
        third.add(new KeyboardButton("Просто анекдотики"));
        third.add(new KeyboardButton("Другие форматы"));
        forth.add(new KeyboardButton("Назад " + Emoji.BACK.get()));
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        keyboardRows.add(first);
        keyboardRows.add(second);
        keyboardRows.add(third);
        keyboardRows.add(forth);
        return replyKeyboardMarkup;
    }

    public ReplyKeyboardMarkup format() {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList();
        KeyboardRow first = new KeyboardRow();
        KeyboardRow second = new KeyboardRow();
        KeyboardRow third = new KeyboardRow();
        KeyboardRow forth = new KeyboardRow();
        first.add(new KeyboardButton(Exel.getDateList().get(0)));
        first.add(new KeyboardButton(Exel.getDateList().get(1)));
        first.add(new KeyboardButton(Exel.getDateList().get(2)));
        second.add(new KeyboardButton(Exel.getDateList().get(3)));
        second.add(new KeyboardButton(Exel.getDateList().get(4)));
        second.add(new KeyboardButton(Exel.getDateList().get(5)));
        third.add(new KeyboardButton(Exel.getDateList().get(6)));
        third.add(new KeyboardButton(Exel.getDateList().get(7)));
        third.add(new KeyboardButton(Exel.getDateList().get(8)));
        forth.add(new KeyboardButton("Назад " +Emoji.BACK.get()));
        replyKeyboardMarkup.setKeyboard(keyboardRows);
        keyboardRows.add(first);
        keyboardRows.add(second);
        keyboardRows.add(third);
        keyboardRows.add(forth);
        return replyKeyboardMarkup;
    }

    public InlineKeyboardMarkup socialNetwork() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("ВК").setUrl("https://vk.com/velikij_chelovek");
        inlineKeyboardButton2.setText("Инстаграм").setUrl("https://www.instagram.com/why.ez_/");

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<InlineKeyboardButton>();

        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton1);


        List<List<InlineKeyboardButton>> rowList= new ArrayList<List<InlineKeyboardButton>>();
        rowList.add(keyboardButtonsRow1);


        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
        public ReplyKeyboardMarkup booking(){
            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);
            List<KeyboardRow> keyboardRows = new ArrayList();
            KeyboardRow first = new KeyboardRow();
            KeyboardRow second = new KeyboardRow();

            first.add(new KeyboardButton("Забронировать"));
            second.add(new KeyboardButton("Назад " +Emoji.BACK.get()));

            replyKeyboardMarkup.setKeyboard(keyboardRows);
            keyboardRows.add(first);
            keyboardRows.add(second);

            return replyKeyboardMarkup;
        }

       public ReplyKeyboardMarkup date(){

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);
            List<KeyboardRow> keyboardRows = new ArrayList();
           Map<Integer, KeyboardButton> keyboardButtonMap = new HashMap<>();
           System.out.println(Format.getDateByFormat().toString());
           for (int i = 0; i < Format.getDateByFormat().size(); i++) {
               keyboardButtonMap.put(i, new KeyboardButton(Format.getDateByFormat().get(i)));

           }
           System.out.println(keyboardButtonMap.entrySet());
           keyboardRows.add(new KeyboardRow());
           for (int i = 1; i < keyboardButtonMap.size(); i++) {

               if(i%3==0){
                   keyboardRows.add(new KeyboardRow());
               }
           }
           System.out.println(keyboardRows.size());

           for (int i = 0; i < keyboardButtonMap.size(); i++) {
               if(i<3) keyboardRows.get(0).add(keyboardButtonMap.get(i));
                if(i>=3&&i<6) keyboardRows.get(1).add(keyboardButtonMap.get(i));
               if(i>=6) keyboardRows.get(2).add(keyboardButtonMap.get(i));
           }
            KeyboardRow last = new KeyboardRow();
           last.add(new KeyboardButton("Назад " +Emoji.BACK.get()));
           keyboardRows.add(last);

            Format.dateByFormat.clear();

            replyKeyboardMarkup.setKeyboard(keyboardRows);


            return replyKeyboardMarkup;
        }

    public ReplyKeyboardMarkup back(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRows = new ArrayList();
        KeyboardRow first = new KeyboardRow();


        first.add(new KeyboardButton("Назад " +Emoji.BACK.get()));

        replyKeyboardMarkup.setKeyboard(keyboardRows);
        keyboardRows.add(first);

        return replyKeyboardMarkup;
    }

}
