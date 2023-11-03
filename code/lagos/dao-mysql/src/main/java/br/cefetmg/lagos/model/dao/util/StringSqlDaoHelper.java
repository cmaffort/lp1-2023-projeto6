package br.cefetmg.lagos.model.dao.util;

import java.util.List;
import java.util.Map;

public class StringSqlDaoHelper {
    public static String insertWithValues(String table, List<String> columns) {
        return StringSql.insert(table, columns) + " " + StringSql.values(columns.size());
    }

    public static String updateSet(String table, List<String> columnsSet) {
        return StringSql.bigStatement(StringSql.update(table), StringSql.set(columnsSet));
    }

    public static String updateSetWhere(String table, List<String> columnsSet, List<String> columnsWhere) {
        return StringSql.bigStatement(updateSet(table, columnsSet), StringSql.where(columnsWhere));
    }

    public static String updateSetWhereEq(String table, List<String> columnsSet, List<String> columnsWhere) {
        return StringSql.bigStatement(updateSet(table, columnsSet), StringSql.whereEq(columnsWhere));
    }

    public static String deleteFromWhereEq(String table, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.deleteFrom(table), StringSql.whereEq(columnsWhere));
    }

    public static String deleteFromWhereEq(List<String> tables, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.deleteFrom(tables), StringSql.whereEq(columnsWhere));
    }

    public static String selectFromOrderBy(List<String> columnsSelect, String table, List<String> columnsOrder) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(table),
                StringSql.orderBy(columnsOrder));
    }

    public static String selectFromOrderBy(List<String> columnsSelect, List<String> tables, List<String> columnsOrder) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(tables),
                StringSql.orderBy(columnsOrder));
    }

    public static String selectFromWhereOrderBy(List<String> columnsSelect, List<String> tables, List<String> columnsWhere,
                                                List<String> columnsOrder) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(tables), StringSql.where(columnsWhere),
                StringSql.orderBy(columnsOrder));
    }

    public static String selectFromWhereEq(List<String> columnsSelect, String table, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(table), StringSql.whereEq(columnsWhere));
    }

    public static String selectFromWhereEq(List<String> columnsSelect, List<String> tables, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(tables), StringSql.whereEq(columnsWhere));
    }

    public static String selectFromWhere(List<String> columnsSelect, String table, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(table), StringSql.where(columnsWhere));
    }

    public static String selectFromWhere(List<String> columnsSelect, String table, Map<String, String> columnsWhere) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(table), StringSql.where(columnsWhere));
    }

    public static String selectFromWhere(List<String> columnsSelect, List<String> tables, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.select(columnsSelect), StringSql.from(tables), StringSql.where(columnsWhere));
    }

    public static String selectAllFromWhereEq(String table, List<String> columnsWhere) {
        return StringSql.bigStatement(StringSql.selectAll(), StringSql.from(table), StringSql.whereEq(columnsWhere));
    }
}
