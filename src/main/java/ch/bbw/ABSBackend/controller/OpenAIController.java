package ch.bbw.ABSBackend.controller;


import ch.bbw.ABSBackend.model.GeneratedFlashCardRequest;
import ch.bbw.ABSBackend.model.GeneratedFlashCardResponse;
import ch.bbw.ABSBackend.services.OpenAIServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/generateFlashCard")
@CrossOrigin(origins = "*")
public class OpenAIController {

    private final OpenAIServiceImpl service;

    public OpenAIController(OpenAIServiceImpl service){
        this.service = service;
    }

    @PostMapping
    public GeneratedFlashCardResponse askForFlashCards(@RequestBody  GeneratedFlashCardRequest request){
        return service.getFlashCard(request);
    }

}
