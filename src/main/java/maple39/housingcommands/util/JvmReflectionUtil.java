package maple39.housingcommands.util;

import java.lang.reflect.Field;

/**
 * Common code for performing reflection.
 * 
 * @author Reece Dunham
 */
public class JvmReflectionUtil {
    @SuppressWarnings("deprecation")
    public static Object getPrivateFieldValue(Class<?> clazz, Object classInstance, String fieldName) {
        if (clazz != null && !fieldName.isEmpty()) {
            Field f;
            try {
                f = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException | SecurityException e) {
                e.printStackTrace();
                return null;
            }

            if (!f.isAccessible()) {
                f.trySetAccessible();
            }

            try {
                return f.get(classInstance);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        return null;
    }
}