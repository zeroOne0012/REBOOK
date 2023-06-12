package dbteam4.booksale.service;

import dbteam4.booksale.domain.School;
import dbteam4.booksale.dto.SchoolDTO;
import dbteam4.booksale.repository.SchoolMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolMapper schoolMapper;

    public void save(SchoolDTO schoolDTO){
        schoolMapper.save(schoolDTO);
    }

    public List<School> findAllSchool() {
         return schoolMapper.findAll();
    }
    public HashMap<String, List<String>> findAllSchoolByMap() {
        HashMap<String, List<String>> schoolDepartmentsMap = new HashMap<>();
        List<School> schoolList = findAllSchool();

        String tempUniversity = schoolList.get(0).getUniversity();
        List<String> tempDepartmentList = new ArrayList<>();

        for (var school : schoolList) {
            String university = school.getUniversity();
            String department = school.getDepartment();

            if (university.equals(tempUniversity)) {
                tempDepartmentList.add(department);
            }
            else {
                schoolDepartmentsMap.put(new String(tempUniversity), new ArrayList<String>(tempDepartmentList));
                tempUniversity = new String(university);
                tempDepartmentList.clear();
                tempDepartmentList.add(department);
            }
        }
        //last index에서 할당
        schoolDepartmentsMap.put(new String(tempUniversity), new ArrayList<String>(tempDepartmentList));

        return schoolDepartmentsMap;
    }
}
