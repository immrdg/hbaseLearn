import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;

public class InsertIntoTable {
    public static void main(String[] args) throws IOException {

        // Instantiating the Configuration class with HBase configuration
        Configuration conf = HBaseConfiguration.create();

        // Creating a Connection instance using the Configuration object
        Connection connection = ConnectionFactory.createConnection(conf);

        // Instantiating the Admin class to perform administrative operations
        Admin admin = connection.getAdmin();

        // Define the table name, row key, column family, column qualifier, and value
        TableName tableName = TableName.valueOf("employee");
        String rowKey = "1";
        String columnFamily = "personal";
        String columnQualifier1 = "city";
        String value1 = "Chennai";
        String columnQualifier2 = "country";
        String value2 = "India";

        Table table = connection.getTable(tableName);

        Put put=new Put(rowKey.getBytes());
        System.out.println(put);
        put.addColumn(columnFamily.getBytes(),columnQualifier1.getBytes(),value1.getBytes());
        System.out.println(put);
        put.addColumn(columnFamily.getBytes(),columnQualifier2.getBytes(),value2.getBytes());
        System.out.println(put.toJSON());

        table.put(put);
        table.close();
        admin.close();
        connection.close();

    }
}
