package Task_Scheduler;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {
    CalculationMessage msg;
    Long schedulingTime;
}
