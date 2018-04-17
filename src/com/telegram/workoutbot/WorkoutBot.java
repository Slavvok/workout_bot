package com.telegram.workoutbot;

import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
 
public class WorkoutBot extends TelegramLongPollingBot {
 
	@Override
	public String getBotUsername() {
		return "W0rkoutBot";
	}
 
	@Override
	public String getBotToken() {
		return "567243848:AAEcEbIzYXfOkhQPV_ZUKbBEmIt5Wnru7J0";
	}
 
	@Override
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		if (message != null && message.hasText()) {
			if (message.getText().equals("/help"))
				sendMsg(message, "ѕривет, € робот");
			else
				sendMsg(message, "я не знаю что ответить на это");
		}
	}
 
	private void sendMsg(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
 
}
