package Methods;

import Entries.Exercise;
import Entries.Food;
import Entries.Medication;

import java.util.Date;

public class CompMethod extends SimpleMethod {
    protected Exercise exercise = new Exercise();
    protected Food food = new Food();
    protected Medication med = new Medication();


    public CompMethod() {
    }

    public void setExercise(String type,Date startTime, Date endTime) {
        exercise.setType(type);
        exercise.setStartTime(startTime);
        exercise.setEndTime(endTime);
    }

    public Exercise getExercise(){return exercise;};
}
