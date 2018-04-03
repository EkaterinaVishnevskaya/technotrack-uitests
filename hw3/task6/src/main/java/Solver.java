import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Solver {
    public static int[] Solve(Class c) {
        Field[] fields = c.getFields();
        int res[] = {0, 0, 0};
        for (int i=0; i<fields.length;i++)
        {
            int m = fields[i].getModifiers();
            if (Modifier.isPrivate(m))
            {
                res[0]++;
            }

            if (Modifier.isProtected(m))
            {
                res[1]++;
            }

            if (Modifier.isPublic(m))
            {
                res[2]++;
            }
        }
        return res;
    }
}
