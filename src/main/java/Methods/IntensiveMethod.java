package Methods;

import java.util.Date;

public class IntensiveMethod extends CompMethod {
    public IntensiveMethod(){

    }
    public void setIntensiveExercise(String type,String name, Date startTime, Date endTime){
        exercise.setType(type);
        exercise.setName(name);
        exercise.setStartTime(startTime);
        exercise.setEndTime(endTime);
    }

//No need for get method as it is already coded in parent class.

    public void setIntensiveFood(String type,String name, Date time, double carbAmmount ){
        food.setMealType(type);
        food.setName(name);
        food.setTime(time);
        food.setCarbAmmount(carbAmmount);
    }

    public void setIntensiveMed(String type, String name, Date time, String dosage){
        med.setType(type);
        med.setName(name);
        med.setTime(time);
        med.setDosage(dosage);
    }



}
