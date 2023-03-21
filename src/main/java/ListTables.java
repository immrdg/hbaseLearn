import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.List;

public class ListTables {
    public static void main(String[] args) throws IOException {
        // Instantiating the Configuration class with HBase configuration
        Configuration conf = HBaseConfiguration.create();

        // Creating a Connection instance using the Configuration object
        Connection connection = ConnectionFactory.createConnection(conf);

        // Instantiating the Admin class to perform administrative operations
        Admin admin = connection.getAdmin();

        List<TableDescriptor> tableDescriptor = admin.listTableDescriptors();
        tableDescriptor.forEach(table -> System.out.println(table.getTableName()));

    }
}
