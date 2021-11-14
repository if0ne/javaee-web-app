import org.junit.Test;
import ru.rsreu.javaeewebapp.models.StudentsStatus;
import ru.rsreu.javaeewebapp.util.MapClassConverter;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class ConverterTest {

    @Test
    public void Test1() {
        /*Map<String, Object> row = new HashMap<String, Object>();
        StudentsStatus originalObj = new StudentsStatus("Agafonov", "Pavel", "Alekseevich", true);
        row.put("lastName", originalObj.getLastName());
        row.put("firstName", originalObj.getFirstName());
        row.put("middleName", originalObj.getMiddleName());
        row.put("status", originalObj.getStatus());

        StudentsStatus obj = MapClassConverter.getObjectFromMap(row, StudentsStatus.class);
        assertNotEquals(obj, null);
        assertEquals(originalObj.getFirstName(), obj.getFirstName());
        assertEquals(originalObj.getLastName(), obj.getLastName());
        assertEquals(originalObj.getMiddleName(), obj.getMiddleName());
        assertEquals(originalObj.getStatus(), obj.getStatus());*/
    }

}
