import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bot extends TelegramLongPollingBot {
    private final String TOKEN = "1738473029:AAEm0HD8usihENHIm8BvvmxLKafxGakKu5E";
    private final String USERNAME = "Bot_na_pricole_bot";
    Integer messageStartId = 0;
    public String nameOfEvent;
    private int step;
    public int indexOfEvent;
    @Override
    public String getBotToken() {
        return TOKEN;
    }
    public String getBotUsername() {
        return USERNAME;
    }


    public void onUpdateReceived(Update update ) {

        String chat_id = update.getMessage().getChatId().toString();
        String text = update.getMessage().getText();

        if (update.hasMessage() && update.getMessage().hasText()) {

            if (text.equals("/start")) {
                TgKeyBoard keyBoard = new TgKeyBoard();
                messageStartId = update.getMessage().getMessageId();
                SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());

                try {
                    execute(new SendMessage(chat_id, "Привет, я бот - организатор веселух ").setReplyMarkup(keyBoard.helloKeyboard()));
                    step = 1;

                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }
            if (step == 1 && update.hasMessage() && update.getMessage().hasText()) {

                if (text.equals("Помощь" + Emoji.QUESTION.get())) {
                    SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                    try {
                        execute(message.setText("Если у вас возникли вопросы обращайтесь к нам" +
                                "\n" + Emoji.TALK.get() + " в инстаграмм - https://www.instagram.com/why.ez_" +
                                "\n" + Emoji.TALK.get() + " или в вк - https://vk.com/velikij_chelovek"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                } else if (text.equals("Информация о нас")) {
                    SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                    try {
                        execute(message.setText("Мы шутники, наша цель поднять тебе настроение." + Emoji.SMILE.get() +
                                "\nУ нас ты можешь посмотреть " +
                                "\n" + Emoji.MICROPHONE.get() + "стендапы" +
                                "\n" + Emoji.CLOWN.get() + "концерты" +
                                "\n" + Emoji.CLOCK.get() + "выбрать ближайшие ивенты" +
                                "\n" + Emoji.WTF.get() + "и многое другое." +
                                "\nПомни: смех продлевает жизнь - так что мы делаем тебе отдолжение"));
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Выбрать по дате посещения")) {
                    SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Ближайшие даты мероприятий\n" +
                                "Выберите удобный для вас день").setReplyMarkup(keyBoard.format()));

                        step = 2;

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Выбрать по нашим форматам")) {
                    SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId());

                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Выберите формат").setReplyMarkup(keyBoard.dateFormat()));
                        step = 3;

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (step == 2 && update.hasMessage() && update.getMessage().hasText()) {
                if (text.equals("Назад " + Emoji.BACK.get())) {

                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух").setReplyMarkup(keyBoard.helloKeyboard()));
                        step = 1;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(0))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(0, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(0);
                        indexOfEvent = 0;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(1))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(1, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(1);
                        indexOfEvent = 1;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(2))) {

                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(2, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(2);
                        indexOfEvent = 2;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(3))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(3, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(3);
                        indexOfEvent = 3;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(4))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(4, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent= Exel.getDateList().get(4);
                        indexOfEvent = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(5))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(5, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(5);
                        indexOfEvent = 5;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(6))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(6, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));
                        nameOfEvent = Exel.getDateList().get(6);
                        indexOfEvent = 6;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(7))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(7, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(7);
                        indexOfEvent = 7;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals(Exel.getDateList().get(8))) {
                    TgKeyBoard keyBoard = new TgKeyBoard();

                    try {
                        SendPhoto photo = Events.choiceOfEvent(8, chat_id);
                        execute(photo.setReplyMarkup(keyBoard.socialNetwork()));
                        step = 4;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    TgKeyBoard keyBoard1 = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Желаете забронировать?").setReplyMarkup(keyBoard1.booking()));

                        nameOfEvent = Exel.getDateList().get(8);
                        indexOfEvent = 8;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (step == 4 && update.hasMessage() && update.getMessage().hasText()) {

                if (text.equals("Назад " + Emoji.BACK.get())) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух.").setReplyMarkup(keyBoard.format()));
                        step = 2;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                    if(text.equals("Забронировать")) {
                        try {
                            TgKeyBoard tgKeyBoard = new TgKeyBoard();
                            execute(new SendMessage(chat_id, "Введите имя посещаемого").setReplyMarkup(tgKeyBoard.back()));
                            step = 6;
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }





                

            }

            if (step == 3 && update.hasMessage() && update.getMessage().hasText()) {

                if (text.equals("Назад " + Emoji.BACK.get())) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух.").setReplyMarkup(keyBoard.helloKeyboard()));
                        step = 1;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Стендап")) {

                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        Format.setFormat(Exel.getFormatList());
                        Format.setDate(Exel.getDateList());
                        Format.formatChoose("Стендап");
                        execute(new SendMessage(chat_id, "Выберите дату").setReplyMarkup(keyBoard.date()));
                        SendPhoto stendap = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\stendap.png")).setCaption("Это стендап - тут все просто. Один актер - море шуток. Если не лишен самоиронии, обязательно загляни к нам!");
                        execute(stendap);
                        step =5;
                    } catch (TelegramApiException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Корпоративный юмор")) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        Format.setFormat(Exel.getFormatList());
                        Format.setDate(Exel.getDateList());
                        Format.formatChoose("Корпоративный юмор");
                        execute(new SendMessage(chat_id, "Выберите дату").setReplyMarkup(keyBoard.date()));
                        SendPhoto coop = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\кю.jpg")).setCaption("Корпоративный юмор.\n" +
                                "Обсуждаем профессии в юмористическом ключе. Да-да-да, трактористы вошли в чат. После выступления вы можете взять контакты выступающего и пригласить егот на свой корпоратив");
                        execute(coop);
                        step =5;
                    } catch (TelegramApiException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else if (text.equals("Прямой эфир")) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        Format.setFormat(Exel.getFormatList());
                        Format.setDate(Exel.getDateList());
                        Format.formatChoose("Прямой эфир");

                        execute(new SendMessage(chat_id, "Выберите дату").setReplyMarkup(keyBoard.date()));
                        SendPhoto web = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\пэ.jpg")).setCaption("Прямой эфир.\n" +
                                "Вам даже не нужно никуда ходить. Взяли устройство, оставили бронь и все: ожидайте звонка от организатора. В перспективе, если бронь не будет отменена, вам пришлют ссылку на трансляцию концерта");
                        execute(web);
                        step =5;
                    } catch (TelegramApiException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else if (text.equals("Просто анекдотики")) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        Format.setFormat(Exel.getFormatList());
                        Format.setDate(Exel.getDateList());
                        Format.formatChoose("Просто анекдотики");
                        execute(new SendMessage(chat_id, "Выберите дату").setReplyMarkup(keyBoard.date()));
                        SendPhoto humor = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\кю.jpg")).setCaption("Просто анекдоты. \n" +
                                "Отсутствие какой-либо тематики. С вас тема - с нас шутка. Выступление ведется в форме диалога");
                        execute(humor);
                        step =5;
                    } catch (TelegramApiException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else if (text.equals("Тематический стендап")) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        Format.setFormat(Exel.getFormatList());
                        Format.setDate(Exel.getDateList());
                        Format.formatChoose("Тематический стендап");
                        execute(new SendMessage(chat_id, "Выберите дату").setReplyMarkup(keyBoard.date()));
                        SendPhoto title = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\stendap.png")).setCaption("Тематический стендап.\n" +
                                "Шутки на конкретную тему. Тема готовится заранее организатором мероприятия.");
                        execute(title);
                        step =5;
                    } catch (TelegramApiException | FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else if(text.equals("Другие форматы")){
                    try {
                        execute(new SendMessage(chat_id,"Извините, данный тип мероприятия находиться в разработке"));
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                }
            }
            if(step==5 && update.hasMessage() && update.getMessage().hasText()){
                if (text.equals("Назад " + Emoji.BACK.get())) {
                    TgKeyBoard keyBoard = new TgKeyBoard();
                    try {
                        execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух.").setReplyMarkup(keyBoard.dateFormat()));
                        step = 3;
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                }else if(text.equals("Забронировать")){
                    try{
                        execute(new SendMessage(chat_id, "Введите имя посещаемого"));
                        step = 6;
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                }
            }
            if(step==7&&update.hasMessage() && update.getMessage().hasText()){
                if(text.equals("Назад " + Emoji.BACK.get())) {
                   try {
                       TgKeyBoard tgKeyBoard = new TgKeyBoard();
                       execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух.").setReplyMarkup(tgKeyBoard.format()));
                        step = 2;
                   }catch (TelegramApiException e){
                        e.printStackTrace();
                   }
                }else{
                try{
                    String telephone = update.getMessage().getText();
                    System.out.println(telephone + " Телефон");
                    SQL.setTelephone(telephone);
                    SQL.setDateOfEvent(nameOfEvent);
                    SQL.setEvent(Exel.getFormatList().get(indexOfEvent));
                    SQL.parsToSQL();
                    execute(new SendMessage(chat_id, "Вы забронировали"));
                }catch (TelegramApiException e){
                    e.printStackTrace();
                }
                }
            }
            if(step==6&& update.hasMessage() && update.getMessage().hasText() && !text.equals("Забронировать")){
                if(text.equals("Назад " + Emoji.BACK.get())) {
                    try {
                        TgKeyBoard tgKeyBoard = new TgKeyBoard();
                        execute(new SendMessage(chat_id, "Я все еще бот - организатор веселух.").setReplyMarkup(tgKeyBoard.format()));
                        step = 2;
                    }catch (TelegramApiException e){
                        e.printStackTrace();
                    }
                }else {
                    String name = update.getMessage().getText();
                    System.out.println(name + " Имя");
                    SQL.setNameOfUser(name);

                    try {

                        execute(new SendMessage(chat_id, "Введите номер телефона"));
                        step = 7;

                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

            }

        }


    }





}








