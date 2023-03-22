import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.TableDescriptor;

import java.io.IOException;

public class DescribeATable {
    public static void main(String[] args) throws IOException {
        // Instantiating the Configuration class with HBase configuration
        Configuration conf = HBaseConfiguration.create();

        // Creating a Connection instance using the Configuration object
        Connection connection = ConnectionFactory.createConnection(conf);

        // Instantiating the Admin class to perform administrative operations
        Admin admin = connection.getAdmin();


        TableName empTable = TableName.valueOf("employee");
        System.out.println();

        TableDescriptor descriptor = admin.getDescriptor(empTable);
        System.out.println(descriptor);
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(descriptor));
    }
}
