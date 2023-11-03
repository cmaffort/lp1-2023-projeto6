package br.cefetmg.lagos.model.dto.enums;

public interface IntEnum<E extends Enum<E>> {
    static <E extends Enum<E>> int getIntForEnum(E enumValue) {
        if (enumValue != null)
            return enumValue.ordinal();
        return -1;
    }

    static <E extends Enum<E>> E getEnumForInt(int ordinal, Class<E> enumClass) {
        return enumClass.getEnumConstants()[ordinal];
    }
}
