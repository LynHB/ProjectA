package study.mapstruct;

import lombok.Data;

import java.util.Date;

/**
 * @Description
 * @Date 10:29 2021/4/25
 * @Author Huang Bing
 */
@Data
public class StudentDto {
    private String studentName;
    private Long id;
    private Date birthDay;
}
