package notsohan.tasks.mappers.impl;

import notsohan.tasks.domain.dtos.TaskListDTO;
import notsohan.tasks.domain.entities.Task;
import notsohan.tasks.domain.entities.TaskList;
import notsohan.tasks.domain.entities.TaskStatus;
import notsohan.tasks.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskListMapperImpl implements Mapper<TaskList, TaskListDTO> {
    private final ModelMapper modelMapper;

    public TaskListMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public TaskListDTO mapTo(TaskList taskList) {
        TaskListDTO map = modelMapper.map(taskList, TaskListDTO.class);
        map.setProgress(calculateTaskListProgress(taskList.getTasks()));
        map.setCount(taskList.getTasks()!=null ? taskList.getTasks().size() : 0);

        return map;
    }

    @Override
    public TaskList mapFrom(TaskListDTO taskListDTO) {
        return modelMapper.map(taskListDTO, TaskList.class);
    }

    private Double calculateTaskListProgress(List<Task> tasks){
        if(tasks == null){
            return null;
        }

        long count = tasks.stream()
                .filter(task -> TaskStatus.CLOSED == task.getStatus())
                .count();

        return (double) count / tasks.size();
    }
}
