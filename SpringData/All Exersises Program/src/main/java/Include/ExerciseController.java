package Include;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import static Messages.CoreMessages.INFO_TEXT;

public abstract class ExerciseController {
    private Map<Integer,String> names;
    private Map<Integer, ExerciseController> homeworkPathes;
    private Map<Integer, ExercisesImp> exercisesPathes;
    private Connection connection;

    public ExerciseController(Connection connection){
        names = new LinkedHashMap<>();
        exercisesPathes = new LinkedHashMap<>();
        homeworkPathes = new LinkedHashMap<>();
        this.connection = connection;
    }

    public void infoText() {
        this.getNames().forEach((key, value) -> System.out.printf(INFO_TEXT, key, value));
        System.out.println();
    }


   public ExercisesImp getExercise (int pick){
        return exercisesPathes.get(pick);
   }

   public String getExerciseName(int pick){
        return names.get(pick);
    }

    public ExerciseController getHomework(int pick){
        return homeworkPathes.get(pick);
    }


    protected Map<Integer, String> getNames() {
        return names;
    }

    protected void inputNames(String ... values){
        int count = 1;
        for (String value : values) {
            names.put(count,value);
            count++;
        }
    }

    protected void inputHomeworkPathes(ExerciseController ... values){
        int count = 1;
        for (ExerciseController value : values) {
            homeworkPathes.put(count,value);
            count ++;
        }
    }

    protected void inputExercisesPathes(ExercisesImp ... values){
        int count = 1;
        for (ExercisesImp value : values) {
            exercisesPathes.put(count,value);
            count ++;
        }
    }
}
