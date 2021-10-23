package one.digitalinnovation.personapi.utils;

import one.digitalinnovation.personapi.model.dto.request.PhoneDTO;
import one.digitalinnovation.personapi.model.entity.Phone;
import one.digitalinnovation.personapi.util.enums.PhoneType;

public class PhoneUtils {

    private static final Long PHONE_ID = 1L;
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final  String PHONE_NUMBER = "(21)999999999";

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .type(PHONE_TYPE)
                .number(PHONE_NUMBER)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .type(PHONE_TYPE)
                .number(PHONE_NUMBER)
                .build();
    }
}
