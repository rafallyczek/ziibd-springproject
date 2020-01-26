package ziibd.project.jobhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobHistoryService {

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    //Pobierz historię pracy
    public JobHistory getJobHistory(int id){
        return jobHistoryRepository.findById(id).get();
    }

    //Pobierz wszystkie historie pracy
    public List<JobHistory> getJobHistories(){
        List<JobHistory> jobHistories = new ArrayList<>();
        jobHistoryRepository.findAll().forEach(jobHistories::add);
        return jobHistories;
    }

    //Dodaj historię pracy
    public void addJobHistory(JobHistory jobHistory){
        jobHistoryRepository.save(jobHistory);
    }

    //Zaktualizuj historię pracy
    public void updateJobHistory(JobHistory jobHistory){
        jobHistoryRepository.save(jobHistory);
    }

    //Usuń historię pracy
    public void deleteJobHistory(int id){
        jobHistoryRepository.deleteById(id);
    }

}