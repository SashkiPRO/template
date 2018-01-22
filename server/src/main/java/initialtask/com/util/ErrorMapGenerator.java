package initialtask.com.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorMapGenerator {

    private ErrorMapGenerator() {
        throw new IllegalStateException("Util class");
    }

    public static Map<String, List<String>> getErrors(List<ConstraintViolation> constraintViolations) {
        Map<String, List<String>> error = new HashMap<>();
        for (ConstraintViolation constraintViolation : constraintViolations) {
            String message = constraintViolation.getMessage();
            OValContext context = constraintViolation.getContext();
            String fieldName = ((FieldContext) context).getField().getName();
            if (!error.containsKey(fieldName)) {
                error.put(fieldName, new ArrayList<String>());
            }
            List<String> er = error.get(fieldName);
            er.add(message);
            error.put(fieldName, er);
        }
        return error;

    }
}
