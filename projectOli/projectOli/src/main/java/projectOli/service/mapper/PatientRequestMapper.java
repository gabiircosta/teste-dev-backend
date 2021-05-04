package projectOli.service.mapper;

import org.springframework.stereotype.Component;
import projectOli.model.request.HealthProblemRequest;
import projectOli.model.request.PatientRequest;
import projectOli.persistence.entity.HealthProblem;
import projectOli.persistence.entity.Patient;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientRequestMapper implements Mapper<PatientRequest, Patient> {

    @Override
    public Patient map(PatientRequest input) {
        if (input == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setBirthDate(input.getBirthDate());
        patient.setGender(input.getGender());
        patient.setName(input.getName());
        patient.setHealthProblem(map(input.getHealthProblem()));

        return patient;
    }

    private List<HealthProblem> map(List<HealthProblemRequest> problemRequests) {
        List<HealthProblem> problems = new ArrayList<>();
        if (!problemRequests.isEmpty()) {
            for (HealthProblemRequest problemRequest : problemRequests) {
                    HealthProblem healthProblem = new HealthProblem();
                    healthProblem.setName(problemRequest.getName());
                    healthProblem.setDeseaseDegree(problemRequest.getDeseaseDegree());

                    problems.add(healthProblem);
            }
        }

        return problems;
    }

}
