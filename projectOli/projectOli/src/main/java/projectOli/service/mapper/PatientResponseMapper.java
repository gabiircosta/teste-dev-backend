package projectOli.service.mapper;

import org.springframework.stereotype.Component;
import projectOli.model.response.HealthProblemResponse;
import projectOli.model.response.PatientResponse;
import projectOli.persistence.entity.HealthProblem;
import projectOli.persistence.entity.Patient;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientResponseMapper implements Mapper<Patient, PatientResponse> {

    @Override
    public PatientResponse map(Patient input) {
        if (input == null) {
            return null;
        }

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(input.getId());
        patientResponse.setName(input.getName());
        patientResponse.setBirthDate(input.getBirthDate());
        patientResponse.setCreationDate(input.getCreationDate());
        patientResponse.setGender(input.getGender());
        patientResponse.setUpdateDate(input.getUpdateDate());

        patientResponse.setHealthProblem(map(input.getHealthProblem()));

        return patientResponse;
    }

    private List<HealthProblemResponse> map(List<HealthProblem> healthProblems) {
        List<HealthProblemResponse> problemResponses = new ArrayList<>();

        if (!healthProblems.isEmpty()) {
            for (HealthProblem healthProblem : healthProblems) {
                HealthProblemResponse problemResponse = new HealthProblemResponse();
                problemResponse.setId(healthProblem.getId());
                problemResponse.setName(healthProblem.getName());
                problemResponse.setDeseaseDegree(healthProblem.getDeseaseDegree());

                problemResponses.add(problemResponse);
            }
        }
        return problemResponses;
    }

}
