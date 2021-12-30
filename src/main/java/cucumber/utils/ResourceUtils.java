package cucumber.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import groovy.util.ResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import java.io.IOException;

import static java.lang.String.format;
import static org.apache.commons.lang3.Validate.notNull;

public final class ResourceUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceUtils.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private ResourceUtils() {
        throw new IllegalStateException("This class isn't instantiable");
    }
    public static <T> T getFromSpringJsonResource(Resource file, TypeReference<T> typeReference) throws ResourceException {
        T result = null;

        if (file == null) {
            throw new ResourceException("Файл не задан.");
        } else if (!file.exists()) {
            throw new ResourceException(format("Файл не найден: %s", file.getFilename()));
        } else {
            try {
                result = OBJECT_MAPPER.readValue(file.getInputStream(), typeReference);
                LOGGER.debug("Ресурс был успешно прочитан: [{}]", file.getFilename());
            } catch (IOException e) {
                throw new ResourceException(format("Ошибка во время чтения файла ресурса: %s", file.getFilename()), e);
            }
        }
        return notNull(result, "Ошибка десериализации json");
    }
    public static <T> T getFromSpringJsonResource(String json, TypeReference<T> typeReference) throws ResourceException {
        try {
            return notNull(OBJECT_MAPPER.readValue(json, typeReference), "Ошибка десериализации json");
        } catch (IOException e) {
            throw new ResourceException("\"Ошибка во время чтения ответа json", e);
        }
    }
}
