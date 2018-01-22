package initialtask.com.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.constraint.exclusion.Nullable;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidatorUtil {
    private Validator validator;

    public ValidatorUtil() {
        AnnotationsConfigurer myConfigurer = new AnnotationsConfigurer();
        myConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);
        validator = new Validator(myConfigurer);
    }

    public List<ConstraintViolation> validate(Object o) {

        return validator.validate(o);
    }
}
