package br.cefetmg.lagos.model.dao.util;

import java.util.*;
import java.util.stream.Collectors;

public class StringSql {
    private static String listWithParenthesis(List<String> list, String delimiter, String prefix, String suffix) {
        return list.stream()
                .map(el -> "(" + el + ")")
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    public static String statementsList(Map<String, String> statements, String delimiter, String prefix, String suffix) {
        return statements.keySet().stream()
                .map(el -> "(" + el + " = (" + statements.get(el) + "))")
                .collect(Collectors.joining(delimiter, prefix, suffix));
    }

    public static String columnList(List<String> columns) {
        return listWithParenthesis(columns, ", ", "(", ")");
    }

    public static String columnValueList(Map<String, String> columns) {
        return statementsList(columns, ", ", "", "");
    }

    public static String columnValueList(List<String> columns) {
        return columns.stream()
                .map(column -> column + " = ?")
                .collect(Collectors.joining(", "));
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

    private static ArrayList<String> toAl(String[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static String insert(String table, String... columns) {
        ArrayList<String> columnsAl = toAl(columns);
        return "INSERT INTO " + table + " " + columnList(columnsAl);
    }

    public static String values(String... values) {
        ArrayList<String> valuesAl = toAl(values);
        return "VALUES " + valueList(valuesAl);
    }

    public static String values(int n) {
        return "VALUES " + valueList(n);
    }

    public static String insertWithValues(String table, String... columns) {
        return insert(table, columns) + " " + values(columns.length);
    }

    public static String from(String table) {
        return "FROM " + table;
    }

    public static String selectAll() {
        return "SELECT *";
    }

    public static String select(String... columns) {
        ArrayList<String> columnsAl = toAl(columns);
        return "SELECT " + columnList(columnsAl);
    }

    public static String set(String... columns) {
        ArrayList<String> columnsAl = toAl(columns);
        return "SET " + columnValueList(columnsAl);
    }

    public static String where(String... statements) {
        ArrayList<String> statementsAl = toAl(statements);
        return "WHERE " + statementList(statementsAl);
    }

    public static String where(Map<String, String> statements) {
        return "WHERE " + statementsList(statements, " AND ", "", "");
    }

    public static String innerJoin(Map<String, String> statements) {
        return "INNER JOIN " + statementsList(statements, " AND ", "", "");
    }

    public static String dateBetween(String dateCheck, String dateStart, String dateEnd) {
        return "(" + dateCheck + ") BETWEEN (" + dateStart + ") AND (" + dateEnd + ")";
    }

    public static String update(String table) {
        return "UPDATE " + table;
    }

    public static void main(String[] args) {
        String[] columns = {"pk", "select @hv2"};
        Map<String, String> dateDataWhere = Map.ofEntries(
                Map.entry("pk", "periodicidade__fk")
        );
        String sqlDiasPeriodicidade = select("periodo * periodicidade.quantidade_dias_por_periodo") + "\n" +
                from("periodicidade") + "\n" +
                where(dateDataWhere);
        String sql = select(columns) + "\n" +
                from("promocao") + "\n" +
                where(dateBetween("2023-10-30", "data_inicio", "ADDDATE(data_inicio, " + sqlDiasPeriodicidade + ")"));
        System.out.println(sql);
    }
}
