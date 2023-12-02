package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

        String filePath = "C:\\Users\\ZW\\IdeaProjects\\telebot\\src\\main\\java\\org\\example\\problemslist.json";
        //change the filePath based on where you store this project
        
        try{
            ObjectMapper objectmapper = new ObjectMapper();
            File jsonFile = new File(filePath);
            UserData userData = objectmapper.readValue(jsonFile,UserData.class);

            ArrayList<Integer> qId = new ArrayList<Integer>();
            ArrayList<String> qnTitle = new ArrayList<String>();
            ArrayList<Integer> diff = new ArrayList<Integer>();

            for(StatStatusPair pair: userData.getStatStatusPairs()){
                boolean paidOnly = pair.isPaid_only();
                if(paidOnly == false){
                    int question_Id = pair.getStat().getQuestion_id();
                    qId.add(question_Id);

                    String question_title_slug = pair.getStat().getQuestion__title_slug();
                    qnTitle.add(question_title_slug);

                    int lvl = pair.getDifficulty().getLevel();
                    diff.add(lvl);

                    //System.out.println("Question ID: " + question_Id);
                    //System.out.println("Question Title Slug: " + question_title_slug);
                    //System.out.println("Difficuly Level " + lvl);
                    //System.out.println("\n");

                }
            }
            System.out.println(qId.size()); //1399
            Bot bot = new Bot(qId,qnTitle,diff);
            botsApi.registerBot(bot);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
