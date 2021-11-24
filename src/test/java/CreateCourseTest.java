import org.junit.Assert;
import org.junit.Test;
import ru.rsreu.javaeewebapp.DaoFactory;
import ru.rsreu.javaeewebapp.DbType;
import ru.rsreu.javaeewebapp.models.Dates;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static ru.rsreu.javaeewebapp.DaoFactory.getInstance;

public class CreateCourseTest {

    @Test
    public void Test1() {
        int size = getInstance(DbType.ORACLE).getCoursesDAO().getAllStudentCourses(1).size();
        getInstance(DbType.ORACLE).getModifiedCourseDAO().createCourse(0, "Bla-bla", "desc",
                new ArrayList<Date>());
        int newSize = getInstance(DbType.ORACLE).getCoursesDAO().getAllStudentCourses(1).size();

        Assert.assertEquals(size, newSize - 1);
    }

}
