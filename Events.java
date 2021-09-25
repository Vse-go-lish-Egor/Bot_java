import com.sun.deploy.util.DeploySysAction;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;



public class Events  {



    public static SendPhoto choiceOfEvent(Integer indexOfEvent, String chat_id) throws FileNotFoundException {

            if (Exel.getFormatList().get(indexOfEvent).equals("Стендап")) {
                SendPhoto stendap = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\stendap.png")).setCaption("Это стендап - тут все просто. Один актер - море шуток. Если не лишен самоиронии, обязательно загляни к нам!");
                return stendap;
            } else if (Exel.getFormatList().get(indexOfEvent).equals("Корпоративный юмор")) {
                SendPhoto coop = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\кю.jpg")).setCaption("Корпоративный юмор.\n" +
                        "Обсуждаем профессии в юмористическом ключе. Да-да-да, трактористы вошли в чат. После выступления вы можете взять контакты выступающего и пригласить егот на свой корпоратив");
                return coop;
            } else if (Exel.getFormatList().get(indexOfEvent).equals("Просто анекдотики")) {
                SendPhoto humor = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\кю.jpg")).setCaption("Просто анекдоты. \n" +
                        "Отсутствие какой-либо тематики. С вас тема - с нас шутка. Выступление ведется в форме диалога");
                return humor;
            } else if (Exel.getFormatList().get(indexOfEvent).equals("Прямой эфир")) {
                SendPhoto web = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\пэ.jpg")).setCaption("Прямой эфир.\n" +
                        "Вам даже не нужно никуда ходить. Взяли устройство, оставили бронь и все: ожидайте звонка от организатора. В перспективе, если бронь не будет отменена, вам пришлют ссылку на трансляцию концерта");
                return web;

            } else if (Exel.getFormatList().get(indexOfEvent).equals("Тематический стендап")) {
                SendPhoto title = new SendPhoto().setChatId(chat_id).setPhoto("photo", new FileInputStream("C:\\Users\\Lenovo\\OneDrive\\Рабочий стол\\Bot\\photo\\stendap.png")).setCaption("Тематический стендап.\n" +
                        "Шутки на конкретную тему. Тема готовится заранее организатором мероприятия.");
                return title;
            } else {
                return new SendPhoto().setChatId(chat_id).setCaption("Error");
            }
        }
    }

