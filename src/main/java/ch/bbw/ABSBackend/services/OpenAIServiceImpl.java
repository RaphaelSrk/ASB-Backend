package ch.bbw.ABSBackend.services;


import ch.bbw.ABSBackend.model.GeneratedFlashCardRequest;
import ch.bbw.ABSBackend.model.GeneratedFlashCardResponse;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIServiceImpl implements OpenAIService{


    private final ChatModel chatModel;

    @Value("classpath:templates/getFlashCard.st")
    private Resource getFlashCard;



    public OpenAIServiceImpl(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    @Override
    public GeneratedFlashCardResponse getFlashCard(GeneratedFlashCardRequest request) {
        {
            BeanOutputConverter<GeneratedFlashCardResponse> converter = new BeanOutputConverter<>(GeneratedFlashCardResponse.class);
            String format = converter.getFormat();
            PromptTemplate selectedPrompt = new PromptTemplate(getFlashCard);
            Prompt prompt = selectedPrompt.create(
                    Map.of(
                            "amount", request.amount(),
                            "text", request.text(),
                            "format", format
                    )
            );
            ChatResponse chatResponse = chatModel.call(prompt);
            String answerString = chatResponse.getResult().getOutput().getText();
            if(answerString == null){
                System.out.println("Exception: answerString was null ");
                return null;
            }
            System.out.println(answerString);
            return converter.convert(answerString);
        }
    }
}
