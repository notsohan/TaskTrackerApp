package notsohan.tasks.mappers.impl;

import notsohan.tasks.domain.dtos.TaskDTO;
import notsohan.tasks.domain.entities.Task;
import notsohan.tasks.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements Mapper<Task, TaskDTO> {
    private final ModelMapper modelMapper;

    public TaskMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskDTO mapTo(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public Task mapFrom(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }
}
