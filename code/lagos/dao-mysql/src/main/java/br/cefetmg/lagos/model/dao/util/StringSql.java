package br.cefetmg.lagos.model.dao.util;

import java.util.*;
import java.util.stream.Collectors;

public class StringSql {
    private static String listWithParenthesis(List<String> list, String delimiter, String prefix, String suffix) {
        return list.stream()
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    public static String statementsList(Map<String, String> statements, String delimiter, String prefix, String suffix) {
        return statements.keySet().stream()
                .map(el -> "(" + el + " = (" + statements.get(el) + "))")
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    public static String columnList(List<String> columns, String prefix, String suffix) {
        return listWithParenthesis(columns, ", ", prefix, suffix);
    }

    public static String columnValueList(Map<String, String> columns) {
        return statementsList(columns, ", ", "", "");
    }

    public static String columnValueList(List<String> columns, String delimiter) {
        return columns.stream()
                .map(column -> column + " = ?")
                .collect(Collectors.joining(delimiter));
    }

    public static String columnValueList(List<String> columns) {
        return columnValueList(columns, ", ");
    }

    public static String valueList(List<String> values) {
        return listWithParenthesis(values, ", ", "(", ")");
    }

    public static String valueList(int n) {
        return "(" + "?, ".repeat(n - 1) + "?)";
    }

    public static String statementList(List<String> statements) {
        return listWithParenthesis(statements, " AND ", "(", ")");
    }

    public static String insert(String table, List<String> columns) {
        return "INSERT INTO " + table + " " + columnList(columns, "(", ")");
    }

    public static String values(List<String> values) {
        return "VALUES " + valueList(values);
    }

    public static String values(int n) {
        return "VALUES " + valueList(n);
    }

    public static String from(String table) {
        return "FROM " + table;
    }

    public static String from(List<String> tables) {
        return "FROM " + columnList(tables, "", "");
    }

    public static String selectAll() {
        return "SELECT *";
    }

    public static String select(List<String> columns) {
        return "SELECT " + columnList(columns, "", "");
    }

    public static String set(List<String> columns) {
        return "SET " + columnValueList(columns);
    }

    public static String where(List<String> statements) {
        return "WHERE " + statementList(statements);
    }

    public static String where(Map<String, String> statements) {
        return "WHERE " + statementsList(statements, " AND ", "", "");
    }

    public static String whereIn(String columnWhere, List<String> valuesIn) {
        return "WHERE " + columnWhere + " IN " + listWithParenthesis(valuesIn, ", ", "(", ")");
    }

    public static String field(String column, List<String> values) {
        return "FIELD(" + column + ", " + listWithParenthesis(values, ", ", "", "") + ")";
    }

    public static String whereEq(List<String> columns) {
        return "WHERE " + columnValueList(columns, " AND ");
    }

    public static String innerJoin(String table, Map<String, String> statements) {
        return "INNER JOIN " + table + " ON " + statementsList(statements, " AND ", "", "");
    }

    public static String unionAll(List<String> unionValues, String column) {
        unionValues = new ArrayList<>(unionValues);
        String result = "SELECT " + unionValues.remove(0) + " AS " + column + " ";
        return result + unionValues.stream()
                .map(value -> "UNION ALL SELECT " + value + " AS " + column).collect(Collectors.joining(" "));
    }

    public static String innerJoinSelectUnionAll(List<String> unionValues, String columnUnion, Map<String, String> statements, String unionName) {
        return "INNER JOIN " + "(" + unionAll(unionValues, columnUnion) + ") " + unionName + " ON " + statementsList(statements, " AND ", "", "");
    }

    public static String dateBetween(String dateCheck, String dateStart, String dateEnd) {
        return "(" + dateCheck + ") BETWEEN (" + dateStart + ") AND (" + dateEnd + ")";
    }

    public static String update(String table) {
        return "UPDATE " + table;
    }

    public static String deleteFrom(String table) {
        return "DELETE FROM " + table;
    }

    public static String deleteFrom(List<String> tables) {
        return "DELETE " + from(tables);
    }

    public static String orderBy(List<String> columns) {
        return "ORDER BY " + listWithParenthesis(columns, ", ", "", "");
    }

    public static String multipleStatements(String... statements) {
        return String.join("; ", statements) + ";";
    }

    public static String bigStatement(String... microStatements) {
        return String.join(" ", microStatements);
    }
}
