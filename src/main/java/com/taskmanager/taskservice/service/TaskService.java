package com.taskmanager.taskservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taskmanager.taskservice.model.Task;
import com.taskmanager.taskservice.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Service
@RequiredArgsConstructor
public class TaskService {

    public final TaskRepository taskRepository;
    public final ObjectMapper mapper;

    @RabbitListener(queues = "task")
    public void handler(JsonNode request){
        switch (request.get("method").asText()){
            case "CREATE":
                create(request.get("body"));
                break;
            case "UPDATE":
                update(request.get("body"));
                break;
            case "DELETE":
                delete(request.get("body").get("id").asLong());
                break;
            default:
                break;
        }
    }

    public void create(JsonNode request){
        taskRepository.save(mapper.convertValue(request, Task.class));

    }

    public void update(JsonNode request){
        taskRepository.save(mapper.convertValue(request, Task.class));
    }
    public void delete(Long id){
        taskRepository.deleteById(id);
    }
}
