package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Random;

public class Bot extends TelegramLongPollingBot{
    private ArrayList<Integer> qId;
    private ArrayList<String> qnTitle;
    private ArrayList<Integer> diff;

    public Bot(ArrayList<Integer> qId, ArrayList<String> qnTitle, ArrayList<Integer> diff) {
        this.qId = qId;
        this.qnTitle = qnTitle;
        this.diff = diff;
    }
    @Override
    public String getBotUsername(){
        return "l33tcodebot";
    }

    @Override
    public String getBotToken(){
        return "YOUR-TELEGRAM-API-TOKEN";
    }
    //get your own telgram api token and add it here

    @Override
    public void onUpdateReceived(Update update){
        if (update.hasMessage() && update.getMessage().hasText()) {
            Message message = update.getMessage();
            long chatId = message.getChatId();
            int randomNum = 0;

            // Check if the message is the "/rtd" command
            if (message.getText().equals("/rtd")) {
                // Respond only to the "/rtd" command
                randomNum = RTD();

                String response =
                        "Good Morning 早上您好！Let's get the bread 我们一起去拿面包!\n" +
                        "Today's lucky number is: " + randomNum + ". Time to buy 4D?\n" +
                        "Question Title Slug: " + qnTitle.get(randomNum-1) + "\n" +
                        "Difficulty level " + diff.get(randomNum-1);


                if (diff.get(randomNum-1) == 1) {
                    response += ": Easy - _ - Close both eyes also can do!\n";
                } else if (diff.get(randomNum-1) == 2) {
                    response += ": Medium 0 - 0 Gimme sleep\n";
                } else {
                    response += ": Hard ; - ; These tears are drying up\n";
                }

                response += "Link: " + "https://leetcode.com/problems/" + qnTitle.get(randomNum-1) + "/description/";

                System.out.println(response);
                sendResponse(chatId, response);
            }
        }

        //from tutorial
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        System.out.println("\n");
        System.out.println(update);
        System.out.println(user.getUserName() + " wrote " + msg.getText());
    }

    //random number generator, 1399 is number of free leetcode problems
    public int RTD(){
        Random rand = new Random();
        int randNum = rand.nextInt(1399)+1;
        return randNum;
    }

    public void sendResponse(long chatId,String text){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try{
            execute(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
