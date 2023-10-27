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

    public static String insert(String table, List<String> columns) {
        return "INSERT INTO " + table + " " + columnList(columns, "(", ")");
    }

    public static String values(List<String> values) {
        return "VALUES " + valueList(values);
    }

    public static String values(int n) {
        return "VALUES " + valueList(n);
    }

    public static String insertWithValues(String table, List<String> columns) {
        return insert(table, columns) + " " + values(columns.size());
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

    public static String whereEq(List<String> columns) {
        return "WHERE " + columnValueList(columns);
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

    public static String deleteFrom(String table) {
        return "DELETE FROM " + table;
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

    public static void main(String[] args) {
        List<String> columns = Arrays.asList("pk", "select @hv2");
        Map<String, String> dateDataWhere = Map.ofEntries(
                Map.entry("pk", "periodicidade__fk")
        );
        String sqlDiasPeriodicidade = select(Collections.singletonList("periodo * periodicidade.quantidade_dias_por_periodo")) + "\n" +
                from("periodicidade") + "\n" +
                where(dateDataWhere);
        String sql = select(columns) + "\n" +
                from("promocao") + "\n" +
                where(List.of(dateBetween("2023-10-30", "data_inicio", "ADDDATE(data_inicio, " + sqlDiasPeriodicidade + ")")));
        System.out.println(sql);

        List<String> columnsInsert = Arrays.asList("nome", "sobrenome", "nascimento", "email", "telefone");

        sql = StringSql.insertWithValues("pessoa", columnsInsert) + "; " +
                StringSql.select(List.of("LAST_INSERT_ID()"));

        System.out.println(sql);
    }
}
