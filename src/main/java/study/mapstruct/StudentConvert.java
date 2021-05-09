package study.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Date;

/**
 * @Description
 * @Date 10:31 2021/4/25
 * @Author Huang Bing
 */
@Mapper
public interface StudentConvert {
    StudentConvert STUDENT_CONVERT =  Mappers.getMapper(StudentConvert.class);

    @Mapping(source = "name", target = "studentName")
    StudentDto infoToVo(StudentInfo info);

    public static void main(String[] args){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(1L);
        studentInfo.setName("xxx");
        studentInfo.setBirthDay(new Date());
        StudentDto studentDto = STUDENT_CONVERT.infoToVo(studentInfo);
        System.out.println(studentDto.getStudentName());
    }
}
