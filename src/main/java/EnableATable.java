import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class EnableATable {
    public static void main(String[] args) throws IOException {
        // Instantiating the Configuration class with HBase configuration
        Configuration conf = HBaseConfiguration.create();

        // Creating a Connection instance using the Configuration object
        Connection connection = ConnectionFactory.createConnection(conf);

        // Instantiating the Admin class to perform administrative operations
        Admin admin = connection.getAdmin();

        // I have employee table in my HBase.
        // Table to Be Disabled
        TableName empTable = TableName.valueOf("employee");

        // Checking if the table is disabled before performing any operations
        boolean isTableEnabled = admin.isTableEnabled(empTable);

        System.out.println(isTableEnabled); //false;

        if(!isTableEnabled){
            admin.enableTable(empTable);
        }
        System.out.println(admin.isTableEnabled(empTable));  // true
    }
}
