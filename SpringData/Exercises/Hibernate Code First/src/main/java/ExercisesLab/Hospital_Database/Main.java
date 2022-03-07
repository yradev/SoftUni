package ExercisesLab.Hospital_Database;

import ExercisesLab.Hospital_Database.Entities.Diagnoses;
import ExercisesLab.Hospital_Database.Entities.Medicaments;
import ExercisesLab.Hospital_Database.Entities.Patients;
import ExercisesLab.Hospital_Database.Entities.Visitations;
import Include.Exercises;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static Messages.ExerciseMessages.*;

public class Main extends Exercises {
    private Patients patient;
    private Scanner scanner;
   private EntityManager em;
    @Override
    public void run() {
        scanner = new Scanner(System.in);
        em = super.connectToDB("Hospital_Database");

       try {

           while(true){
               if(!addPatient()){
                   break;
               }
           }

           findName();

           while(true){
               System.out.println(TYPE_BACK);
               System.out.println(ENTER_OPERATION);

               String operation = scanner.nextLine();
               if(operation.equalsIgnoreCase("back")){
                   break;
               }

               String result;
               switch (operation){

                   case "diagnoses":
                       System.out.printf(ENTER_SECOND_OPERATION,operation);
                       result = scanner.nextLine();
                       if(result.equalsIgnoreCase("add"))
                       {
                           inputDiagnose();
                       }else if(result.equalsIgnoreCase("view")){
                           if(!patient.getDiagnoses().isEmpty()) {
                               patient.getDiagnoses().forEach(a -> System.out.printf("Name: %s Comments: %s\n", a.getName(), a.getComments()));
                           }else{
                               System.out.println(EMPTY);
                           }
                       }
                       break;
                   case "medicaments":
                       System.out.printf(ENTER_SECOND_OPERATION,operation);
                       result = scanner.nextLine();
                       if(result.equalsIgnoreCase("add"))
                       {
                           inputMediament();
                       }else if(result.equalsIgnoreCase("view")){
                           if(!patient.getMedicaments().isEmpty()) {
                               patient.getMedicaments().forEach(a -> System.out.printf("Name: %s\n", a.getName()));
                           }else {
                               System.out.println(EMPTY);
                           }
                       }
                       break;
                   case "visitations":
                       System.out.printf(ENTER_SECOND_OPERATION,operation);
                       result = scanner.nextLine();
                       if(result.equalsIgnoreCase("add"))
                       {
                           inputVisitation();
                       }else if(result.equalsIgnoreCase("view")){
                           if(!patient.getVisitations().isEmpty()) {
                               patient.getVisitations().forEach(a -> System.out.printf("Date: %s Comments: %s\n", a.getDate(), a.getComments()));
                           }else{
                               System.out.println(EMPTY);
                           }
                       }
                       break;
                   default:
                       System.out.println(INVALID_INPUT);
                       break;
               }

           }
       }catch (IllegalStateException e){
           System.out.printf("Error: %s\n",e.getMessage());
       }
    }

    private void inputVisitation() {
        Visitations visitation = new Visitations();
        System.out.println(ENTER_COMMENT);
        String comment = scanner.nextLine();
        visitation.setComments(comment);

        visitation.setDate(LocalDate.now());
        visitation.setComments(comment);
        visitation.setPatient(patient);

        em.getTransaction().begin();
        em.persist(visitation);
        em.getTransaction().commit();
    }

    private void inputDiagnose() {
        Diagnoses diagnose = new Diagnoses();
        System.out.println(TYPE_NAME);
        String name = scanner.nextLine();
        diagnose.setName(name);
        System.out.println(ENTER_COMMENT);
        String comment = scanner.nextLine();
        diagnose.setComments(comment);
        diagnose.setPatient(patient);

        em.getTransaction().begin();
        em.persist(diagnose);
        em.getTransaction().commit();
    }

    private void inputMediament() {
        Medicaments medicament = new Medicaments();
        System.out.println(TYPE_NAME);
        String name = scanner.nextLine();
        medicament.setName(name);
        medicament.setPatient(patient);

        em.getTransaction().begin();
        em.persist(medicament);
        em.getTransaction().commit();
    }

    private boolean findName() {
        System.out.println(ENTER_NAME);
        String firstname = scanner.nextLine();
        List<Patients> patientsList = em.createQuery("SELECT p FROM Patients p WHERE p.first_name = :name")
                .setParameter("name",firstname)
                .getResultList();

        if(patientsList.isEmpty()){
            System.out.println(NO_PATIENT);
            return false;
        }
        patientsList.forEach(a->{
            System.out.println(ENTER_ID);
            System.out.printf("%s for pasient -> %s %s\n",a.getId(),a.getFirst_name(),a.getLast_name());
        });

        int patientID = Integer.parseInt(scanner.nextLine());
        patient = em.find(Patients.class,patientID);
        return true;
    }

    private boolean addPatient() {
        System.out.println(ADD_PATIENT);
        String input = scanner.nextLine();
        if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")){
            System.out.println("Error: "+BAD_INSURANCE_INPUT);
            return true;
        }
        boolean addOrNot = input.equalsIgnoreCase("Yes");

        if(addOrNot) {
            System.out.println(TYPE_PATIENT_INPUT);
            input = new Scanner(System.in).nextLine();
            verification(input);
            return true;
        }

        return false;
    }

    private void verification(String inputString) {
      String[] input = inputString.split(",");
          Patients patient = new Patients();

          int count = 1;
          for (String value : input) {
              switch (count) {
                  case 1:
                      patient.setFirst_name(value.trim());
                      break;
                  case 2:
                      patient.setLast_name(value.trim());
                      break;
                  case 3:
                      patient.setAddress(value);
                      break;
                  case 4:
                      patient.setBirthDate(LocalDate.parse(value.trim()));
                      break;
                  case 5:
                      if(!value.equalsIgnoreCase("yes") && !value.equalsIgnoreCase("no")){
                          throw new IllegalStateException(BAD_INSURANCE_INPUT);
                      }
                      patient.setMedical_insurance(value.equals("yes"));
                      break;
              }
              count++;
          }
        em.getTransaction().begin();
        em.persist(patient);
        em.getTransaction().commit();
    }
}
