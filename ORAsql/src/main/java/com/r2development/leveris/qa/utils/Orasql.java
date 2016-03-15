package com.r2development.leveris.qa.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Orasql {

    private static final Log log = LogFactory.getLog(Orasql.class);
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
//    private ResultSetMetaData resultSetMetaData;
    private String DB, userName, passWord;

    /**
     * Constructor of Library class responsible for setting all necessary variables based on input parameters defined in following rows
     * @param DB - String with DB address in expected format ex.: "jdbc:oracle:thin:@172.31.102.142:1521/TEST1"
     * @param userName - String with loginName for specified DB
     * @param passWord - String with password for specified userName and DB
     * @throws SQLException - if connection is not established
     */
    public Orasql(String DB, String userName, String passWord) throws SQLException {
        log.info("Creating an Orasql for connecting to a DB : '" + DB + "' with an userName : '" + userName + "' and using passWord : '" + passWord + "'");
        this.DB = DB;
        this.userName = userName;
        this.passWord = passWord;
        this.connection = this.openConnection();
//        this.statement  = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
        this.statement = connection.createStatement();
    }

    /**
     * This Constructor is expecting all necessary variables DB, userName, passWord to be set in property file or provided through VM options
     * @throws SQLException - thrown when isn't being connected to the DB
     */
    public Orasql() throws SQLException {
        log.info("Creating Property driven constructor");
        this.DB = System.getProperty("DB");
        this.userName = System.getProperty("userName");
        this.passWord = System.getProperty("passWord");
        log.info("Connecting to a DB : '" + System.getProperty("DB") + "' with an userName : '" + System.getProperty("userName") + "' and using passWord : '" + System.getProperty("passWord") + "'");
        this.connection = this.openConnection();
        this.statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT);
    }

    /**
     * Method responsible for Opening Connection
     * @return - Connection type used in createStatement method
     * @throws SQLException
     */
    private Connection openConnection() throws SQLException {
        log.info("method openConnection\n" + this.DB + ",\n" + this.userName + ",\n" + this.passWord);
        return DriverManager.getConnection(this.DB, this.userName, this.passWord);
    }

    /**
     * Method responsible for closing connection to the DB
     * @throws SQLException
     */
    private void closeConnection() throws SQLException {
        log.info("method closeConnection");
        try {
            if ( connection != null)
                connection.close();
        } catch (SQLException se) {
            try {
                if ( connection != null )
                    connection.close();
            } catch ( SQLException se2 ) {
                log.error("Can't close sql connection.");
            }
        }
        finally {
            if ( connection != null )
                connection.close();
        }

    }

    /**
     * Method responsible for closing statement
     * @throws SQLException
     */
    private void closeStatement() throws SQLException {
        log.info("method closeStatement");
        try {
            if ( statement != null )
                statement.close();
        } catch ( SQLException se ) {
            try {
                if ( statement != null )
                    statement.close();
            } catch ( SQLException se2 ) {
                log.error("Problem of closing sql statement.");
            }
        } finally {
            if ( statement != null )
                statement.close();
        }
    }

    /**
     * Method is creating Statement responsible for sending SQL statements to the DB
     * @return - Statement type used in method responsible for executing the SQL against DB
     * @throws SQLException
     */
    private Statement createStatement() throws SQLException {
        log.info("method createStatement");
        return connection.createStatement();
    }

    /**
     * Method is closing Result Set - note : when I used it it was failing and in fact impossible to use at all.
     * @throws SQLException
     */
    private void closeResultSet() throws SQLException {
        log.info("method closeResultSet");
        resultSet.close();
    }

    /**
     * Method is executing an SQL query against declared DB
     * @param sql - String containing select Statement "select * from TABLE where PARAMETER LIKE '%contains%'
     * @return - ResultSet containing results for executed select statement
     * @throws SQLException
     */
    public ResultSet executeSQLSelect(String sql) throws SQLException {
        log.info("method executeSQLSelect : '" + sql + "'");
        return this.resultSet = statement.executeQuery(sql);
    }

    /**
     * Method doesn't returns statement.execute(sql) as it would return boolean
     * @param sql - SQL updateStatement
     * @throws SQLException
     */
    public boolean doSQLUpdate(String sql) throws SQLException, InterruptedException {
        log.info("method doSQLUpdate : '" + sql + "'");
        return statement.execute(sql);
    }

    /**
     * Method doesn't returns statement.execute(sql) as it would return boolean
     * @param sql - SQL updateStatement
     * @throws SQLException
     */
    public void sqlUpdate(String sql) throws SQLException, InterruptedException {
        log.info("method doSQLUpdate : '" + sql + "'");

        boolean haveResult = statement.execute(sql);
        if(haveResult){
            statement.getResultSet();
            log.info("SQL update Passed with resultSet : '" + resultSet + "'");
        } else {
            log.info("SQL update status unknown or without resultSet, because haveResult should be false ==> '" + haveResult + "'");
        }
//        connection.commit();
    }

    /**
     * Same as method executeSQLSelect and it is present just for better usage&orientation within the library
     * @param sql - String with select statement queried against the DB
     * @return - ResultSet
     * @throws SQLException
     */
    public ResultSet getResultSet(String sql) throws SQLException {
        return executeSQLSelect(sql);
    }

    /**
     * Method is returning a Database metadata containing detailed information about the connected DB.
     * @return - DatabaseMetadata
     * @throws SQLException
     */
    public DatabaseMetaData getDatabaseMetadata() throws SQLException {
        log.info("method getDatabaseMetadata");
        return connection.getMetaData();
    }

    /**
     * Method is obtaining a Metadata for given sql it's used for example for getting the column data types for given sql statement
     * @param sql - String containing sql select
     * @return - ResultSetMetadata
     * @throws SQLException
     */
    public ResultSetMetaData getResultSetMetadata(String sql) throws SQLException {
        log.info("method getResultSetMetadata(String sql = '" + sql + "'");
        return getResultSet(sql).getMetaData();
    }

    /**
     * Method is obtaining a Metadata for given resultSet it's used for example for getting the column data types for given sql statement
     * @param resultSet - ResultSet obtained from executed sql select
     * @return - ResultSetMetadata
     * @throws SQLException
     */
    public ResultSetMetaData getResultSetMetadata(ResultSet resultSet) throws SQLException {
        log.info("method getResultSetMetadata '" + resultSet + "'");
        return resultSet.getMetaData();
    }

    /**
     * Method is obtaining all DB tables obtained from DBMetadata
     * @return - Map<Integer, String> int is 0,1,2,3,4 etc... String value is containing DB table names
     * @throws SQLException
     */
    public Map<Integer, String> getTableNames() throws SQLException {
        log.info("method getTableNames");
        Map<Integer, String> tableNames = new HashMap<>();
        ResultSet resultSet = getDatabaseMetadata().getTables(null, null, null, null);
        int i = 0;

        while(resultSet.next()){
            i = i + 1;
            String tableName = resultSet.getString(3);
            tableNames.putIfAbsent(i, tableName);
        }
        return tableNames;
    }

    /**
     * For R&D Automation
     * @param allTableNames - returns Map of all DB tables obtained from DatabaseMetadata
     * @throws SQLException
     */
    public void displayTableNames(Map<Integer, String> allTableNames) throws SQLException{
        log.info("method displayTableNames is for development&debug purposes");
        for (int i = 0; i < allTableNames.size(); i++){
            log.info("DB contains following tables : '\n" +
                    allTableNames.get(i));
        }
    }

    /**
     * Method is making easier to use original getColumnNamesAndDataTypes
     * @param sql - String with sql query
     * @return - Map<String, String> is filled in this way  <ColumnName, ColumnDataType>
     * @throws SQLException
     */
    public Map<String, String> getColumnNamesAndDataTypes(String sql) throws SQLException {
        log.info("method getColumnNamesAndDataTypes(String sql = '" + sql + "')");
        return getColumnNamesAndDataTypes(getResultSet(sql));
    }

    /**
     * Method is providing a Map of Column names and their DataTypes obtained from inputted resultSet
     * @param resultSet - ResultSet based on sql query
     * @return - Map<String, String> is filled in this way  <ColumnName, ColumnDataType>
     * @throws SQLException
     */
    public Map<String, String> getColumnNamesAndDataTypes(ResultSet resultSet) throws SQLException {
        log.info("method getColumnNamesAndDataTypes : '" +  resultSet + "'");

        ResultSetMetaData resultSetMetaData = getResultSetMetadata(resultSet);

        Map<String, String> dataReceived = new HashMap<>();
        Map<String ,Integer> duplicityCounter = new HashMap<>();

        int cols = resultSetMetaData.getColumnCount();

        System.out.printf("The query fetched %d columns\n",cols);
        System.out.println("These columns are: ");

        for (int i = 1; i <= cols; i++) {
            String colName = resultSetMetaData.getColumnName(i);
            String colType = resultSetMetaData.getColumnTypeName(i);
            System.out.println(colName + " of type " + colType);

            if (dataReceived.get(colName) == null) {
                dataReceived.put(colName, colType);
                duplicityCounter.put(colName, 1);
            } else {
                duplicityCounter.replace(colName, duplicityCounter.get(colName) + 1);
                dataReceived.put(colName + "." + duplicityCounter.get(colName), colType);
            }
            log.info("dataReceived " + dataReceived);
            log.info("duplicateCounter " + duplicityCounter );
        }
        return dataReceived;
    }

    /**
     *
     * @param sql - sql statement result
     * @return - Map<Integer, String> Integer is 0,1,2,3,4 etc... String is containing column names
     * @throws SQLException
     */
    public Map<Integer, String> getColumnNames(String sql) throws SQLException {
        log.info("Method getColumnNames(String sql = '" + sql + "')");
        return getColumnNames(getResultSet(sql));
    }
    /**
     * Method is returning a Map of Column names based on ResultSet. output of this method is mainly used to access all keys of Map provided by method
     *
     * example usage :
     *
     * Map<String, String> map = getColumnNamesAndDataTypes(resultSet);
     * Map<Integer, String> columns = getColumnNames(resultSet);
     *
     * for(int i = 0; i < map.size(); i++){
     *
     * String columnName = columns.get(i);
     *
     * log.info("This column DataType gets extracted : '" + columnName + "'");
     *
     * String eachColumnDataType = map.get(columnName);
     *
     * log.info("DataType is : '" + eachColumnDataType + "'");
     * }
     *
     * @param resultSet - sql statement result
     * @return - Map<Integer, String> Integer is 0,1,2,3,4 etc... String is containing column names
     * @throws SQLException
     */
    public Map<Integer, String> getColumnNames(ResultSet resultSet) throws SQLException {
        log.info("method getColumnNames : '" + resultSet + "'");
        Map<Integer, String> collNames = new HashMap<>();
        ResultSetMetaData resultSetMetaData = getResultSetMetadata(resultSet);
        int cols = resultSetMetaData.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            collNames.put(i, resultSetMetaData.getColumnName(i));
        }
        return collNames;
    }

    /**
     * Method is making more simple to use method getDataCollNames
     * @param sql - String sql
     * @return - Map<Integer = 1,2,3,4,5..., String = Column Names .... First Name, Last Name, etc...>
     * @throws SQLException
     */
    public Map<Integer, String> getDataCollNames(String sql) throws SQLException {
        log.info("method getDataCollNames(String sql = '" + sql + "')");
        return getDataCollNames(getResultSet(sql));
    }

    /**
     * Same as method getColumnNames and it is present just for better usage&orientation within the library
     * @param resultSet - resultSet
     * @return - Map<Integer - index, String - column name>
     * @throws SQLException
     */
    public Map<Integer, String> getDataCollNames(ResultSet resultSet) throws SQLException {
        return getColumnNames(resultSet);
    }

    /**
     * Method is making more simple to use method getData providing load of sql specified data into variables [Map]
     * @param sql - String containing a sql query
     * @return - Map<Integer - row index, Map<String column name, String column DB data>>
     * @throws Exception
     */
    public Map<Integer, Map<String, String>> getData(String sql) throws Exception {
        log.info("method getData(String sql = '" + sql + "')");
        return getData(getResultSet(sql));
    }

    /**
     * Method is extracting Data from resultSet and is returning a Map of rowMaps with column name as key and cell data as value
     * @param resultSet - resultSet of some sql select
     * @return - Map<Integer - row index, Map<String column name, String column DB data>>
     * @throws Exception
     */
    public Map<Integer, Map<String, String>> getData(ResultSet resultSet) throws Exception {

        Map<String, String> sqlResultRowSetData = new HashMap<>();
        Map<Integer, Map<String, String>> sqlAllResultSetData = new HashMap<>();

        try {
            this.connection = openConnection();
            this.statement = createStatement();
            this.resultSet = resultSet;
//            this.resultSetMetaData = getResultSetMetadata(resultSet);
            ResultSetMetaData resultSetMetaData = getResultSetMetadata(resultSet);
            int counter = 0; // name better this variable such as rowIndex

            while (resultSet.next()) {

                for ( int i=1; i<= resultSetMetaData.getColumnCount(); i++) {

                    String columnTypeName = resultSetMetaData.getColumnTypeName(i);
                    METHODTYPE collEnumType = METHODTYPE.valueOf(columnTypeName);
                    String columnName = resultSetMetaData.getColumnName(i);


                    Class<?> classLoader = resultSet.getClass().getClassLoader().loadClass("java.sql.ResultSet");
                    Method method = classLoader.getMethod(METHODTYPE.getMethod(columnTypeName).getMethodName(), int.class);
                    Object object = method.invoke(resultSet, i);

//                    String
//                            finalResult = null,
//                            varchar_result = null;
//                    Byte
//                            byte_result = null;
//                    Short
//                            short_result = null;
//                    int
//                            int_result;
//                    Long
//                            long_result = null;
//                    Float
//                            float_result = null;
//                    Double
//                            double_result = null;
//                    Boolean
//                            boolean_result = null;
//                    BigDecimal
//                            bigDecimal_result = null;
//                    Byte[ ]
//                            bytes_result = null;
//                    Date
//                            date_result = null;
//                    Time
//                            time_result= null;
//                    Timestamp
//                            timespamp_result = null;
//                    Clob
//                            clob_result = null;
//                    Blob
//                            blob_result = null;
//                    Array
//                            array_result = null;
//                    Ref
//                            ref_result = null;
//                    Struct
//                            struct_result = null;

                    String
                            finalResult="",
                            varchar_result;
                    Byte
                            byte_result;
                    Short
                            short_result;
                    int
                            int_result;
                    Long
                            long_result;
                    Float
                            float_result;
                    Double
                            double_result;
                    Boolean
                            boolean_result;
                    BigDecimal
                            bigDecimal_result;
                    Byte[ ]
                            bytes_result;
                    Date
                            date_result;
                    Time
                            time_result;
                    Timestamp
                            timespamp_result;
                    Clob
                            clob_result;
                    Blob
                            blob_result;
                    Array
                            array_result;
                    Ref
                            ref_result;
                    Struct
                            struct_result;

                    switch (collEnumType) {
                        case VARCHAR:
                            varchar_result = convert(object, String.class);
                            log.info(varchar_result);
                            finalResult = varchar_result;
                            break;

                        case VARCHAR2:
                            varchar_result = convert(object, String.class);
                            log.info(varchar_result);
                            finalResult = varchar_result;
                            break;

                        case CHAR:
                            varchar_result = convert(object, String.class);
                            log.info(varchar_result);
                            finalResult = varchar_result;
                            break;

                        case LONGVARCHAR:
                            varchar_result = convert(object, String.class);
                            log.info(varchar_result);
                            finalResult = varchar_result;
                            break;

                        case BIT:
                            boolean_result = convert(object, boolean.class);
                            log.info(boolean_result.toString());
                            finalResult = boolean_result.toString();
                            break;

                        case NUMERIC:
                            bigDecimal_result = convert(object, BigDecimal.class);
                            log.info(bigDecimal_result.toString());
                            finalResult = bigDecimal_result.toString();
                            break;

                        case TINYINT:
                            byte_result = convert(object, Byte.class);
                            log.info(byte_result.toString());
                            finalResult = byte_result.toString();
                            break;

                        case SMALLINT:
                            short_result = convert(object, Short.class);
                            log.info(short_result.toString());
                            finalResult = short_result.toString();
                            break;

                        case INTEGER:
                            int_result = convert(object, int.class);
                            log.info(String.valueOf(int_result));
                            finalResult = String.valueOf(int_result);
                            break;

                        case BIGINT:
                            long_result = convert(object, Long.class);
                            log.info(long_result.toString());
                            finalResult = long_result.toString();
                            break;

                        case REAL:
                            float_result = convert(object, Float.class);
                            log.info(float_result.toString());
                            finalResult = float_result.toString();
                            break;

                        case FLOAT:
                            float_result = convert(object, Float.class);
                            log.info(float_result.toString());
                            finalResult = float_result.toString();
                            break;

                        case DOUBLE:
                            double_result = convert(object, Double.class);
                            log.info(double_result.toString());
                            finalResult = double_result.toString();
                            break;

                        case VARBINARY:
                            bytes_result = convert(object, Byte[].class);
                            log.info(Arrays.toString(bytes_result));
                            finalResult = Arrays.toString(bytes_result);
                            break;

                        case BINARY:
                            bytes_result = convert(object, Byte[].class);
                            log.info(Arrays.toString(bytes_result));
                            finalResult = Arrays.toString(bytes_result);
                            break;

                        case DATE:
                            date_result = convert(object, Date.class);
                            log.info(date_result.toString());
                            finalResult = date_result.toString();
                            break;

                        case TIME:
                            time_result = convert(object, Time.class);
                            log.info(time_result.toString());
                            finalResult = time_result.toString();
                            break;

                        case TIMESTAMP:
                            timespamp_result = convert(object, Timestamp.class);
                            log.info(timespamp_result.toString());
                            finalResult = timespamp_result.toString();
                            break;

                        case CLOB:
                            clob_result = convert(object, Clob.class);
                            log.info(clob_result.toString());
                            finalResult = clob_result.toString();
                            break;

                        case BLOB:
                            blob_result = convert(object, Blob.class);
                            log.info(blob_result.toString());
                            finalResult = blob_result.toString();
                            break;

                        case ARRAY:
                            array_result = convert(object, Array.class);
                            log.info(array_result.toString());
                            finalResult = array_result.toString();
                            break;

                        case REF:
                            ref_result = convert(object, Ref.class);
                            log.info(ref_result.toString());
                            finalResult = ref_result.toString();
                            break;

                        case STRUCT:
                            struct_result = convert(object, Struct.class);
                            log.info(struct_result.toString());
                            finalResult = struct_result.toString();
                            break;
                    }
                    sqlResultRowSetData.put(columnName, finalResult);
                }
                sqlAllResultSetData.put(counter, sqlResultRowSetData);
                counter = counter + 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sqlAllResultSetData;
    }

    /**
     * Method is used for displaying the results in console output. Please use only for development and debug purposes
     * @param sql - String should contains sql query to be selected from DB
     * @throws Exception
     */
    public void displayResults(String sql) throws Exception {

        //For Debug or Development Purposes
        this.connection = openConnection();
        this.statement = createStatement();
        this.resultSet = getResultSet(sql);

        Map<Integer, Map<String, String>> resultDataMap = getData(resultSet);
        Map<Integer, String> resultCollNames = getDataCollNames(resultSet);

        for(int w = 0; w < resultDataMap.size(); w ++) {

            log.info("|||||||||||||||||||||||||||||\n" +
                    "          row cycle : '" + w + "'");

            for (int i = 0; i < resultCollNames.size(); i++){

                log.info("/////////////////////////\n" +
                        "       coll cycle : '" + i + "'");
                log.info(resultCollNames.get(i));
                log.info(resultDataMap.get(w).get(resultCollNames.get(i)));
            }
        }
        closeResultSet();
        closeStatement();
        closeConnection();
    }

    public <I, O> O convert(I input, Class<O> outputclass) throws Exception {
        //noinspection unchecked
        return (O) input;
    }

    public static void displayResult(String DB, String userName, String passWord, String sqlSelectQuery) throws Exception {
        Orasql orasql = new Orasql(DB, userName, passWord);
        orasql.displayResults(sqlSelectQuery);
    }

    public static void executeSqlUpdateQuery( String DB, String userName, String passWord, String sqlUpdateQuery) throws Exception {
        Orasql orasql = new Orasql(DB, userName, passWord);
        orasql.sqlUpdate(sqlUpdateQuery);
    }

    public static Map<Integer, Map<String, String>> executeSqlSelectQuery( String DB, String userName, String passWord, String sqlSelectQuery) throws Exception {
        Orasql orasql = new Orasql(DB, userName, passWord);
        return orasql.getData(sqlSelectQuery);
    }

}