package br.cefetmg.lagos.model.dto.enums;

public class IntEnum {
    public static <E extends Enum<E>> Integer getIntForEnum(E enumValue) {
        if (enumValue != null)
            return enumValue.ordinal();
        return null;
    }

    public static <E extends Enum<E>> E getEnumForInt(Integer ordinal, Class<E> enumClass) {
        if (ordinal != null)
            return enumClass.getEnumConstants()[ordinal];
        return null;
    }
}
